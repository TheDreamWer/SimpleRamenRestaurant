package boundary;

import control.Business;
import control.Main;
import entities.Menu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    private Business business = Main.getBusiness();

    @FXML
    private AnchorPane RamenPnl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CheckBox tonkotsu = (CheckBox) RamenPnl.lookup("#tonkotsu");
        CheckBox shoyu = (CheckBox) RamenPnl.lookup("#shoyu");
        CheckBox shio = (CheckBox) RamenPnl.lookup("#shio");
        CheckBox soft = (CheckBox) RamenPnl.lookup("#soft");
        CheckBox medium = (CheckBox) RamenPnl.lookup("#medium");
        CheckBox firm = (CheckBox) RamenPnl.lookup("#firm");
        CheckBox nori = (CheckBox) RamenPnl.lookup("#nori");
        CheckBox egg = (CheckBox) RamenPnl.lookup("#egg");
        CheckBox bamboo = (CheckBox) RamenPnl.lookup("#bamboo");
        CheckBox chashu = (CheckBox) RamenPnl.lookup("#chashu");
        TextField extraNori = (TextField) RamenPnl.lookup("#extraNori");
        TextField extraChashu = (TextField) RamenPnl.lookup("#extraChashu");
        TextField extraeEgg = (TextField) RamenPnl.lookup("#extraeEgg");
        TextField bamboo_price = (TextField) RamenPnl.lookup("#bamboo_price");
        TextField price = (TextField) RamenPnl.lookup("#price");
        Button btnOK = (Button) RamenPnl.lookup("#btnOK");

        if( Menu.isSoup_Tonkotsu() ){
            tonkotsu.setSelected(false);
        }
        else{
            tonkotsu.setSelected(true);
        }
        if( Menu.isSoup_Shoyu() ){
            shoyu.setSelected(false);
        }
        else{
            shoyu.setSelected(true);
        }
        if( Menu.isSoup_Shio() ){
            shio.setSelected(false);
        }
        else{
            shio.setSelected(true);
        }
        if( Menu.isNoodles_Soft() ){
            soft.setSelected(false);
        }
        else{
            soft.setSelected(true);
        }
        if( Menu.isNoodles_Medium() ){
            medium.setSelected(false);
        }
        else{
            medium.setSelected(true);
        }
        if( Menu.isNoodles_Firm() ){
            firm.setSelected(false);
        }
        else{
            firm.setSelected(true);
        }
        if( Menu.isNori() ){
            nori.setSelected(false);
        }
        else{
            nori.setSelected(true);
        }
        if( Menu.isBoiled_egg() ){
            egg.setSelected(false);
        }
        else{
            egg.setSelected(true);
        }
        if( Menu.isBamboo_shoots() ){
            bamboo.setSelected(false);
        }
        else{
            bamboo.setSelected(true);
        }
        if( Menu.isChashu() ){
            chashu.setSelected(false);
        }
        else{
            chashu.setSelected(true);
        }
        extraNori.setText(Menu.getP_E_Nori() + "");
        extraChashu.setText(Menu.getP_E_Chashu() + "");
        extraeEgg.setText(Menu.getP_E_boiledEgg() +"");
        bamboo_price.setText(Menu.getP_Bamboo_Shoots() + "");
        price.setText(Menu.getFixed_price() + "");

        btnOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( tonkotsu.isSelected() ){
                    Menu.setSoup_Tonkotsu(false);
                }
                else{
                    Menu.setSoup_Tonkotsu(true);
                }
                if( shoyu.isSelected() ){
                    Menu.setSoup_Shoyu(false);
                }
                else{
                    Menu.setSoup_Shoyu(true);
                }
                if( shio.isSelected() ){
                    Menu.setSoup_Shio(false);
                }
                else{
                    Menu.setSoup_Shio(true);
                }
                if( soft.isSelected() ){
                    Menu.setNoodles_Soft(false);
                }
                else{
                    Menu.setNoodles_Soft(true);
                }
                if( medium.isSelected() ){
                    Menu.setNoodles_Medium(false);
                }
                else{
                    Menu.setNoodles_Medium(true);
                }
                if( firm.isSelected() ){
                    Menu.setNoodles_Firm(false);
                }
                else{
                    Menu.setNoodles_Firm(true);
                }
                if( nori.isSelected() ){
                    Menu.setNori(false);
                }
                else{
                    Menu.setNori(true);
                }
                if( egg.isSelected() ){
                    Menu.setBoiled_egg(false);
                }
                else{
                    Menu.setBoiled_egg(true);
                }
                if( bamboo.isSelected() ){
                    Menu.setBamboo_shoots(false);
                }
                else{
                    Menu.setBamboo_shoots(true);
                }
                if( chashu.isSelected() ){
                    Menu.setChashu(false);
                }
                else{
                    Menu.setChashu(true);
                }
                Menu.setP_E_Nori(Float.parseFloat(extraNori.getText()));
                Menu.setP_E_Chashu(Float.parseFloat(extraChashu.getText()));
                Menu.setP_E_boiledEgg(Float.parseFloat(extraeEgg.getText()));
                Menu.setP_Bamboo_Shoots(Float.parseFloat(bamboo_price.getText()));
                Menu.setFixed_price(Float.parseFloat(price.getText()));
                try {
                    business.saveMenu();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
