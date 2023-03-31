package com.oa01.model.entity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.*;


/**
 * 
 * 员工信息表
 * 
 **/
@SuppressWarnings("serial")
public class UserInfo implements Serializable {

	/**主键，自增**/
	private Integer userInfoId;

	/**用户编号，员工号**/
	private String userInfoNo;

	/**姓名**/
	private String userName;

	/**所在部门**/
	private Integer userDeptId;

	/**性别**/
	private String userInfoSex;

	/**学历**/
	private String userInfoEducation;

	/**邮箱**/
	private String userInfoEmail;

	/**电话**/
	private String userInfoPhone;

	/**入职时间**/
	private Date userInfoEntryTime;

	/**创建时间**/
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date userInfoCreateTime;



	public void setUserInfoId(Integer userInfoId){
		this.userInfoId = userInfoId;
	}

	public Integer getUserInfoId(){
		return this.userInfoId;
	}

	public void setUserInfoNo(String userInfoNo){
		this.userInfoNo = userInfoNo;
	}

	public String getUserInfoNo(){
		return this.userInfoNo;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return this.userName;
	}

	public void setUserDeptId(Integer userDeptId){
		this.userDeptId = userDeptId;
	}

	public Integer getUserDeptId(){
		return this.userDeptId;
	}

	public void setUserInfoSex(String userInfoSex){
		this.userInfoSex = userInfoSex;
	}

	public String getUserInfoSex(){
		return this.userInfoSex;
	}

	public void setUserInfoEducation(String userInfoEducation){
		this.userInfoEducation = userInfoEducation;
	}

	public String getUserInfoEducation(){
		return this.userInfoEducation;
	}

	public void setUserInfoEmail(String userInfoEmail){
		this.userInfoEmail = userInfoEmail;
	}

	public String getUserInfoEmail(){
		return this.userInfoEmail;
	}

	public void setUserInfoPhone(String userInfoPhone){
		this.userInfoPhone = userInfoPhone;
	}

	public String getUserInfoPhone(){
		return this.userInfoPhone;
	}

	public void setUserInfoEntryTime(Date userInfoEntryTime){
		this.userInfoEntryTime = userInfoEntryTime;
	}

	public Date getUserInfoEntryTime(){
		return this.userInfoEntryTime;
	}

	public void setUserInfoCreateTime(Date userInfoCreateTime){
		this.userInfoCreateTime = userInfoCreateTime;
	}

	public Date getUserInfoCreateTime(){
		return this.userInfoCreateTime;
	}

	@Override
	public String toString() {
		return "UserInfo [userInfoId=" + userInfoId + ", userInfoNo=" + userInfoNo + ", userName=" + userName + ", userDeptId=" + userDeptId + ", userInfoSex=" + userInfoSex + ", userInfoEducation=" + userInfoEducation + ", userInfoEmail=" + userInfoEmail + ", userInfoPhone=" + userInfoPhone + ", userInfoEntryTime=" + userInfoEntryTime + ", userInfoCreateTime=" + userInfoCreateTime+ "]";
	}
}
