package com.oa01.service.impl;

import com.oa01.mapper.MenuMapper;
import com.oa01.mapper.RoleMapper;
import com.oa01.mapper.UserInfoMapper;
import com.oa01.model.entity.Login;
import com.oa01.model.entity.Menu;
import com.oa01.model.entity.Role;
import com.oa01.model.entity.UserInfo;
import com.oa01.model.support.MyMessage;
import com.oa.util.MD5Util;
import jdk.internal.instrumentation.Logger;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.oa01.mapper.LoginMapper;
import com.oa01.service.LoginService;


/**
 * 
 * LoginService业务逻辑操作接口类的实现类
 * 
 **/

@Service
@Transactional
@Slf4j
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginMapper loginMapper;

	@Autowired
	UserInfoMapper userInfoMapper;

	@Autowired
	RoleMapper roleMapper;

	@Autowired
	MenuMapper menuMapper;


	@Override
	public MyMessage loginValidate(Login login) {
		log.info("验证是否登录成功：loginValidate(Login login)");
		MyMessage msg = new MyMessage();
		//（1）通过用户名，获得用户信息
		Login temp = new Login();
		temp.setLoginAccount(login.getLoginAccount());
		List<Login> logins = loginMapper.selectLoginsByCondition(temp);
		if(logins==null || logins.size()==0){
			//没有找到，用户名错了
			msg.setMsg("用户名或密码错误，请确认后再次登录");
		}else{
			//找到了，该用户已经被禁用
			Login result = logins.get(0);
			if (result.getLoginStatus()==1){
				msg.setMsg("用户已经被禁用，请联系管理员");
			}else{
				//用户没有被禁用，加密密码后比对
				String pwd = MD5Util.md5To32String(login.getLoginPwd(),
						result.getLoginSalt(),result.getLoginIndex());
				if(pwd.equalsIgnoreCase(result.getLoginPwd())){
					//用户名与密码是正确的，登录成功
					msg.setMsg("登录成功");
					msg.setSuccess(true);
					//错误次数清零
					result.setLoginError(0);
					//获得用户对应的角色
					Role role = roleMapper.selectByPrimaryKey(result.getLoginRoleId());

					//获得用户对应的权限菜单
					//获得一级菜单
					List<Menu> firstMenu = menuMapper.selectAllFirstMenus();
					//获得二级菜单
					List<Menu> menus = menuMapper.selectAllMenusByRoleId(result.getLoginRoleId());
					// 获得用户详细信息
					UserInfo info = userInfoMapper.selectByPrimaryKey(result.getLoginUserId());
					Map<String,Object> map = new HashMap<>();
					map.put("user",result);//登录信息
					map.put("role",role);//角色
					map.put("firstMenu",firstMenu);//一级菜单
					map.put("secondMenu",menus);//对应角色的二级菜单
					map.put("info",info);//获得用户的相信信息
					msg.setObj(map);//保存在msg中，传给controller
				}else{
					//用户名对的，密码是错误的，登录失败
					//错误次数+1；
					result.setLoginError(result.getLoginError()+1);
					msg.setMsg("用户名或密码错误，请确认后再次登录");
					//如果是连续5次错误，锁定账户
					if (result.getLoginError()>=5){
						result.setLoginStatus(1);
						msg.setMsg("连续5次密码错误，账户锁定，请联系管理员");
					}
				}
				//更改数据库
				loginMapper.updateByPrimaryKey(result);
			}
		}
		return msg;
	}

	//查询（根据主键ID查询）
	public Login  selectByPrimaryKey (Integer id){
		log.info("通过主键查询Login信息:selectByPrimaryKey() ");
		return loginMapper.selectByPrimaryKey(id);
	}

	//查询（获得数据表中的数量）
	public int selectLoginCount(){
		log.info("获得Login数量信息:selectLoginCount() ");
		return loginMapper.selectLoginCount();
	}

	//查询全部信息
	public List<Login>  selectAllLogins ( ){
		log.info("获得全部Login信息:selectAllLogins() ");
		return loginMapper.selectAllLogins ( );
	}

	//查询（根据其他条件查询需要的结果）

	public int selectLoginsCountByCondition(Map<String,Object> map){
		log.info("根据其他条件查询需要的Login信息:selectLoginsCountByCondition() ");
		return loginMapper.selectLoginsCountByCondition(map);
	}

	//查询（通过Map条件，获得所有符合的信息）

	public List<Login> selectLoginsCondition(Map<String,Object> map){
		log.info("根据其他条件查询需要的Login信息:selectLoginsCountByCondition() ");
		return loginMapper.selectLoginsCondition(map);
	}

	//查询（通过条件进行分页查询）

	public List<Login> selectLoginsPerPageByCondition(Map<String,Object> map){
		log.info("通过条件进行分页查询Login信息:selectLoginsPerPageByCondition() ");
		return loginMapper.selectLoginsPerPageByCondition(map);
	}

	//条件查询
	public List<Login>  selectLoginsByCondition (Login record){
		log.info("通过传入的参数条件Login信息进行查询:selectLoginsByCondition () ");
		return loginMapper.selectLoginsByCondition(record);
	}

	//删除（条件删除）
	public int deleteByCondition( Login record ){
		log.info("根据传入的Login信息，条件删除:deleteByCondition() ");
		return loginMapper.deleteByCondition(record);
	}

	//删除（根据主键ID删除）
	public int deleteByPrimaryKey (Integer id ){
		log.info("主键ID删除Login信息:deleteByPrimaryKey() ");
		return loginMapper.deleteByPrimaryKey(id);
	}

	//添加
	public int insert( Login record ){
		log.info("新增Login信息:insert() ");
		//处理用户的详细信息
		UserInfo info = new UserInfo();
		int num = 100000+(int)(Math.random()*900000);
		info.setUserInfoNo("No"+num);
		int count=userInfoMapper.insert2(info);//添加一个用户的详细信息
		System.out.println("id:"+info.getUserInfoId());
		//处理用户名与密码
		record.setLoginUserId(info.getUserInfoId());//关联
		//加盐（随机字符串，10个长度）
		String salt= RandomStringUtils.randomAlphabetic(10);

		//获得index(0-9)
		int index = (int)(Math.random()* MD5Util.TOTAL);
		String newPass=MD5Util.md5To32String(record.getLoginPwd(),salt,index);
		record.setLoginPwd(newPass);
		record.setLoginIndex(index);
		record.setLoginSalt(salt);
		count+= loginMapper.insert2(record);
		return count;
	}
	public int insert2( Login record ){
		log.info("新增Login信息:insert() ");
		return loginMapper.insert(record);
	}

	//添加 （匹配有值的字段）
	public int insertSelective( Login record ){
		log.info("新增（匹配有值的字段）Login信息:insertSelective() ");
		return loginMapper.insertSelective(record);
	}

	//修改 （匹配有值的字段）
	public int updateByPrimaryKeySelective( Login record ){
		log.info("修改（匹配有值的字段）Login信息:updateByPrimaryKeySelective() ");
		return loginMapper.updateByPrimaryKeySelective(record);
	}

	//修改（根据主键ID修改）
	public int updateByPrimaryKey ( Login record ){
		log.info("修改Login信息:updateByPrimaryKey() ");
		return loginMapper.updateByPrimaryKey(record);
	}

}