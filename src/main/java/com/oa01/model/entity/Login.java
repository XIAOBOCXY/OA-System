package com.oa01.model.entity;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.*;


/**
 * 
 * 用户登录信息表
 * 
 **/
@SuppressWarnings("serial")
public class Login implements Serializable {

	/**主键，自增**/
	private Integer loginId;

	/**登录名唯一**/
	private String loginAccount;

	/**密码**/
	private String loginPwd;

	/**盐**/
	private String loginSalt;

	/**加密索引**/
	private Integer loginIndex;

	/**状态，1：正常，2：禁用**/
	private Integer loginStatus;

	/**错误次数**/
	private Integer loginError;

	/**用户详细信息的Id**/
	private Integer loginUserId;

	/**角色Id，管理员 普通用户 人事专员**/
	private Integer loginRoleId;

	/**创建时间**/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date loginCreateTime;



	public void setLoginId(Integer loginId){
		this.loginId = loginId;
	}

	public Integer getLoginId(){
		return this.loginId;
	}

	public void setLoginAccount(String loginAccount){
		this.loginAccount = loginAccount;
	}

	public String getLoginAccount(){
		return this.loginAccount;
	}

	public void setLoginPwd(String loginPwd){
		this.loginPwd = loginPwd;
	}

	public String getLoginPwd(){
		return this.loginPwd;
	}

	public void setLoginSalt(String loginSalt){
		this.loginSalt = loginSalt;
	}

	public String getLoginSalt(){
		return this.loginSalt;
	}

	public void setLoginIndex(Integer loginIndex){
		this.loginIndex = loginIndex;
	}

	public Integer getLoginIndex(){
		return this.loginIndex;
	}

	public void setLoginStatus(Integer loginStatus){
		this.loginStatus = loginStatus;
	}

	public Integer getLoginStatus(){
		return this.loginStatus;
	}

	public void setLoginError(Integer loginError){
		this.loginError = loginError;
	}

	public Integer getLoginError(){
		return this.loginError;
	}

	public void setLoginUserId(Integer loginUserId){
		this.loginUserId = loginUserId;
	}

	public Integer getLoginUserId(){
		return this.loginUserId;
	}

	public void setLoginRoleId(Integer loginRoleId){
		this.loginRoleId = loginRoleId;
	}

	public Integer getLoginRoleId(){
		return this.loginRoleId;
	}

	public void setLoginCreateTime(Date loginCreateTime){
		this.loginCreateTime = loginCreateTime;
	}

	public Date getLoginCreateTime(){
		return this.loginCreateTime;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", loginAccount=" + loginAccount + ", loginPwd=" + loginPwd + ", loginSalt=" + loginSalt + ", loginIndex=" + loginIndex + ", loginStatus=" + loginStatus + ", loginError=" + loginError + ", loginUserId=" + loginUserId + ", loginRoleId=" + loginRoleId + ", loginCreateTime=" + loginCreateTime+ "]";
	}
}
