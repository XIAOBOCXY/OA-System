package com.oa01.service.impl;

import com.oa01.model.entity.Holiday;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;
import com.oa01.mapper.HolidayMapper;
import com.oa01.service.HolidayService;


/**
 * 
 * HolidayService业务逻辑操作接口类的实现类
 * 
 **/

@Service
@Transactional
@Slf4j
public class HolidayServiceImpl implements HolidayService{

	@Autowired
	HolidayMapper holidayMapper;
	

	//查询（根据主键ID查询）
	public Holiday  selectByPrimaryKey (Integer id){
		log.info("通过主键查询Holiday信息:selectByPrimaryKey() ");
		return holidayMapper.selectByPrimaryKey(id);
	}

	//查询（获得数据表中的数量）
	public int selectHolidayCount(){
		log.info("获得Holiday数量信息:selectHolidayCount() ");
		return holidayMapper.selectHolidayCount();
	}

	//查询全部信息
	public List<Holiday>  selectAllHolidays ( ){
		log.info("获得全部Holiday信息:selectAllHolidays() ");
		return holidayMapper.selectAllHolidays ( );
	}

	//查询（根据其他条件查询需要的结果）

	public int selectHolidaysCountByCondition(Map<String,Object> map){
		log.info("根据其他条件查询需要的Holiday信息:selectHolidaysCountByCondition() ");
		return holidayMapper.selectHolidaysCountByCondition(map);
	}

	//查询（通过Map条件，获得所有符合的信息）

	public List<Holiday> selectHolidaysCondition(Map<String,Object> map){
		log.info("根据其他条件查询需要的Holiday信息:selectHolidaysCountByCondition() ");
		return holidayMapper.selectHolidaysCondition(map);
	}

	//查询（通过条件进行分页查询）

	public List<Holiday> selectHolidaysPerPageByCondition(Map<String,Object> map){
		log.info("通过条件进行分页查询Holiday信息:selectHolidaysPerPageByCondition() ");
		return holidayMapper.selectHolidaysPerPageByCondition(map);
	}

	//条件查询
	public List<Holiday>  selectHolidaysByCondition (Holiday record){
		log.info("通过传入的参数条件Holiday信息进行查询:selectHolidaysByCondition () ");
		return holidayMapper.selectHolidaysByCondition(record);
	}

	//删除（条件删除）
	public int deleteByCondition( Holiday record ){
		log.info("根据传入的Holiday信息，条件删除:deleteByCondition() ");
		return holidayMapper.deleteByCondition(record);
	}

	//删除（根据主键ID删除）
	public int deleteByPrimaryKey (Integer id ){
		log.info("主键ID删除Holiday信息:deleteByPrimaryKey() ");
		return holidayMapper.deleteByPrimaryKey(id);
	}

	//添加
	public int insert( Holiday record ){
		log.info("新增Holiday信息:insert() ");
		return holidayMapper.insert(record);
	}

	//添加 （匹配有值的字段）
	public int insertSelective( Holiday record ){
		log.info("新增（匹配有值的字段）Holiday信息:insertSelective() ");
		return holidayMapper.insertSelective(record);
	}

	//修改 （匹配有值的字段）
	public int updateByPrimaryKeySelective( Holiday record ){
		log.info("修改（匹配有值的字段）Holiday信息:updateByPrimaryKeySelective() ");
		return holidayMapper.updateByPrimaryKeySelective(record);
	}

	//修改（根据主键ID修改）
	public int updateByPrimaryKey ( Holiday record ){
		log.info("修改Holiday信息:updateByPrimaryKey() ");
		return holidayMapper.updateByPrimaryKey(record);
	}

}