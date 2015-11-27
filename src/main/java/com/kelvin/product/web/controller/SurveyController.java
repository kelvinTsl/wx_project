package com.kelvin.product.web.controller;

import com.kelvin.product.web.model.dto.PageDTO;
import com.kelvin.product.web.model.plat.Survey;
import com.kelvin.product.web.model.system.BaseUser;
import com.kelvin.product.web.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by kelvin on 15/11/26.
 */
@Controller
@RequestMapping(value = "/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    /**
     * 获取survey list
     * @param survey
     * @param result
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String list(Survey survey, PageDTO pageDTO, BindingResult result, Model model, HttpServletRequest request){
        List<Survey> list = surveyService.findAllByQueryForPage(survey, pageDTO);
        model.addAttribute("surveys",list);
        model.addAttribute("pageDTO",pageDTO);
        return "survey.list";
    }
}
