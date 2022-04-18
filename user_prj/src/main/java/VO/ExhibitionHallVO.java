package VO;

public class ExhibitionHallVO {
	private String ex_name, adress1, adress2, mgr_name, mgr_tel, ex_tel ,zipcode, input_date,ex_loc;
	private char hall_deleted;
	private int ex_hall_num;
	private double latitude, longitude;
	public ExhibitionHallVO() {
		
	}
	public ExhibitionHallVO(String ex_name, String adress1, String adress2, String mgr_name, String mgr_tel,
			String ex_tel, String zipcode, String input_date, String ex_loc, char hall_deleted, int ex_hall_num,
			double latitude, double longitude) {
		this.ex_name = ex_name;
		this.adress1 = adress1;
		this.adress2 = adress2;
		this.mgr_name = mgr_name;
		this.mgr_tel = mgr_tel;
		this.ex_tel = ex_tel;
		this.zipcode = zipcode;
		this.input_date = input_date;
		this.ex_loc = ex_loc;
		this.hall_deleted = hall_deleted;
		this.ex_hall_num = ex_hall_num;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public String getEx_name() {
		return ex_name;
	}
	public void setEx_name(String ex_name) {
		this.ex_name = ex_name;
	}
	public String getAdress1() {
		return adress1;
	}
	public void setAdress1(String adress1) {
		this.adress1 = adress1;
	}
	public String getAdress2() {
		return adress2;
	}
	public void setAdress2(String adress2) {
		this.adress2 = adress2;
	}
	public String getMgr_name() {
		return mgr_name;
	}
	public void setMgr_name(String mgr_name) {
		this.mgr_name = mgr_name;
	}
	public String getMgr_tel() {
		return mgr_tel;
	}
	public void setMgr_tel(String mgr_tel) {
		this.mgr_tel = mgr_tel;
	}
	public String getEx_tel() {
		return ex_tel;
	}
	public void setEx_tel(String ex_tel) {
		this.ex_tel = ex_tel;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getInput_date() {
		return input_date;
	}
	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}
	public String getEx_loc() {
		return ex_loc;
	}
	public void setEx_loc(String ex_loc) {
		this.ex_loc = ex_loc;
	}
	public char getHall_deleted() {
		return hall_deleted;
	}
	public void setHall_deleted(char hall_deleted) {
		this.hall_deleted = hall_deleted;
	}
	public int getEx_hall_num() {
		return ex_hall_num;
	}
	public void setEx_hall_num(int ex_hall_num) {
		this.ex_hall_num = ex_hall_num;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
}
