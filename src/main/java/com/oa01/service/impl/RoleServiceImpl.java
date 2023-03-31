package com.oa01.service.impl;

import com.oa01.model.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;
import com.oa01.mapper.RoleMapper;
import com.oa01.service.RoleService;


/**
 * 
 * RoleService业务逻辑操作接口类的实现类
 * 
 **/

@Service
@Transactional
@Slf4j
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleMapper roleMapper;


	//查询（根据主键ID查询）
	public Role  selectByPrimaryKey (Integer id){
		log.info("通过主键查询Role信息:selectByPrimaryKey() ");
		return roleMapper.selectByPrimaryKey(id);
	}

	//查询（获得数据表中的数量）
	public int selectRoleCount(){
		log.info("获得Role数量信息:selectRoleCount() ");
		return roleMapper.selectRoleCount();
	}

	//查询全部信息
	public List<Role>  selectAllRoles ( ){
		log.info("获得全部Role信息:selectAllRoles() ");
		return roleMapper.selectAllRoles ( );
	}

	//查询（根据其他条件查询需要的结果）

	public int selectRolesCountByCondition(Map<String,Object> map){
		log.info("根据其他条件查询需要的Role信息:selectRolesCountByCondition() ");
		return roleMapper.selectRolesCountByCondition(map);
	}

	//查询（通过Map条件，获得所有符合的信息）

	public List<Role> selectRolesCondition(Map<String,Object> map){
		log.info("根据其他条件查询需要的Role信息:selectRolesCountByCondition() ");
		return roleMapper.selectRolesCondition(map);
	}

	//查询（通过条件进行分页查询）

	public List<Role> selectRolesPerPageByCondition(Map<String,Object> map){
		log.info("通过条件进行分页查询Role信息:selectRolesPerPageByCondition() ");
		return roleMapper.selectRolesPerPageByCondition(map);
	}

	//条件查询
	public List<Role>  selectRolesByCondition (Role record){
		log.info("通过传入的参数条件Role信息进行查询:selectRolesByCondition () ");
		return roleMapper.selectRolesByCondition(record);
	}

	//删除（条件删除）
	public int deleteByCondition( Role record ){
		log.info("根据传入的Role信息，条件删除:deleteByCondition() ");
		return roleMapper.deleteByCondition(record);
	}

	//删除（根据主键ID删除）
	public int deleteByPrimaryKey (Integer id ){
		log.info("主键ID删除Role信息:deleteByPrimaryKey() ");
		return roleMapper.deleteByPrimaryKey(id);
	}

	//添加
	public int insert( Role record ){
		log.info("新增Role信息:insert() ");
		return roleMapper.insert(record);
	}

	//添加 （匹配有值的字段）
	public int insertSelective( Role record ){
		log.info("新增（匹配有值的字段）Role信息:insertSelective() ");
		return roleMapper.insertSelective(record);
	}

	//修改 （匹配有值的字段）
	public int updateByPrimaryKeySelective( Role record ){
		log.info("修改（匹配有值的字段）Role信息:updateByPrimaryKeySelective() ");
		return roleMapper.updateByPrimaryKeySelective(record);
	}

	//修改（根据主键ID修改）
	public int updateByPrimaryKey ( Role record ){
		log.info("修改Role信息:updateByPrimaryKey() ");
		return roleMapper.updateByPrimaryKey(record);
	}

}