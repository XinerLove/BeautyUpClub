package bean.services;

import bean.spa.SPA;

public class Service {

	private int id;
	 private double price;
	 private String type;
	 private String image;
	 private SPA spa;
	 
	public Service(double price, String type, SPA spa) {
		super();
	
		this.price = price;
		this.type = type;
		this.spa = spa;
	}

	public Service(int id, double price, String type, SPA spa) {
		super();
	this.id = id;
		this.price = price;
		this.type = type;
		this.spa = spa;
	}
	
	public Service( int id, double price, String type, String image, SPA spa) {
		super();
		this.id = id;
		this.price = price;
		this.type = type;
		this.image = image;
		this.spa = spa;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SPA getSpa() {
		return spa;
	}


	public void setSpa(SPA spa) {
		this.spa = spa;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	 
	 
	 
	 
	 
	 
	 
	 
}
