package com.oa01.model.entity;
import java.io.Serializable;
import java.util.*;


/**
 * 
 * 部门信息表
 * 
 **/
@SuppressWarnings("serial")
public class Dept implements Serializable {

	/**部门序号，主键，自增**/
	private Integer deptId;

	/**部门编号，唯一**/
	private String deptNo;

	/**部门名称**/
	private String deptName;

	/**部门父编号**/
	private Integer deptPid;

	/**负责人名称**/
	private String deptUser;

	/**部门地址**/
	private String deptAddress;



	public void setDeptId(Integer deptId){
		this.deptId = deptId;
	}

	public Integer getDeptId(){
		return this.deptId;
	}

	public void setDeptNo(String deptNo){
		this.deptNo = deptNo;
	}

	public String getDeptNo(){
		return this.deptNo;
	}

	public void setDeptName(String deptName){
		this.deptName = deptName;
	}

	public String getDeptName(){
		return this.deptName;
	}

	public void setDeptPid(Integer deptPid){
		this.deptPid = deptPid;
	}

	public Integer getDeptPid(){
		return this.deptPid;
	}

	public void setDeptUser(String deptUser){
		this.deptUser = deptUser;
	}

	public String getDeptUser(){
		return this.deptUser;
	}

	public void setDeptAddress(String deptAddress){
		this.deptAddress = deptAddress;
	}

	public String getDeptAddress(){
		return this.deptAddress;
	}

	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptNo=" + deptNo + ", deptName=" + deptName + ", deptPid=" + deptPid + ", deptUser=" + deptUser + ", deptAddress=" + deptAddress+ "]";
	}
}
