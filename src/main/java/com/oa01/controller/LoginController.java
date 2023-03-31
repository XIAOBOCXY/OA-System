package com.oa01.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.oa01.model.entity.*;
import com.oa01.model.support.MyMessage;
import com.oa01.model.vo.LoginVo;
import com.oa01.service.DeptService;
import com.oa01.service.LoginService;
import com.oa01.service.RoleService;
import com.oa01.service.UserInfoService;
import com.wf.captcha.utils.CaptchaUtil;
import javafx.scene.control.Alert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
@Slf4j //写日志
public class LoginController {

    @Autowired
    LoginService loginService;
    @Autowired
    DeptService deptService;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    RoleService roleService;

    @GetMapping("/getall")//显示所有员工信息
    public String employeeManagement(HttpServletRequest request){
        HttpSession session = request.getSession();
        //查询对应的部门
        List<Dept> depts = deptService.getSecondDepts();
        //获得所有的员工信息
        List<UserInfo> infos = userInfoService.selectAllUserInfos();
        session.setAttribute("depts",depts);
        session.setAttribute("infos",infos);
        return "user/userAll";
    }
    //验证用户名是否存在
    @GetMapping("/isExist")
    @ResponseBody //绕过视图解析器，返回一个字符串（json对象）
    public String isExist(@RequestParam("username") String name){
        log.info("LoginController------------------->isExist()");
        String result="yes";//yes代表存在，no代表不存在
        //判断是否存在
        Login login = new Login();
        login.setLoginAccount(name);
        List<Login> logins = loginService.selectLoginsByCondition(login);
        if(logins==null || logins.size()==0){
            //数据库中没有，可以使用的账号
        }else{
            result = "no";
        }
        return result;
    }

    //验证用户名是否存在
    @PostMapping("/regist")//做一个简单的数据封装
    @ResponseBody
    public MyMessage regist(@ModelAttribute("login") Login login){
        log.info("LoginController------------------->regist()");
        MyMessage msg=new MyMessage();
        int count = loginService.insert(login);
        //停了，优化service
        if(count==2){
            //成功
            msg.setSuccess(true);
            msg.setMsg("注册成功");
        }else{
            msg.setSuccess(false);
            msg.setMsg("注册失败");
        }
        return msg;

    }

    //登录的方法
    @PostMapping("/loginVo")//
    public String loginVo(@ModelAttribute("vo")LoginVo vo, HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("LoginController------------------->loginVo(LoginVo vo)");
        MyMessage msg=new MyMessage();
       //（1）验证我们输入的验证码是否正确
        if (!CaptchaUtil.ver(vo.getCode(), request)) {
            CaptchaUtil.clear(request);  // 清除session中的验证码
            msg.setMsg("验证码错误");
        }else{
            //如果验证码正确，才去比较，用户名和密码
            //loginService 停止
            Login temp = new Login();
            request.setAttribute( "loginAccount", vo.getLoginAccount());
            temp.setLoginAccount(vo.getLoginAccount());
            temp.setLoginPwd(vo.getLoginPwd());
            msg = loginService.loginValidate(temp);
            if(msg.getSuccess()) {
                Map<String, Object> map = (Map<String, Object>) msg.getObj();
                HttpSession session = request.getSession();//单体项目（项目在同一服务器张），session是可用的，保存需要的相关信息
                // 如果不是单体项目（前后端，前端一个网站，后端是一个网站），token

                session.setAttribute("user", map.get("user"));
                session.setAttribute("frist", map.get("firstMenu"));
                session.setAttribute("role", map.get("role"));
                session.setAttribute("second", map.get("secondMenu"));
                session.setAttribute("info", map.get("info"));
                return "main"; //跳转到首页
            }else{
                //用户名密码错误
                //response.sendRedirect("/");
                request.getSession().setAttribute("msg","用户名或密码错误");
            }

        }
        //验证码错误
        //response.sendRedirect("/");
        request.getSession().setAttribute("msg","验证码错误");
        return "index";
    }
    @GetMapping("/addHLoginPage")
    public String addHLoginPage(){
        return "login/loginAdd";
    }

