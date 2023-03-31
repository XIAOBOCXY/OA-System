package com.oa01.model.entity;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.*;


/**
 * 
 * 权限信息表
 * 
 **/
@SuppressWarnings("serial")
public class Permissions implements Serializable {

	/**主键，自增**/
	private Integer permissionsId;

	/**角色Id**/
	private Integer permissionsRoleId;

	/**菜单Id**/
	private Integer permissionsMenuId;

	/**创建时间**/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date permissionsCreateTime;



	public void setPermissionsId(Integer permissionsId){
		this.permissionsId = permissionsId;
	}

	public Integer getPermissionsId(){
		return this.permissionsId;
	}

	public void setPermissionsRoleId(Integer permissionsRoleId){
		this.permissionsRoleId = permissionsRoleId;
	}

	public Integer getPermissionsRoleId(){
		return this.permissionsRoleId;
	}

	public void setPermissionsMenuId(Integer permissionsMenuId){
		this.permissionsMenuId = permissionsMenuId;
	}

	public Integer getPermissionsMenuId(){
		return this.permissionsMenuId;
	}

	public void setPermissionsCreateTime(Date permissionsCreateTime){
		this.permissionsCreateTime = permissionsCreateTime;
	}

	public Date getPermissionsCreateTime(){
		return this.permissionsCreateTime;
	}

	@Override
	public String toString() {
		return "Permissions [permissionsId=" + permissionsId + ", permissionsRoleId=" + permissionsRoleId + ", permissionsMenuId=" + permissionsMenuId + ", permissionsCreateTime=" + permissionsCreateTime+ "]";
	}
}
