package com.oa01.model.entity;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.*;

/**
 * 
 * 报销信息表
 * 
 **/
@SuppressWarnings("serial")
public class Baoxiao implements Serializable {

	/**报销序号**/
	private Integer baoxiaoId;

	/**报销编号**/
	private String baoxiaoNo;

	/**报销申请人**/
	private String baoxiaoUserId;

	/**报销类型**/
	private Integer baoxiaoType;

	/**报销摘要**/
	private String baoxiaoTest;

	/**报销金额**/
	private Integer baoxiaoMoney;

	/**报销申请时间**/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date baoxiaoCreateTime;

	/**报销申请状态**/
	private Integer baoxiaoStatus;



	public void setBaoxiaoId(Integer baoxiaoId){
		this.baoxiaoId = baoxiaoId;
	}

	public Integer getBaoxiaoId(){
		return this.baoxiaoId;
	}

	public void setBaoxiaoNo(String baoxiaoNo){
		this.baoxiaoNo = baoxiaoNo;
	}

	public String getBaoxiaoNo(){
		return this.baoxiaoNo;
	}

	public void setBaoxiaoUserId(String baoxiaoUserId){
		this.baoxiaoUserId = baoxiaoUserId;
	}

	public String getBaoxiaoUserId(){
		return this.baoxiaoUserId;
	}

	public void setBaoxiaoType(Integer baoxiaoType){
		this.baoxiaoType = baoxiaoType;
	}

	public Integer getBaoxiaoType(){
		return this.baoxiaoType;
	}

	public void setBaoxiaoTest(String baoxiaoTest){
		this.baoxiaoTest = baoxiaoTest;
	}

	public String getBaoxiaoTest(){
		return this.baoxiaoTest;
	}

	public void setBaoxiaoMoney(Integer baoxiaoMoney){
		this.baoxiaoMoney = baoxiaoMoney;
	}

	public Integer getBaoxiaoMoney(){
		return this.baoxiaoMoney;
	}

	public void setBaoxiaoCreateTime(java.util.Date baoxiaoCreateTime){
		this.baoxiaoCreateTime = baoxiaoCreateTime;
	}

	public java.util.Date getBaoxiaoCreateTime(){
		return this.baoxiaoCreateTime;
	}

	public void setBaoxiaoStatus(Integer baoxiaoStatus){
		this.baoxiaoStatus = baoxiaoStatus;
	}

	public Integer getBaoxiaoStatus(){
		return this.baoxiaoStatus;
	}

	@Override
	public String toString() {
		return "Baoxiao [baoxiaoId=" + baoxiaoId + ", baoxiaoNo=" + baoxiaoNo + ", baoxiaoUserId=" + baoxiaoUserId + ", baoxiaoType=" + baoxiaoType + ", baoxiaoTest=" + baoxiaoTest + ", baoxiaoMoney=" + baoxiaoMoney + ", baoxiaoCreateTime=" + baoxiaoCreateTime + ", baoxiaoStatus=" + baoxiaoStatus+ "]";
	}
}
