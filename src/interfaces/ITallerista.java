package interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;

import persistence.Tallerista;

public interface ITallerista extends Remote {
Tallerista searchTallerista(int id)throws RemoteException;
boolean updateTallerista(int idIn, String nameIn, String last_nameIn, String emailIn, int ageIn)throws RemoteException;
boolean delTallerista(int id)throws RemoteException;
boolean addTallerista(int idIn, String nameIn, String last_nameIn, String emailIn, int ageIn)throws RemoteException;
}