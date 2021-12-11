package bean.services;

import bean.spa.SPA;

public class Facial extends Service{
	

	public Facial( double price, String type, SPA spa) {
		super(price, type, spa);
	}
	public Facial( int id, double price, String type, SPA spa) {
		super(id ,price, type, spa);
	}
	
	public Facial( int id, double price, String type, String image, SPA spa) {
		super(id ,price, type, image, spa);
	}

}
