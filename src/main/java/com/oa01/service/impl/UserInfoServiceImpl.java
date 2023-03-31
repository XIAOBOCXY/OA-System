package com.oa01.service.impl;

import com.oa01.mapper.LoginMapper;
import com.oa01.model.entity.Login;
import com.oa01.model.entity.UserInfo;
import com.oa.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;
import com.oa01.mapper.UserInfoMapper;
import com.oa01.service.UserInfoService;


/**
 * 
 * UserInfoService业务逻辑操作接口类的实现类
 * 
 **/

@Service
@Transactional
@Slf4j
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	UserInfoMapper userInfoMapper;
	@Autowired
	LoginMapper loginMapper;

	//查询（根据主键ID查询）
	public UserInfo  selectByPrimaryKey (Integer id){
		log.info("通过主键查询UserInfo信息:selectByPrimaryKey() ");
		return userInfoMapper.selectByPrimaryKey(id);
	}

	//查询（获得数据表中的数量）
	public int selectUserInfoCount(){
		log.info("获得UserInfo数量信息:selectUserInfoCount() ");
		return userInfoMapper.selectUserInfoCount();
	}

	//查询全部信息
	public List<UserInfo>  selectAllUserInfos ( ){
		log.info("获得全部UserInfo信息:selectAllUserInfos() ");
		return userInfoMapper.selectAllUserInfos ( );
	}

	//查询（根据其他条件查询需要的结果）

	public int selectUserInfosCountByCondition(Map<String,Object> map){
		log.info("根据其他条件查询需要的UserInfo信息:selectUserInfosCountByCondition() ");
		return userInfoMapper.selectUserInfosCountByCondition(map);
	}

	//查询（通过Map条件，获得所有符合的信息）

	public List<UserInfo> selectUserInfosCondition(Map<String,Object> map){
		log.info("根据其他条件查询需要的UserInfo信息:selectUserInfosCountByCondition() ");
		return userInfoMapper.selectUserInfosCondition(map);
	}

	//查询（通过条件进行分页查询）

	public List<UserInfo> selectUserInfosPerPageByCondition(Map<String,Object> map){
		log.info("通过条件进行分页查询UserInfo信息:selectUserInfosPerPageByCondition() ");
		return userInfoMapper.selectUserInfosPerPageByCondition(map);
	}

	//条件查询
	public List<UserInfo>  selectUserInfosByCondition (UserInfo record){
		log.info("通过传入的参数条件UserInfo信息进行查询:selectUserInfosByCondition () ");
		return userInfoMapper.selectUserInfosByCondition(record);
	}

	//删除（条件删除）
	public int deleteByCondition( UserInfo record ){
		log.info("根据传入的UserInfo信息，条件删除:deleteByCondition() ");
		return userInfoMapper.deleteByCondition(record);
	}

	//删除（根据主键ID删除）
	public int deleteByPrimaryKey (Integer id ){
		log.info("主键ID删除UserInfo信息:deleteByPrimaryKey() ");
		return userInfoMapper.deleteByPrimaryKey(id);
	}

	//添加
	public int insert( UserInfo record ){
		log.info("新增UserInfo信息:insert() ");
		int count = userInfoMapper.insert(record);//增加了员工的信息（获得员工信息中生成主键）
		//增加一个登录信息
		Login loginInfo =new Login();
		loginInfo.setLoginAccount(record.getUserInfoNo());
		String salt = RandomStringUtils.randomAlphabetic(10);
		int index = (int)(Math.random()* MD5Util.TOTAL);
		String newPass = MD5Util.md5To32String("111111",salt,index);
		loginInfo.setLoginPwd(newPass);
		loginInfo.setLoginSalt(salt);
		loginInfo.setLoginIndex(index);
		loginInfo.setLoginRoleId(3);
		loginInfo.setLoginStatus(0);
		loginInfo.setLoginError(0);
		loginInfo.setLoginUserId(record.getUserInfoId());//两个表的关联
		count += loginMapper.insert(loginInfo);
		return count;
	}

	//添加 （匹配有值的字段）
	public int insertSelective( UserInfo record ){
		log.info("新增（匹配有值的字段）UserInfo信息:insertSelective() ");
		return userInfoMapper.insertSelective(record);
	}

	//修改 （匹配有值的字段）
	public int updateByPrimaryKeySelective( UserInfo record ){
		log.info("修改（匹配有值的字段）UserInfo信息:updateByPrimaryKeySelective() ");
		return userInfoMapper.updateByPrimaryKeySelective(record);
	}

	//修改（根据主键ID修改）
	public int updateByPrimaryKey ( UserInfo record ){
		log.info("修改UserInfo信息:updateByPrimaryKey() ");
		return userInfoMapper.updateByPrimaryKey(record);
	}

}