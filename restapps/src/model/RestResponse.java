package model;

public class RestResponse {
private int code;
private String message;
public RestResponse(int code, String message) {
	super();
	this.code = code;
	this.message = message;
}
public RestResponse() {
	super();
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

}
