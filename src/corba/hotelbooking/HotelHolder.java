package corba.hotelbooking;

/**
* corba/hotelbooking/HotelHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Hotel.idl
* 2015��5��20�� ������ ����03ʱ03��44�� CST
*/

public final class HotelHolder implements org.omg.CORBA.portable.Streamable
{
  public corba.hotelbooking.Hotel value = null;

  public HotelHolder ()
  {
  }

  public HotelHolder (corba.hotelbooking.Hotel initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = corba.hotelbooking.HotelHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    corba.hotelbooking.HotelHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return corba.hotelbooking.HotelHelper.type ();
  }

}
