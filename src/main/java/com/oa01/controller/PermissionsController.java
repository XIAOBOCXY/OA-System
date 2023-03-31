package com.oa01.controller;

import com.oa01.model.entity.*;
import com.oa01.service.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.util.calendar.BaseCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Permission;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/permissions")
@Slf4j
public class PermissionsController {
    @Autowired
    HolidayService holidayService;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    DeptService deptService;
    @Autowired
    SysConfigService sysConfigService;
    @Autowired
    PermissionsService permissionsService;
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;

    @GetMapping("/addpermissionsPage")//显示添加请假的页面
    public String addpermissionsPage(HttpServletRequest request){

        List<Role> roles= roleService.selectAllRoles();
        request.getSession().setAttribute("roles",roles);
        List<Menu> menus = menuService.selectAllMenus();
        request.getSession().setAttribute("menus",menus);
        return "permissions/permissionsAdd";
    }

    @GetMapping("/getall")
    public String getAllHoliday(HttpServletRequest request){
        log.info("HolidayController---------------------------->getAllHoliday(HttpServletRequest request,HttpServletResponse response)");
        List<Permissions> permissionss=permissionsService.selectAllPermissionss();
        request.getSession().setAttribute("permissionss",permissionss);
        List<Role> roles= roleService.selectAllRoles();
        request.getSession().setAttribute("roles",roles);
        List<Menu> menus = menuService.selectAllMenus();
        request.getSession().setAttribute("menus",menus);
        request.getSession().setAttribute("page1",3);
        request.getSession().setAttribute("pageCount",10);
        return "permissions/permissionsAll";
    }
    @PostMapping("/addPermissions")
    public String addUser(@ModelAttribute Permissions permissions, HttpServletRequest request) {
        permissions.setPermissionsCreateTime(new Date());
        int count = permissionsService.insert(permissions);
        List<Permissions> permissionss=permissionsService.selectAllPermissionss();
        request.getSession().setAttribute("permissionss",permissionss);
        return "permissions/permissionsAll";
    }
    @GetMapping("isExistNo")
    @ResponseBody//跳过视图解析器，只返回一个字符串
    public String isExistNo(@RequestParam("no")int no){
        Permissions permissions=new Permissions();
        permissions.setPermissionsId(no);
        List<Permissions> list = permissionsService.selectPermissionssByCondition(permissions);
        if(list==null || list.size()==0){
            //没有找到对应编号的员工，编号是可用的
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/deletepermissions")//是不是可以删除该用户
    public String deleteUser(@RequestParam("permissionsId") int uid,HttpServletRequest request){
        int temp=permissionsService.deleteByPrimaryKey(uid);
        return "permissions/permissionsAll";
    }
    @GetMapping("/modifypermissions")//获得要修改用户信息
    public String modifypermissions(@RequestParam("permissionsId") int uid,HttpServletRequest request){
        Permissions permissions=permissionsService.selectByPrimaryKey(uid);
        request.getSession().setAttribute("permissions",permissions);
        List<Role> roles= roleService.selectAllRoles();
        request.getSession().setAttribute("roles",roles);
        List<Menu> menus = menuService.selectAllMenus();
        request.getSession().setAttribute("menus",menus);
        return "permissions/permissionsEditor";
    }
    @PostMapping("/editPermissions")//修改用户信息
    public String editHoliday(@ModelAttribute Permissions permissions, HttpServletRequest request){
        //通过主键修改用户信息
        int count=permissionsService.updateByPrimaryKeySelective(permissions);
        List<Permissions> permissionss=permissionsService.selectAllPermissionss();
        request.getSession().setAttribute("permissionss",permissionss);
        List<Role> roles= roleService.selectAllRoles();
        request.getSession().setAttribute("roles",roles);
        List<Menu> menus = menuService.selectAllMenus();
        request.getSession().setAttribute("menus",menus);
        return "permissions/permissionsAll";
    }
    @PostMapping("/searchPermissions")//查询用户
    public String searchUser(
                             @RequestParam("permissionsRoleId") int permissionsRoleId,
                             @RequestParam("permissionsMenuId") int permissionsMenuId,
                             HttpServletRequest request){
        Permissions permissions=new Permissions();
        if(permissionsRoleId==1 || permissionsRoleId==2 || permissionsRoleId==3 || permissionsRoleId==4 || permissionsRoleId==5 || permissionsRoleId==6 || permissionsRoleId==7){
          permissions.setPermissionsRoleId(permissionsRoleId);
        }
       permissions.setPermissionsMenuId(permissionsMenuId);
        List<Permissions> permissionss=permissionsService.selectPermissionssByCondition(permissions);
        request.getSession().setAttribute("permissionss",permissionss);
        List<Role> roles= roleService.selectAllRoles();
        request.getSession().setAttribute("roles",roles);
        List<Menu> menus = menuService.selectAllMenus();
        request.getSession().setAttribute("menus",menus);
        return "permissions/permissionsAll";
    }
}
