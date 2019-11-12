package com.company.df.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.PersistenceConstructor;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_lecture")
@Getter
@Setter
public class Lecture {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
    private Long id;
	
	@Column(name="type")
    private String type;
    
	@Column(name="title")
    private String title;
    
	@Column(name="content")
    private String content;
	
	@Column(name="isShow")
	private String isShow;
     
//	@PersistenceConstructor
	public Lecture() {}
    public Lecture( String type, String title, String content, String isShow)
    {
//    	super();
    	this.type = type;
    	this.title = title;
    	this.content = content; 
    	this.isShow = isShow;
    	
    }
    public Lecture(Long Id, String type, String title, String content, String isShow)
    {
//    	super();
    	this.id = Id;
    	this.type = type;
    	this.title = title;
    	this.content = content; 
    	this.isShow = isShow;
    	
    }



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String gettype() {
		return type;
	}


	public void settype(String type) {
		this.type = type;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	 void setType(String type) {
		this.type = type;
	}
	public String getIsShow() {
		return isShow;
	}
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
}
