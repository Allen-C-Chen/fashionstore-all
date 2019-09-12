package com.smoothstack.fs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "tbl_coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "couponId")
	private Integer couponId;
    
    @Column(name = "code")
	private String code;
    
    @Column(name = "value")
	private Integer value;
    
    @ManyToOne
    @JoinColumn(name = "groupId")
	private Category group;

	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coupon(Integer couponId, String code, Integer value, Category group) {
		super();
		this.couponId = couponId;
		this.code = code;
		this.value = value;
		this.group = group;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Category getGroup() {
		return group;
	}

	public void setGroup(Category group) {
		this.group = group;
	}

}
