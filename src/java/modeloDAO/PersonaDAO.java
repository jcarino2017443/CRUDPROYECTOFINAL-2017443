/*Emerson Alexsander Rosales Ixcoy - 2019380*/ 
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
        String sql = "select * from Persona where codigoPersona = " + id;
        try{
            con = conect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                nuevaPersona.setCodigoPersona(rs.getInt("codigoPersona"));
                nuevaPersona.setDPI(rs.getString("DPI"));
                nuevaPersona.setNombrePersona(rs.getString("nombrePersona"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return nuevaPersona;
    }

    
    @Override
    public boolean add(Persona per) {
        String sql = "insert into Persona(DPI,nombrePersona) values('" + per.getDPI() + "','" + per.getNombrePersona() + "')";
        try{
            con = conect.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Persona per) {
        String sql = "update Persona set DPI = '" + per.getDPI() + "', nombrePersona = '" + per.getNombrePersona() + "' where codigoPersona = " + per.getCodigoPersona();
        try{
            con = conect.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean remove(int id) {
      String sql = "delete from Persona where codigoPersona = " + id;
        try{
            con = conect.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
}
