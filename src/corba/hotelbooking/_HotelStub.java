package corba.hotelbooking;


/**
* corba/hotelbooking/_HotelStub.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Hotel.idl
* 2015年5月20日 星期三 下午03时03分44秒 CST
*/

public class _HotelStub extends org.omg.CORBA.portable.ObjectImpl implements corba.hotelbooking.Hotel
{

  public void setRoom (String str, int count, int temp)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("setRoom", true);
                $out.write_string (str);
                $out.write_long (count);
                $out.write_long (temp);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                setRoom (str, count, temp        );
            } finally {
                _releaseReply ($in);
            }
  } // setRoom

  public void usersInfo (String str)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("usersInfo", true);
                $out.write_string (str);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                usersInfo (str        );
            } finally {
                _releaseReply ($in);
            }
  } // usersInfo

  public boolean judgeRoomID (String str, int count, int temp)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("judgeRoomID", true);
                $out.write_string (str);
                $out.write_long (count);
                $out.write_long (temp);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return judgeRoomID (str, count, temp        );
            } finally {
                _releaseReply ($in);
            }
  } // judgeRoomID

  public String getHotelName (int i)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getHotelName", true);
                $out.write_long (i);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getHotelName (i        );
            } finally {
                _releaseReply ($in);
            }
  } // getHotelName

  public boolean judgeVacancy (String id, String inDay, String outDay)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("judgeVacancy", true);
                $out.write_string (id);
                $out.write_string (inDay);
                $out.write_string (outDay);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return judgeVacancy (id, inDay, outDay        );
            } finally {
                _releaseReply ($in);
            }
  } // judgeVacancy

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:corba/hotelbooking/Hotel:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _HotelStub
