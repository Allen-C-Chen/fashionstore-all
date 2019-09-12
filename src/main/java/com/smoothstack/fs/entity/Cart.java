package com.smoothstack.fs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "cartId")
	private Integer cartId;
    @Column(name = "cartStatus")
	private String cartStatus;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(Integer cartId, String cartStatus) {
		super();
		this.cartId = cartId;
		this.cartStatus = cartStatus;
	}
	public Cart(Integer cartId) {
		super();
		this.cartId = cartId;
		this.cartStatus = "In proggress";
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public String getCartStatus() {
		return cartStatus;
	}
	public void setCartStatus(String cartStatus) {
		this.cartStatus = cartStatus;
	}
    
}
