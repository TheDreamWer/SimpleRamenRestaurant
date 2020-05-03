package test;

import control.Customer;
import control.FillOrderList;
import control.FillRestInfo;
import entities.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class TestCustomer {
    @Test
    void testGetterSetter(){
        Customer customer = new Customer(0);

        Restaurant rest = new Restaurant();
        customer.setRest(rest);
        assertSame(customer.getRest(), rest);

        Order order = new Order();
        customer.setDraft(order);
        assertSame(customer.getDraft(), order);

        Ramen ramen = new Ramen();
        customer.setRamen(ramen);
        assertSame(customer.getRamen(), ramen);

        Ticket ticket = new Ticket(order);
        customer.setTicket(ticket);
        assertSame(customer.getTicket(), ticket);

        FillRestInfo fillRestInfo = new FillRestInfo(0);
        customer.setFillRestInfo(fillRestInfo);
        assertSame(customer.getFillRestInfo(), fillRestInfo);

        FillOrderList fillOrderList = new FillOrderList();
        customer.setFillOrderList(fillOrderList);
        assertSame(customer.getFillOrderList(), fillOrderList);

        OrderList orderList = new OrderList();
        customer.setOrderList(orderList);
        assertSame(customer.getOrderList(), orderList);
    }

    @Test
    void testFillInRest(){
        Customer customer = new Customer(0);
        assertEquals(customer.getFillRestInfo().getRestaurant(), customer.getRest());
    }
    @Test
    void testFillInOrderList(){
        Customer customer = new Customer(0);
        customer.fillInOrderList();
        assertNotEquals(customer.getOrderList(), null);
    }

    @Test
    void testShowRestInfo(){
        Customer customer = new Customer(0);
        assertEquals(customer.getRest().getRestIntro(), customer.showRestInfo());
    }

    @Test
    void testFormOrder() throws IOException {
        Customer customer = new Customer(0);
        customer.formOrder();
        int length = customer.getOrderList().getArraylist().size();
        assertSame(customer.getOrderList().getArraylist().get(length-1), customer.getDraft());
    }

    @Test
    void testSaveOrderToDraft() throws IOException {
        Customer customer = new Customer(0);
        Order order = new Order();
        customer.saveOrderToDraft(order);
        assertSame(customer.getDraft(), order);
    }
}