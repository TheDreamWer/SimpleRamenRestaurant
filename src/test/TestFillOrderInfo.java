package test;

import entities.*;
import control.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class TestFillOrderInfo {
    @Test
    void testSetterGetter(){
        FillOrderInfo fillOrderInfo = new FillOrderInfo();
        Order order = new Order();
        fillOrderInfo.setOrder(order);
        assertEquals(order, fillOrderInfo.getOrder());
    }

    @Test
    void testCalcOrderID(){
        FillOrderInfo fillOrderInfo = new FillOrderInfo();
        int inputCode = 1;

        String orderID = Long.toString(fillOrderInfo.calcOrderID(inputCode));
        String orderDate = "";
        for(int i=0; i<6; i++){
           orderDate += orderID.charAt(i);
        }

        int orderCode = Integer.parseInt(""+orderID.charAt(6));

        String date = "";
        String dateString = new SystemTime().getDateString();
        date += dateString.charAt(2);
        date += dateString.charAt(3);
        date += dateString.charAt(5);
        date += dateString.charAt(6);
        date += dateString.charAt(8);
        date += dateString.charAt(9);

        assertEquals(date, orderDate);
        assertEquals(inputCode+1, orderCode);
    }

    @Test
    void testAddRamen(){
        FillOrderInfo fillOrderInfo = new FillOrderInfo();
        Ramen ramen = new Ramen();

        fillOrderInfo.addRamen(ramen);
        assertSame(fillOrderInfo.getOrder().getRamenList().get(0), ramen);
    }

    @Test
    void testDeleteRamen(){
        FillOrderInfo fillOrderInfo = new FillOrderInfo();
        Ramen ramen0 = new Ramen();
        Ramen ramen1 = new Ramen();

        fillOrderInfo.addRamen(ramen0);
        fillOrderInfo.addRamen(ramen1);
        fillOrderInfo.deleteRamen(0);
        assertEquals(fillOrderInfo.getOrder().getRamenList().size(), 1);
        assertSame(fillOrderInfo.getOrder().getRamenList().get(0), ramen1);
    }

    @Test
    void testCalcOrderAmount(){
        FillOrderInfo fillOrderInfo = new FillOrderInfo();

        Ramen ramen0 = new Ramen();
        ramen0.setBamboo_shoots(2);
        Ramen ramen1 = new Ramen();
        ramen1.setExtra_nori(3);

        fillOrderInfo.addRamen(ramen0);
        fillOrderInfo.addRamen(ramen1);

        float order_amount = 0;
        for(int i=0; i<fillOrderInfo.getOrder().getRamenList().size(); i++){
            Ramen ramen = (Ramen) fillOrderInfo.getOrder().getRamenList().get(i);
            order_amount += ramen.getNum()*ramen.calcRamenAmount();
        }

        assertEquals(fillOrderInfo.calcOrderAmount(fillOrderInfo.getOrder().getRamenList()), order_amount);
    }

    @Test
    void testGetSystemTime(){
        FillOrderInfo fillOrderInfo = new FillOrderInfo();
        assertEquals(new SystemTime().getDateString(), fillOrderInfo.getSystemTime());
    }

    @Test
    void testInitOrder(){
        FillOrderInfo fillOrderInfo = new FillOrderInfo();
        int inputCode = 1;
        fillOrderInfo.initOrder(inputCode);

        assertEquals(fillOrderInfo.getOrder().getOrderID(), fillOrderInfo.calcOrderID(inputCode));
        assertEquals(fillOrderInfo.getOrder().getCode(), inputCode+1);
        assertEquals(fillOrderInfo.getOrder().getGenerateTime(), fillOrderInfo.getSystemTime());
        assertEquals(fillOrderInfo.getOrder().getRamenList(), new ArrayList<Ramen>());
        assertEquals(fillOrderInfo.getOrder().getOrderAmount(), 0);
        assertEquals(fillOrderInfo.getOrder().getPaymentMethod(), "unpaid");
    }

}
