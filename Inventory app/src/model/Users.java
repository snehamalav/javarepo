package model;

public class Users {
private String ename;
private String empid;
private String password;

private String contactno;
private String mailid;
private String gender;

//setters and getters
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getEmpid() {
	return empid;
}
public void setEmpid(String empid) {
	this.empid = empid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGender() {
	return gender;
}
public Users() {
	super();
}
public Users(String ename, String empid, String password, String contactno, String mailid,String gender) {
	super();
	this.ename = ename;
	this.empid = empid;
	this.password = password;
	
	this.contactno = contactno;
	this.mailid = mailid;
	this.gender = gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getContactno() {
	return contactno;
}
public void setContactno(String contactno) {
	this.contactno = contactno;
}
public String getMailid() {
	return mailid;
}
public void setMailid(String mailid) {
	this.mailid = mailid;
}


}
