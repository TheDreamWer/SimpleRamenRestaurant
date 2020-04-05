package control;
import entities.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveOrderList {
    private OrderList list; // 先设置一个空指针
    // 设置一个对外的接口，将外部的orderlist类传入进来
    public SaveOrderList(OrderList list){
        this.list = list;
    }

    public void Save() throws IOException {

        File csv = new File("src/entities/OrderList.csv");
        FileWriter fw = new FileWriter(csv);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("");
        for (int i = 0; i< list.Getter().size(); i++) {
            for (int j=0;j< list.Getter().get(i).getRamenList().size();j++) {
                bw.write(String.valueOf(list.Getter().get(i).getOrderID())+",");
                bw.write(String.valueOf(list.Getter().get(i).getCode())+",");
                bw.write(String.valueOf(list.Getter().get(i).getOrderAmount())+",");
                bw.write(list.Getter().get(i).getPaymentMethod()+",");
                bw.write(list.Getter().get(i).getGenerateTime()+",");
                bw.write(list.Getter().get(i).getRamen(j).getSoup()+",");
                bw.write(list.Getter().get(i).getRamen(j).getNoodles()+",");
                bw.write(list.Getter().get(i).getRamen(j).getOnion_level()+",");
                bw.write(String.valueOf(list.Getter().get(i).getRamen(j).getNori())+",");
                bw.write(String.valueOf(list.Getter().get(i).getRamen(j).getChashu())+",");
                bw.write(String.valueOf(list.Getter().get(i).getRamen(j).getBoiled_egg())+",");
                bw.write(String.valueOf(list.Getter().get(i).getRamen(j).getSpiciness())+",");
                bw.write(String.valueOf(list.Getter().get(i).getRamen(j).getExtra_nori())+",");
                bw.write(String.valueOf(list.Getter().get(i).getRamen(j).getExtra_boiled_egg())+",");
                bw.write(String.valueOf(list.Getter().get(i).getRamen(j).getBamboo_shoots())+",");
                bw.write(String.valueOf(list.Getter().get(i).getRamen(j).getExtra_chashu())+"\r\n");
            }
        }

        bw.flush();
        bw.close();
        fw.close();
    }
}
