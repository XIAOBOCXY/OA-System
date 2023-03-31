package com.oa01.mapper;

import com.oa01.model.entity.Baoxiao;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import java.util.List;



/**
 * 
 * BaoxiaoMapper数据库操作接口类
 * 
 **/

public interface BaoxiaoMapper{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Baoxiao selectByPrimaryKey (@Param("id") Integer id );
	/**
	 * 
	 * 查询（获得数据表中的数量）
	 * 
	 **/
	public int selectBaoxiaoCount();

	/**
	 * 
	 * 查询（根据其他条件查询需要的结果）
	 * 
	 **/
	public int selectBaoxiaosCountByCondition(Map<String,Object> map);

	/**
	 * 
	 * 查询（通过Map条件进行分页查询）
	 * 
	 **/
	public List<Baoxiao> selectBaoxiaosPerPageByCondition(Map<String,Object> map);

	/**
	 * 
	 * 查询（通过Map条件，获得所有符合的信息）
	 * 
	 **/
	public List<Baoxiao> selectBaoxiaosCondition(Map<String,Object> map);

	/**
	 * 
	 * 查询全部信息
	 * 
	 **/
	public List<Baoxiao>  selectAllBaoxiaos ( );

	/**
	 * 
	 * 查询（根据实体类的条件查询）
	 * 
	 **/
	public List<Baoxiao> selectBaoxiaosByCondition (Baoxiao record);

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	public int deleteByPrimaryKey ( @Param("id") Integer id );

	/**
	 * 
	 * 删除（条件删除）
	 * 
	 **/
	public int deleteByCondition( Baoxiao record );

	/**
	 * 
	 * 添加
	 * 
	 **/
	public int insert( Baoxiao record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	public int insertSelective( Baoxiao record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	public int updateByPrimaryKeySelective( Baoxiao record );

	/**
	 * 
	 * 修改（根据主键ID修改）
	 * 
	 **/
	public int updateByPrimaryKey ( Baoxiao record );

}