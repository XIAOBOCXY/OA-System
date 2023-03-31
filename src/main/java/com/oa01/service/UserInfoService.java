package com.oa01.service;

import com.oa01.model.entity.UserInfo;
import java.util.List;
import java.util.Map;

/**
 * 
 * UserInfoService业务逻辑操作接口类
 * 
 **/

public interface UserInfoService{


	//查询（根据主键ID查询）
	public UserInfo  selectByPrimaryKey(Integer id);
	//查询全部信息
	public List<UserInfo>  selectAllUserInfos();
	//条件查询信息
	public List<UserInfo>  selectUserInfosByCondition(UserInfo record);
	//查询（获得数据表中的数量）
	public int selectUserInfoCount();
	//查询（根据 Map条件查询需要的结果）

	public int selectUserInfosCountByCondition(Map<String, Object> map);

	//查询（通过Map条件，获得所有符合的信息）

	public List<UserInfo> selectUserInfosCondition(Map<String, Object> map);
	//查询（通过Map条件进行分页查询）

	public List<UserInfo> selectUserInfosPerPageByCondition(Map<String, Object> map);

	//删除（根据主键ID删除）
	public int deleteByPrimaryKey(Integer id);
	//删除（条件删除）
	public int deleteByCondition(UserInfo record);
	//添加
	public int insert(UserInfo record);
	//添加 （匹配有值的字段）
	public int insertSelective(UserInfo record);
	//修改 （匹配有值的字段）
	public int updateByPrimaryKeySelective(UserInfo record);
	//修改（根据主键ID修改）
	public int updateByPrimaryKey(UserInfo record);

}