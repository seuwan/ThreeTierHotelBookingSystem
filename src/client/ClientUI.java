package client;

import java.io.*;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import constants.Constants;

public class ClientUI {
	
	protected ClientImpl cImpl;
	protected BufferedReader console;
	
	public ClientUI() {
		cImpl = new ClientImpl();
		console = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void main(String[] args) {
		
		System.setProperty("java.security.policy", ClientUI.class
				.getResource("all.policy").toString());
		System.setSecurityManager(new RMISecurityManager());
		
		ClientUI ui = new ClientUI();
		try {
			
			ui.loop();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loop() throws IOException {
		String line = null;
		while (true) {			
			try {
				System.out.print(Constants.CR_LF + "Entre Request: 1."
						+ Constants.BOOK + "  2. " + Constants.RECORDINFO
						+ "  3." + Constants.COMPARE + "  4." + Constants.QUIT+Constants.CR_LF);
				line = console.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
			if (line.equalsIgnoreCase("1")) {
				book();
			} else if (line.equalsIgnoreCase("2")) {
				recordInfo();
			} else if (line.equalsIgnoreCase("3")) {
				compare();
			} else if (line.equalsIgnoreCase("4")) {
				quit();
				System.exit(0);
			} else {
				System.out.println(Constants.ERROR+Constants.CR_LF);
			}
		}
	}
	
	public void book() throws RemoteException {
		System.out.println("client booking: ");
		cImpl.getCity();
		cImpl.setCity();
		cImpl.setHotel();
		cImpl.setRoom();
		cImpl.setInfo();
	}

	public void recordInfo() {
		System.out.println("record Information: ");
		cImpl.recordInfo();
	}

	public void compare() throws IOException {
		boolean b = true;
		while(b){
			cImpl.getCity();
			cImpl.setCity();		
			System.out.println(Constants.CR_LF+"compare rate! choose:  asc  desc");
			String seq = console.readLine();
			if("asc".equalsIgnoreCase(seq)){
				cImpl.compareRate(seq);
				b=false;
			}else if("desc".equalsIgnoreCase(seq)){
				cImpl.compareRate(seq);		
				b=false;
			}else{
				System.out.println(Constants.ERROR);
				b=true;
			}			
		}
	}
	
	public void quit(){
		System.out.println("quit...");
		cImpl.quit();
	}
	
}
