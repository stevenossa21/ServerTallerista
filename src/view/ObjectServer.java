package view;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import logic.Impl_Pregunta;
import logic.Impl_Respuesta;
import logic.Impl_Tallerista;

public class ObjectServer {

	/**
	 * @param args
	 */
public static void main(String[] args) throws RemoteException, MalformedURLException{
		
		
		Impl_Tallerista impl = new Impl_Tallerista();
		Impl_Pregunta implPregunta = new Impl_Pregunta();
		Impl_Respuesta implRespuesta = new Impl_Respuesta();
		Registry r = LocateRegistry.createRegistry(10000);
		r.rebind("Tallerista", impl);
		r.rebind("Pregunta", implPregunta);
		r.rebind("Respuesta", implRespuesta);
		System.out.println("Objetos Publicados");
		
	}

}
