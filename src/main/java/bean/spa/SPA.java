package bean.spa;

import bean.account.Account;

public class SPA {
  private int id;
  private String name;
  private String phone;
  private String license;
  private Account seller;
  
  
public SPA(int id,String name, String phone, String license, Account seller) {
	this.id= id;
	this.name = name;
	this.phone = phone;
	this.license = license;
	this.seller = seller;

}

public SPA() {
	// TODO Auto-generated constructor stub
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getLicense() {
	return license;
}

public void setLicense(String license) {
	this.license = license;
}

public Account getSeller() {
	return seller;
}

public void setSeller(Account seller) {
	this.seller = seller;
}


 

  
  
}
