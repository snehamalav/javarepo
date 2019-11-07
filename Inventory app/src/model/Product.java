package model;

public class Product {
private String pid;
private String pname;
private int unitprice;
private int stock;
private String category;
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getUnitprice() {
	return unitprice;
}
public void setUnitprice(int unitprice) {
	this.unitprice = unitprice;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public Product(String pid, String pname, int unitprice, int stock, String category) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.unitprice = unitprice;
	this.stock = stock;
	this.category = category;
}
public Product() {
	super();
}

}
