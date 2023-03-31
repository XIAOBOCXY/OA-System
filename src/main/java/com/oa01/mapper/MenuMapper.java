package com.oa01.mapper;

import com.oa01.model.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;
import java.util.List;

/**
 * 
 * MenuMapper数据库操作接口类
 * 
 **/

public interface MenuMapper{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Menu  selectByPrimaryKey(@Param("id") Integer id);
	/**
	 * 
	 * 查询（获得数据表中的数量）
	 * 
	 **/
	public int selectMenuCount();

	/**
	 * 
	 * 查询（根据其他条件查询需要的结果）
	 * 
	 **/
	public int selectMenusCountByCondition(Map<String, Object> map);

	/**
	 * 
	 * 查询（通过Map条件进行分页查询）
	 * 
	 **/
	public List<Menu> selectMenusPerPageByCondition(Map<String, Object> map);

	/**
	 * 
	 * 查询（通过Map条件，获得所有符合的信息）
	 * 
	 **/
	public List<Menu> selectMenusCondition(Map<String, Object> map);

	/**
	 * 
	 * 查询全部信息
	 * 
	 **/
	public List<Menu>  selectAllMenus();

	/**
	 * 
	 * 查询（根据实体类的条件查询）
	 * 
	 **/
	public List<Menu> selectMenusByCondition(Menu record);

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
	public int deleteByCondition(Menu record);

	/**
	 * 
	 * 添加
	 * 
	 **/
	public int insert(Menu record);

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	public int insertSelective(Menu record);

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	public int updateByPrimaryKeySelective(Menu record);

	/**
	 * 
	 * 修改（根据主键ID修改）
	 * 
	 **/
	public int updateByPrimaryKey(Menu record);
	//通过角色id获得所有二级菜单
	@Select("select m.* from t_menu m inner join t_permissions  p on p.permissions_menu_id=m.menu_id  where m.menu_parent_id <> 0 and p.permissions_role_id=#{roleId} ")
    List<Menu> selectAllMenusByRoleId(@Param("roleId") Integer loginRoleId);

	//通过角色的一级菜单
	@Select("select * from t_menu where menu_parent_id=0")
	List<Menu> selectAllFirstMenus();
}