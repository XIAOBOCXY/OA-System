package com.oa01.service.impl;

import com.oa01.model.entity.Permissions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;
import com.oa01.mapper.PermissionsMapper;
import com.oa01.service.PermissionsService;


/**
 * 
 * PermissionsService业务逻辑操作接口类的实现类
 * 
 **/

@Service
@Transactional
@Slf4j
public class PermissionsServiceImpl implements PermissionsService{

	@Autowired
	PermissionsMapper permissionsMapper;
	

	//查询（根据主键ID查询）
	public Permissions  selectByPrimaryKey (Integer id){
		log.info("通过主键查询Permissions信息:selectByPrimaryKey() ");
		return permissionsMapper.selectByPrimaryKey(id);
	}

	//查询（获得数据表中的数量）
	public int selectPermissionsCount(){
		log.info("获得Permissions数量信息:selectPermissionsCount() ");
		return permissionsMapper.selectPermissionsCount();
	}

	//查询全部信息
	public List<Permissions>  selectAllPermissionss ( ){
		log.info("获得全部Permissions信息:selectAllPermissionss() ");
		return permissionsMapper.selectAllPermissionss ( );
	}

	//查询（根据其他条件查询需要的结果）

	public int selectPermissionssCountByCondition(Map<String,Object> map){
		log.info("根据其他条件查询需要的Permissions信息:selectPermissionssCountByCondition() ");
		return permissionsMapper.selectPermissionssCountByCondition(map);
	}

	//查询（通过Map条件，获得所有符合的信息）

	public List<Permissions> selectPermissionssCondition(Map<String,Object> map){
		log.info("根据其他条件查询需要的Permissions信息:selectPermissionssCountByCondition() ");
		return permissionsMapper.selectPermissionssCondition(map);
	}

	//查询（通过条件进行分页查询）

	public List<Permissions> selectPermissionssPerPageByCondition(Map<String,Object> map){
		log.info("通过条件进行分页查询Permissions信息:selectPermissionssPerPageByCondition() ");
		return permissionsMapper.selectPermissionssPerPageByCondition(map);
	}

	//条件查询
	public List<Permissions>  selectPermissionssByCondition (Permissions record){
		log.info("通过传入的参数条件Permissions信息进行查询:selectPermissionssByCondition () ");
		return permissionsMapper.selectPermissionssByCondition(record);
	}

	//删除（条件删除）
	public int deleteByCondition( Permissions record ){
		log.info("根据传入的Permissions信息，条件删除:deleteByCondition() ");
		return permissionsMapper.deleteByCondition(record);
	}

	//删除（根据主键ID删除）
	public int deleteByPrimaryKey (Integer id ){
		log.info("主键ID删除Permissions信息:deleteByPrimaryKey() ");
		return permissionsMapper.deleteByPrimaryKey(id);
	}

	//添加
	public int insert( Permissions record ){
		log.info("新增Permissions信息:insert() ");
		return permissionsMapper.insert(record);
	}

	//添加 （匹配有值的字段）
	public int insertSelective( Permissions record ){
		log.info("新增（匹配有值的字段）Permissions信息:insertSelective() ");
		return permissionsMapper.insertSelective(record);
	}

	//修改 （匹配有值的字段）
	public int updateByPrimaryKeySelective( Permissions record ){
		log.info("修改（匹配有值的字段）Permissions信息:updateByPrimaryKeySelective() ");
		return permissionsMapper.updateByPrimaryKeySelective(record);
	}

	//修改（根据主键ID修改）
	public int updateByPrimaryKey ( Permissions record ){
		log.info("修改Permissions信息:updateByPrimaryKey() ");
		return permissionsMapper.updateByPrimaryKey(record);
	}

}