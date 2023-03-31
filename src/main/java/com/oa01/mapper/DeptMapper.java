package com.oa01.mapper;

import com.oa01.model.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;
import java.util.List;

/**
 * 
 * DeptMapper数据库操作接口类
 * 
 **/
@Mapper //加入注解
public interface DeptMapper{

	//获得所有的二级部门（查询）
	// （1）通过注解编程的方式，这是现在比较流行的方式，比较简单
	//（2）通过接口+xml文件方式，老的方式，更加的成熟，多一个xml文件
	@Select("select * from t_dept where dept_pid=1")
	List<Dept> getSecondDepts();


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Dept  selectByPrimaryKey(@Param("id") Integer id);
	/**
	 * 
	 * 查询（获得数据表中的数量）
	 * 
	 **/
	public int selectDeptCount();

	/**
	 * 
	 * 查询（根据其他条件查询需要的结果）
	 * 
	 **/
	public int selectDeptsCountByCondition(Map<String, Object> map);

	/**
	 * 
	 * 查询（通过Map条件进行分页查询）
	 * 
	 **/
	public List<Dept> selectDeptsPerPageByCondition(Map<String, Object> map);

	/**
	 * 
	 * 查询（通过Map条件，获得所有符合的信息）
	 * 
	 **/
	public List<Dept> selectDeptsCondition(Map<String, Object> map);

	/**
	 * 
	 * 查询全部信息
	 * 
	 **/
	public List<Dept>  selectAllDepts();

	/**
	 * 
	 * 查询（根据实体类的条件查询）
	 * 
	 **/
	public List<Dept> selectDeptsByCondition(Dept record);

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
	public int deleteByCondition(Dept record);

	/**
	 * 
	 * 添加
	 * 
	 **/
	public int insert(Dept record);

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	public int insertSelective(Dept record);

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	public int updateByPrimaryKeySelective(Dept record);

	/**
	 * 
	 * 修改（根据主键ID修改）
	 * 
	 **/
	public int updateByPrimaryKey(Dept record);

}