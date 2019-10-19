package interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import persistence.Tallerista;

public interface ITallerista extends Remote {
Tallerista searchTallerista(int id)throws RemoteException;
boolean updateTallerista(int idIn, String nameIn, String last_nameIn, String emailIn, int ageIn)throws RemoteException;
boolean delTallerista(int id)throws RemoteException;
boolean addTallerista(String nameIn, String last_nameIn, String emailIn, int ageIn)throws RemoteException;
List<Tallerista> searchTallerista()throws RemoteException;
}