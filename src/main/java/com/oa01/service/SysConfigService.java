package com.oa01.service;

import com.oa01.model.entity.SysConfig;
import java.util.List;
import java.util.Map;

/**
 * 
 * SysConfigService业务逻辑操作接口类
 * 
 **/

public interface SysConfigService{


	//查询（根据主键ID查询）
	public SysConfig  selectByPrimaryKey(Integer id);
	//查询全部信息
	public List<SysConfig>  selectAllSysConfigs();
	//条件查询信息
	public List<SysConfig>  selectSysConfigsByCondition(SysConfig record);
	//查询（获得数据表中的数量）
	public int selectSysConfigCount();
	//查询（根据 Map条件查询需要的结果）

	public int selectSysConfigsCountByCondition(Map<String, Object> map);

	//查询（通过Map条件，获得所有符合的信息）

	public List<SysConfig> selectSysConfigsCondition(Map<String, Object> map);
	//查询（通过Map条件进行分页查询）

	public List<SysConfig> selectSysConfigsPerPageByCondition(Map<String, Object> map);

	//删除（根据主键ID删除）
	public int deleteByPrimaryKey(Integer id);
	//删除（条件删除）
	public int deleteByCondition(SysConfig record);
	//添加
	public int insert(SysConfig record);
	//添加 （匹配有值的字段）
	public int insertSelective(SysConfig record);
	//修改 （匹配有值的字段）
	public int updateByPrimaryKeySelective(SysConfig record);
	//修改（根据主键ID修改）
	public int updateByPrimaryKey(SysConfig record);

}