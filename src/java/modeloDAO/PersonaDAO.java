/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import configuracion.Conexion;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Persona;

/**
 *
 * @author Carino
 */
public class PersonaDAO implements CRUD {
    Conexion conect = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona nuevaPersona = new Persona();
    
    @Override
    public List listar() {
        ArrayList<Persona> listaPersona = new ArrayList<>();
        String sql="select * from persona";
        try{
            con = conect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Persona nuevaPersona = new Persona();
                nuevaPersona.setCodigoPersona(rs.getInt("codigoPersona"));
                nuevaPersona.setDPI(rs.getString("DPI"));
                nuevaPersona.setNombrePersona(rs.getString("NombrePersona"));
                listaPersona.add(nuevaPersona);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaPersona;
    }

    @Override
    public Persona list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Persona per) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(Persona per) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
