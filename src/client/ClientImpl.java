package client;

import java.io.*;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import broker.Broker;
import constants.Constants;


public class ClientImpl {


	protected BufferedReader console;
	protected Broker broker;
	public static int count=0;
	public static int temp=0;
	Pattern pattern;
	Matcher matcher;
	String regex;
	String inDay = null;
	String outDay = null;
	
	public ClientImpl() {

		console = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			broker = (Broker) Naming.lookup("rmi://localhost:8888/Broker");
			System.out.println("RMI client complete...client to broker.");
		} catch (ConnectException conEx) {
			System.out.println("Unable to connect to broker!");
			System.exit(1);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
		
	}
	
	public void getCity() {
			try {
				String[] city= broker.getCity();
				for (int i = 1; i < city.length; i++) {
					System.out.print(city[i]+"\t");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}
	
	public void setCity(){
		System.out.print(Constants.CR_LF+"Please choose city : ");
		boolean b = true;
		String line = null;
		while(b){
			try {
				line = console.readLine();
				if("beijing".equalsIgnoreCase(line)){
					String[] city= broker.setCity("beijing");
					for (int i = 1; i < city.length; i++) {
						System.out.print(city[i]+"\t");
					}
					count = 1;
					b = false;
				}else if("shanghai".equalsIgnoreCase(line)){
					String[] city= broker.setCity("shanghai");
					for (int i = 1; i < city.length; i++) {
						System.out.print(city[i]+"\t");
					}
					count = 2;
					b = false;
				}else{
					System.out.println(Constants.ERROR);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
			
	public void setHotel() {
		System.out.print(Constants.CR_LF+"Please choose hotel : ");
		boolean b = true;
		String line = null;
		while(b){
			try {
				line = console.readLine();
				if("7days".equalsIgnoreCase(line)){
					temp = 1;
					String[] hotel= broker.setHotel("7days",count);
					for (int i = 0; i < hotel.length; i++) {
						System.out.println(hotel[i]);
					}
					b = false;
				}else if("jjstar".equalsIgnoreCase(line)){
					temp = 2;
					String[] hotel= broker.setHotel("jjstar",count);
					for (int i = 0; i < hotel.length; i++) {
						System.out.println(hotel[i]);
					}
					b = false;
				}else{
					System.out.println(Constants.ERROR);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}		
	}
	
	public void setRoom() {
		boolean a = true;
		boolean b = false;
		boolean c = false;
		while(a){
			try {
				System.out.print(Constants.CR_LF+"please choose the room id: ");
				String id = console.readLine();
				b = broker.judgeRoomID(id,count,temp);
				if(b){
					System.out.println(Constants.ERROR);				
				}else{		
					while(c==false){						
						boolean d = true;
						while(d){
							inDay = getInDay();
							outDay = getOutDay();
							d = judgeDate(inDay, outDay);
						}
						c = broker.judgeVacancy(id,inDay,outDay,count);	
						if(c==false){
							System.out.println("this time periods has been booked."+Constants.CR_LF+Constants.ERROR);
						}
					}
					
					broker.setRoom(id,count,temp);	
					a=false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void setInfo() {
		try {
			String hotelName=null;
			System.out.println("please set you information: ");
			if(count==1&&temp==1){
				hotelName = broker.getHotelName(1);
			}else if(count==1&&temp==2){
				hotelName = broker.getHotelName(2);
			}else if(count==2&&temp==1){
				hotelName = broker.getHotelName(3);
			}else{
				hotelName = broker.getHotelName(4);
			}
			String name = getName();
			String creCard = getCreCard();
			String phone = getPhone();
			String[] total = new String[]{hotelName,name,inDay,outDay,creCard,phone};
			broker.usersInfo(total,count);
			System.out.println("information has been saved.");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void recordInfo() {
		try {
			System.out.println("input your tel number:");
			String tel=console.readLine();
				String[] record= broker.getRecord(tel);
				for (int i = 0; i < record.length; i++) {
					System.out.println(record[i]);
				}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void compareRate(String seq) {
		try {
			String[] rate= broker.getRate(seq,count);
			for (int i = 0; i < rate.length; i++) {
				System.out.println(rate[i]);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	
	public String getName() {
			System.out.print("please input your name: ");
			String name = null;
			try {
				name = console.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return name;
		}

	public String getInDay() {
		boolean a = true;
		boolean b = true;
		String inDay = null;
		while (a) {
			System.out.print("please input your inDay: form yyyy-mm-dd ");
			regex = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
			try {
				inDay = console.readLine();
				pattern = Pattern.compile(regex);
				matcher = pattern.matcher(inDay);
				b = matcher.matches();
				if(b){
					a=false;
				}else{
					System.out.println(Constants.ERROR);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return inDay;
	}

	public String getOutDay() {
		boolean a = true;
		boolean b = true;
		String outDay = null;
		while (a) {
			System.out.print("please input your outDay: form yyyy-mm-dd ");
			regex = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
			try {
				outDay = console.readLine();
				pattern = Pattern.compile(regex);
				matcher = pattern.matcher(outDay);
				b = matcher.matches();
				if(b){
					a=false;
				}else{
					System.out.println(Constants.ERROR);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return outDay;
	}

	public String getCreCard() {
		boolean a = true;
		boolean b = true;
		String card = null;
		while (a) {
			System.out.print("please input your card num: form [1-9]{1}[0-9]{5} ");
			regex = "[1-9]{1}[0-9]{5}";
			try {
				card = console.readLine();
				pattern = Pattern.compile(regex);
				matcher = pattern.matcher(card);
				b = matcher.matches();
				if(b){
					a=false;
				}else{
					System.out.println(Constants.ERROR);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return card;
	}

	public String getPhone() {
		boolean a = true;
		boolean b = true;
		String phone = null;
		while (a) {
			System.out.print("please input your phone num: form [1-9]{1}[0-9]{10} ");
			regex = "[1-9]{1}[0-9]{10}";
			try {
				phone = console.readLine();
				pattern = Pattern.compile(regex);
				matcher = pattern.matcher(phone);
				b = matcher.matches();
				if(b){
					a=false;
				}else{
					System.out.println(Constants.ERROR);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return phone;
	}
	
	public boolean judgeDate(String inDate,String outDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = sdf.parse(inDate);
			d2 = sdf.parse(outDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long result = d1.getTime() - d2.getTime();
		if(result<0){
			return false;
		}else{
			return true;
		}
		
	}
		
	public void quit() {
		try {
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
