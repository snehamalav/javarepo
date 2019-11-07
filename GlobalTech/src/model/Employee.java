package model;

public class Employee {
private int eid;
private String fname;
private String lname;
private String password;
private int contactno;
private String gender;
private String email;
private String dname;
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getContactno() {
	return contactno;
}
public void setContactno(int contactno) {
	this.contactno = contactno;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public Employee(int eid, String fname, String lname, String password, int contactno, String gender, String email,
		String dname) {
	super();
	this.eid = eid;
	this.fname = fname;
	this.lname = lname;
	this.password = password;
	this.contactno = contactno;
	this.gender = gender;
	this.email = email;
	this.dname = dname;
}
public Employee() {
	super();
}


}
