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
	
	public void setRestID(int num) {
		this.restID=num;
	}
	
	public void setRestName(String str) {
		this.name=str;
	}
	
	public void setRestIntro(String str) {
		this.intro=str;
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
	
}

/****************All copy right reserved by group 105*********************/