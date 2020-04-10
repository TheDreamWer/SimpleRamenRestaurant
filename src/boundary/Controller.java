package boundary;

import control.Customer;
import control.SaveRestInfo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Customer customer = new Customer(1);

    @FXML
    private Pane pnlOrders;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private Button btnCustomers;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Button btnOverview;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private VBox pnItems;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnRestaurant;

    @FXML
    private Pane pnlRestaurant;

    @FXML
    private VBox rest;

    @FXML
    private Button btnMenus;

    @FXML
    private Pane pnlMenus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Node[] nodes = new Node[customer.getOrderList().getArraylist().size()];
        int i = 0;
        for (i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));

                Parent p = (Parent)nodes[i];
                Label id = (Label) p.lookup("#ID");
                Label name = (Label) p.lookup("#UserName");
                Label time = (Label) p.lookup("#Time");
                Button active = (Button) p.lookup("#Active");
                id.setText("" + customer.getOrderList().getArraylist().get(i).getOrderID());
                name.setText("" + customer.getOrderList().getArraylist().get(i).getCode());
                time.setText("" + customer.getOrderList().getArraylist().get(i).getGenerateTime());

                //give the items some effect
                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });
                pnItems.getChildren().add(nodes[i]);

                //System.out.println(customer.getOrderList().getArraylist().get(i).getOrderID());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #1620A1");
            pnlCustomer.toFront();
        }
        if (actionEvent.getSource() == btnMenus) {
            pnlMenus.setStyle("-fx-background-color : #53639F");
            pnlMenus.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
            //setOnAction
            Label totalOrders = (Label)pnlOverview.lookup("#TotalOrders");
            totalOrders.setText("" + customer.getOrderList().getArraylist().size());

            Label totalAmount = (Label)pnlOverview.lookup("#TotalAmount");
            totalAmount.setText("" + customer.getOrderList().getArraylist().size());

            Label todayOrders = (Label)pnlOverview.lookup("#TodayOrders");
            todayOrders.setText("" + customer.getOrderList().getArraylist().size());
        }
        if(actionEvent.getSource()==btnOrders)
        {
            pnlOrders.setStyle("-fx-background-color : #464F67");
            pnlOrders.toFront();

        }
        if(actionEvent.getSource()==btnRestaurant)
        {
            pnlRestaurant.setStyle("-fx-background-color : #464F67");
            pnlRestaurant.toFront();
            Node[] nodes = new Node[1];

            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("Restaurant.fxml"));

                //nodes[0].setStyle("-fx-background-color : #3f5967");
                pnlRestaurant.getChildren().add(nodes[0]);

                TextField tf = (TextField) pnlRestaurant.lookup("#RestName");
                tf.setText(customer.getRest().getRestName());
                tf.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        customer.getRest().setRestName(tf.getText().trim());
                    }
                });

                ScrollPane sp = (ScrollPane) pnlRestaurant.lookup("#RestIntro");
                TextArea ta = (TextArea) sp.contentProperty().getValue();
                ta.setText(customer.getRest().getRestIntro());

                Button ok = (Button) pnlRestaurant.lookup("#OK");
                ok.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        //System.out.println(ta.getText());
                        customer.getRest().setRestIntro(ta.getText());
                        new SaveRestInfo(customer.getRest());
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(actionEvent.getSource()==btnMenus)
        {
            Label Amount = (Label) pnlMenus.lookup("#Amount");
            //初始化Ramen
            ArrayList<Ramen> tempRamen = new ArrayList<Ramen>();
            tempRamen.add(new Ramen());
            tempRamen.get(tempRamen.size()-1).setOnion_level(-1);

             //额外的Nori 增减部分
            Label ExtraNori = (Label) pnlMenus.lookup("ExtraNori");
            Button addNori = (Button) pnlMenus.lookup("#addNori");
            addNori.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (!ExtraNori.getText().equals("100")) {
                        ExtraNori.setText(String.valueOf(Integer.parseInt(ExtraNori.getText())+1));
                        Amount.setText(String.valueOf(Integer.parseInt(Amount.getText())+1));
                        tempRamen.get(tempRamen.size()-1).setExtra_nori(Integer.parseInt(ExtraNori.getText())+1);
                    }
                }
            });
            Button subNori = (Button) pnlMenus.lookup("#subNori");
            subNori.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (!ExtraNori.getText().equals("0"))
                        ExtraNori.setText(String.valueOf(Integer.parseInt(ExtraNori.getText())-1));
                        Amount.setText(String.valueOf(Integer.parseInt(Amount.getText())-1));
                        tempRamen.get(tempRamen.size()-1).setExtra_nori(Integer.parseInt(ExtraNori.getText())-1);
                }
            });

            //额外的Chashu 增减
            Label ExtraChashu = (Label) pnlMenus.lookup("ExtraChashu");
            Button addChashu = (Button) pnlMenus.lookup("#addChashu");
            addChashu.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (!ExtraChashu.getText().equals("100")) {
                        ExtraChashu.setText(String.valueOf(Integer.parseInt(ExtraChashu.getText())+2));
                        Amount.setText(String.valueOf(Integer.parseInt(Amount.getText())+2));
                        tempRamen.get(tempRamen.size()-1).setExtra_chashu(Integer.parseInt(ExtraNori.getText())+2);
                    }
                }
            });
            Button subChashu = (Button) pnlMenus.lookup("#subChashu");
            subChashu.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (!ExtraChashu.getText().equals("0"))
                        ExtraChashu.setText(String.valueOf(Integer.parseInt(ExtraChashu.getText())-2));
                        Amount.setText(String.valueOf(Integer.parseInt(Amount.getText())-2));
                }
            });

            //额外的BoiledEgg 增减
            Label ExtraBoiledEgg = (Label) pnlMenus.lookup("ExtraBoiledEgg");
            Button addBoiledEgg = (Button) pnlMenus.lookup("#addBoiledEgg");
            addBoiledEgg.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (!ExtraBoiledEgg.getText().equals("100")) {
                        ExtraBoiledEgg.setText(String.valueOf(Integer.parseInt(ExtraBoiledEgg.getText())+1));
                        Amount.setText(String.valueOf(Integer.parseInt(Amount.getText())+1));
                        tempRamen.get(tempRamen.size()-1).setExtra_boiled_egg(Integer.parseInt(ExtraNori.getText())+1);
                    }
                }
            });
            Button subBoiledEgg = (Button) pnlMenus.lookup("#subBoiledEgg");
            subBoiledEgg.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (!ExtraBoiledEgg.getText().equals("0"))
                        ExtraBoiledEgg.setText(String.valueOf(Integer.parseInt(ExtraBoiledEgg.getText())-1));
                        Amount.setText(String.valueOf(Integer.parseInt(Amount.getText())-1));
                        tempRamen.get(tempRamen.size()-1).setExtra_boiled_egg(Integer.parseInt(ExtraNori.getText())-1);
                }
            });

            //额外 Bamboo shoot 的增减
            Label BambooShoots = (Label) pnlMenus.lookup("BambooShoots");
            Button addBambooShoot = (Button) pnlMenus.lookup("#addBambooShoot");
            addBambooShoot.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (!BambooShoots.getText().equals("100")) {
                        BambooShoots.setText(String.valueOf(Integer.parseInt(BambooShoots.getText())+1));
                        Amount.setText(String.valueOf(Integer.parseInt(Amount.getText())+1));
                        tempRamen.get(tempRamen.size()-1).setBamboo_shoots(Integer.parseInt(ExtraNori.getText())+1);
                    }
                }
            });
            Button subBambooShoot = (Button) pnlMenus.lookup("#subBambooShoot");
            subBambooShoot.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (!BambooShoots.getText().equals("0"))
                        BambooShoots.setText(String.valueOf(Integer.parseInt(BambooShoots.getText())-1));
                    Amount.setText(String.valueOf(Integer.parseInt(Amount.getText())-1));
                    tempRamen.get(tempRamen.size()-1).setBamboo_shoots(Integer.parseInt(ExtraNori.getText())-1);
                }
            });

            //面汤group
            ToggleGroup groupSoup = new ToggleGroup();
            RadioButton Tonkotsu = (RadioButton) pnlMenus.lookup("#Tonkotsu");
            Tonkotsu.setToggleGroup(groupSoup);
            RadioButton Shoyu = (RadioButton) pnlMenus.lookup("#Shoyu");
            Shoyu.setToggleGroup(groupSoup);
            RadioButton Shio = (RadioButton) pnlMenus.lookup("#Shio");
            Shio.setToggleGroup(groupSoup);
            groupSoup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                        public void changed(ObservableValue<? extends Toggle> changed,
                                            Toggle oldVal, Toggle newVal) {
                            if (groupSoup.getSelectedToggle() != null) {
                                tempRamen.get(tempRamen.size()-1).setSoup(groupSoup.getSelectedToggle().toString());
                            }
                        }
                    });

            //面的group
            ToggleGroup groupNoddles = new ToggleGroup();
            RadioButton NoodleSoft = (RadioButton) pnlMenus.lookup("#NoodleSoft");
            NoodleSoft.setToggleGroup(groupNoddles);
            RadioButton NoodleMedium = (RadioButton) pnlMenus.lookup("#NoodleMedium");
            NoodleMedium.setToggleGroup(groupNoddles);
            RadioButton NoodleFirm = (RadioButton) pnlMenus.lookup("#NoodleFirm");
            NoodleFirm.setToggleGroup(groupNoddles);
            groupNoddles.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                public void changed(ObservableValue<? extends Toggle> changed,
                                    Toggle oldVal, Toggle newVal) {
                    if (groupNoddles.getSelectedToggle() != null) {
                        tempRamen.get(tempRamen.size()-1).setNoodles(groupNoddles.getSelectedToggle().toString());
                    }
                }
            });

            //洋葱 group
            ToggleGroup groupOnion = new ToggleGroup();
            RadioButton OnionNo = (RadioButton) pnlMenus.lookup("#OnionNo");
            OnionNo.setToggleGroup(groupOnion);
            RadioButton OnionLittle = (RadioButton) pnlMenus.lookup("#OnionLittle");
            OnionLittle.setToggleGroup(groupOnion);
            RadioButton OnionLot = (RadioButton) pnlMenus.lookup("#OnionLot");
            OnionLot.setToggleGroup(groupOnion);
            groupOnion.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                public void changed(ObservableValue<? extends Toggle> changed,
                                    Toggle oldVal, Toggle newVal) {
                    if (groupOnion.getSelectedToggle() != null) {
                        if (groupOnion.getSelectedToggle().getUserData().equals("NO"))
                            tempRamen.get(tempRamen.size()-1).setOnion_level(0);
                        else if (groupOnion.getSelectedToggle().getUserData().equals("NO"))
                            tempRamen.get(tempRamen.size()-1).setOnion_level(1);
                        else
                            tempRamen.get(tempRamen.size()-1).setOnion_level(2);
                    }
                }
            });

            //Nori 的group
            ToggleGroup groupNori = new ToggleGroup();
            RadioButton NoriYes = (RadioButton) pnlMenus.lookup("#NoriYes");
            NoriYes.setToggleGroup(groupNori);
            RadioButton NoriNo = (RadioButton) pnlMenus.lookup("#NoriNo");
            NoriNo.setToggleGroup(groupNori);
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
                        }
                    }
                }
            });

            //chashu 的group
            ToggleGroup groupchashu = new ToggleGroup();
            RadioButton chashuYes = (RadioButton) pnlMenus.lookup("#chashuYes");
            chashuYes.setToggleGroup(groupchashu);
            RadioButton chashuNo = (RadioButton) pnlMenus.lookup("#chashuNo");
            NoriNo.setToggleGroup(groupchashu);
            groupNori.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
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
                        }
                    }
                }
            });

            //煮鸡蛋的group
            ToggleGroup groupBoiledEgg = new ToggleGroup();
            RadioButton BoiledEggYes = (RadioButton) pnlMenus.lookup("#BoiledEggYes");
            chashuYes.setToggleGroup(groupBoiledEgg);
            RadioButton BoiledEggNo = (RadioButton) pnlMenus.lookup("#BoiledEggNo");
            NoriNo.setToggleGroup(groupBoiledEgg);
            groupNori.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
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
                        }
                    }
                }
            });

            //辣度的group
            ToggleGroup groupSpiciness = new ToggleGroup();
            RadioButton[] rSpiciness = new RadioButton[6];
            for (int i=0;i<6;i++) {
                rSpiciness[i] = (RadioButton) pnlMenus.lookup("Spiciness"+i);       //Radiobutton的id需为Spiciness加后缀1～5
                rSpiciness[i].setToggleGroup(groupSpiciness);
            }
            groupSpiciness.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                public void changed(ObservableValue<? extends Toggle> changed,
                                    Toggle oldVal, Toggle newVal) {
                    if (groupSpiciness.getSelectedToggle() != null) {
                        if (groupBoiledEgg.getSelectedToggle().getUserData().toString().equals("No"))
                            tempRamen.get(tempRamen.size()-1).setSpiciness(0);
                        else
                            tempRamen.get(tempRamen.size()-1).setSpiciness(Integer.parseInt(
                                    groupSpiciness.getSelectedToggle().getUserData().toString()));
                    }
                }
            });
            //添加购物车
            Button addCart = (Button) pnlMenus.lookup("#addcart");
            addCart.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if ((!tempRamen.get(tempRamen.size()-1).getSoup().isEmpty())
                            &&(!tempRamen.get(tempRamen.size()-1).getNoodles().isEmpty())
                            &&tempRamen.get(tempRamen.size()-1).getOnion_level()!=-1) {
                        customer.getDraft().getRamenList().add(tempRamen.get(tempRamen.size()-1));
                        customer.getDraft().setOrderAmount(customer.getDraft().getOrderAmount()
                                + tempRamen.get(tempRamen.size()-1).calcRamenAmount());
                        tempRamen.add(new Ramen());
                    }
                }
            });

        }
    }
}
