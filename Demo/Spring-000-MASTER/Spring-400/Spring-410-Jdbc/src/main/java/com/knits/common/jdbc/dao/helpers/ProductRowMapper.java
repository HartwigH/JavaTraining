package com.knits.common.jdbc.dao.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.knits.spring.common.model.Product;

public class ProductRowMapper implements RowMapper<Product>{

	
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setName(rs.getString("product_name"));
		product.setUrl(rs.getString("product_url"));
		product.setImgUrl(rs.getString("product_img_url"));
		product.setDataId(rs.getString("product_data_id"));
		product.setVisibility(rs.getInt("product_visibility"));
		product.setStoreId(rs.getInt("store_id"));
		return product;
	}

}
