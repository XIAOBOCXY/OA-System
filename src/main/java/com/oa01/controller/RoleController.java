package com.oa01.controller;

import com.oa01.model.entity.*;
import com.oa01.service.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.util.calendar.BaseCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/role")
@Slf4j
public class RoleController {
    @Autowired
    HolidayService holidayService;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    DeptService deptService;
    @Autowired
    SysConfigService sysConfigService;
    @Autowired
    RoleService roleService;
    @GetMapping("/addRolePage")//显示添加请假的页面
    public String addRolePage(){
        return "role/roleAdd";
    }

    @GetMapping("/getall")
    public String getall(HttpServletRequest request){
        log.info("HolidayController---------------------------->getAllHoliday(HttpServletRequest request,HttpServletResponse response)");
        List<Role> roles=roleService.selectAllRoles();
        request.getSession().setAttribute("roles",roles);
        request.getSession().setAttribute("page1",3);
        request.getSession().setAttribute("pageCount",10);
        return "role/roleAll";
    }

    @GetMapping("/modifyrole")//获得要修改用户信息
    public String modifyUser(@RequestParam("roleId") int uid,HttpServletRequest request){
        Role role=roleService.selectByPrimaryKey(uid);
        request.getSession().setAttribute("role",role);
        return "role/roleEditor";
    }
    @GetMapping("/deleterole")//是不是可以删除该用户
    public String deleteUser(@RequestParam("roleId") int uid,HttpServletRequest request){
        int temp=roleService.deleteByPrimaryKey(uid);
        return "role/roleAll";
    }
    @PostMapping("/addRole")
    public String addUser(@ModelAttribute Role role, HttpServletRequest request) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        userInfo.setUserInfoEntryTime(format.parse(date));
        role.setRoleCreateTime(new Date());
        int count = roleService.insert(role);
        List<Role> roles=roleService.selectAllRoles();
        request.getSession().setAttribute("roles",roles);
//        List<UserInfo> infos = userInfoService.selectAllUserInfos();
//        request.getSession().setAttribute("infos",infos);
        return "role/roleAll";
    }
    @GetMapping("isExistNo")
    @ResponseBody//跳过视图解析器，只返回一个字符串
    public String isExistNo(@RequestParam("no")int no){
        Role role=new Role();
        role.setRoleId(no);
        List<Role> list = roleService.selectRolesByCondition(role);
        if(list==null || list.size()==0){
            //没有找到对应编号的员工，编号是可用的
            return "success";
        }else{
            return "error";
        }
    }
    @PostMapping("/editRole")//修改用户信息
    public String editRole(@ModelAttribute Role role, HttpServletRequest request){
        //通过主键修改用户信息
        int count=roleService.updateByPrimaryKeySelective(role);
        List<Role> roles=roleService.selectAllRoles();
        request.getSession().setAttribute("roles",roles);
        return "role/roleAll";
    }
}
