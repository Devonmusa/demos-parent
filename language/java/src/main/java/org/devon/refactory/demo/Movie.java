package org.devon.refactory.demo;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	private String _title;
	private Price _pricecode;
	
	
	public Movie(String name, int pricecode) {
		super();
		this._title = name;
		setPricecode(pricecode); 
	}
	public String get_title() {
		return _title;
	}
	public void set_title(String _title) {
		this._title = _title;
	}
	public int getPricecode() {
		return _pricecode.getPriceCode();
	}
	public void setPricecode(int arg) {
		switch (arg) {
		case REGULAR:
			_price = new RegularPrice();
			break;
		
		case CHILDRENS:
			_price = new ChildrensPrice();
			break;
		case NEW_RELEASE:
			_price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
	}
	double getCharge (int daysRented) {
		return _price.getCharge(daysRented);
	}
	int getFrequentRenterPoints(int daysRented){
		return _price.getFrequentRenterPoints(daysRented);
	}
	Price _price;


	
}
