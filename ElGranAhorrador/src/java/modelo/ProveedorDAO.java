package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listaProveedores(){
        String sql = "Select * from Proveedores";
        List<Proveedor> listaProveedores = new ArrayList();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Proveedor pr = new Proveedor();
                pr.setIdProveedor(rs.getInt(1));
                pr.setProveedor(rs.getString(2));
                pr.setCantidadAdquirida(rs.getInt(3));
                pr.setTotalPagar(rs.getInt(4));
                pr.setIdProducto(rs.getInt(5));
                listaProveedores.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProveedores;
    }
    
    public int agregar(Proveedor pr){
        String sql = "Insert into Proveedores(proveedor, cantidadAdquirida, totalPagar, idProducto)\n" +
        "Values (?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getProveedor());
            ps.setInt(2, pr.getCantidadAdquirida());
            ps.setDouble(3, pr.getTotalPagar());
            ps.setInt(4, pr.getIdProducto());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public Proveedor listarCodigoProveedores(int id){
        Proveedor pr = new Proveedor();
        String sql = "Select* from where idProveedor =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                pr.setProveedor(rs.getString(2));
                pr.setCantidadAdquirida(rs.getInt(3));
                pr.setTotalPagar(rs.getDouble(4));
                pr.setIdProducto(rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
    
    
    public int actulizar(Proveedor pr){
        String sql = "Update Proveedores"
                +"proveedor = ?,"
                +"cantidadAdquirida = ?,"
                +"totalApagar = ?,"
                +"idProducto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getProveedor());
            ps.setInt(2, pr.getCantidadAdquirida());
            ps.setDouble(3, pr.getTotalPagar());
            ps.setInt(4, pr.getIdProducto());
            ps.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(int id){
        String sql = "Delete from Proveedores where idProvedor =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
