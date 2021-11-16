package com.onlineshopping.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshopping.admin.entity.Product;
import com.onlineshopping.admin.service.ProductService;

@RestController

public class AdminController {

	@Autowired
	private ProductService service;

	@GetMapping("/admin")
	public List<Product> getAllproduct() {
		System.out.println(service.getAllproduct());
		return service.getAllproduct();
	}

	@PostMapping("/admin/add")
	public void addProduct(@RequestBody Product product) {
		service.addProduct(product);
	}

	@PostMapping("/admin/update/{productId}")
	public void updateProduct(@RequestBody Product product) {
		service.updateProduct(product);
	}

	@DeleteMapping("/admin/delete/{productId}")
	public void deleteProduct(@PathVariable(required = true) long productId) {
		service.deleteProduct(productId);
	}

}
