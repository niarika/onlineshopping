package com.onlineshopping.admin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.onlineshopping.admin.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
}
/**@Query(value = "SELECT * FROM product WHERE name = ?1", nativeQuery = true)
List<Product> findByName(String productname);

public void deleteByName(String productname);
//public void update(Product productname);

List<Product> findAll();*/