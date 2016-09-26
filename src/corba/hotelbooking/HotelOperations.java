package corba.hotelbooking;


/**
* corba/hotelbooking/HotelOperations.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Hotel.idl
* 2015��5��20�� ������ ����03ʱ03��44�� CST
*/

public interface HotelOperations 
{
  void setRoom (String str, int count, int temp);
  void usersInfo (String str);
  boolean judgeRoomID (String str, int count, int temp);
  String getHotelName (int i);
  boolean judgeVacancy (String id, String inDay, String outDay);
} // interface HotelOperations
