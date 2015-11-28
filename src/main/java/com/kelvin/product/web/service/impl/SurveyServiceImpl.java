package com.kelvin.product.web.service.impl;

import com.kelvin.product.core.generic.service.impl.GenericServiceImpl;
import com.kelvin.product.core.util.StringUtil;
import com.kelvin.product.web.dao.ISurveyDao;
import com.kelvin.product.web.dao.IUserDao;
import com.kelvin.product.web.model.dto.PageDTO;
import com.kelvin.product.web.model.plat.Survey;
import com.kelvin.product.web.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tangshulei on 2015/11/27.
 */
@Service("surveyService")
@Transactional
public class SurveyServiceImpl extends GenericServiceImpl implements SurveyService {

    @Autowired
    private ISurveyDao surveyDao;

    public List<Survey> findAllByQueryForPage(Survey survey, PageDTO pageDTO, String risk){
        if(pageDTO.getCurPage() == 0){
            pageDTO.setCurPage(1);
        }
        if(pageDTO.getPageNum() == 0){
            pageDTO.setPageNum(10);
        }
        List<Survey> list = surveyDao.findListByHql(survey, pageDTO, risk);
        Long count = surveyDao.countListByHql(survey,pageDTO, risk);
        pageDTO.setTotal(count.intValue());
        if(count > 0) {
            double a = new Double(count);
            double b = new Double(pageDTO.getPageNum());
            pageDTO.setPageSize((int) Math.ceil(a / b));
        }else{
            pageDTO.setPageSize(1);
        }

        return list;
    }

    public int updateStatus(Survey survey){
        return surveyDao.updateStatus(survey);
    }
}
