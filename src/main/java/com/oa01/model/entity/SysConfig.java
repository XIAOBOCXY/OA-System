package com.oa01.model.entity;
import java.io.Serializable;
import java.util.*;


/**
 * 
 * 配置信息表
 * 
 **/
@SuppressWarnings("serial")
public class SysConfig implements Serializable {

	/**主键，自增**/
	private Integer configId;

	/**配置类型（请假，报销关键字）**/
	private String configType;

	/**该配置项的key值(用于请假，还是报销)**/
	private String configKey;

	/**页面显示值（例如，丧假是带薪的，如果是直系亲属5天，旁系亲属2天，）**/
	private String configPageValue;

	/**创建时间**/
	private Date configCreateTime;



	public void setConfigId(Integer configId){
		this.configId = configId;
	}

	public Integer getConfigId(){
		return this.configId;
	}

	public void setConfigType(String configType){
		this.configType = configType;
	}

	public String getConfigType(){
		return this.configType;
	}

	public void setConfigKey(String configKey){
		this.configKey = configKey;
	}

	public String getConfigKey(){
		return this.configKey;
	}

	public void setConfigPageValue(String configPageValue){
		this.configPageValue = configPageValue;
	}

	public String getConfigPageValue(){
		return this.configPageValue;
	}

	public void setConfigCreateTime(Date configCreateTime){
		this.configCreateTime = configCreateTime;
	}

	public Date getConfigCreateTime(){
		return this.configCreateTime;
	}

	@Override
	public String toString() {
		return "SysConfig [configId=" + configId + ", configType=" + configType + ", configKey=" + configKey + ", configPageValue=" + configPageValue + ", configCreateTime=" + configCreateTime+ "]";
	}
}
