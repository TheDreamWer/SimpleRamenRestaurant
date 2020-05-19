package entities;

public class User {
	
	String UserID;
	String FirstName;
	String Surname;
	String Passcode;
	String PhoneNum;
	String Email;
	int totalOrders;
	int stamps;
	int usedStamps;
	
	public void setUserID(String id) {
		this.UserID=id;
	}
	
	public void setFirstName(String newName) {
		this.FirstName=newName;
	}

	public void setSurname(String newName){ this.Surname=newName; }
	
	public void setPasscode(String newPW) {
		this.Passcode=newPW;
	}
	
	public void setPhoneNum(String phnum) {
		this.PhoneNum=phnum;
	}
	
	public void setEmail(String email) {
		this.Email=email;
	}
	
	public void setTotalOrders(int num) {
		this.totalOrders=num;
	}
	
	public void setStamps(int num) {
		this.stamps=num;
	}
	
	public void setUsedStamps(int num) {
		this.usedStamps=num;
	}
	
	public String getFirstName() {
		return this.FirstName;
	}

	public String getSurname(){ return this.Surname; }
	
	public String getUserID() {
		return this.UserID;
	}
	
	public String getPasscode() {
		return this.Passcode;
	}
	
	public String getPhoneNum() {
		return this.PhoneNum;
	}
	
	public String getEmail() {
		return this.Email;
	}
	
	public int getTotalOrders() {
		return this.totalOrders;
	}
	
	public int getStamps() {
		return this.stamps;
	}
	
	public int getUsedStamps() {
		return this.usedStamps;
	}
	
}

