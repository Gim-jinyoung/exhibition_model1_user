package VO;

public class MemberVO {
	private String userId,tel,zipcode,address1,address2,password,isSubscribeDate,name;
	private char isDeleted;
	public MemberVO() {
		
	}
	public MemberVO(String userId, String tel, String zipcode, String address1, String address2, String password,
			String isSubscribeDate, String name, char isDeleted) {
		super();
		this.userId = userId;
		this.tel = tel;
		this.zipcode = zipcode;
		this.address1 = address1;
		this.address2 = address2;
		this.password = password;
		this.isSubscribeDate = isSubscribeDate;
		this.name = name;
		this.isDeleted = isDeleted;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIsSubscribeDate() {
		return isSubscribeDate;
	}
	public void setIsSubscribeDate(String isSubscribeDate) {
		this.isSubscribeDate = isSubscribeDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(char isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}
	
	
	