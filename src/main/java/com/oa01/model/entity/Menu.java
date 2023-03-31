package com.oa01.model.entity;
import java.io.Serializable;
import java.util.*;


/**
 * 
 * 菜单信息表
 * 
 **/
@SuppressWarnings("serial")
public class Menu implements Serializable {

	/**主键，自增**/
	private Integer menuId;

	/**菜单名称，唯一**/
	private String menuName;

	/**对应url**/
	private String menuHrefUrl;

	/**上一级菜单**/
	private Integer menuParentId;

	/**创建时间**/
	private Date menuCreateTime;



	public void setMenuId(Integer menuId){
		this.menuId = menuId;
	}

	public Integer getMenuId(){
		return this.menuId;
	}

	public void setMenuName(String menuName){
		this.menuName = menuName;
	}

	public String getMenuName(){
		return this.menuName;
	}

	public void setMenuHrefUrl(String menuHrefUrl){
		this.menuHrefUrl = menuHrefUrl;
	}

	public String getMenuHrefUrl(){
		return this.menuHrefUrl;
	}

	public void setMenuParentId(Integer menuParentId){
		this.menuParentId = menuParentId;
	}

	public Integer getMenuParentId(){
		return this.menuParentId;
	}

	public void setMenuCreateTime(Date menuCreateTime){
		this.menuCreateTime = menuCreateTime;
	}

	public Date getMenuCreateTime(){
		return this.menuCreateTime;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", menuHrefUrl=" + menuHrefUrl + ", menuParentId=" + menuParentId + ", menuCreateTime=" + menuCreateTime+ "]";
	}
}
