package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CuponesDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
    public List listaCupones(){
        String sql = "Select * from Cupones";
        List<Cupones> listaCupones = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cupones cu = new Cupones();
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
    
    
    public int agregar(Cupones cu){
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
    
    
    public Cupones listarCodigoCupones(int id){
        Cupones cu = new Cupones();
        String sql = "Select * from Cupones where idCupon =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cu.setFechaCaducidad(rs.getDate(2));
                cu.setDescuento(rs.getDouble(3));
                cu.setValidez(rs.getBoolean(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cu;
    }
    
    public int actualizar(Cupones cu){
        String sql = "Update Cupones"
                + "fechaCaducidad = ?,"
                + "descuento = ?,"
                + "validez = ?,"
                + "where idCupones = ?";
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
    
    public void eliminar(int id){
        String sql = "Delete from Cupones where idCupones=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
