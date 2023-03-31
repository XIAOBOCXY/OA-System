package com.oa01.service.impl;

import com.oa01.model.entity.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;
import com.oa01.mapper.DeptMapper;
import com.oa01.service.DeptService;


/**
 * 
 * DeptService业务逻辑操作接口类的实现类
 * 
 **/

@Service
@Transactional
@Slf4j
public class DeptServiceImpl implements DeptService{

	@Autowired
	DeptMapper deptMapper;


	@Override
	public List<Dept> getSecondDepts() {
		log.info("获得所有的二级部门信息");
		//停
		return deptMapper.getSecondDepts();
	}

	//查询（根据主键ID查询）
	public Dept  selectByPrimaryKey (Integer id){
		log.info("通过主键查询Dept信息:selectByPrimaryKey() ");
		return deptMapper.selectByPrimaryKey(id);
	}

	//查询（获得数据表中的数量）
	public int selectDeptCount(){
		log.info("获得Dept数量信息:selectDeptCount() ");
		return deptMapper.selectDeptCount();
	}

	//查询全部信息
	public List<Dept>  selectAllDepts ( ){
		log.info("获得全部Dept信息:selectAllDepts() ");
		return deptMapper.selectAllDepts ( );
	}

	//查询（根据其他条件查询需要的结果）

	public int selectDeptsCountByCondition(Map<String,Object> map){
		log.info("根据其他条件查询需要的Dept信息:selectDeptsCountByCondition() ");
		return deptMapper.selectDeptsCountByCondition(map);
	}

	//查询（通过Map条件，获得所有符合的信息）

	public List<Dept> selectDeptsCondition(Map<String,Object> map){
		log.info("根据其他条件查询需要的Dept信息:selectDeptsCountByCondition() ");
		return deptMapper.selectDeptsCondition(map);
	}

	//查询（通过条件进行分页查询）

	public List<Dept> selectDeptsPerPageByCondition(Map<String,Object> map){
		log.info("通过条件进行分页查询Dept信息:selectDeptsPerPageByCondition() ");
		return deptMapper.selectDeptsPerPageByCondition(map);
	}

	//条件查询
	public List<Dept>  selectDeptsByCondition (Dept record){
		log.info("通过传入的参数条件Dept信息进行查询:selectDeptsByCondition () ");
		return deptMapper.selectDeptsByCondition(record);
	}

	//删除（条件删除）
	public int deleteByCondition( Dept record ){
		log.info("根据传入的Dept信息，条件删除:deleteByCondition() ");
		return deptMapper.deleteByCondition(record);
	}

	//删除（根据主键ID删除）
	public int deleteByPrimaryKey (Integer id ){
		log.info("主键ID删除Dept信息:deleteByPrimaryKey() ");
		return deptMapper.deleteByPrimaryKey(id);
	}

	//添加
	public int insert( Dept record ){
		log.info("新增Dept信息:insert() ");
		return deptMapper.insert(record);
	}

	//添加 （匹配有值的字段）
	public int insertSelective( Dept record ){
		log.info("新增（匹配有值的字段）Dept信息:insertSelective() ");
		return deptMapper.insertSelective(record);
	}

	//修改 （匹配有值的字段）
	public int updateByPrimaryKeySelective( Dept record ){
		log.info("修改（匹配有值的字段）Dept信息:updateByPrimaryKeySelective() ");
		return deptMapper.updateByPrimaryKeySelective(record);
	}

	//修改（根据主键ID修改）
	public int updateByPrimaryKey ( Dept record ){
		log.info("修改Dept信息:updateByPrimaryKey() ");
		return deptMapper.updateByPrimaryKey(record);
	}

}