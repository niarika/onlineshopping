package com.onlineshopping.admin.service;

import java.util.List;

import com.onlineshopping.admin.entity.Product;


public interface ProductService {
	Product addProduct(Product product);

	Product updateProduct(Product product);

	List<Product> getAllproduct();

	Product getProductById(long productId);

	void deleteProduct(long productId);

}


