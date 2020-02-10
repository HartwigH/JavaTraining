package com.knits.spring.sf.model;

import lombok.Data;

@Data
public class Product {

	private int id;
	private String name;
	private String url;
	private String imgUrl;
	private String dataId;
	private int visibility;
	private int storeId;
	
}
