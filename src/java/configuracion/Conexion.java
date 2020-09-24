/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LAPTOP
 */
public class Conexion {
    Connection conexion;
    
    public Conexion() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
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
