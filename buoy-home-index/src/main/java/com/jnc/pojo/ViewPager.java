package com.jnc.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_viewpager") //与输出的表作映射
public class ViewPager {
	//id
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="id")
	private Integer id;
	//标题
	@Column(name="title")
	private String title;
	//标题
	@Column(name="context")
	private String context;
	//标题
	@Column(name="img")
	private String img;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	@Override
	public String toString() {
		return "Viewpager [id=" + id + ", title=" + title + ", context=" + context + ", img=" + img + "]";
	}
	
}
