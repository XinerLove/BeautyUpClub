package bean.services;

import bean.spa.SPA;

public class Massage extends Service{

	public Massage( double price, String type, SPA spa) {
		super( price, type, spa);
		
	}
	public Massage( int id, double price, String type, SPA spa) {
		super( id, price, type, spa);
		
	}
	public Massage( int id, double price, String type, String image, SPA spa) {
		super( id, price, type, image, spa);
		
	}
}
