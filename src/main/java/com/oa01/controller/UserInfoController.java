package com.oa01.controller;

import com.oa01.model.entity.Holiday;
import com.oa01.model.entity.Login;
import com.oa01.model.entity.UserInfo;
import com.oa01.service.HolidayService;
import com.oa01.service.LoginService;
import com.oa01.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;



@Controller
@RequestMapping("/userinfo")
@Slf4j
public class UserInfoController  {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    HolidayService holidayService;

    @Autowired
    LoginService loginService;

    @PostMapping("/editUser")//修改用户信息
    public String editUser(@ModelAttribute UserInfo info,HttpServletRequest request){
        //通过主键修改用户信息
        int count = userInfoService.updateByPrimaryKeySelective(info);//修改用户信息
        //刷新一下集合
        //刷新集合
        List<UserInfo> infos = userInfoService.selectAllUserInfos();
        request.getSession().setAttribute("infos",infos);
        return "user/userAll";
    }
    @GetMapping("/modifyUser")//获得要修改用户信息
    public String modifyUser(@RequestParam("userId") int uid,HttpServletRequest request){
        //通过主键查询用户信息
        UserInfo info = userInfoService.selectByPrimaryKey(uid);
        request.getSession().setAttribute("info",info);
        return "user/userEditor";
    }
    @GetMapping("/detailUser")//查看用户的详细信息
    public String detailUser(@RequestParam("userId") int uid,HttpServletRequest request){
        //通过主键查询用户信息
        UserInfo info = userInfoService.selectByPrimaryKey(uid);
        request.getSession().setAttribute("info",info);
        return "user/userDetail";
    }
    @GetMapping("/deleteUser")//是不是可以删除该用户
    public String deleteUser(@RequestParam("userId") int uid,HttpServletRequest request){
        //通过主键删除用户信息
        int i = userInfoService.deleteByPrimaryKey(uid);
        // 删除用户登录信息
        Login login = new Login();
        login.setLoginUserId(uid);
        i+= loginService.deleteByCondition(login);
        //刷新集合
        List<UserInfo> infos = userInfoService.selectAllUserInfos();
        request.getSession().setAttribute("infos",infos);
        return "user/userAll";
    }


    @GetMapping("/isDeleteUser")//是不是可以删除该用户
    @ResponseBody//跳过视图解析器，只返回一个字符串
    public String isDeleteUser(@RequestParam("userId") int uid){
        String result = "ok";
        //通过uid查找与用户信息表相关联的表，如果没有任何关联数据，就可以删除，如果有关联数据就不能删
        //请假，报销
        // 如果删除的是部门信息，这个部门下有没有员工
        // 如果删除的是班级表，看这个班级下有没有学生
        //.........
        Holiday holiday = new Holiday();
        holiday.setHolidayUserId(uid);
        List<Holiday> holidays = holidayService.selectHolidaysByCondition(holiday);
        if(!(holidays==null || holidays.size()==0)){
            result="error";//不能删
        }
        return result;
    }
    @GetMapping("isExistNo")
    @ResponseBody//跳过视图解析器，只返回一个字符串
    public String isExistNo(@RequestParam("no")String no){
        UserInfo info = new UserInfo();
        info.setUserInfoNo(no);
        List<UserInfo> list = userInfoService.selectUserInfosByCondition(info);
        if(list==null || list.size()==0){
            //没有找到对应编号的员工，编号是可用的
            return "success";
        }else{
            return "error";
        }
    }
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute UserInfo userInfo,@RequestParam("userInfoEntryTime1") String date
            ,HttpServletRequest request) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        userInfo.setUserInfoEntryTime(format.parse(date));
        int count = userInfoService.insert(userInfo);//添加员工信息到数据库
        //自动生成登录信息（账号：员工编号，密码：111111）写在service中
        //刷新员工列表，返回到用户管理的主页面
        List<UserInfo> infos = userInfoService.selectAllUserInfos();
        request.getSession().setAttribute("infos",infos);
        return "user/userAll";
    }

    @GetMapping("/addUserInfoPage")//显示添加用户的页面
    public String addUserInfoPage(){
        return "user/userAdd";
    }

    @PostMapping("/searchUser")//查询用户
    public String searchUser(@RequestParam("userName") String userName,
                             @RequestParam("deptId") int id,
                             HttpServletRequest request){
        UserInfo info = new UserInfo();
        if(userName==null || userName.length()==0){
            //没有填写员工姓名
        }else{
            info.setUserName(userName);
        }
        if(id!=0){
            //选择部门编号
            info.setUserDeptId(id);
        }
        //查询（生成的代码是精确查询，修改代码，改成模糊查询）
        List<UserInfo> infos = userInfoService.selectUserInfosByCondition(info);
        request.getSession().setAttribute("infos",infos);
        return "user/userAll";
    }

}
