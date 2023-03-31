package com.oa01.controller;

import com.oa01.model.entity.Dept;
import com.oa01.model.entity.Holiday;
import com.oa01.model.entity.UserInfo;
import com.oa01.service.DeptService;
import com.wf.captcha.utils.CaptchaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;


@Controller //这个类是一个控制器
@RequestMapping("/dept")//注解一个url
@Slf4j
public class DeptController {
    @Autowired
    DeptService deptService;

    @GetMapping("/getall")
    public String getAllDept(HttpServletRequest request,HttpServletResponse response){
        log.info("DeptController---------------------------->getAllDept(HttpServletRequest request,HttpServletResponse response)");
        List<Dept> depts = deptService.selectAllDepts();
        request.getSession().setAttribute("depts",depts);
        request.getSession().setAttribute("page1",3);
        request.getSession().setAttribute("pageCount",10);
        return "dept/deptAll";
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

    @GetMapping("/addDeptPage")//显示添加请假的页面
    public String addDeptPage(){
        return "dept/deptAdd";
    }

    @PostMapping("/addDept")
    public String addUser(@ModelAttribute Dept dept, HttpServletRequest request) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        userInfo.setUserInfoEntryTime(format.parse(date));
//        dept.setHolidayNo("NO"+holiday.getHolidayId());
//        dept.setHolidayHolidayStatus("1");
//        dept.setHolidayCreateTime(new Date());
//        dept.setHolidayUpdateTime(new Date());
//        int count = holidayService.insert(holiday);
        //自动生成登录信息（账号：员工编号，密码：111111）写在service中
        //刷新员工列表，返回到用户管理的主页面
        dept.setDeptPid(1);
        int count=deptService.insert(dept);
        List<Dept> depts=deptService.selectAllDepts();
        request.getSession().setAttribute("depts",depts);
        return "dept/deptAll";
    }
    @GetMapping("isExistNo")
    @ResponseBody//跳过视图解析器，只返回一个字符串
    public String isExistNo(@RequestParam("no")int no){
        Dept dept=new Dept();
        dept.setDeptId(no);
        List<Dept> list=deptService.selectDeptsByCondition(dept);
        if(list==null || list.size()==0){
            //没有找到对应编号的员工，编号是可用的
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/modifydept")//获得要修改用户信息
    public String modifyUser(@RequestParam("deptId") int uid,HttpServletRequest request){
        Dept dept=deptService.selectByPrimaryKey(uid);
        request.getSession().setAttribute("dept",dept);
        return "dept/deptEditor";
    }
    @PostMapping("/editDept")//修改用户信息
    public String editDept(@ModelAttribute Dept dept, HttpServletRequest request){
        //通过主键修改用户信息
        int count=deptService.updateByPrimaryKeySelective(dept);
        List<Dept> depts=deptService.selectAllDepts();
        request.getSession().setAttribute("depts",depts);
        return "dept/deptAll";
    }
    @GetMapping("/detaildept")//查看用户的详细信息
    public String detaildept(@RequestParam("deptId") int uid,HttpServletRequest request){
        Dept dept=deptService.selectByPrimaryKey(uid);
        request.getSession().setAttribute("dept",dept);
        return "dept/deptDetail";
    }
}
