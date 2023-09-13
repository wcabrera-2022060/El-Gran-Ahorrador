package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CuponDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
    public List listaCupones(){
        String sql = "Select * from Cupones";
        List<Cupon> listaCupones = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cupon cu = new Cupon();
                cu.setIdCupon(rs.getInt(1));
                cu.setFechaCaducidad(rs.getDate(2));
                cu.setDescuento(rs.getDouble(3));
                cu.setValidez(rs.getBoolean(4));
                listaCupones.add(cu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaCupones;
    }
    
    
    public int agregar(Cupon cu){
        String sql = "Insert into Cupones(fechaCaducidad, descuento, validez)\n"+
        "values(?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, cu.getFechaCaducidad());
            ps.setDouble(2, cu.getDescuento());
            ps.setBoolean(3, cu.getValidez());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    
    public Cupon listarCodigoCupones(int id){
        Cupon cu = new Cupon();
        String sql = "Select * from Cupones where idCupon =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cu.setIdCupon(id);
                cu.setFechaCaducidad(rs.getDate(2));
                cu.setDescuento(rs.getDouble(3));
                cu.setValidez(rs.getBoolean(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cu;
    }
    
    public int actualizar(Cupon cu){
        String sql = "Update Cupones "
                + "set fechaCaducidad = ?,"
                + "descuento = ?,"
                + "validez = ? "
                + "where idCupon = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, cu.getFechaCaducidad());
            ps.setDouble(2, cu.getDescuento());
            ps.setBoolean(3, cu.getValidez());
            ps.setInt(4, cu.getIdCupon());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(int id){
        String sql = "Delete from Cupones where idCupon=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
