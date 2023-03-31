package com.oa01.controller;

import com.oa01.model.entity.*;
import com.oa01.service.DeptService;
import com.oa01.service.HolidayService;
import com.oa01.service.SysConfigService;
import com.oa01.service.UserInfoService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/holiday")
@Slf4j
public class HolidayController {
    @Autowired
    HolidayService holidayService;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    DeptService deptService;
    @Autowired
    SysConfigService sysConfigService;

    @GetMapping("/addHolidayPage")//显示添加请假的页面
    public String addHolidayPage(){
        return "holiday/holidayAdd";
    }

    @PostMapping("/searchHoliday")//查询用户
    public String searchUser(@RequestParam("userName") String userName,
                             @RequestParam("holidayTypeId") int holidayTypeId,
                             @RequestParam("holidayHolidayStatus") int holidayHolidayStatus,
                             HttpServletRequest request){
        UserInfo info = new UserInfo();
        Holiday holiday=new Holiday();
        if(userName==null || userName.length()==0){
            //没有填写员工姓名
        }else{
            info.setUserName(userName);
            List<UserInfo> infos = userInfoService.selectUserInfosByCondition(info);
            request.getSession().setAttribute("infos",infos);
            for (UserInfo item:infos){
                int id=item.getUserInfoId();
//                System.out.println(id);
//                System.out.println("-------------");
                holiday.setHolidayUserId(id);
            }
        }
        if(holidayTypeId==1 || holidayTypeId==2 || holidayTypeId==3 || holidayTypeId==4 || holidayTypeId==5 || holidayTypeId==6 || holidayTypeId==7){
            holiday.setHolidayTypeId(holidayTypeId);
        }
        if(holidayHolidayStatus==1 ){
            holiday.setHolidayHolidayStatus("1");
        }
        else if(holidayHolidayStatus==2){
            holiday.setHolidayHolidayStatus("2");
        }
//        System.out.println(holidayHolidayStatus);
        System.out.println(holiday);
        //查询（生成的代码是精确查询，修改代码，改成模糊查询）
//        List<UserInfo> infos = userInfoService.selectUserInfosByCondition(info);
//        request.getSession().setAttribute("infos",infos);
        List<Holiday> holidays=holidayService.selectHolidaysByCondition(holiday);
        request.getSession().setAttribute("holidays",holidays);
        return "holiday/holidayAll";
    }
    @GetMapping("/getall")
    public String getAllHoliday(HttpServletRequest request){
        log.info("HolidayController---------------------------->getAllHoliday(HttpServletRequest request,HttpServletResponse response)");
        List<SysConfig> sysConfigs= sysConfigService.selectAllSysConfigs();
        request.getSession().setAttribute("sysconfigs",sysConfigs);
        List<Holiday> holidays = holidayService.selectAllHolidays();
        request.getSession().setAttribute("holidays",holidays);
        List<UserInfo> infos = userInfoService.selectAllUserInfos();
        request.getSession().setAttribute("infos",infos);
        List<Dept> depts = deptService.selectAllDepts();
        request.getSession().setAttribute("depts",depts);
        request.getSession().setAttribute("page1",3);
        request.getSession().setAttribute("pageCount",10);
        return "holiday/holidayAll";
    }
    @GetMapping("/modifyholiday")//获得要修改用户信息
    public String modifyUser(@RequestParam("holidayId") int uid,HttpServletRequest request){
        Holiday holiday=holidayService.selectByPrimaryKey(uid);
        request.getSession().setAttribute("holiday",holiday);
        UserInfo info = userInfoService.selectByPrimaryKey(uid);
        request.getSession().setAttribute("info",info);
        List<UserInfo> infos = userInfoService.selectAllUserInfos();
        request.getSession().setAttribute("infos",infos);
        return "holiday/holidayEditor";
    }
    @GetMapping("/detailholiday")//查看用户的详细信息
    public String detailUser(@RequestParam("holidayId") int uid,HttpServletRequest request){
        Holiday holiday=holidayService.selectByPrimaryKey(uid);
        request.getSession().setAttribute("holiday",holiday);
        return "holiday/holidayDetail";
    }
    @GetMapping("/deleteholiday")//是不是可以删除该用户
    public String deleteUser(@RequestParam("holidayId") int uid,HttpServletRequest request){
        int temp=holidayService.deleteByPrimaryKey(uid);
        return "holiday/holidayAll";
    }
    @PostMapping("/editHoliday")//修改用户信息
    public String editHoliday(@ModelAttribute Holiday holiday, HttpServletRequest request){
        //通过主键修改用户信息
        int count=holidayService.updateByPrimaryKeySelective(holiday);
        List<Holiday> holidays=holidayService.selectAllHolidays();
        request.getSession().setAttribute("holidays",holidays);
        List<UserInfo> infos = userInfoService.selectAllUserInfos();
        request.getSession().setAttribute("infos",infos);
        return "holiday/holidayAll";
    }
    @PostMapping("/addHoliday")
    public String addUser(@ModelAttribute Holiday holiday, HttpServletRequest request) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        userInfo.setUserInfoEntryTime(format.parse(date));
        holiday.setHolidayNo("NO"+holiday.getHolidayId());
        holiday.setHolidayHolidayStatus("1");
        holiday.setHolidayCreateTime(new Date());
        holiday.setHolidayUpdateTime(new Date());
        int count = holidayService.insert(holiday);
        //自动生成登录信息（账号：员工编号，密码：111111）写在service中
        //刷新员工列表，返回到用户管理的主页面
        List<Holiday> holidays=holidayService.selectAllHolidays();
        request.getSession().setAttribute("holidays",holidays);
//        List<UserInfo> infos = userInfoService.selectAllUserInfos();
//        request.getSession().setAttribute("infos",infos);
        return "holiday/holidayAll";
    }
    @GetMapping("isExistNo")
    @ResponseBody//跳过视图解析器，只返回一个字符串
    public String isExistNo(@RequestParam("no")int no){
        Holiday holiday=new Holiday();
        holiday.setHolidayId(no);
        List<Holiday> list = holidayService.selectHolidaysByCondition(holiday);
        if(list==null || list.size()==0){
            //没有找到对应编号的员工，编号是可用的
            return "success";
        }else{
            return "error";
        }
    }
}
