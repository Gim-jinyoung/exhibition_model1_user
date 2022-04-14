package VO;

public class BoardrVO {
private String title, userid, input_date, cat_num,cat_name;
private int bd_id;
private StringBuilder description;
private char isdeleted;
public BoardrVO() {
	
}
public BoardrVO(String title, String userid, String input_date, String cat_num, String cat_name, int bd_id,
		StringBuilder description, char isdeleted) {
	super();
	this.title = title;
	this.userid = userid;
	this.input_date = input_date;
	this.cat_num = cat_num;
	this.cat_name = cat_name;
	this.bd_id = bd_id;
	this.description = description;
	this.isdeleted = isdeleted;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getInput_date() {
	return input_date;
}
public void setInput_date(String input_date) {
	this.input_date = input_date;
}
public String getCat_num() {
	return cat_num;
}
public void setCat_num(String cat_num) {
	this.cat_num = cat_num;
}
public String getCat_name() {
	return cat_name;
}
public void setCat_name(String cat_name) {
	this.cat_name = cat_name;
}
public int getBd_id() {
	return bd_id;
}
public void setBd_id(int bd_id) {
	this.bd_id = bd_id;
}
public StringBuilder getDescription() {
	return description;
}
public void setDescription(StringBuilder description) {
	this.description = description;
}
public char getIsdeleted() {
	return isdeleted;
}
public void setIsdeleted(char isdeleted) {
	this.isdeleted = isdeleted;
}

}
