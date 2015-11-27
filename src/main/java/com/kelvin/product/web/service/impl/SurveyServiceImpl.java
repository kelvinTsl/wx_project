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

    public List<Survey> findAllByQueryForPage(Survey survey, PageDTO pageDTO){
        if(pageDTO.getCurPage() == 0){
            pageDTO.setCurPage(1);
        }
        if(pageDTO.getPageNum() == 0){
            pageDTO.setPageNum(10);
        }
        List<Survey> list = surveyDao.findListByHql(survey, pageDTO);
        Long count = surveyDao.countListByHql(survey,pageDTO);
        pageDTO.setTotal(count.intValue());
        return list;
    }
}
