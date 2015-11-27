package com.kelvin.product.web.service;

import com.kelvin.product.web.model.dto.PageDTO;
import com.kelvin.product.web.model.plat.Survey;

import java.util.List;

/**
 * Created by tangshulei on 2015/11/27.
 */
public interface SurveyService {

    List<Survey> findAllByQueryForPage(Survey survey, PageDTO pageDTO);

}
