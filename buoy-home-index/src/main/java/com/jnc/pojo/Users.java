package com.jnc.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_users") //与输出的表作映射
public class Users implements Serializable{
		
	//用户表id
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="users_id")
	private Integer usersId;
	//用户名
	@Column(name="usersname")
	private String usersName;
	//密码
	@Column(name="password")
	private String passWord;
	
	//进入标识
	@Column(name="users_into")
	private Boolean into;
	//进入时间
	@Column(name="users_into_date")
	private String intoDate;
	//退出标识
	@Column(name="users_exit")
	private Boolean exit;
	//退出时间
	@Column(name="users_exit_date")
	private String exitDate;
	//物理地址
	@Column(name="users_mac_address")
	private String MacAddress;

	//用户图片
	@Column(name="users_img")
	private String img;
	//用户昵称
	@Column(name="users_nickname")
	private String nickname;
	//用户性别
	@Column(name="users_sex")
	private String sex;
	//用户手机号
	@Column(name="users_phone")
	private String phone;
	//物理地址
	@Column(name="users_email")
	private String email;
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMacAddress() {
		return MacAddress;
	}

	public void setMacAddress(String macAddress) {
		MacAddress = macAddress;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Boolean getInto() {
		return into;
	}

	public void setInto(Boolean into) {
		this.into = into;
	}

	public String getIntoDate() {
		return intoDate;
	}

	public void setIntoDate(String intoDate) {
		this.intoDate = intoDate;
	}

	public Boolean getExit() {
		return exit;
	}

	public void setExit(Boolean exit) {
		this.exit = exit;
	}

	public String getExitDate() {
		return exitDate;
	}

	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}
	
	
}
