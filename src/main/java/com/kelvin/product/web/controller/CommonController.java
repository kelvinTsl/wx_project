package com.kelvin.product.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.kelvin.product.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kelvin.product.core.generic.service.GenericService;
import com.kelvin.product.web.system.model.User;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.ModelAndViewResolver;
import org.springframework.web.servlet.support.RequestContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公共视图控制器
 * 
 *  
 * @since 2014年4月15日 下午4:16:34
 **/
@Controller
public class CommonController {
	
	@Autowired 
    UserService userService;

    @Autowired
    MessageSource resources;

    /**
     * 首页
     * 
     * @param request
     * @return
     */
    @RequestMapping()
    public String index(HttpServletRequest request, String name,Model model) {
    	User user = new User();
    	user.setPassword("11111");
    	user.setUserName("1221212");
//        userService.save(user);
//        String abc = resources.getMessage("ccc",null,null);
//
//        String sql = "select * from User where user_name like :name";
//        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("name", "%2212%");
//        List<Map<String,Object>> list = userService.findListBySql(sql, paramMap);

        try {
//            userService.test();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        model.addAttribute("abc",abc);
        model.addAttribute("message", "中文message");

        String a = test1();
        System.out.println(a);

        return "index";
    }
    
    @RequestMapping(value="index", method = RequestMethod.POST)
    public String test(HttpServletRequest request, String name) {
    	request.setAttribute("name", name);
        return "index";
    }

    @RequestMapping(value="test1", method = RequestMethod.GET)
    @ResponseBody
    public String test1(){

        return "index";
    }
}