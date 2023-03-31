package com.oa01.model.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.*;


/**
 * 
 * 请假信息表
 * 
 **/
@SuppressWarnings("serial")
public class Holiday implements Serializable {

	/**主键，自增**/
	private Integer holidayId;

	/**请假条编号**/
	private String holidayNo;

	/**申请人Id**/
	private Integer holidayUserId;

	/**请假的类型**/
	private Integer holidayTypeId;

	/**请假理由**/
	private String holidayBz;

	/**开始时间**/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date holidayStartTime;

	/**结束时间**/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date holidayEndTime;

	/**请假条的状态，1：草稿2：提交**/
	private String holidayHolidayStatus;

	/**审批人Id**/
	private Integer holidayShenpiUserId;

	/**创建时间**/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date holidayCreateTime;

	/**修改时间**/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date holidayUpdateTime;



	public void setHolidayId(Integer holidayId){
		this.holidayId = holidayId;
	}

	public Integer getHolidayId(){
		return this.holidayId;
	}

	public void setHolidayNo(String holidayNo){
		this.holidayNo = holidayNo;
	}

	public String getHolidayNo(){
		return this.holidayNo;
	}

	public void setHolidayUserId(Integer holidayUserId){
		this.holidayUserId = holidayUserId;
	}

	public Integer getHolidayUserId(){
		return this.holidayUserId;
	}

	public void setHolidayTypeId(Integer holidayTypeId){
		this.holidayTypeId = holidayTypeId;
	}

	public Integer getHolidayTypeId(){
		return this.holidayTypeId;
	}

	public void setHolidayBz(String holidayBz){
		this.holidayBz = holidayBz;
	}

	public String getHolidayBz(){
		return this.holidayBz;
	}

	public void setHolidayStartTime(Date holidayStartTime){
		this.holidayStartTime = holidayStartTime;
	}

	public Date getHolidayStartTime(){
		return this.holidayStartTime;
	}

	public void setHolidayEndTime(Date holidayEndTime){
		this.holidayEndTime = holidayEndTime;
	}

	public Date getHolidayEndTime(){
		return this.holidayEndTime;
	}

	public void setHolidayHolidayStatus(String holidayHolidayStatus){
		this.holidayHolidayStatus = holidayHolidayStatus;
	}

	public String getHolidayHolidayStatus(){
		return this.holidayHolidayStatus;
	}

	public void setHolidayShenpiUserId(Integer holidayShenpiUserId){
		this.holidayShenpiUserId = holidayShenpiUserId;
	}

	public Integer getHolidayShenpiUserId(){
		return this.holidayShenpiUserId;
	}

	public void setHolidayCreateTime(Date holidayCreateTime){
		this.holidayCreateTime = holidayCreateTime;
	}

	public Date getHolidayCreateTime(){
		return this.holidayCreateTime;
	}

	public void setHolidayUpdateTime(Date holidayUpdateTime){
		this.holidayUpdateTime = holidayUpdateTime;
	}

	public Date getHolidayUpdateTime(){
		return this.holidayUpdateTime;
	}

	@Override
	public String toString() {
		return "Holiday [holidayId=" + holidayId + ", holidayNo=" + holidayNo + ", holidayUserId=" + holidayUserId + ", holidayTypeId=" + holidayTypeId + ", holidayBz=" + holidayBz + ", holidayStartTime=" + holidayStartTime + ", holidayEndTime=" + holidayEndTime + ", holidayHolidayStatus=" + holidayHolidayStatus + ", holidayShenpiUserId=" + holidayShenpiUserId + ", holidayCreateTime=" + holidayCreateTime + ", holidayUpdateTime=" + holidayUpdateTime+ "]";
	}
}
