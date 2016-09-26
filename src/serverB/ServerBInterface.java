package serverB;

import java.rmi.*;

public interface ServerBInterface extends Remote{
	
	public void usersInfo(String s) throws RemoteException;

	public void setRoom(String id, int count, int temp) throws RemoteException;

	public boolean judgeRoomID(String id, int count, int temp) throws RemoteException;

	public String getHotelName(int i) throws RemoteException;

	public boolean judgeVacancy(String id, String inDay, String outDay) throws RemoteException;
}
