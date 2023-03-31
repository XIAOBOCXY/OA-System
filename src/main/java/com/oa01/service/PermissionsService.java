package com.oa01.service;

import com.oa01.model.entity.Permissions;
import java.util.List;
import java.util.Map;

/**
 * 
 * PermissionsService业务逻辑操作接口类
 * 
 **/

public interface PermissionsService{


	//查询（根据主键ID查询）
	public Permissions  selectByPrimaryKey(Integer id);
	//查询全部信息
	public List<Permissions>  selectAllPermissionss();
	//条件查询信息
	public List<Permissions>  selectPermissionssByCondition(Permissions record);
	//查询（获得数据表中的数量）
	public int selectPermissionsCount();
	//查询（根据 Map条件查询需要的结果）

	public int selectPermissionssCountByCondition(Map<String, Object> map);

	//查询（通过Map条件，获得所有符合的信息）

	public List<Permissions> selectPermissionssCondition(Map<String, Object> map);
	//查询（通过Map条件进行分页查询）

	public List<Permissions> selectPermissionssPerPageByCondition(Map<String, Object> map);

	//删除（根据主键ID删除）
	public int deleteByPrimaryKey(Integer id);
	//删除（条件删除）
	public int deleteByCondition(Permissions record);
	//添加
	public int insert(Permissions record);
	//添加 （匹配有值的字段）
	public int insertSelective(Permissions record);
	//修改 （匹配有值的字段）
	public int updateByPrimaryKeySelective(Permissions record);
	//修改（根据主键ID修改）
	public int updateByPrimaryKey(Permissions record);

}