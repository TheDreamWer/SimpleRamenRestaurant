/* @Name: GenUser.java
 * @Author:He Xuan
 * @Description:This Class is bound for generating a user and save it into the users.csv and there is 
 * method to return the user instance.
* */
package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.User;

public class GenUser {
	
	User usr = new User();
	
	//Entering information needed into the constructor will generate a new user
	public GenUser(String name, String pw, String phnum, String mail) {
		String id=GenID();
		usr.setTotalOrders(0); 
		usr.setStamps(0);
		usr.setUsedStamps(0);
		usr.setUserName(name);
		usr.setPasscode(pw);
		usr.setEmail(mail);
		usr.setPhoneNum(phnum);
		usr.setUserID(id);
		
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
			List<String> userlist = new ArrayList<String>();
			while((content=br.readLine())!=null) {
				userlist.add(content);
			}
			fr.close();
			br.close();
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("");
			int i = 0;
			userlist.add(id+","+name+","+pw+","+phnum+","+mail+",0,0,0,0");
			while(i<userlist.size()) {
				bw.write(userlist.get(i)+"\r\n");
				i++;
			}
			bw.flush();
			bw.close();
			fw.close();
			System.out.println("Successfully Generate New User!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public String GenID() {
		Calendar cld = Calendar.getInstance();
		int year = cld.get(Calendar.YEAR) ;
		int month = cld.get(Calendar.MONTH)+1;
		int day = cld.get(Calendar.DATE);
		int hour = cld.get(Calendar.HOUR_OF_DAY);
		int minute = cld.get(Calendar.MINUTE);
		int second = cld.get(Calendar.SECOND);
		int milisec = cld.get(Calendar.MILLISECOND);
		
		return year+month+day+hour+minute+second+milisec+"";
	}
	
	public User getUser() {
		return usr;
	}
}
