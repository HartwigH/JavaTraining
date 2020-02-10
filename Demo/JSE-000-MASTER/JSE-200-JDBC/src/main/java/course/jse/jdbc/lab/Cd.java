package course.jse.jdbc.lab;

import lombok.Data;

@Data
public class Cd {

	private Long id;
	private String artist;
	private String company;
	private String title;
	private String country;
	private int year;
	private int quantity;
	private double price;
	private Long version;
	
}
