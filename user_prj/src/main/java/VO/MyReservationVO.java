package VO;

public class MyReservationVO {

	private String rez_date,rez_status,userid,visit_date,ex_name,ex_hall_name;
	private int ex_num,rez_num,rez_count,rez_price;
	
	
	public MyReservationVO(String rez_date, String rez_status, String userid, String visit_date, String ex_name,
			String ex_hall_name, int ex_num, int rez_num, int rez_count, int rez_price) {
		this.rez_date = rez_date;
		this.rez_status = rez_status;
		this.userid = userid;
		this.visit_date = visit_date;
		this.ex_name = ex_name;
		this.ex_hall_name = ex_hall_name;
		this.ex_num = ex_num;
		this.rez_num = rez_num;
		this.rez_count = rez_count;
		this.rez_price = rez_price;
	}
	
	
	public MyReservationVO() {
		
	}


	public String getRez_date() {
		return rez_date;
	}
	public void setRez_date(String rez_date) {
		this.rez_date = rez_date;
	}
	public String getRez_status() {
		return rez_status;
	}
	public void setRez_status(String rez_status) {
		this.rez_status = rez_status;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getVisit_date() {
		return visit_date;
	}
	public void setVisit_date(String visit_date) {
		this.visit_date = visit_date;
	}
	public String getEx_name() {
		return ex_name;
	}
	public void setEx_name(String ex_name) {
		this.ex_name = ex_name;
	}
	public String getEx_hall_name() {
		return ex_hall_name;
	}
	public void setEx_hall_name(String ex_hall_name) {
		this.ex_hall_name = ex_hall_name;
	}
	public int getEx_num() {
		return ex_num;
	}
	public void setEx_num(int ex_num) {
		this.ex_num = ex_num;
	}
	public int getRez_num() {
		return rez_num;
	}
	public void setRez_num(int rez_num) {
		this.rez_num = rez_num;
	}
	public int getRez_count() {
		return rez_count;
	}
	public void setRez_count(int rez_count) {
		this.rez_count = rez_count;
	}
	public int getRez_price() {
		return rez_price;
	}
	public void setRez_price(int rez_price) {
		this.rez_price = rez_price;
	}
	
	

}
