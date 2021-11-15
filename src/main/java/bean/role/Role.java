package bean.role;

public class Role {
  private String type;
  // change username to email
  private String email;
  
  public Role() {
	  
  }
  // change all username to email
public Role(String type, String email) {

	this.type = type;
	this.email = email;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
