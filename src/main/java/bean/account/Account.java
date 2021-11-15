package bean.account;

public class Account {
   private String fname;
   private String lname;
  // private String username;
  //private String password;
   private String email;
   private String street;
   private String city;
   private String state;
   private String country;
   private String zip_code;
   
   public Account() {
	   
   }
   
public Account(String fname, String lname,  String email, String street, String city,
		String state, String country, String zip_code) {
	super();
	this.fname = fname;
	this.lname = lname;
	//this.username = username;
//this.password = password;
	this.email = email;
	this.street = street;
	this.city = city;
	this.state = state;
	this.country= country;
	this.zip_code = zip_code;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
/*
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {

	return password;
}
public void setPassword(String password) {
	this.password = password;
}
*/	
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getZip_code() {
	return zip_code;
}
public void setZip_code(String zip_code) {
	this.zip_code = zip_code;
}
}
