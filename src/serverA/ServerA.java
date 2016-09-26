package serverA;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;

/**
 * use CORBA to communicate between broker and serverA
 * CORBA: Common Object Request Broker Architecture,公共对象请求代理体系结构
 * 
 * in the command line, input: tnameserv, for initialize Corba and set the default port: 900
 * 
 * @author Wendy
 *
 */
public class ServerA {

	public static void main(String[] args) {
		
		try {
			System.out.println("Corba ServerA complete...ServerA to broker.");
			ORB orb = ORB.init(args, null);
			ServerAImpl servant = new ServerAImpl();
			orb.connect(servant);
			org.omg.CORBA.Object objectRef = orb
					.resolve_initial_references("NameService");
			NamingContext namingContext = NamingContextHelper.narrow(objectRef);
			NameComponent nameComp = new NameComponent(
					"corba.hotelbooking.Hotel", "");
			NameComponent[] path = { nameComp };
			namingContext.rebind(path, servant);
			java.lang.Object syncObj = new java.lang.Object();
			synchronized (syncObj) {
				syncObj.wait();
			}
		} catch (Exception ex) {
			System.out.println("*** Server error! ***");
			ex.printStackTrace();
		}
	}
}
