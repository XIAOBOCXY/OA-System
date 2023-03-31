package com.oa01.model.entity;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.*;


/**
 * 
 * 角色信息表
 * 
 **/
@SuppressWarnings("serial")
public class Role implements Serializable {

	/**主键，自增**/
	private Integer roleId;

	/**角色名，唯一**/
	private String roleName;

	/**创建时间**/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date roleCreateTime;



	public void setRoleId(Integer roleId){
		this.roleId = roleId;
	}

	public Integer getRoleId(){
		return this.roleId;
	}

	public void setRoleName(String roleName){
		this.roleName = roleName;
	}

	public String getRoleName(){
		return this.roleName;
	}

	public void setRoleCreateTime(Date roleCreateTime){
		this.roleCreateTime = roleCreateTime;
	}

	public Date getRoleCreateTime(){
		return this.roleCreateTime;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleCreateTime=" + roleCreateTime+ "]";
	}
}
