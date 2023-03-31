package com.oa01.service;

import com.oa01.model.entity.Dept;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * DeptService业务逻辑操作接口类
 * 
 **/

public interface DeptService{

	//获得所有的二级部门
	List<Dept> getSecondDepts();


	//查询（根据主键ID查询）
	public Dept  selectByPrimaryKey(Integer id);
	//查询全部信息
	public List<Dept>  selectAllDepts();
	//条件查询信息
	public List<Dept>  selectDeptsByCondition(Dept record);
	//查询（获得数据表中的数量）
	public int selectDeptCount();
	//查询（根据 Map条件查询需要的结果）

	public int selectDeptsCountByCondition(Map<String, Object> map);

	//查询（通过Map条件，获得所有符合的信息）

	public List<Dept> selectDeptsCondition(Map<String, Object> map);
	//查询（通过Map条件进行分页查询）

	public List<Dept> selectDeptsPerPageByCondition(Map<String, Object> map);

	//删除（根据主键ID删除）
	public int deleteByPrimaryKey(Integer id);
	//删除（条件删除）
	public int deleteByCondition(Dept record);
	//添加
	public int insert(Dept record);
	//添加 （匹配有值的字段）
	public int insertSelective(Dept record);
	//修改 （匹配有值的字段）
	public int updateByPrimaryKeySelective(Dept record);
	//修改（根据主键ID修改）
	public int updateByPrimaryKey(Dept record);

}