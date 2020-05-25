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
    private FillUserList ful = new FillUserList();
    private SaveUserList sul = new SaveUserList();
    private User user;
    private int toPersonInfo = 0;
    private int nextCode = 0;

    public Customer(int restID) {
        this.fillOrderList = new FillOrderList();
        this.fillRestInfo = new FillRestInfo(restID);
        this.fillInRest(); // Load the restaurant info
        this.fillInOrderList();
        this.setDraft(new Order());
        this.ramen = new Ramen();
        FillMenu.fillMenu();
    }
    /**Getter/Setter sart */
    public Ramen getRamen() {
        return ramen;
    }
    public void setRamen(Ramen ramen) {
        this.ramen = ramen;
    }
    public void setToPersonInfo(int to){this.toPersonInfo = to;}
    public int getToPersonInfo(){return this.toPersonInfo;}
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

    public void setNextCode(int code){ this.nextCode = code; }
    public int getNextCode(){ return this.nextCode; }

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
    
    public void formOrder(String payment_method){
        this.draft.setPaymentMethod(payment_method);
        this.draft.setCode(this.nextCode);
        this.draft.setOrderAmount(this.calcOrderAmount());
        this.setNextCode(this.getNextCode() + 1);
        this.draft.setUser(this.user);
        if(this.draft.getTakeAway()){
            this.draft.setOrderID(Long.parseLong(this.draft.getOrderID() + this.draft.getCode() + "1"));
        }
        else{
            this.draft.setOrderID(Long.parseLong(this.draft.getOrderID() + this.draft.getCode() + "0"));
        }
        this.orderList.getArraylist().add(this.draft);
        this.ticket = new Ticket(this.draft);
        this.ticket.printTicket();
        this.draft = new Order();
    }

    public float calcOrderAmount(){
        float amount = 0.0f;
        for(int i = 0; i < this.getDraft().getRamenList().size(); i++){
            amount += this.getDraft().getRamenList().get(i).calcRamenAmount();
        }
        return amount;
    }

    public void saveOrderList() throws IOException{
//        this.draft.saveOrder();
        SaveOrderList save = new SaveOrderList(this.orderList);
        save.Save();
    }

    public void saveOrderToDraft(Order order){
        this.draft = order;
    }

    public boolean loginUser(String id,String pw) {
        boolean success = sul.Login(id, pw);
        if(success) {
            this.user = ful.getUserByID(id);
        }
        return success;
    }

    public void logoutUser() {
        sul.Logout(this.user.getUserID());
    }

    public String registUser(String firstName, String surname, String pw, String phone, String mail) {
        String id = sul.GenUser(firstName, surname, pw, phone, mail);
        return id;
    }

    public String viewFirstName() {
        return this.user.getFirstName();
    }

    public String viewSurname(){
        return this.user.getSurname();
    }

    public String viewUserPhoneNum() {
        return this.user.getPhoneNum();
    }

    public String viewUserMail() {
        return this.user.getEmail();
    }

    public int viewUserTotalOrders() {
        return this.user.getTotalOrders();
    }

    public int viewUserStamps() {
        return this.user.getStamps();
    }

    public int viewUserUsedStamps() {
        return this.user.getUsedStamps();
    }

    public void modifyUserName(String firstName, String surname) {
        this.user.setFirstName(firstName);
        this.user.setSurname(surname);
    }

    public void modifyUserPassword(String new_pw) {
        this.user.setPasscode(new_pw);
    }

    public void modifyUserPhoneNum(String phone) {
        this.user.setPhoneNum(phone);
    }

    public void modifyUserMail(String mail) {
        this.user.setEmail(mail);
    }

    public void refreshUserWithoutStamps() {

        this.user = sul.PlusTotalOrders(this.user);
        this.user = sul.ScanStamps(this.user);
    }

    public void refreshUserWithStamps() {

        this.user = sul.PlusTotalOrders(this.user);
        this.user = sul.UseStamps(this.user);
        this.user = sul.ScanStamps(this.user);
    }

    public void saveUser(){
        sul.SaveUserInfo(this.user);
    }

    public User getUser(){return this.user;}
}