package control;

import entities.Menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveMenu {
    public static void saveMenu() throws IOException {
        File csv = new File("src/data/Menu.csv");
        FileWriter fw = new FileWriter(csv);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Soup-Tonkotsu,Soup-Shoyu,Soup-Shio,Noodles-Soft,Noodles-Medium," +
                "Noodles-Firm,Nori,Boiled egg,Bamboo shoots,Chashu,P_E_Nori,P_E_Chashu," +
                "P_E_boiledEgg,P_Bamboo Shoots,Fixed price\r\n");
        bw.write(Menu.isSoup_Tonkotsu()+",");
        bw.write(Menu.isSoup_Shoyu()+",");
        bw.write(Menu.isSoup_Shio()+",");
        bw.write(Menu.isNoodles_Soft()+",");
        bw.write(Menu.isNoodles_Medium()+",");
        bw.write(Menu.isNoodles_Firm()+",");
        bw.write(Menu.isNori()+",");
        bw.write(Menu.isBoiled_egg()+",");
        bw.write(Menu.isBamboo_shoots()+",");
        bw.write(Menu.isChashu()+",");
        bw.write(Menu.getP_E_Nori()+",");
        bw.write(Menu.getP_E_Chashu()+",");
        bw.write(Menu.getP_E_boiledEgg()+",");
        bw.write(Menu.getP_Bamboo_Shoots()+",");
        bw.write(Menu.getFixed_price()+"\r\n");
        bw.flush();
        bw.close();
        fw.close();
    }
}
