
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class FacturaDAO {
    
    Conexion cn = new Conexion();
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar(){
        String sql = "select F.idFactura, F.fecha, F.idCompra, F.idEnvio, F.idMetodoPago, F.idCupon From Factura F";
        List<Factura> listaFactura = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Factura fc = new Factura();
                fc.setIdFactura(rs.getInt(1));
                fc.setFecha(rs.getDate(2));
                fc.setIdCompra(rs.getInt(3));
                fc.setIdEnvio(rs.getInt(4));
                fc.setIdMetodoPago(5);
                fc.setIdCupon(rs.getInt(6));
                listaFactura.add(fc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaFactura;
    }
    
    public int agregar(Factura fc){
        String sql = "Insert into Factura(fecha, idCompra, idEnvio, idMetodoPago, idCupon)" +
                        "values (?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, fc.getFecha());
            ps.setInt(2, fc.getIdCompra());
            ps.setInt(3, fc.getIdEnvio());
            ps.setInt(4, fc.getIdMetodoPago());
            ps.setInt(5, fc.getIdCupon());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
   
    public Factura listaridFactura (int id){
        Factura fc = new Factura();
        String sql = "select F.idFactura, F.fecha, F.idCompra, F.idEnvio, F.idMetodoPago, F.idCupon From Factura F where F.idFactura = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) { 
                fc.setIdFactura(rs.getInt(1));
                fc.setFecha(rs.getDate(2));
                fc.setIdCompra(rs.getInt(3));
                fc.setIdEnvio(rs.getInt(4));
                fc.setIdMetodoPago(rs.getInt(5));
                fc.setIdCupon(rs.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fc;
    }
    
    public int actualizarFactura(Factura fc){
        String sql = "Update Factura F set F.fecha =  ? where F.idFactura = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, fc.getFecha());
            ps.setInt(2, fc.getIdFactura());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminarFactura(int id){
        String sql = "Delete from Factura where idFactura =" +id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
