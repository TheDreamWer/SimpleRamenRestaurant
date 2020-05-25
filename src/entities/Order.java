package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;

import entities.*;
import control.*;

/**
 * Entity class of Order
 */
public class Order implements Serializable{
    /**
     * Iteration 1
     */
    // private static final long serialVersionUID = 1L;
    private long order_ID;//下单日期+取餐码+堂食/外带
    private int code;//取餐码
    private float order_amount; 
    private String payment_method; //cash / online / unpaid
    private String generateTime;
    private ArrayList<Ramen> ramenList;
    private Boolean takeAway = false;
    private User user;


    public Order(){
        SystemTime systemTime = new SystemTime();
        this.generateTime = systemTime.getDateString();
        this.order_ID = Long.parseLong(systemTime.getDateStringPro());
        this.ramenList = new ArrayList<Ramen>();
    }
    /** Getter/Setter start */
    public long getOrderID(){
        return this.order_ID;
    }
    public void setOrderID(long order_ID){
        this.order_ID = order_ID;
    }

    public int getCode(){
        return this.code;
    }
    public void setCode(int code){
        this.code = code;
    }

    public float getOrderAmount(){
        return this.order_amount;
    }
    public void setOrderAmount(float order_amount){
        this.order_amount = order_amount;
    }

    public String getPaymentMethod(){
        return this.payment_method;
    }
    public void setPaymentMethod(String inputMethod){
        this.payment_method = inputMethod;
    }

    public String getGenerateTime(){
        return this.generateTime;
    }
    public void setGenerateTime(String generateTime){
        this.generateTime = generateTime;
    }

    public ArrayList<Ramen> getRamenList(){
        return this.ramenList;
    }
    public void setRamenList(ArrayList<Ramen> ramenList){
        this.ramenList = ramenList;
    }

    public void setTakeAway(Boolean takeAway){
        this.takeAway = takeAway;
    }
    public Boolean getTakeAway(){
        return this.takeAway;
    }

    public void setUser(User user){
        this.user = user;
    }
    public User getUser() {
        return this.user;
    }

    /**Getter/Setter end */

    public Ramen getRamen(int index){
        return this.ramenList.get(index);
    }

//    public String orderToString(int index){ // ramenList index
//        Ramen ramen = this.getRamen(index);
//        String temp = "";
//        temp += Long.toString(this.order_ID) + ",";
//        temp += Integer.toString(this.code) + ",";
//        temp += Float.toString(this.order_amount) + ",";
//        temp += this.payment_method + ",";
//        temp += this.generateTime + ",";
//        temp += ramen.getSoup() + ",";
//        temp += ramen.getNoodles() + ",";
//        temp += Integer.toString(ramen.getOnion_level()) + ",";
//        temp += Boolean.toString(ramen.getNori()) + ",";
//        temp += Boolean.toString(ramen.getChashu()) + ",";
//        temp += Boolean.toString(ramen.getBoiled_egg()) + ",";
//        temp += Integer.toString(ramen.getSpiciness()) + ",";
//        temp += Integer.toString(ramen.getExtra_nori()) + ",";
//        temp += Integer.toString(ramen.getExtra_boiled_egg()) + ",";
//        temp += Integer.toString(ramen.getBamboo_shoots()) + ",";
//        temp += Integer.toString(ramen.getExtra_chashu()) + ",";
//        temp += user.getUserID() + ",";
//        temp += user.getFirstName() + user.getSurname() + ",";
//        return temp;
//    }

}