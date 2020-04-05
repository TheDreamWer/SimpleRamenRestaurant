package test;
import control.Customer;
import entities.Order;
import entities.OrderList;
import entities.Ramen;

import java.io.IOException;
import java.util.ArrayList;

public class TestCustomerOrder {
    public static void main(String[] args) throws IOException {
        Customer customer = new Customer(0);
        System.out.println(customer.showRestInfo());

        OrderList ol = customer.getOrderList();
        System.out.println("the size of orderList.csv: " +
                customer.getOrderList().Getter().size());
//        customer.addRamen();
        /* Print the last ramen in the ramenList of the draft order */
        System.out.println
                (customer.getDraft().orderToString(customer.getDraft().getRamenList().size()-1));

        Ramen ramen = new Ramen();
        ramen.setExtra_boiled_egg(10);
//        customer.addRamen(ramen);
        /* Print the last ramen in the ramenList of the draft order */
        System.out.println
                (customer.getDraft().orderToString(customer.getDraft().getRamenList().size()-1));

//        customer.addRamen();
        /* Print the last ramen in the ramenList of the draft order */
        System.out.println
                (customer.getDraft().orderToString(customer.getDraft().getRamenList().size()-1));

//        customer.deleteRamen(2);
        /* Print the last ramen in the ramenList of the draft order */
        System.out.println
                (customer.getDraft().orderToString(customer.getDraft().getRamenList().size()-1));

        customer.formOrder();
        System.out.println("the size of orderList.csv: " +
                customer.getOrderList().Getter().size());
    }
}
