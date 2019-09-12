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
@Table(name = "tbl_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "productId")
	private Integer productId;
    
    @Column(name = "productName")
	private String productName;
    @Column(name = "productPrice")
	private String productPrice;
    
    @ManyToOne
    @JoinColumn(name = "groupId")
	private Category group;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer productId, String productName, String productPrice, Category group) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.group = group;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public Category getGroup() {
		return group;
	}

	public void setGroup(Category group) {
		this.group = group;
	}
    
    
}
