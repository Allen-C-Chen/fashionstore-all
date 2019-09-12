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
@Table(name = "tbl_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "orderId")
	private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "cartId")
	private Cart cart;
    
    @ManyToOne
    @JoinColumn(name = "productId")
	private Product product;
    @Column(name = "quantity")
	private String quantity;
    @Column(name = "subtotal")
	private float subtotal;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Integer orderId, Cart cart, Product product, String quantity, float subtotal) {
		super();
		this.orderId = orderId;
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

}
