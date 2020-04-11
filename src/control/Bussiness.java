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



    //显示所有订单信息
    public ArrayList<String> showoder() {
        ArrayList<Order> order ;//创建一个order数组引用变量
        OrderList list= new OrderList();
        //list=list.getArraylist(); //得到返回的OrderList
        order =list.getArraylist();//得到返回的ArrayList


        ArrayList<String> order_info = new ArrayList<>(); //储存order信息String形式
        String text="";
        //打印Order信息
        for (int i = 0; i < order.size(); i++) {
            text="";
            text+="******Basic Information******\n";
            text+="OrderID:"+String.valueOf(order.get(i).getOrderID())+"\n";//订单ID
            text+="Code:"+String.valueOf(order.get(i).getCode())+"\n";//订单取餐码
            text+="OrderAmount:"+String.valueOf(order.get(i).getOrderAmount())+"\n";//订单amount
            text+="PaymentMethod:"+String.valueOf(order.get(i).getPaymentMethod())+"\n";//付款方式
            text+="Time:"+String.valueOf(order.get(i).getGenerateTime())+"\n\n";//订单生成时间


            ArrayList<Ramen> Ramenlist ; //创建Ramen数组，用于保存每个订单的ramen信息
            Ramenlist = order.get(i).getRamenList();
            for (int j = 0; j < Ramenlist.size();j++) {
                text+="******Ramen Option******\n";
                //打印Ramen选项
                text+="Soup:" +String.valueOf(Ramenlist.get(j).getSoup())+"\n";
                text+="Noodles:" +String.valueOf(Ramenlist.get(j).getNoodles())+"\n";
                text+="Onion_level:" +String.valueOf(Ramenlist.get(j).getOnion_level())+"\n";
                text+="Nori:" +String.valueOf(Ramenlist.get(j).getNori())+"\n";
                text+="Chashu:" +String.valueOf(Ramenlist.get(j).getChashu())+"\n";
                text+="Boiled_egg:" +String.valueOf(Ramenlist.get(j).getBoiled_egg())+"\n";
                text+="Spiciness:" +String.valueOf(Ramenlist.get(j).getSpiciness())+"\n\n";

                text+="******Ramen Extra Option******\n";
                //打印Ramen额外添加项
                text+="Extra_nori:" +String.valueOf(Ramenlist.get(j).getExtra_nori())+"\n";
                text+="Extra_boiled_egg:" +String.valueOf(Ramenlist.get(j).getExtra_boiled_egg())+"\n";
                text+="Extra_chashu:" +String.valueOf(Ramenlist.get(j).getExtra_chashu())+"\n";
                text+="Bamboo_shoots:" +String.valueOf(Ramenlist.get(j).getBamboo_shoots())+"\n";
            }
            order_info.add(text);
        }
        return order_info;
    }



}
