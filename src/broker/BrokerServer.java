package broker;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.*;

public class BrokerServer {

	corba.hotelbooking.Hotel hotelRef;
	BrokerImpl brokerImpl;

	public static void main(String[] args) throws Exception {

		System.setProperty("java.security.policy", BrokerServer.class
				.getResource("all.policy").toString());
		System.setSecurityManager(new RMISecurityManager());
		
		BrokerImpl temp = new BrokerImpl();
		String rmiObjectName = "rmi://localhost:8888/Broker";
		LocateRegistry.createRegistry(8888);
		Naming.rebind(rmiObjectName, temp);
		System.out.println("RMI broker complete...broker to client.");
	}

	public BrokerServer(String args[]) {
		setup(args);
	}

	public void setup(String args[]) {
		try {
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object objectRef = orb
					.resolve_initial_references("NameService");
			NamingContext namingContext = NamingContextHelper.narrow(objectRef);
			NameComponent nameComp = new NameComponent(
					"corba.hotelbooking.Hotel", "");
			NameComponent[] path = { nameComp };
			objectRef = namingContext.resolve(path);
			hotelRef = corba.hotelbooking.HotelHelper.narrow(objectRef);
			System.out.println("Corba broker complete...broker to ServerA.");
		} catch (Exception ex) {
			System.out.println("*** Client error! ***");
			ex.printStackTrace();
		}
	}

	public void setRoom(String id, int count, int temp) {
		hotelRef.setRoom(id, count, temp);
	}

	public void usersInfo(String total) {
		hotelRef.usersInfo(total);
	}

	public boolean judgeRoomID(String id, int count, int temp) {
		return hotelRef.judgeRoomID(id, count, temp);
	}

	public String getHotelName(int i) {
		return hotelRef.getHotelName(i);
	}

	public boolean judgeVacancy(String id, String inDay, String outDay) {
		return hotelRef.judgeVacancy(id, inDay, outDay);
	}
}
