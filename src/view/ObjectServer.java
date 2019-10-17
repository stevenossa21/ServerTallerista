package view;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import logic.Impl_Tallerista;

public class ObjectServer {

	/**
	 * @param args
	 */
public static void main(String[] args) throws RemoteException, MalformedURLException{
		
		
		Impl_Tallerista impl = new Impl_Tallerista();
		Registry r = LocateRegistry.createRegistry(10000);
		r.rebind("Tallerista",impl);
		    System.out.println("Objeto Publicado");
		
	}

}
