package control;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import entities.*;

public class Business {
    private Restaurant rest;
    private FillRestInfo fillRestInfo;
    private FillOrderList fillOrderList;
    private OrderList orderList;
    private FillUserList fillUserList = new FillUserList();
    private ArrayList<User> userList;



    public Business(int id){
        //Restaurant
        this.fillRestInfo = new FillRestInfo(id);
        this.fillOrderList = new FillOrderList();
        this.rest = this.fillRestInfo.getRestaurant();
        this.orderList = this.fillOrderList.getOrderlist();
        this.userList = this.fillUserList.getUserList();
        FillMenu.fillMenu();
    }

    public OrderList getOrderList(){
        return this.orderList;
    }

    //查看餐厅ID
    public int viewRestid(){
        return rest.getRestID();
    }
    //查看餐厅name
    public String viewRestName(){
        return rest.getRestName();
    }
    //查看餐厅introduction
    public String viewRestIntro(){
        return rest.getRestIntro();
    }

    //查看餐厅Postalcode
    public String viewRestPostalcode(){
        return rest.getRestPostalcode();
    }

    //查看餐厅Address
    public String viewRestAddress(){
        return rest.getRestAddress();
    }

    //查看餐厅RegistrationDate
    public String viewRestRegistrationDate(){
        return rest.getRestRegistrationDate();
    }




    //修改餐馆ID
    public void  modifyRestid(int newid){
        this.rest.setRestID(newid);
    }
    //修改餐馆name
    public void modifyRestName(String name) {
        rest.setRestName(name);
    }
    //修改餐馆introduction
    public void modifyRestIntro(String intro) {
        rest.setRestIntro(intro);
    }

    //修改餐馆Postalcode
    public void modifyRestPostalcode(String Postalcode) {
        rest.setRestPostalcode(Postalcode);
    }
    //修改餐馆Address
    public void modifyRestAddress(String Address) {
        rest.setRestAddress(Address);
    }
    //修改餐馆RegistrationDate
    public void modifyRestRegistrationDate(String RegistrationDate) {
        rest.setRestRegistrationDate(RegistrationDate);
    }

    //保存restaurant信息
    public void saveRestInfo (){
        SaveRestInfo save= new SaveRestInfo(this.rest);
    }


    //返回订单的总数量
    public int viewTotalOrder(){
        ArrayList<String> orderId = new ArrayList<String>();
        int i;

        for(i=0;i < orderList.getArraylist().size();i++){
            if (!orderId.contains(orderList.getArraylist().get(i).getOrderID() + "")){
                orderId.add(orderList.getArraylist().get(i).getOrderID() + "");
            }
        }
        return orderId.size();
    }
    //返回总营业额
    public String viewTotalAmount(){
        double Total_Amount=0;
        DecimalFormat df=new DecimalFormat("0.00");
        int i;

        for(i=0;i<orderList.getArraylist().size();i++){
            Total_Amount+=orderList.getArraylist().get(i).getOrderAmount();
        }
        return df.format(Total_Amount);
    }
    //返回今日的订单数
    public int viewTodayOrder(){
        return 0;
    }

    public int getSoupCount(String name){
        int count = 0;
        int i;
        int j;
        for (i = 0; i < orderList.getArraylist().size(); i++){
            for (j = 0; j < orderList.getArraylist().get(i).getRamenList().size(); j++){
                if (orderList.getArraylist().get(i).getRamenList().get(j).getSoup().equals(name))
                    count++;
            }
        }
        return count;
    }

    public int getNoodleCount(String name){
        int count = 0;
        int i;
        int j;
        for (i = 0; i < orderList.getArraylist().size(); i++){
            for (j = 0; j < orderList.getArraylist().get(i).getRamenList().size(); j++){
                if (orderList.getArraylist().get(i).getRamenList().get(j).getNoodles().equals(name))
                    count++;
            }
        }
        return count;
    }

    public int getNoriCount(){
        int count = 0;
        int i;
        int j;
        for (i = 0; i < orderList.getArraylist().size(); i++){
            for (j = 0; j < orderList.getArraylist().get(i).getRamenList().size(); j++){
                if (orderList.getArraylist().get(i).getRamenList().get(j).getNori())
                    count++;
                count += orderList.getArraylist().get(i).getRamenList().get(j).getExtra_nori();
            }
        }
        return count;
    }

    public int getChashuCount(){
        int count = 0;
        int i;
        int j;
        for (i = 0; i < orderList.getArraylist().size(); i++){
            for (j = 0; j < orderList.getArraylist().get(i).getRamenList().size(); j++){
                if (orderList.getArraylist().get(i).getRamenList().get(j).getChashu())
                    count++;
                count += orderList.getArraylist().get(i).getRamenList().get(j).getExtra_chashu();
            }
        }
        return count;
    }

    public int getEggCount(){
        int count = 0;
        int i;
        int j;
        for (i = 0; i < orderList.getArraylist().size(); i++){
            for (j = 0; j < orderList.getArraylist().get(i).getRamenList().size(); j++){
                if (orderList.getArraylist().get(i).getRamenList().get(j).getBoiled_egg())
                    count++;
                count += orderList.getArraylist().get(i).getRamenList().get(j).getExtra_boiled_egg();
            }
        }
        return count;
    }

    public int getBambooCount(){
        int count = 0;
        int i;
        int j;
        for (i = 0; i < orderList.getArraylist().size(); i++){
            for (j = 0; j < orderList.getArraylist().get(i).getRamenList().size(); j++){
                count += orderList.getArraylist().get(i).getRamenList().get(j).getBamboo_shoots();
            }
        }
        return count;
    }

    public String getPopularOnion(){
        int No = 0;
        int Little = 0;
        int Lot = 0;
        int i;
        int j;
        for (i = 0; i < orderList.getArraylist().size(); i++){
            for (j = 0; j < orderList.getArraylist().get(i).getRamenList().size(); j++){
                if (orderList.getArraylist().get(i).getRamenList().get(j).getOnion_level() == 0) {No++;}
                else if (orderList.getArraylist().get(i).getRamenList().get(j).getOnion_level() == 1) {Little++;}
                else{Lot++;}
            }
        }
        if (No >= Little && No >= Lot){
            return "No";
        }
        else if (Little >= No && Little >= Lot){
            return "A Little";
        }
        else{
            return "Lot";
        }
    }

    public String getPopularSpic(){
        int[] spic = {0, 0, 0, 0, 0};
        int index = 0;
        int max = 0;
        int i;
        int j;
        for (i = 0; i < orderList.getArraylist().size(); i++){
            for (j = 0; j < orderList.getArraylist().get(i).getRamenList().size(); j++){
                spic[orderList.getArraylist().get(i).getRamenList().get(j).getSpiciness()]++;
            }
        }
        for (i = 0; i < 5; i ++){
            if (spic[i] > max)
                index = i;
        }
        return "" + i;
    }

    public void saveMenu() throws IOException { SaveMenu.saveMenu(); }

    public ArrayList<User> getUserList(){ return this.userList; }
}
