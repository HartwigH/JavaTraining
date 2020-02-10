package com.knits.common.jdbc.dao;

import static com.knits.common.jdbc.dao.ProductQueries.PRODUCT_ALL;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.knits.spring.common.model.Product;
import com.knits.common.jdbc.dao.helpers.ProductRowMapper;

@Repository()
public class ProductDaoJdbcSupportImpl extends JdbcDaoSupport implements ProductDao{

	
	@Autowired
	private ProductRowMapper ProductRowMapper;
	
	@Autowired
	private DataSource dataSource;
	
	
	
	@PostConstruct
	public void init(){
		this.setDataSource(dataSource);
	}
	
//	@Override
//	public CD findById(Long id) {
//		return getJdbcTemplate().queryForObject(CD_BY_ID,new Object[] { id }, cdRowMapper);			
//	}

	@Override
	public List<Product> readProducts() {
		// TODO Auto-generated method stub
		return null; //getJdbcTemplate().queryForObject(PRODUCT_ALL,new List<Product> { },ProductRowMapper);
	}


	@Override
	public List<Product> readProductsVisible() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> readProductsUnvisible() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int readProductIdByCol(String name, String dataId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int readProductIdByRecent() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void editProductVisibilityById(int productId, int option) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createNewProduct(Product newProduct) {
		// TODO Auto-generated method stub
		
	}


	

}
