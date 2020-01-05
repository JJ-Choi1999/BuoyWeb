package com.jnc.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_administrators") //与输出的表作映射
public class Administrators {
	@Id	//生成主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//增长策略
	@Column(name="id")	//完成实体类id与数据表中id的映射
	private Integer id;
	@Column(name="usersname")	//完成实体类usersname与数据表中usersname的映射
	private String usersname;
	@Column(name="password")	//完成实体类password与数据表中password的映射
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsersname() {
		return usersname;
	}
	public void setUsersname(String usersname) {
		this.usersname = usersname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", usersname=" + usersname + ", password=" + password + "]";
	}
	
	
}
