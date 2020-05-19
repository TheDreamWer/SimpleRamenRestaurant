package control;

import entities.Menu;

import java.io.*;

public class FillMenu {

    public static void fillMenu(){
        File csv = new File("src/data/Menu.csv");

        try {
            BufferedReader textFile = new BufferedReader(new FileReader(csv));
            textFile.readLine();
            String[] items = textFile.readLine().split(",");

            Menu.setSoup_Tonkotsu(Boolean.parseBoolean(items[0]));
            Menu.setSoup_Shoyu(Boolean.parseBoolean(items[1]));
            Menu.setSoup_Shio(Boolean.parseBoolean(items[2]));
            Menu.setNoodles_Soft(Boolean.parseBoolean(items[3]));
            Menu.setNoodles_Medium(Boolean.parseBoolean(items[4]));
            Menu.setNoodles_Firm(Boolean.parseBoolean(items[5]));
            Menu.setNori(Boolean.parseBoolean(items[6]));
            Menu.setBoiled_egg(Boolean.parseBoolean(items[7]));
            Menu.setBamboo_shoots(Boolean.parseBoolean(items[8]));
            Menu.setChashu(Boolean.parseBoolean(items[9]));
            Menu.setP_E_Nori(Float.parseFloat(items[10]));
            Menu.setP_E_Chashu(Float.parseFloat(items[11]));
            Menu.setP_E_boiledEgg(Float.parseFloat(items[12]));
            Menu.setP_Bamboo_Shoots(Float.parseFloat(items[13]));
            Menu.setFixed_price(Float.parseFloat(items[13]));

            textFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("Write/read error");
        }
    }

}
