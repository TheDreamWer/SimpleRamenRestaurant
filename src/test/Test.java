package test;
import entities.*;
import control.*;

public class Test {
    public static void main(String[] args) {
         FillOrderList list = new FillOrderList();
         System.out.println(list.getOrderlist().getArraylist().get(0).getOrderID());
         System.out.println(list.getOrderlist().getArraylist().get(0).getRamen(1).getOnion_level());
    }
}
