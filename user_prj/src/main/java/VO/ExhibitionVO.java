package VO;

public class ExhibitionVO {
 private String ex_name, ex_poster, ex_info, ex_intro , add_Img,exhibit_date, dead_line, input_date, ex_status ;
 private int ex_hall_num, ex_num, total_count,adult,teen,child;
 
 public ExhibitionVO() {
	 
 }
public ExhibitionVO(String ex_name, String ex_poster, String ex_info, String ex_intro, String add_Img,
		String exhibit_date, String dead_line, String input_date, String ex_status,int ex_hall_num, int ex_num, int total_count, int adult, int teen, int child) {
	super();
	this.ex_hall_num = ex_hall_num;
	this.ex_name = ex_name;
	this.ex_poster = ex_poster;
	this.ex_info = ex_info;
	this.ex_intro = ex_intro;
	this.add_Img = add_Img;
	this.exhibit_date = exhibit_date;
	this.dead_line = dead_line;
	this.input_date = input_date;
	this.ex_status = ex_status;
	this.ex_num = ex_num;
	this.total_count = total_count;
	this.adult = adult;
	this.teen = teen;
	this.child = child;

}



public String getEx_name() {
	return ex_name;
}

public int getEx_hall_num() {
	return ex_hall_num;
}
public void setEx_hall_num(int ex_hall_num) {
	this.ex_hall_num = ex_hall_num;
}
public void setEx_name(String ex_name) {
	this.ex_name = ex_name;
}
public String getEx_poster() {
	return ex_poster;
}
public void setEx_poster(String ex_poster) {
	this.ex_poster = ex_poster;
}
public String getEx_info() {
	return ex_info;
}
public void setEx_info(String ex_info) {
	this.ex_info = ex_info;
}
public String getEx_intro() {
	return ex_intro;
}
public void setEx_intro(String ex_intro) {
	this.ex_intro = ex_intro;
}
public String getAdd_Img() {
	return add_Img;
}
public void setAdd_Img(String add_Img) {
	this.add_Img = add_Img;
}
public String getExhibit_date() {
	return exhibit_date;
}
public void setExhibit_date(String exhibit_date) {
	this.exhibit_date = exhibit_date;
}
public String getDead_line() {
	return dead_line;
}
public void setDead_line(String dead_line) {
	this.dead_line = dead_line;
}
public String getInput_date() {
	return input_date;
}
public void setInput_date(String input_date) {
	this.input_date = input_date;
}
public String getEx_status() {
	return ex_status;
}
public void setEx_status(String ex_status) {
	this.ex_status = ex_status;
}
public int getEx_num() {
	return ex_num;
}
public void setEx_num(int ex_num) {
	this.ex_num = ex_num;
}
public int getTotal_count() {
	return total_count;
}
public void setTotal_count(int total_count) {
	this.total_count = total_count;
}
/**
 * @return the adult
 */
public int getAdult() {
	return adult;
}
/**
 * @param adult the adult to set
 */
public void setAdult(int adult) {
	this.adult = adult;
}
/**
 * @return the teen
 */
public int getTeen() {
	return teen;
}
/**
 * @param teen the teen to set
 */
public void setTeen(int teen) {
	this.teen = teen;
}
/**
 * @return the child
 */
public int getChild() {
	return child;
}
/**
 * @param child the child to set
 */
public void setChild(int child) {
	this.child = child;
}

}
