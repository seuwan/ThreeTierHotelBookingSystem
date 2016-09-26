package serverB;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

/**
 * use RMI to communicate between broker and serverB
 * RMI: Remote Method Invocation,远程方法调用
 * @author Wendy
 *
 */
public class ServerB {

	public static void main(String[] args) {

		try {
			ServerBImpl temp = new ServerBImpl();
			String rmiObjectName = "rmi://localhost:8899/ServerBInterface";
			LocateRegistry.createRegistry(8899);
			Naming.rebind(rmiObjectName, temp);
			System.out.println("RMI Binding complete...ServerB to broker.\n");
		} catch (Exception ex) {
			System.out.println("*** ServerB error! ***");
			ex.printStackTrace();
		}
	}

}
