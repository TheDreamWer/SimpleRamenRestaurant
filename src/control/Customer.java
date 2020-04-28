package control;

import java.io.IOException;

import entities.*;

/**
 * Entity of Customer
 */


// public class Customer extends Application{
public class Customer {
    private Restaurant rest; // finish
    private Order draft = new Order();
    private Ramen ramen;
    private Ticket ticket;
    private FillRestInfo fillRestInfo;
    private FillOrderList fillOrderList;
    private OrderList orderList;

    public Customer(int restID) {
        this.fillOrderList = new FillOrderList();
        this.fillRestInfo = new FillRestInfo(restID);
        this.fillInRest(); // Load the restaurant info
        this.fillInOrderList();
        int code = this.orderList.getArraylist().size();
        this.setDraft(new Order());
        this.ramen = new Ramen();    
    }
    /**Getter/Setter sart */
    public Ramen getRamen() {
        return ramen;
    }
    public void setRamen(Ramen ramen) {
        this.ramen = ramen;
    }

    public Order getDraft() {
		return draft;
	}
	public void setDraft(Order draft) {
		this.draft = draft;
    }
    
    public Restaurant getRest(){
        return this.rest;
    }
    public void setRest(Restaurant rest){
        this.rest = rest;
    }

    public FillRestInfo setFillRestInfo(){
        return this.fillRestInfo;
    }
    public void setFillRestInfo(FillRestInfo fillRestInfo){
        this.fillRestInfo = fillRestInfo;
    }

    public OrderList getOrderList(){
        return this.orderList;
    }
    public void setOrderList(OrderList orderList){
        this.orderList = orderList;
    }
    
    public Ticket getTicket(){
        return this.ticket;
    }
    public void setTicket(Ticket ticket){
        this.ticket = ticket;
    }

    /**Getter/Setter end */
    
    public void fillInRest(){
        this.rest = this.fillRestInfo.getRestaurant();
    }

    public void fillInOrderList(){
        this.orderList = this.fillOrderList.getOrderlist();
    }
    
    public String showRestInfo(){
        return this.rest.getRestIntro();
    }
    
    public void formOrder()throws IOException{

        this.orderList.getArraylist().add(this.draft);
        this.ticket = new Ticket(this.draft);
        this.ticket.printTicket();
        this.saveOrderList();
        // this.draft = new Order();
    }

//    public void addRamen(Ramen ramen){
//        this.draft.addRamen(ramen);
//    }
//    public void addRamen(){
//        this.draft.addRamen(this.ramen);
//    }
//    public void deleteRamen(int key){
//        this.draft.deleteRamen(key);
//    }

    public void saveOrderList() throws IOException{
//        this.draft.saveOrder();
        SaveOrderList save = new SaveOrderList(this.orderList);
        save.Save();
    }

    public void saveOrderToDraft(Order order){
        this.draft = order;
    }
}