package com.knits.spring.sf.dao;

import java.util.List;

import com.knits.spring.sf.model.Product;

public interface ProductDao {
	
	List<Product> readProducts();
	
	List<Product> readProductsVisible();
	
	List<Product> readProductsUnvisible();
	
	int readProductIdByCol(String name, String dataId);
	
	int readProductIdByRecent();
	
	void editProductVisibilityById(int productId, int option);
	
	void createNewProduct(Product newProduct);
	

}
