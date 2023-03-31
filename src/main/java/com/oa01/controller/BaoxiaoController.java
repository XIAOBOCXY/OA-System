package com.oa01.controller;

import com.oa01.model.entity.*;
import com.oa01.service.BaoxiaoService;
import com.oa01.service.DeptService;
import com.oa01.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller //这个类是一个控制器
@RequestMapping("/baoxiao")//注解一个url
@Slf4j
public class BaoxiaoController {

    @Autowired
    BaoxiaoService baoxiaoService;
    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/getall")
    public String getAllHoliday(HttpServletRequest request){
        List<Baoxiao> baoxiaos=baoxiaoService.selectAllBaoxiaos();
        request.getSession().setAttribute("baoxiaos",baoxiaos);
        List<UserInfo> infos = userInfoService.selectAllUserInfos();
        request.getSession().setAttribute("infos",infos);
        request.getSession().setAttribute("page1",3);
        request.getSession().setAttribute("pageCount",10);
        return "baoxiao/baoxiaoAll";
    }
    @GetMapping("/addBaoxiaoPage")//显示添加请假的页面
    public String addHolidayPage(){
        return "baoxiao/baoxiaoAdd";
    }

    @PostMapping("/addBaoxiao")
    public String addUser(@ModelAttribute Baoxiao baoxiao, HttpServletRequest request) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        userInfo.setUserInfoEntryTime(format.parse(date));
//        baoxiao.setHolidayCreateTime(new Date());
//        baoxiao.setHolidayUpdateTime(new Date());
        baoxiao.setBaoxiaoCreateTime(new Date());
        baoxiao.setBaoxiaoNo("bno"+baoxiao.getBaoxiaoId());
        int count = baoxiaoService.insert(baoxiao);
        List<Baoxiao> baoxiaos = baoxiaoService.selectAllBaoxiaos();
        request.getSession().setAttribute("baoxiaos", baoxiaos);
        List<UserInfo> infos = userInfoService.selectAllUserInfos();
        request.getSession().setAttribute("infos",infos);
        return "baoxiao/baoxiaoAll";
    }
    @GetMapping("isExistNo")
    @ResponseBody//跳过视图解析器，只返回一个字符串
    public String isExistNo(@RequestParam("no")int no){
        Baoxiao baoxiao=new Baoxiao();
        baoxiao.setBaoxiaoId(no);
        List<Baoxiao> list = baoxiaoService.selectBaoxiaosByCondition(baoxiao);
        if(list==null || list.size()==0){
            //没有找到对应编号的员工，编号是可用的
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/modifybaoxiao")//获得要修改用户信息
    public String modifyUser(@RequestParam("baoxiaoId") int uid,HttpServletRequest request){
        Baoxiao baoxiao=baoxiaoService.selectByPrimaryKey(uid);
        request.getSession().setAttribute("baoxiao",baoxiao);
        return "baoxiao/baoxiaoEditor";
    }
    @PostMapping("/editBaoxiao")//修改用户信息
    public String editHoliday(@ModelAttribute Baoxiao baoxiao, HttpServletRequest request){
        //通过主键修改用户信息
        int count=baoxiaoService.updateByPrimaryKeySelective(baoxiao);
        List<Baoxiao> baoxiaos = baoxiaoService.selectAllBaoxiaos();
        List<UserInfo> infos = userInfoService.selectAllUserInfos();
        request.getSession().setAttribute("infos",infos);
        request.getSession().setAttribute("baoxiaos", baoxiaos);
        return "baoxiao/baoxiaoAll";
    }
    @GetMapping("/detailbaoxiao")//查看用户的详细信息
    public String detailUser(@RequestParam("baoxiaoId") int uid,HttpServletRequest request){
        Baoxiao baoxiao=baoxiaoService.selectByPrimaryKey(uid);
        request.getSession().setAttribute("baoxiao", baoxiao);
        return "baoxiao/baoxiaoDetail";
    }
    @GetMapping("/deletebaoxiao")//是不是可以删除该用户
    public String deleteUser(@RequestParam("baoxiaoId") int uid,HttpServletRequest request){
        int temp=baoxiaoService.deleteByPrimaryKey(uid);
        return "baoxiao/baoxiaoAll";
    }
    @PostMapping("/searchBaoxiao")//查询用户
    public String searchUser(@RequestParam("baoxiaoType") int baoxiaoType,
                             @RequestParam("baoxiaoStatus") int baoxiaoStatus,
                             HttpServletRequest request){
        Baoxiao baoxiao=new Baoxiao();
        if(baoxiaoType==1 || baoxiaoType==2 || baoxiaoType==3){
            baoxiao.setBaoxiaoType(baoxiaoType);
        }
        if(baoxiaoStatus==1 ){
            baoxiao.setBaoxiaoStatus(1);
        }
        else if(baoxiaoStatus==2){
            baoxiao.setBaoxiaoStatus(2);
        }
        List<Baoxiao> baoxiaos=baoxiaoService.selectBaoxiaosByCondition(baoxiao);
        request.getSession().setAttribute("baoxiaos",baoxiaos);
        return "baoxiao/baoxiaoAll";
    }
}
