package corba.hotelbooking;


/**
* corba/hotelbooking/HotelOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Hotel.idl
* 2015年5月20日 星期三 下午03时03分44秒 CST
*/

public interface HotelOperations 
{
  void setRoom (String str, int count, int temp);
  void usersInfo (String str);
  boolean judgeRoomID (String str, int count, int temp);
  String getHotelName (int i);
  boolean judgeVacancy (String id, String inDay, String outDay);
} // interface HotelOperations
