package course.jse.jdbc.salesFinder;

import java.util.ArrayList;
import java.util.List;

public class DaoDemo {

	public static void main(String[] args) {
		/*
		 * Product DAO's needed
		 * - readProducts | Done
		 * - readProductsVisible | Done
		 * - readProductsUnvisible | Done
		 * - readProductIdByCol(product_name, product_data_id) | Done
		 * - readProductIdByRecent | Done
		 * - editProductVisibilityById | Done
		 * - createNewProduct | Done
 		 */
		
		ProductDao productDao = new ProductDao();

		List<Product> allProducts = productDao.readProducts();
		allProducts.forEach(id -> System.out.println(id));
		
		List<Product> allVisibleProducts = productDao.readProductsVisible();
		allVisibleProducts.forEach(id -> System.out.println(id));
		
		List<Product> allUnvisibleProducts = productDao.readProductsUnvisible();
		allUnvisibleProducts.forEach(id -> System.out.println(id));
		
		int productId = productDao.readProductIdByCol("Shirt", "Na");
		System.out.println("Product(id=" + productId + ")");
		
		int lastProductId = productDao.readProductIdByRecent();
		System.out.println("Product(id=" + lastProductId + ")");
		
		productDao.editProductVisibilityById(4, 1);
		productDao.editProductVisibilityById(4, 0);
		
		
		Product mockProduct = new Product();
		mockProduct.setName("Hat");
		mockProduct.setUrl("some url");
		mockProduct.setImgUrl("some img url");
		mockProduct.setDataId("a007bc8");
		mockProduct.setVisibility(0);
		mockProduct.setStoreId(1);
		
		productDao.createNewProduct(mockProduct);
		
		/*
		 * ===== SERVICE MOCK TESTS =====
		 */
		MockCrawler[] mockCrawlerArray = new MockCrawler[2];
		
		String crawlDate = "2020-01-17";
		
		for (int i = 0; i < mockCrawlerArray.length; i++) {
			mockCrawlerArray[i] = new MockCrawler();
		}
		
		mockCrawlerArray[0].setName("Shoes");
		mockCrawlerArray[0].setUrl("url");
		mockCrawlerArray[0].setImgUrl("url");
		mockCrawlerArray[0].setDataId("some id");
		mockCrawlerArray[0].setVisibility(1);
		mockCrawlerArray[0].setStoreId(1);
		mockCrawlerArray[0].setPrice(15.99f);
		mockCrawlerArray[0].setDate(crawlDate);
		
		
		mockCrawlerArray[1].setName("Shoes 2");
		mockCrawlerArray[1].setUrl("url");
		mockCrawlerArray[1].setImgUrl("url");
		mockCrawlerArray[1].setDataId("some id");
		mockCrawlerArray[1].setVisibility(1);
		mockCrawlerArray[1].setStoreId(1);
		mockCrawlerArray[1].setPrice(15.99f);
		mockCrawlerArray[1].setDate(crawlDate);
		
		for (int i = 0; i < mockCrawlerArray.length; i++) {
			int recievedId =productDao.readProductIdByCol(mockCrawlerArray[i].getName(), mockCrawlerArray[i].getDataId());
			
			// Matching id was found and Crawler has new data about price, add new price and date
			if (recievedId != 0 && mockCrawlerArray[i].getPrice() != 0) {
				// createPriceById(recievedId) <= priceDao
				// x = readProductIdByRecent()
				// createNewEntry(x) <= auditLogDao
				
			// No matching id found, but Crawler found price, add new row to product and price	
			} else {
				// new product fount, adding it
				mockProduct.setName(mockCrawlerArray[i].getName());
				// createNewProduct(x)
				// x = readProductIdByRecent()
				// createPriceById(x) <= priceDao
				// createNewEntry(x) <= auditLogDao
				
			// Find all id's that did not receive an update (crawler did not find name that exists in database)	
			} 
		}
		
		// Call for all id's that have new date
		// SQL: select id from product outer join, with audit_log get id's where date equals crawlDate
	}

}
