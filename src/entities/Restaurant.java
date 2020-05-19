/*
 * @ Name: Restaurant.java
 * @ version: 1.0-new test
 * @ author: He Xuan
 * @ description: this is for basic data of restaurant info
 */
package entities;

public class Restaurant {
	private int restID;
	private String name; 
	private String intro;
	private String Postalcode;
	private String Address;
	private String RegistrationDate;
	
	public void setRestID(int num) {
		this.restID=num;
	}
	
	public void setRestName(String str) {
		this.name=str;
	}
	
	public void setRestPostalcode(String Postalcode ) {
		this.Postalcode=Postalcode;
	}

	public void setRestIntro(String str) { this.intro=str; }

	public void setRestAddress(String Address) {
		this.Address=Address;
	}

	public void setRestRegistrationDate(String RegistrationDate) {
		this.RegistrationDate=RegistrationDate;
	}

	
	public int getRestID() {
		return this.restID;
	}
	
	public String getRestName() {
		return this.name;
	}
	
	public String getRestIntro() {
		return this.intro;
	}

	public String getRestPostalcode() {
		return this.Postalcode;
	}

	public String getRestAddress() {
		return this.Address;
	}

	public String getRestRegistrationDate() {
		return this.RegistrationDate;
	}
	
}

/****************All copy right reserved by group 105*********************/
