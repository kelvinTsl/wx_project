package com.kelvin.product.web.dao.impl;

import com.kelvin.product.core.generic.dao.impl.GenericDao;
import com.kelvin.product.core.util.StringUtil;
import com.kelvin.product.web.dao.ISurveyDao;
import com.kelvin.product.web.model.dto.PageDTO;
import com.kelvin.product.web.model.plat.Survey;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tangshulei on 2015/11/27.
 */
@Repository
public class SurveyDao extends GenericDao implements ISurveyDao {

    public Long countListByHql(Survey survey, PageDTO pageDTO){
        String hql = "select count(a) from Survey a where 1 = 1 ";
        Query query = null;
        query = addParam(query, hql, survey, pageDTO, 1);
        Long count = (Long)query.uniqueResult();
        return count;
    }

    public List<Survey> findListByHql(Survey survey, PageDTO pageDTO){
        String hql = "select a from Survey a where 1 = 1 ";
        Query query = null;
        query = addParam(query, hql, survey, pageDTO, 0);
        int num = pageDTO.getPageNum();
        int page = pageDTO.getCurPage();
        int first = (page - 1)*num;
        query.setFirstResult(first).setMaxResults(num);
        List<Survey> list = query.list();
        return list;
    }

    private Query addParam(Query query, String hql, Survey survey, PageDTO pageDTO, int i){
        String candidateName = null;
        String candidateSex = null;
        String candidateCellphone = null;
        if(survey.getCandidate() != null) {
            candidateName = survey.getCandidate().getCandidateName();
            if (!StringUtil.isEmpty(candidateName)) {
                hql += " and a.candidate.candidateName = :name";
            }
            candidateSex = survey.getCandidate().getCandidateSex();
            if (!StringUtil.isEmpty(candidateSex)) {
                hql += " and a.candidate.candidateSex = :sex";
            }
            //年龄缺失

            candidateCellphone = survey.getCandidate().getCandidateCellphone();
            if (!StringUtil.isEmpty(candidateCellphone)) {
                hql += " and a.candidate.candidateCellphone = :cellphone";
            }
        }
        Integer status = survey.getStatus();
        if(status != null){
            hql += " and a.status = :st";
        }
        if(i == 0) {
            if (!StringUtil.isEmpty(pageDTO.getOrder())) {
                hql += "order by " + pageDTO.getOrder();
                if (PageDTO.PAGE_ORDER0_TYPE_ASC.equals(pageDTO.getOrderType()) || PageDTO.PAGE_ORDER0_TYPE_DESC.equals(pageDTO.getOrderType())) {
                    hql += " " + pageDTO.getOrderType();
                }
            }
        }
        query = getSession().createQuery(hql);
        if(!StringUtil.isEmpty(candidateName)) {
            query.setParameter("name", candidateName);
        }
        if(!StringUtil.isEmpty(candidateSex)){
            query.setParameter("sex", candidateSex);
        }
        if(!StringUtil.isEmpty(candidateCellphone)){
            query.setParameter("cellphone", candidateCellphone);
        }
        if(status != null){
            query.setParameter("st", status);
        }
        return query;
    }
}
