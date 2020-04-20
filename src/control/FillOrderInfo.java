package control;

import java.util.ArrayList;

import control.*;
import entities.*;

public class FillOrderInfo{
    private Order order = new Order();
    /**
     * Iteration 1
     * 
     */
    /** Getter/Setter start */
    public Order getOrder(){
        return this.order;
    }
    public void setOrder(Order order){
        this.order = order;
    }
    /** Getter/Setter end */

    public void initOrder(int inputCode){
        Long order_ID = this.calcOrderID(inputCode);
        this.order.setOrderID(order_ID);
        this.order.setCode(inputCode + 1);;
        String systemTime = this.getSystemTime();
        this.order.setGenerateTime(systemTime);
        this.order.setRamenList(new ArrayList<Ramen>());
        this.order.setOrderAmount(0);
        this.order.setPaymentMethod("unpaid");
    }

    public Long calcOrderID(int inputCode){
        SystemTime systemTime = new SystemTime();
        String temp_ID = "";
        String dateString = systemTime.getDateString();
        String codeString = Integer.toString(inputCode+1);
        
        temp_ID += dateString.charAt(2);
        temp_ID += dateString.charAt(3);
        temp_ID += dateString.charAt(5);
        temp_ID += dateString.charAt(6);
        temp_ID += dateString.charAt(8);
        temp_ID += dateString.charAt(9);
        temp_ID += codeString;

        Long orderID = Long.parseLong(temp_ID);

        return orderID;
    }

    public float calcOrderAmount(ArrayList ramenList){
        float order_amount = 0;
        Ramen ramen;
        for(int i=0; i<ramenList.size(); i++){
            ramen = (Ramen) ramenList.get(i);
            order_amount += ramen.getNum()*ramen.calcRamenAmount();
        }

        return order_amount;
    }

    public float calcRamenAmount(Ramen ramen){
        float amount = 9.9;
        amount += ramen.getExtra_nori();
        amount += ramen.getExtra_boiled_egg();
        amount += ramen.getExtra_chashu() * 2.;
        amount += ramen.getBamboo_shoots();
        return amount;
    }

    public String getSystemTime(){
        SystemTime systemTime = new SystemTime();
        return systemTime.getDateString();
    }

    public void addRamen(Ramen ramen){
        this.order.getRamenList().add(ramen);
        float amount = this.calcOrderAmount(this.order.getRamenList());
        this.order.setOrderAmount(amount);
    }
    public void deleteRamen(int index){
        this.order.getRamenList().remove(index);
        float amount = this.calcOrderAmount(this.order.getRamenList());
        this.order.setOrderAmount(amount);
    }
}
