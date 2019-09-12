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
@Table(name = "tbl_sales_store")
public class SaleStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "salesStoreId")
	private Integer salesStoreId;
    @ManyToOne
    @JoinColumn(name = "cartId")
	private Cart cart;
    
    @Column(name = "gross")
	private float gross;
    @Column(name = "taxes")
	private float taxes;
    @Column(name = "net")
	private float net;
     

    @ManyToOne
    @JoinColumn(name = "groupId")
	private Category group;


	public SaleStore() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SaleStore(Integer salesStoreId, Cart cart, float gross, float taxes, float net, Category group) {
		super();
		this.salesStoreId = salesStoreId;
		this.cart = cart;
		this.gross = gross;
		this.taxes = taxes;
		this.net = net;
		this.group = group;
	}


	public Integer getSalesStoreId() {
		return salesStoreId;
	}


	public void setSalesStoreId(Integer salesStoreId) {
		this.salesStoreId = salesStoreId;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public float getGross() {
		return gross;
	}


	public void setGross(float gross) {
		this.gross = gross;
	}


	public float getTaxes() {
		return taxes;
	}


	public void setTaxes(float taxes) {
		this.taxes = taxes;
	}


	public float getNet() {
		return net;
	}


	public void setNet(float net) {
		this.net = net;
	}


	public Category getGroup() {
		return group;
	}


	public void setGroup(Category group) {
		this.group = group;
	}
    
}
