package com.oa01.mapper;

import com.oa01.model.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import java.util.List;

/**
 * 
 * UserInfoMapper数据库操作接口类
 * 
 **/

public interface UserInfoMapper{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	UserInfo  selectByPrimaryKey(@Param("id") Integer id);
	/**
	 * 
	 * 查询（获得数据表中的数量）
	 * 
	 **/
	public int selectUserInfoCount();

	/**
	 * 
	 * 查询（根据其他条件查询需要的结果）
	 * 
	 **/
	public int selectUserInfosCountByCondition(Map<String, Object> map);

	/**
	 * 
	 * 查询（通过Map条件进行分页查询）
	 * 
	 **/
	public List<UserInfo> selectUserInfosPerPageByCondition(Map<String, Object> map);

	/**
	 * 
	 * 查询（通过Map条件，获得所有符合的信息）
	 * 
	 **/
	public List<UserInfo> selectUserInfosCondition(Map<String, Object> map);

	/**
	 * 
	 * 查询全部信息
	 * 
	 **/
	public List<UserInfo>  selectAllUserInfos();

	/**
	 * 
	 * 查询（根据实体类的条件查询）
	 * 
	 **/
	public List<UserInfo> selectUserInfosByCondition(UserInfo record);

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	public int deleteByPrimaryKey(@Param("id") Integer id);

	/**
	 * 
	 * 删除（条件删除）
	 * 
	 **/
	public int deleteByCondition(UserInfo record);

	/**
	 * 
	 * 添加
	 * 
	 **/
	public int insert(UserInfo record);
	public int insert2(UserInfo record);

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	public int insertSelective(UserInfo record);

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	public int updateByPrimaryKeySelective(UserInfo record);

	/**
	 * 
	 * 修改（根据主键ID修改）
	 * 
	 **/
	public int updateByPrimaryKey(UserInfo record);

}