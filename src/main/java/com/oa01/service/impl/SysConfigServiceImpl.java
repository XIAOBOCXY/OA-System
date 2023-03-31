package com.oa01.service.impl;

import com.oa01.model.entity.SysConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;
import com.oa01.mapper.SysConfigMapper;
import com.oa01.service.SysConfigService;


/**
 * 
 * SysConfigService业务逻辑操作接口类的实现类
 * 
 **/

@Service
@Transactional
@Slf4j
public class SysConfigServiceImpl implements SysConfigService{

	@Autowired
	SysConfigMapper sysConfigMapper;
	

	//查询（根据主键ID查询）
	public SysConfig  selectByPrimaryKey (Integer id){
		log.info("通过主键查询SysConfig信息:selectByPrimaryKey() ");
		return sysConfigMapper.selectByPrimaryKey(id);
	}

	//查询（获得数据表中的数量）
	public int selectSysConfigCount(){
		log.info("获得SysConfig数量信息:selectSysConfigCount() ");
		return sysConfigMapper.selectSysConfigCount();
	}

	//查询全部信息
	public List<SysConfig>  selectAllSysConfigs ( ){
		log.info("获得全部SysConfig信息:selectAllSysConfigs() ");
		return sysConfigMapper.selectAllSysConfigs ( );
	}

	//查询（根据其他条件查询需要的结果）

	public int selectSysConfigsCountByCondition(Map<String,Object> map){
		log.info("根据其他条件查询需要的SysConfig信息:selectSysConfigsCountByCondition() ");
		return sysConfigMapper.selectSysConfigsCountByCondition(map);
	}

	//查询（通过Map条件，获得所有符合的信息）

	public List<SysConfig> selectSysConfigsCondition(Map<String,Object> map){
		log.info("根据其他条件查询需要的SysConfig信息:selectSysConfigsCountByCondition() ");
		return sysConfigMapper.selectSysConfigsCondition(map);
	}

	//查询（通过条件进行分页查询）

	public List<SysConfig> selectSysConfigsPerPageByCondition(Map<String,Object> map){
		log.info("通过条件进行分页查询SysConfig信息:selectSysConfigsPerPageByCondition() ");
		return sysConfigMapper.selectSysConfigsPerPageByCondition(map);
	}

	//条件查询
	public List<SysConfig>  selectSysConfigsByCondition (SysConfig record){
		log.info("通过传入的参数条件SysConfig信息进行查询:selectSysConfigsByCondition () ");
		return sysConfigMapper.selectSysConfigsByCondition(record);
	}

	//删除（条件删除）
	public int deleteByCondition( SysConfig record ){
		log.info("根据传入的SysConfig信息，条件删除:deleteByCondition() ");
		return sysConfigMapper.deleteByCondition(record);
	}

	//删除（根据主键ID删除）
	public int deleteByPrimaryKey (Integer id ){
		log.info("主键ID删除SysConfig信息:deleteByPrimaryKey() ");
		return sysConfigMapper.deleteByPrimaryKey(id);
	}

	//添加
	public int insert( SysConfig record ){
		log.info("新增SysConfig信息:insert() ");
		return sysConfigMapper.insert(record);
	}

	//添加 （匹配有值的字段）
	public int insertSelective( SysConfig record ){
		log.info("新增（匹配有值的字段）SysConfig信息:insertSelective() ");
		return sysConfigMapper.insertSelective(record);
	}

	//修改 （匹配有值的字段）
	public int updateByPrimaryKeySelective( SysConfig record ){
		log.info("修改（匹配有值的字段）SysConfig信息:updateByPrimaryKeySelective() ");
		return sysConfigMapper.updateByPrimaryKeySelective(record);
	}

	//修改（根据主键ID修改）
	public int updateByPrimaryKey ( SysConfig record ){
		log.info("修改SysConfig信息:updateByPrimaryKey() ");
		return sysConfigMapper.updateByPrimaryKey(record);
	}

}