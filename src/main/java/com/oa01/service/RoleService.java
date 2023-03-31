package com.oa01.service;

import com.oa01.model.entity.Role;
import java.util.List;
import java.util.Map;

/**
 * 
 * RoleService业务逻辑操作接口类
 * 
 **/

public interface RoleService{


	//查询（根据主键ID查询）
	public Role  selectByPrimaryKey(Integer id);
	//查询全部信息
	public List<Role>  selectAllRoles();
	//条件查询信息
	public List<Role>  selectRolesByCondition(Role record);
	//查询（获得数据表中的数量）
	public int selectRoleCount();
	//查询（根据 Map条件查询需要的结果）

	public int selectRolesCountByCondition(Map<String, Object> map);

	//查询（通过Map条件，获得所有符合的信息）

	public List<Role> selectRolesCondition(Map<String, Object> map);
	//查询（通过Map条件进行分页查询）

	public List<Role> selectRolesPerPageByCondition(Map<String, Object> map);

	//删除（根据主键ID删除）
	public int deleteByPrimaryKey(Integer id);
	//删除（条件删除）
	public int deleteByCondition(Role record);
	//添加
	public int insert(Role record);
	//添加 （匹配有值的字段）
	public int insertSelective(Role record);
	//修改 （匹配有值的字段）
	public int updateByPrimaryKeySelective(Role record);
	//修改（根据主键ID修改）
	public int updateByPrimaryKey(Role record);

}