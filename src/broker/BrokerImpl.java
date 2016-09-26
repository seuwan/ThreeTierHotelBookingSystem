package broker;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;

import serverB.*;
import sql.*;

@SuppressWarnings("serial")
public class BrokerImpl extends UnicastRemoteObject implements Broker {

	corba.hotelbooking.Hotel hotelRef;
	protected SqlImpl sqlImpl;
	protected BrokerServer brokerSer;
	protected ServerBInterface serverb;
	String[] str = null;

	public BrokerImpl() throws RemoteException {
		try {
			sqlImpl = new SqlImpl();
			brokerSer = new BrokerServer(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			serverb = (ServerBInterface) Naming
					.lookup("rmi://localhost:8899/ServerBInterface");
			System.out.println("RMI broker complete...broker to ServerB.");
		} catch (ConnectException conEx) {
			System.out.println("Unable to connect to ServerB!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public String[] getCity() throws RemoteException {

		str = sqlImpl.queryCity();
		return str;
	}

	public String[] setCity(String string) throws RemoteException {
		str = sqlImpl.selectCity(string);
		return str;
	}

	public String[] setHotel(String string, int count) throws RemoteException {
		str = sqlImpl.selectHotel(string, count);
		return str;
	}

	public void setRoom(String id, int count, int temp) throws RemoteException {
		if (count == 1) {
			brokerSer.setRoom(id, count, temp);
		} else {
			serverb.setRoom(id, count, temp);
		}
	}

	public void usersInfo(String[] total, int count) throws RemoteException {
		String s = convertString(total);
		if (count == 1) {
			brokerSer.usersInfo(s);
		} else {
			serverb.usersInfo(s);
		}
	}

	public String convertString(String[] str) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length; i++) {
			sb.append(str[i]);
			sb.append("%");
		}
		String s = sb.toString();
		return s;
	}

	public String[] convertStringArray(String s) {
		String[] str = s.split("%");
		return str;

	}

	public boolean judgeRoomID(String id, int count, int temp)
			throws RemoteException {
		boolean b = false;
		if (count == 1) {
			b = brokerSer.judgeRoomID(id, count, temp);
		} else {
			b = serverb.judgeRoomID(id, count, temp);
		}
		return b;
	}

	public String getHotelName(int i) throws RemoteException {
		String hotelName = null;
		if (i == 1 || i == 2) {
			hotelName = brokerSer.getHotelName(i);
		} else {
			hotelName = serverb.getHotelName(i);
		}
		return hotelName;
	}

	public String[] getRecord(String tel) throws RemoteException {
		str = sqlImpl.queryRecord(tel);
		return str;
	}

	public String[] getRate(String rate, int count) throws RemoteException {
		str = sqlImpl.queryRate(rate, count);
		return str;
	}

	public boolean judgeVacancy(String id, String inDay, String outDay,
			int count) throws RemoteException {
		boolean b = false;
		if (count == 1) {
			b = brokerSer.judgeVacancy(id, inDay, outDay);
		} else {
			b = serverb.judgeVacancy(id, inDay, outDay);
		}
		return b;
	}

}