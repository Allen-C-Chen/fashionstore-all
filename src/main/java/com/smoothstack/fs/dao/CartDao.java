package com.smoothstack.fs.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.smoothstack.fs.entity.Cart;
import com.smoothstack.fs.entity.Product;

public interface CartDao extends JpaRepository<Cart, Integer> {
	final static String displayProducstByCartIdQuery = "SELECT * " + 
			"FROM tbl_products;";
	final static String displayProducstByCartIdQuery2 = "SELECT productName, productPrice" + 
			"FROM tbl_cart " + 
			"	INNER JOIN tbl_order " + 
			"		ON tbl_cart.cartId = tbl_order.cartId " + 
			"    INNER JOIN tbl_products " + 
			"		on tbl_order.productId = tbl_products.productId " + 
			"	WHERE tbl_cart.cartId = ?1;";

	final static String findByGender = "SELECT productId, productName, productPrice, tbl_category.groupId " + 
			"FROM tbl_products " + 
			"INNER JOIN tbl_category " + 
			"ON tbl_products.groupId = tbl_category.groupId " + 
			"WHERE gender = male";

	@Query(value = findByGender, nativeQuery = true)
	public Optional<List<Product>> displayProducstByCartId(Integer cartId);

}
