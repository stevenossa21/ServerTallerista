package logic;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import persistence.NotFoundException;
import persistence.Tallerista;
import persistence.TalleristaDao;
import interfaces.ITallerista;
//objeto remoto
public class Impl_Tallerista extends UnicastRemoteObject implements ITallerista {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Impl_Tallerista() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Tallerista searchTallerista(int id) throws RemoteException {
		//crear el value object a retornar
		Tallerista u=new Tallerista();
		//crear los DAO a manipular
		u.setId(id);
	    TalleristaDao Tallerista= new TalleristaDao();
            
	    try{
	    	Tallerista.load(getConnection(),u);
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


	public boolean updateTallerista(int idIn, String nameIn, String last_nameIn, String emailIn, int ageIn)
			throws RemoteException {
		boolean update=true;
		//crear el value object a actualizar
		Tallerista u=new Tallerista();
		u.setId(idIn);
		u.setAll(nameIn, last_nameIn, emailIn, ageIn);
		//crear los DAO a manipular
	    TalleristaDao Tallerista= new TalleristaDao();
            
	    try{
	    	Tallerista.save(getConnection(),u);
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

	public boolean delTallerista(int id) throws RemoteException {
		boolean del=true;
		//crear el value object a eliminar
		Tallerista u=new Tallerista();
		u.setId(id);
		//crear los DAO a manipular
	    TalleristaDao Tallerista= new TalleristaDao();
            
	    try{
	    	Tallerista.delete(getConnection(),u);
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

	public boolean addTallerista(String nameIn, String last_nameIn, String emailIn, int ageIn)
			throws RemoteException {
		boolean add = true;

		// crear el value object de Tallerista
		Tallerista u = new Tallerista();
		u.setAll(nameIn, last_nameIn, emailIn, ageIn);
		// crear el DAO a manipular
		TalleristaDao Tallerista = new TalleristaDao();
		
		try {
			Tallerista.create(getConnection(),u);
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
            conn=DriverManager.getConnection("jdbc:mariadb://localhost/taller","jhon","andrea");// login=postgres , contraseña=postgres
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
	public List<Tallerista> searchTallerista() {
		List<Tallerista> l = null;
	    TalleristaDao Tallerista= new TalleristaDao();
	    try{
	    	l = Tallerista.loadAll(getConnection());
	    }
	    catch(SQLException e){
	    	l=null;
	    	e.printStackTrace();
	    }
		return l;
	}



}