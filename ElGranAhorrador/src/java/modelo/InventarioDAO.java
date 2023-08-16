package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listarInventario(){
        String sql  = "Select I.idInventario, I.cantidadDisponible, I.direccionDisponibilidad, I.disponibilidad from Inventario I";
        List<Inventario> listaInventario = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Inventario in = new Inventario();
                in.setIdInventario(rs.getInt(1));
                in.setCantidadDisponible(rs.getInt(2));
                in.setDireccionDisponibilidad(rs.getString(3));
                in.setDisponibilidad(rs.getBoolean(4));
                listaInventario.add(in);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaInventario;
    }
    
    public int agregarInventario(Inventario in){
        String sql = "Insert into Inventario (cantidadDisponible, direccionDisponibilidad, disponibilidad) values(?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, in.getCantidadDisponible());
            ps.setString(2, in.getDireccionDisponibilidad());
            ps.setBoolean(3, in.getDisponibilidad());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    public Inventario buscarInventario(int id){
        Inventario in = new Inventario();
        String sql = "Select I.idInventario, I.cantidadDisponible, I.direccionDisponibilidad, I.disponibilidad from Inventario I where I.idInventario ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                in.setIdInventario(rs.getInt(1));
                in.setCantidadDisponible(rs.getInt(2));
                in.setDireccionDisponibilidad(rs.getString(3));
                in.setDisponibilidad(rs.getBoolean(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return in;
    }
    
    public int actualizarInventario(Inventario in){
        String sql = "Update Inventario"
                + "set cantidadDisponible = ?,"
                + "direccionDisponibilidad = ?,"
                + "disponibilidad = ?"
                + "where idInventario = ?";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, in.getCantidadDisponible());
            ps.setString(2, in.getDireccionDisponibilidad());
            ps.setBoolean(3, in.getDisponibilidad());
            ps.setInt(4, in.getIdInventario());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminarInventario(int id){
        String sql = "delete from Inventario where codigoInventario = "+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
