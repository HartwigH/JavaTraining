package course.jse.jdbc.salesFinder;

import lombok.Data;

@Data
public class MockCrawler {
	
	private String name;
	private String url;
	private String imgUrl;
	private String dataId;
	private int visibility;
	private int storeId;
	private float price;
	private String date;

}
