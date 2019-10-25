package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import interfaces.IRespuesta;
import persistence.NotFoundException;
import persistence.PreguntaRespuesta;
import persistence.Respuesta;
import persistence.RespuestaDao;


public class Impl_Respuesta extends UnicastRemoteObject implements IRespuesta {

	public Impl_Respuesta() throws RemoteException {
		super();
	}

	public Respuesta searchRespuesta(int id) throws RemoteException {
		//crear el value object a retornar
		Respuesta u =new Respuesta();
		//crear los DAO a manipular
		u.setId(id);
		RespuestaDao respuesta= new RespuestaDao();
            
	    try{
	    	respuesta.load(getConnection(),u);
	    }
	    catch(SQLException e){
	    	u=null;
	    	e.printStackTrace();
	    } catch (NotFoundException e) {
			u=null;
			e.printStackTrace();
		}
	    return u;
	}

	public boolean updateRespuesta(int idIn, int id_pregunta, String strrespuesta, int correct)
			throws RemoteException {
		boolean update=true;
		//crear el value object a actualizar
		Respuesta u=new Respuesta();
		u.setId(idIn);
		u.setAll(id_pregunta, strrespuesta, correct);
		//crear los DAO a manipular
		RespuestaDao respuesta = new RespuestaDao();
            
	    try{
	    	respuesta.save(getConnection(),u);
	    }
	    catch(SQLException e){
	    	update=false;
	    	e.printStackTrace();	
	    } catch (NotFoundException e) {
			// TODO Auto-generated catch block
	    	update=false;
	    	e.printStackTrace();
			
		}
	    return update;
	}

	public boolean delRespuesta(int id) throws RemoteException {
		boolean del=true;
		//crear el value object a eliminar
		Respuesta u=new Respuesta();
		u.setId(id);
		//crear los DAO a manipular
		RespuestaDao respuesta= new RespuestaDao();
            
	    try{
	    	respuesta.delete(getConnection(),u);
	    }
	    catch(SQLException e){
	    	del=false;
	    	e.printStackTrace();
	    } catch (NotFoundException e) {
			// TODO Auto-generated catch block
	    	del=false;
	    	e.printStackTrace();
		}
	    return del;
	}


	public boolean addRespuesta(int id_pregunta, String strrespuesta, int correct) throws RemoteException {
		boolean add = true;

		// crear el value object de Respuesta
		Respuesta u = new Respuesta();
		u.setAll(id_pregunta, strrespuesta, correct);
		// crear el DAO a manipular
		RespuestaDao pregunta = new RespuestaDao();
		
		try {
			pregunta.create(getConnection(),u);
		} catch (SQLException e) {
			add = false;
			e.printStackTrace();
		}
		return add;
	}

	public List<PreguntaRespuesta> searchRespuesta() throws RemoteException {
		List<PreguntaRespuesta> l = null;
		RespuestaDao respuesta= new RespuestaDao();
	    try{
	    	l = respuesta.preguntaRespuesta(getConnection());
	    }
	    catch(SQLException e){
	    	l=null;
	    	e.printStackTrace();
	    }
		return l;
	}
	
	private Connection getConnection(){
		Connection conn=null;
		try{
            //registrar la clase del driver
            Class.forName("org.mariadb.jdbc.Driver");
            //obtener el objeto de conexion
            conn=DriverManager.getConnection("jdbc:mariadb://localhost/taller","root","admin123");// login=postgres , contraseña=postgres
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
        	e.printStackTrace();
        }
        return conn;
	
	}

}
