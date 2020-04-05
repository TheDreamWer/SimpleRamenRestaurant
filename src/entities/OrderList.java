package entities;
import java.util.ArrayList;
import control.*;

public class OrderList {
    private ArrayList<Order> list = new ArrayList<Order>();

    public void setter(ArrayList<Order> list)
    {
        this.list=list;
    }

    public OrderList getter(){
        FillOrderList fill = new FillOrderList();
        return fill.getter();
    }//返回 orderlist对象

    public ArrayList<Order> Getter()
    {
        return this.list;
    }//返回 arraylist
}