package com.jnc.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_focus") //与输出的表作映射
public class Focus implements Serializable{
		
	//用户表id
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="focusId")
	private Integer focusId;
	//用户名
	@Column(name="usersName")
	private String usersName;
	//启航点击次数
	@Column(name="goFocusNum")
	private Integer goFocusNum;
	
	//启航点击次数
	@Column(name="buoyFocusNum")
	private Integer buoyFocusNum;
		
	//启航点击次数
	@Column(name="newsFocusNum")
	private Integer newsFocusNum;

	//启航点击次数
	@Column(name="aboutFocusNum")
	private Integer aboutFocusNum;

	public Integer getFocusId() {
		return focusId;
	}

	public void setFocusId(Integer focusId) {
		this.focusId = focusId;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public Integer getGoFocusNum() {
		return goFocusNum;
	}

	public void setGoFocusNum(Integer goFocusNum) {
		this.goFocusNum = goFocusNum;
	}

	public Integer getBuoyFocusNum() {
		return buoyFocusNum;
	}

	public void setBuoyFocusNum(Integer buoyFocusNum) {
		this.buoyFocusNum = buoyFocusNum;
	}

	public Integer getNewsFocusNum() {
		return newsFocusNum;
	}

	public void setNewsFocusNum(Integer newsFocusNum) {
		this.newsFocusNum = newsFocusNum;
	}

	public Integer getAboutFocusNum() {
		return aboutFocusNum;
	}

	public void setAboutFocusNum(Integer aboutFocusNum) {
		this.aboutFocusNum = aboutFocusNum;
	}
	
	
	
	
}
