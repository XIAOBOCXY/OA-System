package com.oa01.service;

import com.oa01.model.entity.Holiday;
import java.util.List;
import java.util.Map;

/**
 * 
 * HolidayService业务逻辑操作接口类
 * 
 **/

public interface HolidayService{


	//查询（根据主键ID查询）
	public Holiday  selectByPrimaryKey(Integer id);
	//查询全部信息
	public List<Holiday>  selectAllHolidays();
	//条件查询信息
	public List<Holiday>  selectHolidaysByCondition(Holiday record);
	//查询（获得数据表中的数量）
	public int selectHolidayCount();
	//查询（根据 Map条件查询需要的结果）

	public int selectHolidaysCountByCondition(Map<String, Object> map);

	//查询（通过Map条件，获得所有符合的信息）

	public List<Holiday> selectHolidaysCondition(Map<String, Object> map);
	//查询（通过Map条件进行分页查询）

	public List<Holiday> selectHolidaysPerPageByCondition(Map<String, Object> map);

	//删除（根据主键ID删除）
	public int deleteByPrimaryKey(Integer id);
	//删除（条件删除）
	public int deleteByCondition(Holiday record);
	//添加
	public int insert(Holiday record);
	//添加 （匹配有值的字段）
	public int insertSelective(Holiday record);
	//修改 （匹配有值的字段）
	public int updateByPrimaryKeySelective(Holiday record);
	//修改（根据主键ID修改）
	public int updateByPrimaryKey(Holiday record);

}