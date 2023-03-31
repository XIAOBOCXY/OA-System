package com.oa01.service;

import com.oa01.model.entity.Menu;
import java.util.List;
import java.util.Map;

/**
 * 
 * MenuService业务逻辑操作接口类
 * 
 **/

public interface MenuService{


	//查询（根据主键ID查询）
	public Menu  selectByPrimaryKey(Integer id);
	//查询全部信息
	public List<Menu>  selectAllMenus();
	//条件查询信息
	public List<Menu>  selectMenusByCondition(Menu record);
	//查询（获得数据表中的数量）
	public int selectMenuCount();
	//查询（根据 Map条件查询需要的结果）

	public int selectMenusCountByCondition(Map<String, Object> map);

	//查询（通过Map条件，获得所有符合的信息）

	public List<Menu> selectMenusCondition(Map<String, Object> map);
	//查询（通过Map条件进行分页查询）

	public List<Menu> selectMenusPerPageByCondition(Map<String, Object> map);

	//删除（根据主键ID删除）
	public int deleteByPrimaryKey(Integer id);
	//删除（条件删除）
	public int deleteByCondition(Menu record);
	//添加
	public int insert(Menu record);
	//添加 （匹配有值的字段）
	public int insertSelective(Menu record);
	//修改 （匹配有值的字段）
	public int updateByPrimaryKeySelective(Menu record);
	//修改（根据主键ID修改）
	public int updateByPrimaryKey(Menu record);

}