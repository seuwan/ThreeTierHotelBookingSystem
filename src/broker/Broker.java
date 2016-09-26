package broker;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Broker extends Remote {

	public String[] getCity() throws RemoteException;

	public String[] setCity(String str) throws RemoteException;

	public String[] setHotel(String string, int count) throws RemoteException;

	public String[] getRate(String seq, int count) throws RemoteException;

	public String[] getRecord(String tel) throws RemoteException;
	
	public void usersInfo(String[] total,int count) throws RemoteException;

	public void setRoom(String id, int count, int temp) throws RemoteException;

	public boolean judgeRoomID(String id, int count, int temp) throws RemoteException;

	public String getHotelName(int i) throws RemoteException;

	public boolean judgeVacancy(String id, String inDay, String outDay, int count) throws RemoteException;
	
	
	
	
}
