/*
 * @ Name: FillRestInfo.java
 * @ version: 1.0-new test
 * @ author: He Xuan
 * @ description: this is for getting info of a restaurant from csv file
 */
package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


import entities.Restaurant;
import org.junit.Test;
public class FillRestInfo {
	private Restaurant r = new Restaurant();// a local restaurant instance ready to be filled by constructor
	
	/* When u create a FillRestInfo
	 * u need to transmit the Restaurant ID into this constructor
	 * only then the Restaurant info u want will be loaded into the local restaurant instance r
	 */
	
	public FillRestInfo(int restid) {
		try {
			File f = new File("src/data/RestInfo.csv");
			if(!f.exists())
			{
				throw new RuntimeException("ERROR: Lack Of RestInfo.csv");
			}
			else {
				Boolean cunzai = false;
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String content = "";
				while((content=br.readLine())!=null) {
					String[] splitstr = content.split(",");
					if(splitstr[0].equals(Integer.toString(restid)))
					{
						cunzai = true;
						r.setRestID(restid);
						r.setRestName(splitstr[1]);
						r.setRestIntro(splitstr[2].replace("`+`", "\n"));
						r.setRestPostalcode(splitstr[3]);
						r.setRestAddress(splitstr[4]);
						r.setRestRegistrationDate(splitstr[5]);
					}
				}
				br.close();
				fr.close();
				if(!cunzai) {
					throw new RuntimeException("ERROR: No Such Restaurant ID");
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/*return the local restaurant r */
	@Test
	public Restaurant getRestaurant() {
		return this.r;
	}
}

/****************All copy right reserved by group 105*********************/