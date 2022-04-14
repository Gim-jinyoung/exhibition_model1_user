package VO;

public class AdminMemberVO {
private String admin_id,admin_pass,created_date;
public AdminMemberVO() {
	
}
public AdminMemberVO(String admin_id, String admin_pass, String created_date) {
	super();
	this.admin_id = admin_id;
	this.admin_pass = admin_pass;
	this.created_date = created_date;
}
public String getAdmin_id() {
	return admin_id;
}
public void setAdmin_id(String admin_id) {
	this.admin_id = admin_id;
}
public String getAdmin_pass() {
	return admin_pass;
}
public void setAdmin_pass(String admin_pass) {
	this.admin_pass = admin_pass;
}
public String getCreated_date() {
	return created_date;
}
public void setCreated_date(String created_date) {
	this.created_date = created_date;
}

}
