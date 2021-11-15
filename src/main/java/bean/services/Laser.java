package bean.services;

import bean.spa.SPA;

public class Laser extends Service {

	public Laser(double price, String type, SPA spa) {
		super( price, type, spa);
		
	}
	public Laser( int id, double price, String type, SPA spa) {
		super( id, price, type, spa);
		
	}

}
