package com.oa01.service.impl;

import com.oa01.model.entity.Menu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;
import com.oa01.mapper.MenuMapper;
import com.oa01.service.MenuService;


/**
 * 
 * MenuService业务逻辑操作接口类的实现类
 * 
 **/

@Service
@Transactional
@Slf4j
public class MenuServiceImpl implements MenuService{

	@Autowired
	MenuMapper menuMapper;

	//查询（根据主键ID查询）
	public Menu  selectByPrimaryKey (Integer id){
		log.info("通过主键查询Menu信息:selectByPrimaryKey() ");
		return menuMapper.selectByPrimaryKey(id);
	}

	//查询（获得数据表中的数量）
	public int selectMenuCount(){
		log.info("获得Menu数量信息:selectMenuCount() ");
		return menuMapper.selectMenuCount();
	}

	//查询全部信息
	public List<Menu>  selectAllMenus ( ){
		log.info("获得全部Menu信息:selectAllMenus() ");
		return menuMapper.selectAllMenus ( );
	}

	//查询（根据其他条件查询需要的结果）

	public int selectMenusCountByCondition(Map<String,Object> map){
		log.info("根据其他条件查询需要的Menu信息:selectMenusCountByCondition() ");
		return menuMapper.selectMenusCountByCondition(map);
	}

	//查询（通过Map条件，获得所有符合的信息）

	public List<Menu> selectMenusCondition(Map<String,Object> map){
		log.info("根据其他条件查询需要的Menu信息:selectMenusCountByCondition() ");
		return menuMapper.selectMenusCondition(map);
	}

	//查询（通过条件进行分页查询）

	public List<Menu> selectMenusPerPageByCondition(Map<String,Object> map){
		log.info("通过条件进行分页查询Menu信息:selectMenusPerPageByCondition() ");
		return menuMapper.selectMenusPerPageByCondition(map);
	}

	//条件查询
	public List<Menu>  selectMenusByCondition (Menu record){
		log.info("通过传入的参数条件Menu信息进行查询:selectMenusByCondition () ");
		return menuMapper.selectMenusByCondition(record);
	}

	//删除（条件删除）
	public int deleteByCondition( Menu record ){
		log.info("根据传入的Menu信息，条件删除:deleteByCondition() ");
		return menuMapper.deleteByCondition(record);
	}

	//删除（根据主键ID删除）
	public int deleteByPrimaryKey (Integer id ){
		log.info("主键ID删除Menu信息:deleteByPrimaryKey() ");
		return menuMapper.deleteByPrimaryKey(id);
	}

	//添加
	public int insert( Menu record ){
		log.info("新增Menu信息:insert() ");
		return menuMapper.insert(record);
	}

	//添加 （匹配有值的字段）
	public int insertSelective( Menu record ){
		log.info("新增（匹配有值的字段）Menu信息:insertSelective() ");
		return menuMapper.insertSelective(record);
	}

	//修改 （匹配有值的字段）
	public int updateByPrimaryKeySelective( Menu record ){
		log.info("修改（匹配有值的字段）Menu信息:updateByPrimaryKeySelective() ");
		return menuMapper.updateByPrimaryKeySelective(record);
	}

	//修改（根据主键ID修改）
	public int updateByPrimaryKey ( Menu record ){
		log.info("修改Menu信息:updateByPrimaryKey() ");
		return menuMapper.updateByPrimaryKey(record);
	}

}