package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import persistence.Pregunta;

public interface IPregunta  extends Remote{
	Pregunta searchPregunta(int id)throws RemoteException;
	boolean updatePregunta(int idIn, String pregunta, int valor)throws RemoteException;
	boolean delPregunta(int id)throws RemoteException;
	boolean addPregunta(String pregunta, int valor)throws RemoteException;
	List<Pregunta> searchPregunta()throws RemoteException;
}
