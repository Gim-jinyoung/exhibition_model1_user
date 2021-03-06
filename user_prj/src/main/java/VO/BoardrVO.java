package VO;

public class BoardrVO {
private String title, userid, input_date, cat_name, cm_input_date,imgfile,cm_userid;
private int bd_id, cat_num, recommend, views, cm_id,rownum ;
private String description, cm_description;
private char isdeleted;
private int pageNum;
public BoardrVO() {
	
}
public BoardrVO(String title, String userid, String input_date, int cat_num, String cat_name, int bd_id,
		String description, char isdeleted , int recommend, int views ,String cm_description, int cm_id, String cm_input_date, String imgfile,String cm_userid) {
	super();
	this.title = title;
	this.userid = userid;
	this.input_date = input_date;
	this.cat_num = cat_num;
	this.cat_name = cat_name;
	this.bd_id = bd_id;
	this.description = description;
	this.isdeleted = isdeleted;
	this.recommend = recommend;
	this.views = views;
	this.cm_description = cm_description;
	this.cm_id = cm_id;
	this.cm_input_date = cm_input_date;
	this.imgfile = imgfile;
	this.cm_userid = cm_userid;
}

/**
 * @return the cm_userid
 */
public String getCm_userid() {
	return cm_userid;
}
/**
 * @param cm_userid the cm_userid to set
 */
public void setCm_userid(String cm_userid) {
	this.cm_userid = cm_userid;
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
public int getCat_num() {
	return cat_num;
}
public void setCat_num(int cat_num) {
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
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public char getIsdeleted() {
	return isdeleted;
}
public void setIsdeleted(char isdeleted) {
	this.isdeleted = isdeleted;
}
/**
 * @return the recommend
 */
public int getRecommend() {
	return recommend;
}
/**
 * @param recommend the recommend to set
 */
public void setRecommend(int recommend) {
	this.recommend = recommend;
}
/**
 * @return the views
 */
public int getViews() {
	return views;
}
/**
 * @param views the views to set
 */
public void setViews(int views) {
	this.views = views;
}
/**
 * @return the cm_description
 */
public String getCm_description() {
	return cm_description;
}
/**
 * @param cm_description the cm_description to set
 */
public void setCm_description(String cm_description) {
	this.cm_description = cm_description;
}
/**
 * @return the cm_id
 */
public int getCm_id() {
	return cm_id;
}
/**
 * @param cm_id the cm_id to set
 */
public void setCm_id(int cm_id) {
	this.cm_id = cm_id;
}
/**
 * @return the cm_input_date
 */
public String getCm_input_date() {
	return cm_input_date;
}
/**
 * @param cm_input_date the cm_input_date to set
 */
public void setCm_input_date(String cm_input_date) {
	this.cm_input_date = cm_input_date;
}
/**
 * @return the imgfile
 */
public String getImgfile() {
	return imgfile;
}
/**
 * @param imgfile the imgfile to set
 */
public void setImgfile(String imgfile) {
	this.imgfile = imgfile;
}
/**
 * @return the pageNum
 */
public int getPageNum() {
	return pageNum;
}
/**
 * @param pageNum the pageNum to set
 */
public void setPageNum(int pageNum) {
	this.pageNum = pageNum;
}
/**
 * @return the rownum
 */
public int getRownum() {
	return rownum;
}
/**
 * @param rownum the rownum to set
 */
public void setRownum(int rownum) {
	this.rownum = rownum;
}



}