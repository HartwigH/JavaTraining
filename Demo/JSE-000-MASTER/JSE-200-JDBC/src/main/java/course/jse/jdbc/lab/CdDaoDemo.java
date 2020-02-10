package course.jse.jdbc.lab;

import java.util.List;

public class CdDaoDemo {
	public static void main(String[] args) {
		CdDao cdDao = new CdDao();
		
		Cd mockCd = new Cd();
		mockCd.setArtist("random Artist");
		mockCd.setCompany("random company" );
		mockCd.setCountry("random country");
		mockCd.setPrice(100.0);
		mockCd.setQuantity(2);
		mockCd.setTitle("Some title");
		mockCd.setVersion(1L);
		mockCd.setYear(2000);		
		
		cdDao.saveCd(mockCd);
		
		long lastId = cdDao.findLastRecordId();
		
		cdDao.deleteCd(lastId);
		cdDao.updateCd(60L, "Artist", "Rod Stewart 2");
		
		//Cd foundCd =cdDao.findById(58L);
		System.out.println("RESPONSE: Cd values: "+ cdDao.findById(58L).toString() + "\n");
		
		List<Cd> foundCd =cdDao.findByPrice(9.90);
		System.out.println("RESPONSE: Cd's that have same price: "+ foundCd.size() + "\n Titles:" );
		foundCd.forEach(id -> System.out.println("\t - " + id.getTitle()));
		
		
		
	}

}
