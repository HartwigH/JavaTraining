package com.knits.spring.sf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knits.spring.common.dao.UserDao;
import com.knits.spring.common.integration.UserJmsClient;
import com.knits.spring.common.service.MyService;
import com.knits.spring.sf.dao.ProductDao;

import com.knits.spring.sf.model.Product;
import lombok.Data;

@Data
@Service
public class DemoService {
	
	@Autowired
	private ProductDao productDao;

	
	public void readAllProducts() {
		List<Product> allProducts = productDao.readProducts();
		allProducts.forEach(id -> System.out.println(id));
	}
	
	public void readProductsByVisibility() {
		List<Product> allVisibleProducts = productDao.readProductsVisible();
		allVisibleProducts.forEach(id -> System.out.println(id));
	}
	
	public void readProductsByUnvisible() {
		List<Product> allUnvisibleProducts = productDao.readProductsUnvisible();
		allUnvisibleProducts.forEach(id -> System.out.println(id));
	}
	
	public void readProductIdByNames(String productName, String productDataName) {
		int productId = productDao.readProductIdByCol(productName, productDataName);
		System.out.println("Product(id=" + productId + ")");
	}
	
	public void readRecentProductId() {
		int lastProductId = productDao.readProductIdByRecent();
		System.out.println("Product(id=" + lastProductId + ")");
	}
	
	public void editProductVisibility(int productId, int visibilityOption) {
		productDao.editProductVisibilityById(productId, visibilityOption);
	}
	
	public void createNewProduct() {
		Product mockProduct = new Product();
		mockProduct.setName("Hat");
		mockProduct.setUrl("some url");
		mockProduct.setImgUrl("some img url");
		mockProduct.setDataId("a007bc8");
		mockProduct.setVisibility(0);
		mockProduct.setStoreId(1);
		
		productDao.createNewProduct(mockProduct);
	}
	
	
}
