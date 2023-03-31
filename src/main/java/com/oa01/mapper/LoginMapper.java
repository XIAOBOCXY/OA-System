package com.oa01.mapper;

import com.oa01.model.entity.Login;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import java.util.List;

/**
 * 
 * LoginMapper数据库操作接口类
 * 
 **/

public interface LoginMapper{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Login  selectByPrimaryKey(@Param("id") Integer id);
	/**
	 * 
	 * 查询（获得数据表中的数量）
	 * 
	 **/
	public int selectLoginCount();

	/**
	 * 
	 * 查询（根据其他条件查询需要的结果）
	 * 
	 **/
	public int selectLoginsCountByCondition(Map<String, Object> map);

	/**
	 * 
	 * 查询（通过Map条件进行分页查询）
	 * 
	 **/
	public List<Login> selectLoginsPerPageByCondition(Map<String, Object> map);

	/**
	 * 
	 * 查询（通过Map条件，获得所有符合的信息）
	 * 
	 **/
	public List<Login> selectLoginsCondition(Map<String, Object> map);

	/**
	 * 
	 * 查询全部信息
	 * 
	 **/
	public List<Login>  selectAllLogins();

	/**
	 * 
	 * 查询（根据实体类的条件查询）
	 * 
	 **/
	public List<Login> selectLoginsByCondition(Login record);

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	public int deleteByPrimaryKey(@Param("id") Integer id);

	/**
	 * 
	 * 删除（条件删除）
	 * 
	 **/
	public int deleteByCondition(Login record);

	/**
	 * 
	 * 添加
	 * 
	 **/
	public int insert(Login record);
	public int insert2(Login record);

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	public int insertSelective(Login record);

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	public int updateByPrimaryKeySelective(Login record);

	/**
	 * 
	 * 修改（根据主键ID修改）
	 * 
	 **/
	public int updateByPrimaryKey(Login record);

}