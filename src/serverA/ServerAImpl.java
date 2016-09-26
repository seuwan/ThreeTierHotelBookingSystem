package serverA;

import java.rmi.RemoteException;
import java.sql.SQLException;

import sql.SqlImpl;

@SuppressWarnings("serial")
public class ServerAImpl extends corba.hotelbooking._HotelImplBase {

	protected SqlImpl sqlImpl;

	public ServerAImpl() throws RemoteException {
		try {
			sqlImpl = new SqlImpl();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setRoom(String id, int count, int temp) {
		sqlImpl.updateList(id, count, temp);
	}

	public void usersInfo(String s) {
		String[] str = convertStringArray(s);
		sqlImpl.updateUsersInfo(str);
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

	public boolean judgeRoomID(String id, int count, int temp) {
		boolean b = sqlImpl.judgeRoomID(id, count, temp);
		return b;
	}

	public String getHotelName(int i) {
		String hotelName = sqlImpl.getHotelName(i);
		return hotelName;
	}

	public boolean judgeVacancy(String id, String inDay, String outDay) {
		boolean b = sqlImpl.judgeVacancy(id, inDay, outDay);
		return b;
	}
}
