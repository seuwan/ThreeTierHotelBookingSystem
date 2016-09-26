package corba.hotelbooking;


/**
* corba/hotelbooking/_HotelImplBase.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Hotel.idl
* 2015年5月20日 星期三 下午03时03分44秒 CST
*/

public abstract class _HotelImplBase extends org.omg.CORBA.portable.ObjectImpl
                implements corba.hotelbooking.Hotel, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors
  public _HotelImplBase ()
  {
  }

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("setRoom", new java.lang.Integer (0));
    _methods.put ("usersInfo", new java.lang.Integer (1));
    _methods.put ("judgeRoomID", new java.lang.Integer (2));
    _methods.put ("getHotelName", new java.lang.Integer (3));
    _methods.put ("judgeVacancy", new java.lang.Integer (4));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // corba/hotelbooking/Hotel/setRoom
       {
         String str = in.read_string ();
         int count = in.read_long ();
         int temp = in.read_long ();
         this.setRoom (str, count, temp);
         out = $rh.createReply();
         break;
       }

       case 1:  // corba/hotelbooking/Hotel/usersInfo
       {
         String str = in.read_string ();
         this.usersInfo (str);
         out = $rh.createReply();
         break;
       }

       case 2:  // corba/hotelbooking/Hotel/judgeRoomID
       {
         String str = in.read_string ();
         int count = in.read_long ();
         int temp = in.read_long ();
         boolean $result = false;
         $result = this.judgeRoomID (str, count, temp);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // corba/hotelbooking/Hotel/getHotelName
       {
         int i = in.read_long ();
         String $result = null;
         $result = this.getHotelName (i);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 4:  // corba/hotelbooking/Hotel/judgeVacancy
       {
         String id = in.read_string ();
         String inDay = in.read_string ();
         String outDay = in.read_string ();
         boolean $result = false;
         $result = this.judgeVacancy (id, inDay, outDay);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:corba/hotelbooking/Hotel:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }


} // class _HotelImplBase
