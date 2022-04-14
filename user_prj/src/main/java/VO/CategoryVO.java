package VO;

public class CategoryVO {
	private String myinfo,rsv;
public CategoryVO() {
	
}
public CategoryVO(String myinfo, String rsv) {
	super();
	this.myinfo = myinfo;
	this.rsv = rsv;
}
public String getMyinfo() {
	return myinfo;
}
public void setMyinfo(String myinfo) {
	this.myinfo = myinfo;
}
public String getRsv() {
	return rsv;
}
public void setRsv(String rsv) {
	this.rsv = rsv;
}


}
