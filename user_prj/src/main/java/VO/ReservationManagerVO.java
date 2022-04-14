package VO;

public class ReservationManagerVO {
	private String rez_date, userid, visit_date,ex_name, exhibit_date, deadline,mgr_name,ex_loc,name;
	private int  rez_num, rez_count, ex_num,adult, teen, child;
	private char rez_status;
	private StringBuilder ex_info;
	
	public ReservationManagerVO() {
		
	}

	public ReservationManagerVO(String rez_date, String userid, String visit_date, String ex_name, String exhibit_date,
			String deadline, String mgr_name, String ex_loc, String name, int rez_num, int rez_count, int ex_num,
			int adult, int teen, int child, char rez_status, StringBuilder ex_info) {
		super();
		this.rez_date = rez_date;
		this.userid = userid;
		this.visit_date = visit_date;
		this.ex_name = ex_name;
		this.exhibit_date = exhibit_date;
		this.deadline = deadline;
		this.mgr_name = mgr_name;
		this.ex_loc = ex_loc;
		this.name = name;
		this.rez_num = rez_num;
		this.rez_count = rez_count;
		this.ex_num = ex_num;
		this.adult = adult;
		this.teen = teen;
		this.child = child;
		this.rez_status = rez_status;
		this.ex_info = ex_info;
	}

	public String getRez_date() {
		return rez_date;
	}

	public void setRez_date(String rez_date) {
		this.rez_date = rez_date;
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

	public String getExhibit_date() {
		return exhibit_date;
	}

	public void setExhibit_date(String exhibit_date) {
		this.exhibit_date = exhibit_date;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getMgr_name() {
		return mgr_name;
	}

	public void setMgr_name(String mgr_name) {
		this.mgr_name = mgr_name;
	}

	public String getEx_loc() {
		return ex_loc;
	}

	public void setEx_loc(String ex_loc) {
		this.ex_loc = ex_loc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getEx_num() {
		return ex_num;
	}

	public void setEx_num(int ex_num) {
		this.ex_num = ex_num;
	}

	public int getAdult() {
		return adult;
	}

	public void setAdult(int adult) {
		this.adult = adult;
	}

	public int getTeen() {
		return teen;
	}

	public void setTeen(int teen) {
		this.teen = teen;
	}

	public int getChild() {
		return child;
	}

	public void setChild(int child) {
		this.child = child;
	}

	public char getRez_status() {
		return rez_status;
	}

	public void setRez_status(char rez_status) {
		this.rez_status = rez_status;
	}

	public StringBuilder getEx_info() {
		return ex_info;
	}

	public void setEx_info(StringBuilder ex_info) {
		this.ex_info = ex_info;
	}
	
}
