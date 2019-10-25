package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import interfaces.IPregunta;
import persistence.NotFoundException;
import persistence.Pregunta;
import persistence.PreguntaDao;

public class Impl_Pregunta extends UnicastRemoteObject implements IPregunta{
	private static final long serialVersionUID = 1L;
	public Impl_Pregunta() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Pregunta searchPregunta(int id) throws RemoteException {
		//crear el value object a retornar
		Pregunta u =new Pregunta();
		//crear los DAO a manipular
		u.setId(id);
	    PreguntaDao pregunta= new PreguntaDao();
            
	    try{
	    	pregunta.load(getConnection(),u);
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


	public boolean updatePregunta(int idIn, String strpregunta, int valor)
			throws RemoteException {
		boolean update=true;
		//crear el value object a actualizar
		Pregunta u=new Pregunta();
		u.setId(idIn);
		u.setAll(strpregunta, valor);
		//crear los DAO a manipular
	    PreguntaDao pregunta= new PreguntaDao();
            
	    try{
	    	pregunta.save(getConnection(),u);
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

	public boolean delPregunta(int id) throws RemoteException {
		boolean del=true;
		//crear el value object a eliminar
		Pregunta u=new Pregunta();
		u.setId(id);
		//crear los DAO a manipular
	    PreguntaDao pregunta= new PreguntaDao();
            
	    try{
	    	pregunta.delete(getConnection(),u);
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

	public boolean addPregunta(String strpregunta, int valor)
			throws RemoteException {
		boolean add = true;

		// crear el value object de Pregunta
		Pregunta u = new Pregunta();
		u.setAll(strpregunta, valor);
		// crear el DAO a manipular
		PreguntaDao pregunta = new PreguntaDao();
		
		try {
			pregunta.create(getConnection(),u);
		} catch (SQLException e) {
			add = false;
			e.printStackTrace();
		}
		return add;
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

	@Override
	public List<Pregunta> searchPregunta() {
		List<Pregunta> l = null;
	    PreguntaDao pregunta= new PreguntaDao();
	    try{
	    	l = pregunta.loadAll(getConnection());
	    }
	    catch(SQLException e){
	    	l=null;
	    	e.printStackTrace();
	    }
		return l;
	}

}
