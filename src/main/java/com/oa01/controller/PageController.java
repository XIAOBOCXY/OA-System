package com.oa01.controller;

import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@RestController
@Controller //这个类是一个控制器
@RequestMapping("/")//注解一个url
public class PageController {

    // /page/index
    @GetMapping("/page/{mypage}")//get请求，{路径占位符}
    public String getPage(@PathVariable("mypage") String page){
        //page="index";====》/前缀 index   后缀.jsp /index.jsp
        return page;
    }
    //
    @GetMapping("")//get请求，返回首页
    public String getindex(){
        return "index";
    }

    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.out(request, response);
    }

    @GetMapping("/page/userRegist")//get请求，返回首页
    public String getuserRegist(){
        return "userRegist";
    }


}
