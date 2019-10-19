package persistence;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * Tallerista Value Object.
  * This class is value object representing database table Tallerista
  * This class is intented to be used together with associated Dao object.
  */

 /**
  * This sourcecode has been generated by FREE DaoGen generator version 2.4.1.
  * The usage of generated code is restricted to OpenSource software projects
  * only. DaoGen is available in http://titaniclinux.net/daogen/
  * It has been programmed by Tuomo Lukka, Tuomo.Lukka@iki.fi
  *
  * DaoGen license: The following DaoGen generated source code is licensed
  * under the terms of GNU GPL license. The full text for license is available
  * in GNU project's pages: http://www.gnu.org/copyleft/gpl.html
  *
  * If you wish to use the DaoGen generator to produce code for closed-source
  * commercial applications, you must pay the lisence fee. The price is
  * 5 USD or 5 Eur for each database table, you are generating code for.
  * (That includes unlimited amount of iterations with all supported languages
  * for each database table you are paying for.) Send mail to
  * "Tuomo.Lukka@iki.fi" for more information. Thank you!
  */



public class Tallerista implements Cloneable, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int id;
    private String name;
    private String last_name;
    private String email;
    private int age;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Tallerista () {

    }



    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getId() {
          return this.id;
    }
    public void setId(int idIn) {
          this.id = idIn;
    }

    public String getName() {
          return this.name;
    }
    public void setName(String nameIn) {
          this.name = nameIn;
    }

    public String getLast_name() {
          return this.last_name;
    }
    public void setLast_name(String last_nameIn) {
          this.last_name = last_nameIn;
    }

    public String getEmail() {
          return this.email;
    }
    public void setEmail(String emailIn) {
          this.email = emailIn;
    }

    public int getAge() {
          return this.age;
    }
    public void setAge(int ageIn) {
          this.age = ageIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(
          String nameIn,
          String last_nameIn,
          String emailIn,
          int ageIn) {
          this.name = nameIn;
          this.last_name = last_nameIn;
          this.email = emailIn;
          this.age = ageIn;
    }


    /** 
     * hasEqualMapping-method will compare two Tallerista instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Tallerista valueObject) {

          if (valueObject.getId() != this.id) {
                    return(false);
          }
          if (this.name == null) {
                    if (valueObject.getName() != null)
                           return(false);
          } else if (!this.name.equals(valueObject.getName())) {
                    return(false);
          }
          if (this.last_name == null) {
                    if (valueObject.getLast_name() != null)
                           return(false);
          } else if (!this.last_name.equals(valueObject.getLast_name())) {
                    return(false);
          }
          if (this.email == null) {
                    if (valueObject.getEmail() != null)
                           return(false);
          } else if (!this.email.equals(valueObject.getEmail())) {
                    return(false);
          }
          if (valueObject.getAge() != this.age) {
                    return(false);
          }

          return true;
    }



    /**
     * toString will return String object representing the state of this 
     * valueObject. This is useful during application development, and 
     * possibly when application is writing object states in textlog.
     */
    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass Tallerista, mapping to table Tallerista\n");
        out.append("Persistent attributes: \n"); 
        out.append("id = " + this.id + "\n"); 
        out.append("name = " + this.name + "\n"); 
        out.append("last_name = " + this.last_name + "\n"); 
        out.append("email = " + this.email + "\n"); 
        out.append("age = " + this.age + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Tallerista cloned = new Tallerista();

        cloned.setId(this.id); 
        if (this.name != null)
             cloned.setName(new String(this.name)); 
        if (this.last_name != null)
             cloned.setLast_name(new String(this.last_name)); 
        if (this.email != null)
             cloned.setEmail(new String(this.email)); 
        cloned.setAge(this.age); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}
