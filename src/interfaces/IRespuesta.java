package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import persistence.PreguntaRespuesta;
import persistence.Respuesta;


public interface IRespuesta extends Remote{
	Respuesta searchRespuesta(int id)throws RemoteException;
	boolean updateRespuesta(int idIn, int id_pregunta, String respuesta, int correct)throws RemoteException;
	boolean delRespuesta(int id)throws RemoteException;
	boolean addRespuesta(int id_pregunta, String respuesta, int correct)throws RemoteException;
	List <PreguntaRespuesta> searchRespuesta()throws RemoteException;

}
