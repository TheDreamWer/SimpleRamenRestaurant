/*
 * @ Name: UserList.java
 * @ author: He Xuan
 * @ description: this is for getting arraylist of users from the file 'Users.csv'
 */


package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import entities.User;

public class UserList {
	
	ArrayList<User> usrlist = new ArrayList<User>();
	
	
	/*This Constructor will read the users in Users.csv and load them into the local 'usrlist' 
	 * */
	public UserList() {
		try {
			File f = new File("data/Users.csv");
			if(!f.exists())
			{
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				String titleline = "UserID,UserName,Passcode,Phone,Email,Stamps,UsedStamps,TotalOrders,Online";
				bw.write(titleline);
				bw.flush();
				bw.close();
				fw.close();
			}
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String content = "";
			User usr = new User();
			content=br.readLine(); //跳过第一标题栏
			while((content=br.readLine())!=null) {
				String[] splitstr = content.split(",");
				usr.setUserID(splitstr[0]);
				usr.setUserName(splitstr[1]);
				usr.setPasscode(splitstr[2]);
				usr.setPhoneNum(splitstr[3]);
				usr.setEmail(splitstr[4]);
				usr.setStamps(Integer.parseInt(splitstr[5]));
				usr.setUsedStamps(Integer.parseInt(splitstr[6]));
				usr.setTotalOrders(Integer.parseInt(splitstr[7]));

				usrlist.add(usr);
			}
			fr.close();
			br.close();
		}
		catch(Exception e) {
			throw new RuntimeException("Error in UserList.java");
		}
	}
	
	//This method return the 'usrlist'
	public ArrayList<User> getUserList(){
		return usrlist;
	}
}