    @GetMapping("/getInfo")
    public String getInfo(HttpServletRequest request){
        List<Login> logins=loginService.selectAllLogins();
        request.getSession().setAttribute("logins",logins);
        List<Role> roles= roleService.selectAllRoles();
        request.getSession().setAttribute("roles",roles);
        request.getSession().setAttribute("page1",3);
        request.getSession().setAttribute("pageCount",10);
        return "login/loginAll";
    }
    @PostMapping("/addLogin")
    public String addLogin(@ModelAttribute Login login, HttpServletRequest request) {
        login.setLoginPwd("593C9B4A9390551D53E5CACF28EBD638");
        login.setLoginSalt("DcaRpkXGLp");
        login.setLoginIndex(0);
        login.setLoginError(0);
        login.setLoginUserId(login.getLoginId());
        login.setLoginCreateTime(new Date());
        System.out.println(login);
        int count = loginService.insert2(login);
        List<Login> logins = loginService.selectAllLogins();
        request.getSession().setAttribute("logins", logins);
        return "login/loginAll";
    }
    @GetMapping("isExistNo")
    @ResponseBody//跳过视图解析器，只返回一个字符串
    public String isExistNo(@RequestParam("no")int no){
        Login login=new Login();
        login.setLoginId(no);
        List<Login> list = loginService.selectLoginsByCondition(login);
        if(list==null || list.size()==0){
            //没有找到对应编号的员工，编号是可用的
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/deletelogin")//是不是可以删除该用户
    public String deleteUser(@RequestParam("loginId") int uid,HttpServletRequest request){
        int temp=loginService.deleteByPrimaryKey(uid);
        return "login/loginAll";
    }
    @PostMapping("/editLogin")//修改用户信息
    public String editHoliday(@ModelAttribute Login login, HttpServletRequest request){
        //通过主键修改用户信息
        int count=loginService.updateByPrimaryKeySelective(login);
        List<Login> logins=loginService.selectAllLogins();
        request.getSession().setAttribute("logins",logins);
        List<UserInfo> infos = userInfoService.selectAllUserInfos();
        request.getSession().setAttribute("infos",infos);
        return "login/loginAll";
    }
    @GetMapping("/modifylogin")//获得要修改用户信息
    public String modifyUser(@RequestParam("loginId") int uid,HttpServletRequest request){
        Login login=loginService.selectByPrimaryKey(uid);
        request.getSession().setAttribute("login",login);
        List<UserInfo> infos = userInfoService.selectAllUserInfos();
        request.getSession().setAttribute("infos",infos);
        return "login/loginEditor";
    }

    @GetMapping("/passwordModify")
    public String passwordModify( HttpServletRequest request){
        List<Login> logins=loginService.selectAllLogins();
        request.getSession().setAttribute("logins",logins);
        return "login/passwordEditor";
    }

    @PostMapping("/editpassword")//修改用户信息
    public String editpassword(@RequestParam("loginId") Integer loginId,
                               @RequestParam("oldloginPwd") String oldloginPwd,
                               @RequestParam("newloginPwd1") String newloginPwd1,
                               @RequestParam("newloginPwd2") String newloginPwd2,
                               HttpServletRequest request){
        Login login=loginService.selectByPrimaryKey(loginId);
        request.getSession().setAttribute("login",login);
        //通过主键修改用户信息
        if(newloginPwd1.equals(newloginPwd2)){
            login.setLoginPwd(com.oa.util.MD5Util.md5To32String(newloginPwd1,
                    login.getLoginSalt(),login.getLoginIndex()));
            int count=loginService.updateByPrimaryKeySelective(login);
            List<Login> logins=loginService.selectAllLogins();
            request.getSession().setAttribute("logins",logins);
            List<UserInfo> infos = userInfoService.selectAllUserInfos();
            request.getSession().setAttribute("infos",infos);
            return "login/passwordEditor";
        }
        else{
            return "login/passwordEditor";
        }
    }
    @GetMapping("/exit")
    public String exit(){
        return "login/exit";
    }
    @PostMapping("/searchLogin")//查询用户
    public String searchUser(@RequestParam("loginAccount") String loginAccount,
                             @RequestParam("loginStatus") int loginStatus,
                             @RequestParam("loginRoleId") int loginRoleId,
                             HttpServletRequest request){
          Login login=new Login();
        if(loginAccount==null || loginAccount.length()==0){
            //没有填写员工姓名
        }else{
            login.setLoginAccount(loginAccount);
            List<Login> logins=loginService.selectLoginsByCondition(login);
            request.getSession().setAttribute("logins",logins);
            for (Login item:logins){
                int id=item.getLoginId();
                login.setLoginId(id);
            }
        }
        if(loginStatus==0 ){
            login.setLoginStatus(0);
        }
        else if(loginStatus==1){
            login.setLoginStatus(1);
        }
        login.setLoginRoleId(loginRoleId);
        System.out.println("---------------------------------");
        System.out.println(login);
        List<Login> logins=loginService.selectLoginsByCondition(login);
        request.getSession().setAttribute("logins",logins);
        return "login/loginAll";
    }
}
