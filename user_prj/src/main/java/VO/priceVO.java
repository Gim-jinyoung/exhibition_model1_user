package VO;

public class priceVO {
private int adult,teen,child;

public priceVO() {
	
}

public priceVO(int adult, int teen, int child) {
	super();
	this.adult = adult;
	this.teen = teen;
	this.child = child;
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


}
