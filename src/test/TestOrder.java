package test;

import control.FillOrderInfo;
import control.FillOrderList;
import entities.Order;
import entities.Ramen;
import entities.SystemTime;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class TestOrder {
    @Test
    void testContainer(){
        Order order = new Order();

        assertEquals(order.getGenerateTime(), new SystemTime().getDateString());
        assertEquals(order.getRamenList(), new ArrayList<Ramen>());
    }

    @Test
    void testGetterSetter(){
        Order order = new Order();

        order.setOrderID(new FillOrderInfo().calcOrderID(0));
        assertEquals(order.getOrderID(), new FillOrderInfo().calcOrderID(0));

        order.setCode(123);
        assertEquals(order.getCode(), 123);

        order.setOrderAmount(321);
        assertEquals(order.getOrderAmount(), 321);

        order.setPaymentMethod("paid");
        assertEquals(order.getPaymentMethod(), "paid");

        order.setGenerateTime(new SystemTime().getDateString());
        assertEquals(order.getGenerateTime(), new SystemTime().getDateString());

        ArrayList<Ramen> ramenList = new ArrayList<Ramen>();
        order.setRamenList(ramenList);
        assertSame(order.getRamenList(), ramenList);
    }

    @Test
    void testGetRamen(){
        Ramen ramen = new Ramen();
        FillOrderInfo fillOrderInfo = new FillOrderInfo();
        fillOrderInfo.addRamen(ramen);

        assertSame(fillOrderInfo.getOrder().getRamen(0), ramen);
    }

    @Test
    void testOrderToString(){
        FillOrderInfo fillOrderInfo = new FillOrderInfo();
        fillOrderInfo.addRamen(new Ramen());
        Order order = fillOrderInfo.getOrder();

        Ramen ramen = order.getRamen(0);
        String temp = "";
        temp += Long.toString(order.getOrderID()) + ",";
        temp += Integer.toString(order.getCode()) + ",";
        temp += Float.toString(order.getOrderAmount()) + ",";
        temp += order.getPaymentMethod() + ",";
        temp += order.getGenerateTime() + ",";
        temp += ramen.getSoup() + ",";
        temp += ramen.getNoodles() + ",";
        temp += Integer.toString(ramen.getOnion_level()) + ",";
        temp += Boolean.toString(ramen.getNori()) + ",";
        temp += Boolean.toString(ramen.getChashu()) + ",";
        temp += Boolean.toString(ramen.getBoiled_egg()) + ",";
        temp += Integer.toString(ramen.getSpiciness()) + ",";
        temp += Integer.toString(ramen.getExtra_nori()) + ",";
        temp += Integer.toString(ramen.getExtra_boiled_egg()) + ",";
        temp += Integer.toString(ramen.getBamboo_shoots()) + ",";
        temp += Integer.toString(ramen.getExtra_chashu()) + ",";

        assertEquals(order.orderToString(0), temp);
    }
}
