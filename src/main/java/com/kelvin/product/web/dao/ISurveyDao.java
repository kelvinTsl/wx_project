package com.kelvin.product.web.dao;

import com.kelvin.product.core.generic.dao.IGenericDao;
import com.kelvin.product.web.model.dto.PageDTO;
import com.kelvin.product.web.model.plat.Survey;

import java.util.List;

/**
 * Created by tangshulei on 2015/11/27.
 */
public interface ISurveyDao extends IGenericDao {

    List<Survey> findListByHql(Survey survey, PageDTO pageDTO);
    Long countListByHql(Survey survey, PageDTO pageDTO);
}
