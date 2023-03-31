package com.oa01.service.impl;

import com.oa01.mapper.BaoxiaoMapper;
import com.oa01.model.entity.Baoxiao;
import com.oa01.service.BaoxiaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;


/**
 * 
 * BaoxiaoService业务逻辑操作接口类的实现类
 * 
 **/
@Slf4j
@Service
@Transactional
public class BaoxiaoServiceImpl implements BaoxiaoService {

	@Autowired
	BaoxiaoMapper baoxiaoMapper;


	//查询（根据主键ID查询）
	public Baoxiao selectByPrimaryKey (Integer id){
		log.info("通过主键查询Baoxiao信息:selectByPrimaryKey() ");
		return baoxiaoMapper.selectByPrimaryKey(id);
	}

	//查询（获得数据表中的数量）
	public int selectBaoxiaoCount(){
		log.info("获得Baoxiao数量信息:selectBaoxiaoCount() ");
		return baoxiaoMapper.selectBaoxiaoCount();
	}

	//查询全部信息
	public List<Baoxiao>  selectAllBaoxiaos ( ){
		log.info("获得全部Baoxiao信息:selectAllBaoxiaos() ");
		return baoxiaoMapper.selectAllBaoxiaos ( );
	}

	//查询（根据其他条件查询需要的结果）

	public int selectBaoxiaosCountByCondition(Map<String,Object> map){
		log.info("根据其他条件查询需要的Baoxiao信息:selectBaoxiaosCountByCondition() ");
		return baoxiaoMapper.selectBaoxiaosCountByCondition(map);
	}

	//查询（通过Map条件，获得所有符合的信息）

	public List<Baoxiao> selectBaoxiaosCondition(Map<String,Object> map){
		log.info("根据其他条件查询需要的Baoxiao信息:selectBaoxiaosCountByCondition() ");
		return baoxiaoMapper.selectBaoxiaosCondition(map);
	}

	//查询（通过条件进行分页查询）

	public List<Baoxiao> selectBaoxiaosPerPageByCondition(Map<String,Object> map){
		log.info("通过条件进行分页查询Baoxiao信息:selectBaoxiaosPerPageByCondition() ");
		return baoxiaoMapper.selectBaoxiaosPerPageByCondition(map);
	}

	//条件查询
	public List<Baoxiao>  selectBaoxiaosByCondition (Baoxiao record){
		log.info("通过传入的参数条件Baoxiao信息进行查询:selectBaoxiaosByCondition () ");
		return baoxiaoMapper.selectBaoxiaosByCondition(record);
	}

	//删除（条件删除）
	public int deleteByCondition( Baoxiao record ){
		log.info("根据传入的Baoxiao信息，条件删除:deleteByCondition() ");
		return baoxiaoMapper.deleteByCondition(record);
	}

	//删除（根据主键ID删除）
	public int deleteByPrimaryKey (Integer id ){
		log.info("主键ID删除Baoxiao信息:deleteByPrimaryKey() ");
		return baoxiaoMapper.deleteByPrimaryKey(id);
	}

	//添加
	public int insert( Baoxiao record ){
		log.info("新增Baoxiao信息:insert() ");
		return baoxiaoMapper.insert(record);
	}

	//添加 （匹配有值的字段）
	public int insertSelective( Baoxiao record ){
		log.info("新增（匹配有值的字段）Baoxiao信息:insertSelective() ");
		return baoxiaoMapper.insertSelective(record);
	}

	//修改 （匹配有值的字段）
	public int updateByPrimaryKeySelective( Baoxiao record ){
		log.info("修改（匹配有值的字段）Baoxiao信息:updateByPrimaryKeySelective() ");
		return baoxiaoMapper.updateByPrimaryKeySelective(record);
	}

	//修改（根据主键ID修改）
	public int updateByPrimaryKey ( Baoxiao record ){
		log.info("修改Baoxiao信息:updateByPrimaryKey() ");
		return baoxiaoMapper.updateByPrimaryKey(record);
	}

}