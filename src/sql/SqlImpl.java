package sql;

import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SqlImpl {

	protected BufferedReader console;
	SqlConnect sqlConnect;
	Connection connection = null;
	Statement statement = null;
	ResultSet rSet = null;
	ResultSet rSet2 = null;
	String sql = null;
	String sql1 = null;

	public SqlImpl() throws SQLException {
		sqlConnect = new SqlConnect();
		try {
			connection = sqlConnect.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		statement = connection.createStatement();
		console = new BufferedReader(new InputStreamReader(System.in));
	}

	public void updateUsersInfo(String[] total) {
		String hotelName = null;
		String name = null;
		String inDay = null;
		String outDay = null;
		String creCard = null;
		String phone = null;
		hotelName = total[0];
		name = total[1];
		inDay = total[2];
		outDay = total[3];
		creCard = total[4];
		phone = total[5];
		sql = "insert into user(hotelName,name,inDay,outDay,creCard,phone)"
				+ "values('" + hotelName + "','" + name + "','" + inDay + "','"
				+ outDay + "','" + creCard + "','" + phone + "')";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String[] queryCity() {
		try {
			sql = "select distinct city from cityhotel";
			rSet = statement.executeQuery(sql);
			return convertString(rSet);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String[] selectCity(String string) {
		try {
			if ("beijing".equals(string)) {
				sql = "select hotel from cityhotel where city='beijing'";
			} else {
				sql = "select hotel from cityhotel where city='shanghai'";
			}
			rSet = statement.executeQuery(sql);
			return convertString(rSet);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String[] selectHotel(String string, int count) {
		try {
			if ("7days".equals(string)) {
				if (count == 1) {
					sql = "select roomID,rate,vacancy from bj7days";
				} else {
					sql = "select roomID,rate,vacancy from sh7days";
				}
			} else {
				if (count == 1) {
					sql = "select roomID,rate,vacancy from bjjjstar";
				} else {
					sql = "select roomID,rate,vacancy from shjjstar";
				}
			}
			rSet = statement.executeQuery(sql);
			return convertString(rSet);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getHotelName(int i) {
		String hotelName = null;
		if (i == 1) {
			sql = "select distinct hotelName from bj7days";
		} else if (i == 2) {
			sql = "select distinct hotelName from bjjjstar";
		} else if (i == 3) {
			sql = "select distinct hotelName from sh7days";
		} else {
			sql = "select distinct hotelName from shjjstar";
		}
		try {
			ResultSet rSet = statement.executeQuery(sql);
			while (rSet.next()) {
				hotelName = rSet.getString("hotelName");
			}
			return hotelName;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean judgeRoomID(String id, int count, int temp) {
		if (count == 1 && temp == 1) {
			String s = "select roomID from bj7days where roomID='" + id + "'";
			try {
				ResultSet rSet = statement.executeQuery(s);
				if (rSet.next()) {
					return false;
				} else {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

		} else if (count == 1 && temp == 2) {
			String s = "select roomID from bjjjstar where roomID='" + id + "'";
			try {
				ResultSet rSet = statement.executeQuery(s);
				if (rSet.next()) {
					return false;
				} else {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

		} else if (count == 2 && temp == 1) {
			String s = "select roomID from sh7days where roomID='" + id + "'";
			try {
				ResultSet rSet = statement.executeQuery(s);
				if (rSet.next()) {
					return false;
				} else {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

		} else {
			String s = "select roomID from shjjstar where roomID='" + id + "'";
			try {
				ResultSet rSet = statement.executeQuery(s);
				if (rSet.next()) {
					return false;
				} else {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	public void updateList(String id, int count, int temp) {
		if (count == 1 && temp == 1) {
			System.out
					.println("client choose the city: beijing, hotel: 7days.");
			sql = "update bj7days set vacancy='1' where roomID='" + id + "'";
		} else if (count == 1 && temp == 2) {
			System.out
					.println("client choose the city: beijing, hotel: jjstar.");
			sql = "update bjjjstar set vacancy='1' where roomID='" + id + "'";
		} else if (count == 2 && temp == 1) {
			System.out
					.println("client choose the city: shanghai, hotel: 7days.");
			sql = "update sh7days set vacancy='1' where roomID='" + id + "'";
		} else {
			System.out
					.println("client choose the city: shanghai, hotel: jjstar.");
			sql = "update shjjstar set vacancy='1' where roomID='" + id + "'";
		}
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String[] queryRecord(String tel) {
		try {
			sql = "select *from user where phone='" + tel + "'";
			rSet = statement.executeQuery(sql);
			return convertString(rSet);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String[] queryRate(String seq, int count) {
		try {
			if ("asc".equalsIgnoreCase(seq)) {
				if (count == 1) {
					sql = "select hotelname,rate from bj7days union select hotelname,"
							+ "rate from bjjjstar order by rate asc";
				} else {
					sql = "select hotelname,rate from sh7days "
							+ "union select hotelname,rate from shjjstar order by rate asc";
				}
			} else {
				if (count == 1) {
					sql = "select hotelname,rate from bj7days union select hotelname,"
							+ "rate from bjjjstar order by rate desc";
				} else {
					sql = "select hotelname,rate from sh7days "
							+ "union select hotelname,rate from shjjstar order by rate desc";
				}
			}
			rSet = statement.executeQuery(sql);
			String[] str = convertString(rSet);
			return str;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String[] convertString(ResultSet rSet) {
		ArrayList<String> ar = new ArrayList<String>();
		String command = "";
		String[] out = null;
		if (rSet == null)
			return null;
		try {
			ResultSetMetaData md = rSet.getMetaData();
			int colmun = md.getColumnCount();
			for (int i = 1; i <= colmun; i++) {
				String a = md.getColumnName(i);
				a = String.format("%-22s", a);
				command += a;

			}
			ar.add(command);
			while (rSet.next()) {
				command = "";
				for (int i = 1; i <= colmun; i++) {
					String a = rSet.getString(i);
					a = String.format("%-22s", a);
					command += a;
				}
				ar.add(command);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out = new String[ar.size()];
		ar.toArray(out);
		return out;
	}

	public boolean judgeVacancy(String id, String inDay, String outDay) {
		try {
			boolean jv = true;
			sql = "select roomID,checkInDay,checkOutDay from roomcheck where roomID='"
					+ id + "'";
			rSet = statement.executeQuery(sql);
			while (rSet.next()) {
				String checkInDay = rSet.getString("checkInDay");
				String checkOutDay = rSet.getString("checkOutDay");
				if (judgeDate(inDay, checkOutDay)
						|| judgeDate(checkInDay, outDay)) {
				} else {
					jv = false;
					break;
				}
			}
			if (jv == true) {
				String sqlin = "insert into roomcheck(roomID,checkInDay,checkOutDay)"
						+ "values('"
						+ id
						+ "','"
						+ inDay
						+ "','"
						+ outDay
						+ "')";
				statement.executeUpdate(sqlin);
			}
			return jv;
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
	}

	public boolean judgeDate(String inDate, String outDate) {
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
		if (result <= 0) {
			return false;
		} else {
			return true;
		}

	}

}
