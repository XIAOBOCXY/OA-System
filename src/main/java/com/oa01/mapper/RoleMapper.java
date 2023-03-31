package com.oa01.mapper;

import com.oa01.model.entity.Role;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import java.util.List;

/**
 * 
 * RoleMapper数据库操作接口类
 * 
 **/

public interface RoleMapper{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Role  selectByPrimaryKey(@Param("id") Integer id);
	/**
	 * 
	 * 查询（获得数据表中的数量）
	 * 
	 **/
	public int selectRoleCount();

	/**
	 * 
	 * 查询（根据其他条件查询需要的结果）
	 * 
	 **/
	public int selectRolesCountByCondition(Map<String, Object> map);

	/**
	 * 
	 * 查询（通过Map条件进行分页查询）
	 * 
	 **/
	public List<Role> selectRolesPerPageByCondition(Map<String, Object> map);

	/**
	 * 
	 * 查询（通过Map条件，获得所有符合的信息）
	 * 
	 **/
	public List<Role> selectRolesCondition(Map<String, Object> map);

	/**
	 * 
	 * 查询全部信息
	 * 
	 **/
	public List<Role>  selectAllRoles();

	/**
	 * 
	 * 查询（根据实体类的条件查询）
	 * 
	 **/
	public List<Role> selectRolesByCondition(Role record);

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
	public int deleteByCondition(Role record);

	/**
	 * 
	 * 添加
	 * 
	 **/
	public int insert(Role record);

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	public int insertSelective(Role record);

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	public int updateByPrimaryKeySelective(Role record);

	/**
	 * 
	 * 修改（根据主键ID修改）
	 * 
	 **/
	public int updateByPrimaryKey(Role record);

}