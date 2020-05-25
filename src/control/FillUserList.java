/*
 * @ Name: FillUserList.java
 * @ author: He Xuan
 * @ description: this is for operations on only reading file 'Users.csv'
 */
package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import entities.User;

public class FillUserList {	
	
	//获取单个用户
	public User getUserByID(String id) {
		User usr = new User();
		try {
			File f = new File("src/data/Users.csv");
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
					usr.setStamps(Integer.parseInt(str[6]));
					usr.setUsedStamps(Integer.parseInt(str[7]));
					usr.setTotalOrders(Integer.parseInt(str[8]));
					usr.setFirstName(str[1]);
					usr.setSurname(str[2]);
					usr.setPasscode(str[3]);
					usr.setEmail(str[5]);
					usr.setPhoneNum(str[4]);
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
	
	//获取所有用户信息,用户列表返回
	public ArrayList<User> getUserList(){
		ArrayList<User> usrlist = new ArrayList<User>();
		try {
			File f = new File("src/data/Users.csv");
			if(!f.exists())
			{
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				String titleline = "UserID,firstname,surname,Passcode,Phone,Email,Stamps,UsedStamps,TotalOrders,Online";
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
				usr.setFirstName(splitstr[1]);
				usr.setSurname(splitstr[2]);
				usr.setPasscode(splitstr[3]);
				usr.setPhoneNum(splitstr[4]);
				usr.setEmail(splitstr[5]);
				usr.setStamps(Integer.parseInt(splitstr[6]));
				usr.setUsedStamps(Integer.parseInt(splitstr[7]));
				usr.setTotalOrders(Integer.parseInt(splitstr[8]));

				usrlist.add(usr);
			}
			fr.close();
			br.close();
		}
		catch(Exception e) {
			throw new RuntimeException("Error in getUserList() in FillUserList.java");
		}
		return usrlist;
	}
}
