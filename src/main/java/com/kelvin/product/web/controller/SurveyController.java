package com.kelvin.product.web.controller;

import com.kelvin.product.web.model.plat.Survey;
import com.kelvin.product.web.model.system.BaseUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by kelvin on 15/11/26.
 */
@Controller
@RequestMapping(value = "/survey")
public class SurveyController {

    /**
     * 获取survey list
     * @param survey
     * @param result
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String list(@Valid Survey survey, BindingResult result, Model model, HttpServletRequest request){

        return "survey.list";
    }
}
