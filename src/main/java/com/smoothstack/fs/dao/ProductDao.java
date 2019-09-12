package com.smoothstack.fs.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.smoothstack.fs.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	final static String findByGender = "SELECT productId, productName, productPrice, tbl_category.groupId " + 
			"FROM tbl_products " + 
			"INNER JOIN tbl_category " + 
			"ON tbl_products.groupId = tbl_category.groupId " + 
			"WHERE gender = ?1";
	final static String displayProducstByCartIdQuery = "SELECT tbl_products.productId, productName, productPrice, groupId " + 
			"FROM tbl_cart " + 
			"INNER JOIN tbl_order " + 
			"ON tbl_cart.cartId = tbl_order.cartId " + 
			"INNER JOIN tbl_products " + 
			"on tbl_order.productId = tbl_products.productId " + 
			"WHERE tbl_cart.cartId = ?1";

	//    public List<BookCopies> findByid_libraryBranch_branchID(Integer branchID);
//public List<Product> findById_
	@Query(value = findByGender, nativeQuery = true)
	public Optional<List<Product>> findByGender(String gender);

	@Query(value = displayProducstByCartIdQuery, nativeQuery = true)
	public Optional<List<Product>> displayProdcutsByCartId(int cartId);

}
