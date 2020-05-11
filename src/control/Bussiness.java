package control;

import java.util.ArrayList;
import entities.*;

public class Bussiness {
    
    //查看餐厅ID
    public int viewRestInfo_id(int id){
        Restaurant r ;  //生成一个Restaurant引用变量
        FillRestInfo fill = new FillRestInfo(id);
        r=fill.getRestaurant();   //该引用变量指向数据接口返回的object
        return r.getRestID();
    }
    //查看餐厅name
    public String viewRestInfo_name(int id){
        Restaurant r ;  //生成一个Restaurant引用变量
        FillRestInfo fill = new FillRestInfo(id);
        r=fill.getRestaurant();   //该引用变量指向数据接口返回的object
        return r.getRestName();
    }
    //查看餐厅introduction
    public String viewRestInfo_intro(int id){
        Restaurant r ;  //生成一个Restaurant引用变量
        FillRestInfo fill = new FillRestInfo(id);
        r=fill.getRestaurant();   //该引用变量指向数据接口返回的object
        return r.getRestIntro();
    }

    //查看餐厅Postalcode
    public String viewRestInfo_Postalcode(int id){
        Restaurant r ;  //生成一个Restaurant引用变量
        FillRestInfo fill = new FillRestInfo(id);
        r=fill.getRestaurant();   //该引用变量指向数据接口返回的object
        return r.getRestPostalcode();
    }

    //查看餐厅Address
    public String viewRestInfo_Address(int id){
        Restaurant r ;  //生成一个Restaurant引用变量
        FillRestInfo fill = new FillRestInfo(id);
        r=fill.getRestaurant();   //该引用变量指向数据接口返回的object
        return r.getRestAddress();
    }

    //查看餐厅RegistrationDate
    public String viewRestInfo_RegistrationDate(int id){
        Restaurant r ;  //生成一个Restaurant引用变量
        FillRestInfo fill = new FillRestInfo(id);
        r=fill.getRestaurant();   //该引用变量指向数据接口返回的object
        return r.getRestRegistrationDate();
    }







    //修改餐馆ID
    public void  modifyRestInfo_id(int oldid,int newid){
        Restaurant r ;  //生成一个Restaurant引用变量
        FillRestInfo fill = new FillRestInfo(oldid);
        r=fill.getRestaurant();   //该引用变量指向数据接口返回的object
        r.setRestID(newid);
        SaveRestInfo save= new SaveRestInfo(r);
    }
    //修改餐馆name
    public void modifyRestInfo_name(int Restid, String name) {
        Restaurant r ;  //生成一个Restaurant引用变量
        FillRestInfo fill = new FillRestInfo(Restid);
        r=fill.getRestaurant();   //该引用变量指向数据接口返回的object
        r.setRestName(name);
        SaveRestInfo save= new SaveRestInfo(r);
    }
    //修改餐馆introduction
    public void modifyRestInfo_intro(int Restid,String intro) {
        Restaurant r ;  //生成一个Restaurant引用变量
        FillRestInfo fill = new FillRestInfo(Restid);
        r=fill.getRestaurant();   //该引用变量指向数据接口返回的object
        r.setRestIntro(intro);
        SaveRestInfo save= new SaveRestInfo(r);
    }

    //修改餐馆Postalcode
    public void modifyRestInfo_Postalcode(int Restid,String Postalcode) {
        Restaurant r ;  //生成一个Restaurant引用变量
        FillRestInfo fill = new FillRestInfo(Restid);
        r=fill.getRestaurant();   //该引用变量指向数据接口返回的object
        r.setRestPostalcode(Postalcode);
        SaveRestInfo save= new SaveRestInfo(r);
    }
    //修改餐馆Address
    public void modifyRestInfo_Address(int Restid,String Address) {
        Restaurant r ;  //生成一个Restaurant引用变量
        FillRestInfo fill = new FillRestInfo(Restid);
        r=fill.getRestaurant();   //该引用变量指向数据接口返回的object
        r.setRestAddress(Address);
        SaveRestInfo save= new SaveRestInfo(r);
    }
    //修改餐馆RegistrationDate
    public void modifyRestInfo_RegistrationDate(int Restid,String RegistrationDate) {
        Restaurant r ;  //生成一个Restaurant引用变量
        FillRestInfo fill = new FillRestInfo(Restid);
        r=fill.getRestaurant();   //该引用变量指向数据接口返回的object
        r.setRestRegistrationDate(RegistrationDate);
        SaveRestInfo save= new SaveRestInfo(r);
    }




    //返回订单的总数量
    public int view_totalorder(){
        int Order_num=1;
        int i;
        ArrayList<Order> order ;//创建一个order数组引用变量
        OrderList list= new OrderList();
        list=list.getter(); //得到返回的OrderList
        order =list.Getter();//得到返回的ArrayList

        for(i=0;i<order.size();i++){
            if(order.get(i+1).getOrderID()!=order.get(i).getOrderID()){
                Order_num++;
            }
        }
        return Order_num;
    }
    //返回总营业额
    public int view_totalamount(){
        int Total_Amount=0;
        int i;
        ArrayList<Order> order ;//创建一个order数组引用变量
        OrderList list= new OrderList();
        list=list.getter(); //得到返回的OrderList
        order =list.Getter();//得到返回的ArrayList

        for(i=0;i<order.size();i++){
            Total_Amount+=order.get(i).getOrderAmount();
        }
        return Total_Amount;
    }
    //返回今日的订单数
    public int view_todayorder(){
        return 0;
    }


    



}
