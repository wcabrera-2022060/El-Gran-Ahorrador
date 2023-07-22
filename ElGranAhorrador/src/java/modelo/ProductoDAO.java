package modelos;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List Productos(){
        String sql = "Select * from Productos";
        List<Productos> listaProductos = new ArrayList();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Productos pr = new Productos();
                pr.setIdProducto(rs.getInt(1));
                pr.setNombreProducto(rs.getString(2));
                pr.setPrecioProducto(rs.getDouble(3));
                pr.setMarca(rs.getString(4));
                pr.setFechaVencimiento(rs.getDate(5));
                pr.setIdTipoProducto(rs.getInt(6));
                pr.setIdInventario(rs.getInt(7));
                listaProductos.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProductos;
    }
    
    public int agregar(Productos pr){
        String sql = "Insert into Productos(nombreProducto,precioProducto,marca,fechaVencimiento,idTipoProducto,idInventario)\n" +
                "Values (?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombreProducto());
            ps.setDouble(2, pr.getPrecioProducto());
            ps.setString(3, pr.getMarca());
            ps.setDate(4, pr.getFechaVencimiento());
            ps.setInt(5, pr.getIdTipoProducto());
            ps.setInt(6, pr.getIdInventario());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public Productos listaCodigoProducto(int id){
        Productos pr = new Productos();
        String sql = "Select*from where idProducto =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                pr.setNombreProducto(rs.getString(2));
                pr.setPrecioProducto(rs.getDouble(3));
                pr.setMarca(rs.getString(4));
                pr.setFechaVencimiento(rs.getDate(5));
                pr.setIdTipoProducto(rs.getInt(6));
                pr.setIdInventario(rs.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
    
    public int actualizar(Productos pr){
        String sql = "Update Productos"
                + "nombreProducto = ?"
                + "precioProducto = ?"
                + "marca = ?"
                + "fechaVencimiento = ?"
                + "idTipoProducto = ?"
                + "idInventario = ?";
        try {
          con = cn.Conexion();
           ps = con.prepareStatement(sql);
           ps.setString(1, pr.getNombreProducto());
           ps.setDouble(2, pr.getPrecioProducto());
           ps.setString(3, pr.getMarca());
           ps.setDate(4, pr.getFechaVencimiento());
           ps.setInt(5, pr.getIdTipoProducto());
           ps.setInt(6, pr.getIdInventario());
           ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(int id){
        String sql = "Delete from Productos where idProducto =" + id;
        try {
           con = cn.Conexion();
           ps = con.prepareStatement(sql);
           ps.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
