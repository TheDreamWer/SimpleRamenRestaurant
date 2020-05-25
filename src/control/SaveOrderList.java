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

        File csv = new File("src/data/OrderList.csv");
        FileWriter fw = new FileWriter(csv);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("OrderId,Code,Amount,Method,GenerateTime," +
                "Soup,Noodles,Level,Nori,Chashu,B_egg,Spic,E_nori,E_egg,Bambs,E_cha,Num,UserID,Name\r\n");
        for (int i = 0; i< list.getArraylist().size(); i++) {
            for (int j = 0; j< list.getArraylist().get(i).getRamenList().size(); j++) {
                bw.write(String.valueOf(list.getArraylist().get(i).getOrderID())+((list.getArraylist().get(i).getTakeAway()==true)?1:0)+",");
                bw.write(list.getArraylist().get(i).getCode()+",");
                bw.write(list.getArraylist().get(i).getOrderAmount()+",");
                bw.write(list.getArraylist().get(i).getPaymentMethod()+",");
                bw.write(list.getArraylist().get(i).getGenerateTime()+",");
                bw.write(list.getArraylist().get(i).getRamen(j).getSoup()+",");
                bw.write(list.getArraylist().get(i).getRamen(j).getNoodles()+",");
                bw.write(list.getArraylist().get(i).getRamen(j).getOnion_level()+",");
                bw.write(String.valueOf(list.getArraylist().get(i).getRamen(j).getNori())+",");
                bw.write(String.valueOf(list.getArraylist().get(i).getRamen(j).getChashu())+",");
                bw.write(String.valueOf(list.getArraylist().get(i).getRamen(j).getBoiled_egg())+",");
                bw.write(String.valueOf(list.getArraylist().get(i).getRamen(j).getSpiciness())+",");
                bw.write(String.valueOf(list.getArraylist().get(i).getRamen(j).getExtra_nori())+",");
                bw.write(String.valueOf(list.getArraylist().get(i).getRamen(j).getExtra_boiled_egg())+",");
                bw.write(String.valueOf(list.getArraylist().get(i).getRamen(j).getBamboo_shoots())+",");
                bw.write(String.valueOf(list.getArraylist().get(i).getRamen(j).getExtra_chashu())+",");
                bw.write(list.getArraylist().get(i).getRamen(j).getNum()+",");
                if(list.getArraylist().get(i).getUser() != null){
                    bw.write(list.getArraylist().get(i).getUser().getUserID()+",");
                    bw.write(list.getArraylist().get(i).getUser().getFirstName() + list.getArraylist().get(i).getUser().getSurname() +"\r\n");
                }
                else{
                    bw.write("null"+",");
                    bw.write("Visitor" +"\r\n");
                }
            }
        }

        bw.flush();
        bw.close();
        fw.close();
    }
}
