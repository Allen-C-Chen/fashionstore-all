package com.smoothstack.fs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "groupId")
	private Integer groupId;
    
    @Column(name = "groupName")
	private String groupName;
    @Column(name = "gender")
	private String gender;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(Integer groupId, String groupName, String gender) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.gender = gender;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}




}
