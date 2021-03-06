package corba.hotelbooking;


/**
* corba/hotelbooking/HotelHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Hotel.idl
* 2015年5月20日 星期三 下午03时03分44秒 CST
*/

abstract public class HotelHelper
{
  private static String  _id = "IDL:corba/hotelbooking/Hotel:1.0";

  public static void insert (org.omg.CORBA.Any a, corba.hotelbooking.Hotel that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static corba.hotelbooking.Hotel extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (corba.hotelbooking.HotelHelper.id (), "Hotel");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static corba.hotelbooking.Hotel read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_HotelStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, corba.hotelbooking.Hotel value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static corba.hotelbooking.Hotel narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof corba.hotelbooking.Hotel)
      return (corba.hotelbooking.Hotel)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      corba.hotelbooking._HotelStub stub = new corba.hotelbooking._HotelStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static corba.hotelbooking.Hotel unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof corba.hotelbooking.Hotel)
      return (corba.hotelbooking.Hotel)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      corba.hotelbooking._HotelStub stub = new corba.hotelbooking._HotelStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
