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
        FillOrderInfo getAmount = new FillOrderInfo();
        for (int i=0;i<this.list.size();i++)
            sumAmount += getAmount.calcOrderAmount(this.list.get(i).getRamenList());
        return sumAmount;
    }

    public float getAmount(long orderId) {
        FillOrderInfo getAmount = new FillOrderInfo();
        for (int i=0;i<this.list.size();i++) {
            if (this.list.get(i).getOrderID()==orderId)
                return getAmount.calcOrderAmount(this.list.get(i).getRamenList());
        }
        return 0;
    }
}
