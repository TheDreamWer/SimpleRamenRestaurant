package entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;

import entities.*;

public class Ticket implements Serializable{
    /**
     *Iteration 1
     */
    private static final long serialVersionUID = 1L;
    private Order order;

    public Ticket(Order order){
        this.order = order;
    }

    public Order getOrder(){
        return this.order;
    }
    public void setOrder(Order order){
        this.order = order;
    }

    public void printTicket() { //--------------还需要修改------------   
        try {
			File fl = new File("data/ticket.txt");
            FileWriter fw = new FileWriter(fl);
            BufferedWriter bw = new BufferedWriter(fw);
            String titleline = 
                "order_ID,code,order_amount,payment_method,generateTime,soup,noodles,onion_level,nori,chashu,boiled_egg,spiciness,extra_nori,extra_boiled_egg,Bamboo_shoots,extra_chashu\n";
            bw.write(titleline);
			bw.flush();
            for(int i=0; i<this.order.getRamenList().size(); i++){
                String order_string = this.order.orderToString(i) + "\n";
                bw.write(order_string);
                bw.flush();
            } 
			bw.close();
			fw.close();
		}
		catch(Exception e) {
			System.err.println("Class Restaurant Constructor Error");
			e.printStackTrace();
		}
    }
}