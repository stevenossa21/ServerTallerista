package persistence;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * Respuesta Value Object.
  * This class is value object representing database table Respuesta
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



public class Respuesta implements Cloneable, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int id;
    private int id_pregunta;
    private String respuesta;
    private int correct;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Respuesta () {

    }

    public Respuesta (int idIn) {

          this.id = idIn;

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

    public int getId_pregunta() {
          return this.id_pregunta;
    }
    public void setId_pregunta(int id_preguntaIn) {
          this.id_pregunta = id_preguntaIn;
    }

    public String getRespuesta() {
          return this.respuesta;
    }
    public void setRespuesta(String respuestaIn) {
          this.respuesta = respuestaIn;
    }

    public int getCorrect() {
          return this.correct;
    }
    public void setCorrect(int correctIn) {
          this.correct = correctIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(
          int id_preguntaIn,
          String respuestaIn,
          int correctIn) {
          this.id_pregunta = id_preguntaIn;
          this.respuesta = respuestaIn;
          this.correct = correctIn;
    }


    /** 
     * hasEqualMapping-method will compare two Respuesta instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Respuesta valueObject) {

          if (valueObject.getId() != this.id) {
                    return(false);
          }
          if (valueObject.getId_pregunta() != this.id_pregunta) {
                    return(false);
          }
          if (this.respuesta == null) {
                    if (valueObject.getRespuesta() != null)
                           return(false);
          } else if (!this.respuesta.equals(valueObject.getRespuesta())) {
                    return(false);
          }
          if (valueObject.getCorrect() != this.correct) {
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
        out.append("\nclass Respuesta, mapping to table Respuesta\n");
        out.append("Persistent attributes: \n"); 
        out.append("id = " + this.id + "\n"); 
        out.append("id_pregunta = " + this.id_pregunta + "\n"); 
        out.append("respuesta = " + this.respuesta + "\n"); 
        out.append("correct = " + this.correct + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Respuesta cloned = new Respuesta();

        cloned.setId(this.id); 
        cloned.setId_pregunta(this.id_pregunta); 
        if (this.respuesta != null)
             cloned.setRespuesta(new String(this.respuesta)); 
        cloned.setCorrect(this.correct); 
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
