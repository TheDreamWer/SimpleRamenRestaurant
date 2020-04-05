package test;

import control.FillRestInfo;
import control.SaveRestInfo;
import entities.Restaurant;

public class TestRun {
	public static void main(String[] args) {
		
		//test the SaveRestInfo
		Restaurant rest1 = new Restaurant();
		rest1.setRestID(1);
		rest1.setRestName("Totoro Ramen No.1");
		rest1.setRestIntro("This is the first restaurant of Totoro Ramen!");
		new SaveRestInfo(rest1);
		
		Restaurant rest2 = new Restaurant();
		rest2.setRestID(2);
		rest2.setRestName("Totoro Ramen No.2");
		rest2.setRestIntro("This is the second restaurant of Totoro Ramen!");
		new SaveRestInfo(rest2);
		
		//test the FillRestInfo
		FillRestInfo fri = new FillRestInfo(2);
		Restaurant rptr= fri.getRestaurant();
		System.out.println(rptr.getRestID());
		System.out.println(rptr.getRestName());
		System.out.println(rptr.getRestIntro());
	}
}
