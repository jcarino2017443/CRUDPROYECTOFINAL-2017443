
package configuracion;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    Connection conexion;
    
    public Conexion() {
        try{
            Class.forName("com.mysql.jdbc.driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBRegistro?useSSL=false","root","admin");
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.print("no se pudo establecer una conexion" + e);
        }
    
    }
    public Connection getConnection(){
        return conexion;
    }
           
}
