package boundary;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import entities.*;
import control.*;

public class DashboardController implements Initializable{
    Customer customer = new Customer(1);
    @FXML
    private VBox vBoxButton;

    @FXML
    private Pane pnlPersonalInfo;

    @FXML
    private Pane pnlStamp;

    @FXML
    private Button btnSignOut;

    @FXML
    private Pane pnlRamen;

    @FXML
    private Button btnStamp;

    @FXML
    private Button btnRamen;

    @FXML
    private Button btnPersonalInfo;

    @FXML
    private Button btnCart;

    @FXML
    private Pane pnlCart;

    @FXML
    private Pane pnlWelcome;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pnlWelcome.toFront();
        Node[] nodes = new Node[1];
        try {
            nodes[0] = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
            pnlWelcome.getChildren().add(nodes[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnRamen) {
            pnlRamen.toFront();
            Node[] nodes = new Node[1];

            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("Ramen.fxml"));
                pnlRamen.getChildren().add(nodes[0]);

                Label Amount = (Label) pnlRamen.lookup("#Amount");
                Amount.setText("£9.9");
                //初始化Ramen
                ArrayList<Ramen> tempRamen = new ArrayList<Ramen>();
                tempRamen.add(new Ramen());

                //额外的Nori 增减部分
                Label ExtraNori = (Label) pnlRamen.lookup("#ExtraNori");
                Button addNori = (Button) pnlRamen.lookup("#addNori");
                addNori.setDisable(true);
                addNori.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (!ExtraNori.getText().equals("100")) {
                            ExtraNori.setText(String.valueOf(Integer.parseInt(ExtraNori.getText())+1));
                            tempRamen.get(tempRamen.size()-1).setExtra_nori(Integer.parseInt(ExtraNori.getText())+1);
                            Amount.setText("£" + tempRamen.get(tempRamen.size()-1).calcRamenAmount());
                        }
                    }
                });
                Button subNori = (Button) pnlRamen.lookup("#subNori");
                subNori.setDisable(true);
                subNori.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (!ExtraNori.getText().equals("0")) {
                            ExtraNori.setText(String.valueOf(Integer.parseInt(ExtraNori.getText())-1));
                            tempRamen.get(tempRamen.size()-1).setExtra_nori(Integer.parseInt(ExtraNori.getText())-1);
                            Amount.setText("£" + tempRamen.get(tempRamen.size()-1).calcRamenAmount());
                        }
                    }
                });

                //额外的Chashu 增减
                Label ExtraChashu = (Label) pnlRamen.lookup("#ExtraChashu");
                Button addChashu = (Button) pnlRamen.lookup("#addChashu");
                addChashu.setDisable(true);
                addChashu.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (!ExtraChashu.getText().equals("100")) {
                            ExtraChashu.setText(String.valueOf(Integer.parseInt(ExtraChashu.getText())+2));
                            tempRamen.get(tempRamen.size()-1).setExtra_chashu(Integer.parseInt(ExtraNori.getText())+2);
                            Amount.setText("£" + tempRamen.get(tempRamen.size()-1).calcRamenAmount());
                        }
                    }
                });
                Button subChashu = (Button) pnlRamen.lookup("#subChashu");
                subChashu.setDisable(true);
                subChashu.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (!ExtraChashu.getText().equals("0")) {
                            ExtraChashu.setText(String.valueOf(Integer.parseInt(ExtraChashu.getText())-1));
                            tempRamen.get(tempRamen.size()-1).setExtra_chashu(Integer.parseInt(ExtraNori.getText())-1);
                            Amount.setText("£" + tempRamen.get(tempRamen.size()-1).calcRamenAmount());
                        }
                    }
                });

                //额外的BoiledEgg 增减
                Label ExtraBoiledEgg = (Label) pnlRamen.lookup("#ExtraBoiledEgg");
                Button addBoiledEgg = (Button) pnlRamen.lookup("#addBoiledEgg");
                addBoiledEgg.setDisable(true);
                addBoiledEgg.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (!ExtraBoiledEgg.getText().equals("100")) {
                            ExtraBoiledEgg.setText(String.valueOf(Integer.parseInt(ExtraBoiledEgg.getText())+1));
                            tempRamen.get(tempRamen.size()-1).setExtra_boiled_egg(Integer.parseInt(ExtraNori.getText())+1);
                            Amount.setText("£" + tempRamen.get(tempRamen.size()-1).calcRamenAmount());
                        }
                    }
                });
                Button subBoiledEgg = (Button) pnlRamen.lookup("#subBoiledEgg");
                subBoiledEgg.setDisable(true);
                subBoiledEgg.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (!ExtraBoiledEgg.getText().equals("0")) {
                            ExtraBoiledEgg.setText(String.valueOf(Integer.parseInt(ExtraBoiledEgg.getText())-1));
                            tempRamen.get(tempRamen.size()-1).setExtra_boiled_egg(Integer.parseInt(ExtraNori.getText())-1);
                            Amount.setText("£" + tempRamen.get(tempRamen.size()-1).calcRamenAmount());
                        }
                    }
                });

                //额外 Bamboo shoot 的增减
                Label BambooShoots = (Label) pnlRamen.lookup("#BambooShoots");
                Button addBambooShoot = (Button) pnlRamen.lookup("#addBambooShoot");
                addBambooShoot.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (!BambooShoots.getText().equals("100")) {
                            BambooShoots.setText(String.valueOf(Integer.parseInt(BambooShoots.getText())+1));
                            tempRamen.get(tempRamen.size()-1).setBamboo_shoots(Integer.parseInt(ExtraNori.getText())+1);
                            Amount.setText("£" + tempRamen.get(tempRamen.size()-1).calcRamenAmount());
                        }
                    }
                });
                Button subBambooShoot = (Button) pnlRamen.lookup("#subBambooShoot");
                subBambooShoot.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (!BambooShoots.getText().equals("0")) {
                            BambooShoots.setText(String.valueOf(Integer.parseInt(BambooShoots.getText())-1));
                            tempRamen.get(tempRamen.size()-1).setBamboo_shoots(Integer.parseInt(ExtraNori.getText())-1);
                            Amount.setText("£" + tempRamen.get(tempRamen.size()-1).calcRamenAmount());
                        }
                    }
                });

                //面汤group
                ToggleGroup groupSoup = new ToggleGroup();
                RadioButton Tonkotsu = (RadioButton) pnlRamen.lookup("#Tonkotsu");
                Tonkotsu.setToggleGroup(groupSoup);
                Tonkotsu.setUserData("Tonkotsu");
                RadioButton Shoyu = (RadioButton) pnlRamen.lookup("#Shoyu");
                Shoyu.setToggleGroup(groupSoup);
                Shoyu.setUserData("Shoyu");
                RadioButton Shio = (RadioButton) pnlRamen.lookup("#Shio");
                Shio.setToggleGroup(groupSoup);
                Shio.setUserData("Shio");
                groupSoup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                    public void changed(ObservableValue<? extends Toggle> changed,
                                        Toggle oldVal, Toggle newVal) {
                        if (groupSoup.getSelectedToggle() != null) {
                            tempRamen.get(tempRamen.size()-1).setSoup(groupSoup.getSelectedToggle().getUserData().toString());
                        }
                    }
                });

                //面的group
                ToggleGroup groupNoddles = new ToggleGroup();
                RadioButton NoodleSoft = (RadioButton) pnlRamen.lookup("#NoodleSoft");
                NoodleSoft.setToggleGroup(groupNoddles);
                NoodleSoft.setUserData("Soft");
                RadioButton NoodleMedium = (RadioButton) pnlRamen.lookup("#NoodleMedium");
                NoodleMedium.setToggleGroup(groupNoddles);
                NoodleMedium.setUserData("Medium");
                RadioButton NoodleFirm = (RadioButton) pnlRamen.lookup("#NoodleFirm");
                NoodleFirm.setToggleGroup(groupNoddles);
                NoodleFirm.setUserData("Firm");

                groupNoddles.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                    public void changed(ObservableValue<? extends Toggle> changed,
                                        Toggle oldVal, Toggle newVal) {
                        if (groupNoddles.getSelectedToggle() != null) {
                            tempRamen.get(tempRamen.size()-1).setNoodles(groupNoddles.getSelectedToggle().getUserData().toString());
                        }
                    }
                });

                //洋葱 group
                ToggleGroup groupOnion = new ToggleGroup();
                RadioButton OnionNo = (RadioButton) pnlRamen.lookup("#OnionNo");
                OnionNo.setToggleGroup(groupOnion);
                OnionNo.setUserData("No");
                RadioButton OnionLittle = (RadioButton) pnlRamen.lookup("#OnionLittle");
                OnionLittle.setToggleGroup(groupOnion);
                OnionLittle.setUserData("Little");
                RadioButton OnionLot = (RadioButton) pnlRamen.lookup("#OnionLot");
                OnionLot.setToggleGroup(groupOnion);
                OnionLot.setUserData("Lot");
                groupOnion.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                    public void changed(ObservableValue<? extends Toggle> changed,
                                        Toggle oldVal, Toggle newVal) {
                        if (groupOnion.getSelectedToggle() != null) {
                            if (groupOnion.getSelectedToggle().getUserData().equals("NO"))
                                tempRamen.get(tempRamen.size()-1).setOnion_level(0);
                            else if (groupOnion.getSelectedToggle().getUserData().equals("Little"))
                                tempRamen.get(tempRamen.size()-1).setOnion_level(1);
                            else
                                tempRamen.get(tempRamen.size()-1).setOnion_level(2);
                        }
                    }
                });

                //Nori 的group
                ToggleGroup groupNori = new ToggleGroup();
                RadioButton NoriYes = (RadioButton) pnlRamen.lookup("#NoriYes");
                NoriYes.setToggleGroup(groupNori);
                NoriYes.setUserData("Yes");
                RadioButton NoriNo = (RadioButton) pnlRamen.lookup("#NoriNo");
                NoriNo.setToggleGroup(groupNori);
                NoriNo.setUserData("No");
                groupNori.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                    public void changed(ObservableValue<? extends Toggle> changed,
                                        Toggle oldVal, Toggle newVal) {
                        if (groupNori.getSelectedToggle() != null) {
                            if (groupNori.getSelectedToggle().getUserData().equals("Yes")) {
                                addNori.setDisable(false);      //根据选择来判断是否需要禁用相关button
                                subNori.setDisable(false);
                                tempRamen.get(tempRamen.size()-1).setNori(true);
                            }
                            else {
                                addNori.setDisable(true);
                                subNori.setDisable(true);
                                tempRamen.get(tempRamen.size()-1).setNori(false);
                                tempRamen.get(tempRamen.size()-1).setExtra_nori(0);         //如果选no将数量清零
                                ExtraNori.setText("0");
                            }
                        }
                    }
                });

                //chashu 的group
                ToggleGroup groupchashu = new ToggleGroup();
                RadioButton chashuYes = (RadioButton) pnlRamen.lookup("#chashuYes");
                chashuYes.setToggleGroup(groupchashu);
                chashuYes.setUserData("Yes");
                RadioButton chashuNo = (RadioButton) pnlRamen.lookup("#chashuNo");
                chashuNo.setToggleGroup(groupchashu);
                chashuNo.setUserData("No");
                groupchashu.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                    public void changed(ObservableValue<? extends Toggle> changed,
                                        Toggle oldVal, Toggle newVal) {
                        if (groupchashu.getSelectedToggle() != null) {
                            if (groupchashu.getSelectedToggle().getUserData().equals("Yes")) {
                                addChashu.setDisable(false);      //根据选择来判断是否需要禁用相关button
                                subChashu.setDisable(false);
                                tempRamen.get(tempRamen.size()-1).setChashu(true);
                            }
                            else {
                                addChashu.setDisable(true);
                                subChashu.setDisable(true);
                                tempRamen.get(tempRamen.size()-1).setChashu(false);
                                tempRamen.get(tempRamen.size()-1).setExtra_chashu(0);
                                ExtraChashu.setText("0");
                            }
                        }
                    }
                });

                //煮鸡蛋的group
                ToggleGroup groupBoiledEgg = new ToggleGroup();
                RadioButton BoiledEggYes = (RadioButton) pnlRamen.lookup("#BoiledEggYes");
                BoiledEggYes.setToggleGroup(groupBoiledEgg);
                BoiledEggYes.setUserData("Yes");
                RadioButton BoiledEggNo = (RadioButton) pnlRamen.lookup("#BoiledEggNo");
                BoiledEggNo.setToggleGroup(groupBoiledEgg);
                BoiledEggNo.setUserData("No");
                groupBoiledEgg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                    public void changed(ObservableValue<? extends Toggle> changed,
                                        Toggle oldVal, Toggle newVal) {
                        if (groupBoiledEgg.getSelectedToggle() != null) {
                            if (groupBoiledEgg.getSelectedToggle().getUserData().equals("Yes")) {
                                addBoiledEgg.setDisable(false);      //根据选择来判断是否需要禁用相关button
                                subBoiledEgg.setDisable(false);
                                tempRamen.get(tempRamen.size()-1).setBoiled_egg(true);
                            }
                            else {
                                addBoiledEgg.setDisable(true);
                                subBoiledEgg.setDisable(true);
                                tempRamen.get(tempRamen.size()-1).setBoiled_egg(false);
                                tempRamen.get(tempRamen.size()-1).setExtra_boiled_egg(0);
                                ExtraBoiledEgg.setText("0");
                            }
                        }
                    }
                });

                //辣度的group
                ToggleGroup groupSpiciness = new ToggleGroup();
                RadioButton[] rSpiciness = new RadioButton[6];
                for (int i=0;i<6;i++) {
                    rSpiciness[i] = (RadioButton) pnlRamen.lookup("#Spic"+i);       //Radiobutton的id需为Spic加后缀0～5
                    rSpiciness[i].setToggleGroup(groupSpiciness);
                    rSpiciness[i].setUserData(""+i);
                }
                groupSpiciness.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                    public void changed(ObservableValue<? extends Toggle> changed,
                                        Toggle oldVal, Toggle newVal) {
                        if (groupSpiciness.getSelectedToggle() != null) {
                            tempRamen.get(tempRamen.size()-1).setSpiciness(Integer.parseInt(
                                    groupSpiciness.getSelectedToggle().getUserData().toString()));
                        }
                    }
                });

                //添加购物车
                Button addCart = (Button) pnlRamen.lookup("#addcart");
                addCart.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        customer.getDraft().getRamenList().add(tempRamen.get(tempRamen.size()-1));
                        //System.out.println(tempRamen.get(tempRamen.size()-1));
                        customer.getDraft().setOrderAmount(customer.getDraft().getOrderAmount()
                                + tempRamen.get(tempRamen.size()-1).calcRamenAmount());
                        tempRamen.add(new Ramen());
                        Ticket ticket = new Ticket(customer.getDraft());
                        ticket.printTicket();
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }

        
        }
        if (actionEvent.getSource() == btnCart) {
            pnlCart.toFront();
            Node[] nodes = new Node[1];

            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("Cart.fxml"));
                pnlCart.getChildren().add(nodes[0]);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (actionEvent.getSource() == btnStamp) {
            pnlStamp.toFront();

            Node[] nodes = new Node[1];

            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("Stamp.fxml"));
                pnlStamp.getChildren().add(nodes[0]);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(actionEvent.getSource()==btnPersonalInfo)
        {
            pnlPersonalInfo.toFront();
            Node[] nodes = new Node[1];

            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("PersonalInfo.fxml"));
                pnlPersonalInfo.getChildren().add(nodes[0]);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}


