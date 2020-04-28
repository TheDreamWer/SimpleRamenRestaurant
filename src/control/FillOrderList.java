package control;
import entities.*;
import java.io.*;
import java.util.ArrayList;

public class FillOrderList {
    private OrderList list= new OrderList();

    public FillOrderList(){
        File csv = new File("src/data/OrderList.csv");
        Order temp = new Order();   //建一个空的order
        temp.setOrderID(Long.MAX_VALUE);    //设置不重复ID来保证第一个order不会和空的order相同Id
        Ramen temp_r = new Ramen();

        try {
            BufferedReader textFile = new BufferedReader(new FileReader(csv));
            String lineDta = "";
            while ((lineDta=textFile.readLine()) != null) {
                String item[] = lineDta.split(",");
                if (temp.getOrderID()!=Long.parseLong(item[0]))     //判断是否为同一订单信息
                {
                    temp = new Order();
                    temp.setOrderID(Long.parseLong(item[0]));
                    temp.setCode(Integer.parseInt(item[1]));
                    temp.setOrderAmount(Float.parseFloat(item[2]));
                    temp.setPaymentMethod(item[3]);
                    temp.setGenerateTime(item[4]);
                    temp.setRamenList(new ArrayList<Ramen>());
                    list.getArraylist().add(temp);
                }
                temp_r.setSoup(item[5]);
                temp_r.setNoodles(item[6]);
                temp_r.setOnion_level(Integer.parseInt(item[7]));
                temp_r.setNori(Boolean.parseBoolean(item[8]));
                temp_r.setChashu(Boolean.parseBoolean(item[9]));
                temp_r.setBoiled_egg(Boolean.parseBoolean(item[10]));
                temp_r.setSpiciness(Integer.parseInt(item[11]));
                temp_r.setExtra_nori(Integer.parseInt(item[12]));
                temp_r.setExtra_boiled_egg(Integer.parseInt(item[13]));
                temp_r.setBamboo_shoots(Integer.parseInt(item[14]));
                temp_r.setExtra_chashu(Integer.parseInt(item[15]));
                temp_r.setNum(Integer.parseInt(item[16]));

                temp.getRamenList().add(temp_r);
            }
            textFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("Write/read error");
        }
    }

    public OrderList getOrderlist(){
        return this.list;
    }//返回orderlist对象
}
