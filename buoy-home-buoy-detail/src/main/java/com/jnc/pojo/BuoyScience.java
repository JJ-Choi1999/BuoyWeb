package com.jnc.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_buoyscience") // 与输出的表作映射
public class BuoyScience {

	// id
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	// 用户名
	@Column(name="usersname")
	private String usersname;
	// 标题
	@Column(name="title")
	private String title;
	// 时间
	@Column(name="date")
	private String date;
	// 选择
	@Column(name="opt")
	private String option;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	
	
	

}
