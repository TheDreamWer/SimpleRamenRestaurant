package entities;
import java.util.ArrayList;

public class OrderList {
    private ArrayList<Order> list = new ArrayList<Order>();

    public void setArraylist(ArrayList<Order> list)
    {
        this.list=list;
    }

    public ArrayList<Order> getArraylist()
    {
        return this.list;
    }//返回 arraylist

    public double getSumAmount(){
        double sumAmount = 0.0;
        for (int i=0;i<this.list.size();i++)
            sumAmount += this.list.get(i).getOrderAmount();
        return sumAmount;
    }

    public float getAmount(long orderId) {
        for (int i=0;i<this.list.size();i++) {
            if (this.list.get(i).getOrderID()==orderId)
                return this.list.get(i).getOrderAmount();
        }
        return 0;
    }
}
