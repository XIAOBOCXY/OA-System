package com.oa01.service;

import com.oa01.model.entity.Login;
import com.oa01.model.support.MyMessage;

import java.util.List;
import java.util.Map;

/**
 * 
 * LoginService业务逻辑操作接口类
 * 
 **/

public interface LoginService{

	//登录验证
	MyMessage loginValidate(Login login);

	//查询（根据主键ID查询）
	public Login  selectByPrimaryKey(Integer id);
	//查询全部信息
	public List<Login>  selectAllLogins();
	//条件查询信息
	public List<Login>  selectLoginsByCondition(Login record);
	//查询（获得数据表中的数量）
	public int selectLoginCount();
	//查询（根据 Map条件查询需要的结果）

	public int selectLoginsCountByCondition(Map<String, Object> map);

	//查询（通过Map条件，获得所有符合的信息）

	public List<Login> selectLoginsCondition(Map<String, Object> map);
	//查询（通过Map条件进行分页查询）

	public List<Login> selectLoginsPerPageByCondition(Map<String, Object> map);

	//删除（根据主键ID删除）
	public int deleteByPrimaryKey(Integer id);
	//删除（条件删除）
	public int deleteByCondition(Login record);
	//添加
	public int insert(Login record);
	public int insert2(Login record);
	//添加 （匹配有值的字段）
	public int insertSelective(Login record);
	//修改 （匹配有值的字段）
	public int updateByPrimaryKeySelective(Login record);
	//修改（根据主键ID修改）
	public int updateByPrimaryKey(Login record);

}