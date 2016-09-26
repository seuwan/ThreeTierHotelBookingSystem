package corba.hotelbooking;

/**
* corba/hotelbooking/HotelHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Hotel.idl
* 2015年5月20日 星期三 下午03时03分44秒 CST
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
