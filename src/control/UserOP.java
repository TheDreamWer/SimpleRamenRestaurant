package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import entities.User;

public class UserOP {
	
	// Attention: A Logout operation is needed after Login operation
	// Or You can NEVER be able to Login this user again 
	public void Login(String id, String pw) {
		try {
			File f = new File("data/Users.csv");
			if(!f.exists())
			{
				throw new RuntimeException("No Users.csv");
			}
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String content = "";
			Boolean cunzai =false;
			Boolean login = false;
			List<String> userlist = new ArrayList<String>();
			while((content=br.readLine())!=null) {
				String[] str = content.split(",");
				if(str[0].equals(id)&&str[2].equals(pw)) {
					if(str[8]=="1")
					{
						login=true;
						fr.close();
						br.close();
						throw new RuntimeException("Warninng: User Already Login");
					}
					else {
						cunzai=true;
						userlist.add(str[0]+","+str[1]+","+str[2]+","+str[3]+","+str[4]+","+str[5]+","+str[6]+","+str[7]+",1");
					}
				}
				else userlist.add(content);
			}
			fr.close();
			br.close();
			
			if(cunzai&&(!login)) {
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("");
				int i = 0;
				while(i<userlist.size()) {
					bw.write(userlist.get(i)+"\r\n");
					i++;
				}
				bw.flush();
				bw.close();
				fw.close();
				System.out.println("Successfully Login User:"+id);
			}
			else {
				throw new RuntimeException("Login Failed!");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Never Forget to Logout After You doing Login Operation, That is important!!!
	public void Logout(String id) {
		try {
			File f = new File("data/Users.csv");
			if(!f.exists())
			{
				throw new RuntimeException("No Users.csv");
			}
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String content = "";
			List<String> userlist = new ArrayList<String>();
			while((content=br.readLine())!=null) {
				String[] str = content.split(",");
				if(str[0].equals(id)) {
					userlist.add(str[0]+","+str[1]+","+str[2]+","+str[3]+","+str[4]+","+str[5]+","+str[6]+","+str[7]+",0");
				}
				else userlist.add(content);
			}
			fr.close();
			br.close();
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("");
			int i = 0;
			while(i<userlist.size()) {
				bw.write(userlist.get(i)+"\r\n");
				i++;
			}
			bw.flush();
			bw.close();
			fw.close();
			System.out.println("Successfully Logout User:"+id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//You can get User Info by User's ID
	public User getUserByID(String id) {
		User usr = new User();
		try {
			File f = new File("data/Users.csv");
			if(!f.exists())
			{
				throw new RuntimeException("No Users.csv");
			}
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String content = "";
			List<String> userlist = new ArrayList<String>();
			while((content=br.readLine())!=null) {
				String[] str = content.split(",");
				if(str[0].equals(id)) {
					usr.setStamps(Integer.parseInt(str[5]));
					usr.setUsedStamps(Integer.parseInt(str[6]));
					usr.setTotalOrders(Integer.parseInt(str[7]));
					usr.setUserName(str[1]);
					usr.setPasscode(str[2]);
					usr.setEmail(str[4]);
					usr.setPhoneNum(str[3]);
					usr.setUserID(id);
				}
				else userlist.add(content);
			}
			fr.close();
			br.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return usr;
	}
	
	//You can save UserInfo into Users.csv file
	public void SaveUserInfo(User usr) {
		try {
			File f = new File("data/Users.csv");
			if(!f.exists())
			{
				throw new RuntimeException("No Users.csv");
			}
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String content = "";
			Boolean cunzai = false;
			List<String> userlist = new ArrayList<String>();
			while((content=br.readLine())!=null) {
				String[] str = content.split(",");
				if(usr.getUserID().equals(str[0])) {
					cunzai=true;
					userlist.add(str[0]+","+usr.getUserName()+","+usr.getPasscode()+","+usr.getPhoneNum()+","
					+usr.getEmail()+","+usr.getStamps()+","+usr.getUsedStamps()+","+usr.getTotalOrders()+","+str[8]);
				}
				else userlist.add(content);
			}
			fr.close();
			br.close();
			if(cunzai) {
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("");
				int i = 0;
				while(i<userlist.size()) {
					bw.write(userlist.get(i)+"\r\n");
					i++;
				}
				bw.flush();
				bw.close();
				fw.close();
				System.out.println("Successfully Save User Info!");
			}
			else throw new RuntimeException("NO User:"+usr.getUserID());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//When Successfully purchase new order, call this method to plus it into this User's TotalOrders
	public void PlusTotalOrders(User usr) {
		int num = usr.getTotalOrders();
		num++;
		usr.setTotalOrders(num);
	}
	
	//Every time You use a stamp, please call this method to fresh this User's Stamps and UsedStamps
	public void UseStamps(User usr) {
		int num1 = usr.getStamps();
		num1--;
		usr.setStamps(num1);
		
		int num2 = usr.getUsedStamps();
		num2++;
		usr.setUsedStamps(num2);
	}
	
	//Every time u operate on User's stamp, UsedStamps, or TotalOrders, please call this method to fresh data
	public void ScanStamps(User usr) {
		int num = usr.getTotalOrders();
		int num2 = usr.getUsedStamps();
		int num1 = num/10 - num2;
		usr.setStamps(num1);
	}
	
}
