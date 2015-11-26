package com.kelvin.product.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.kelvin.product.web.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kelvin.product.web.model.system.BaseUser;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 公共视图控制器
 * 
 *  
 * @since 2014年4月15日 下午4:16:34
 **/
@Controller
public class CommonController {
    private Logger logger = Logger.getLogger(CommonController.class);

	@Autowired 
    UserService userService;

    @Autowired
    MessageSource resources;

    /**
     * login页面
     */
    @RequestMapping("/login")
    public String loginView() {
        return "common/login";
    }

    /**
     * login页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid BaseUser user, BindingResult result, Model model, HttpServletRequest request) {
        String telephone = request.getParameter("telephone");
        String cellphone = request.getParameter("cellhone");
        if(result.hasErrors()){
            logger.error("参数错误 ！");
            model.addAttribute("error", "参数错误 ！");
            return "common/login";
        }
        try {
            userService.login(user);
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
            return "common/login";
        }
        return "redirect:/";
    }



    /**
     * 首页
     * 
     * @param request
     * @return
     */
    @RequestMapping()
    public String index(HttpServletRequest request, String name,Model model) {
    	BaseUser user = new BaseUser();
    	user.setPassword("11111");
    	user.setUserName("1221212");
//        userService.save(user);
//        String abc = resources.getMessage("ccc",null,null);
//
//        String sql = "select * from BaseUser where user_name like :name";
//        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("name", "%2212%");
//        List<Map<String,Object>> list = userService.findListBySql(sql, paramMap);

        try {
//            userService.test();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        model.addAttribute("abc",abc);
        model.addAttribute("message", "中文message1111");

        return "index";
    }
    
    @RequestMapping(value="index", method = RequestMethod.POST)
    public String test(HttpServletRequest request, String name) {
    	request.setAttribute("name", name);
        return "index";
    }

    @RequestMapping(value="test", method = RequestMethod.GET)
    public String test1(HttpServletRequest request, String name) {
        request.setAttribute("name", "12121321sdfasdfdsfdsafdsafdasfa");
        return "index";
    }

    @RequestMapping(value="test1", method = RequestMethod.GET)
    @ResponseBody
    public String test1(){
        return "index";
    }
}