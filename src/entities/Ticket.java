package entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;

import control.SystemTime;
import entities.*;

public class Ticket implements Serializable{
    /**
     *Iteration 2
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

    public void printTicket() { 
        try {
			File fl = new File("data/ticket.txt");
            FileWriter fw = new FileWriter(fl);
            BufferedWriter bw = new BufferedWriter(fw);
            SystemTime systemTime = new SystemTime();
            String time = systemTime.getDateString();
            String intro = "Werlcome to Totoro Ramen!\n";
            intro += "\nDate: " + time;
            intro += "\nOrder ID: " + this.order.getOrderID();
            intro += "\nOrder Amount: " + this.order.getOrderAmount();
            intro += "\nCode: " + this.order.getCode();
            intro += "\n=================================\n";
            bw.write(intro);
			bw.flush();
            for(int i=0; i<this.order.getRamenList().size(); i++){
                Ramen ramen = this.order.getRamenList().get(i);
                bw.write(printRamen(ramen, i));
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

    public String printRamen(Ramen ramen, int count){
        String ramenInfo = "---------------  "+ count +"  --------------";
        ramenInfo += "\nSoup: " + ramen.getSoup();
        ramenInfo += "\nNoodles: " + ramen.getNoodles();
        ramenInfo += "\nOnion Level: : " + ramen.getOnion_level();
        ramenInfo += "\nBamboo Shoots: " + ramen.getBamboo_shoots();
        ramenInfo += "\nNori : " + ramen.getNori() + "  Extra: " + ramen.getExtra_nori();
        ramenInfo += "\nChashu: " + ramen.getChashu() + "  Extra: " + ramen.getExtra_chashu();
        ramenInfo += "\nBoiled Egg: " + ramen.getBoiled_egg() + "   Extra: " + ramen.getExtra_boiled_egg();
        ramenInfo += "\nSpiciness: " + ramen.getSpiciness();
        ramenInfo += "\nNumber : " + ramen.getNum(); 
        ramenInfo += "\n---------------------------------\n\n";

        return ramenInfo;
    }
}
