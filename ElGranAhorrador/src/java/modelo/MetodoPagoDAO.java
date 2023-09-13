package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MetodoPagoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listarMetodoPago(){
        //String sql = "Select MP.idMetodoPago, MP.metodoPago, MP.pagoTotal, MP.banco from MetodoPago MP";
        String sql = "select * from MetodoPago";
        List<MetodoPago> listaMetodoPago = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                MetodoPago mp = new MetodoPago();
                mp.setIdMetodoPago(rs.getInt(1));
                mp.setMetodoPago(rs.getString(2));
                mp.setPagoTotal(rs.getDouble(3));
                mp.setBanco(rs.getString(4));
                listaMetodoPago.add(mp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaMetodoPago;
    }
    
    
    public int agregarMetodoPago(MetodoPago mp){
        String sql = "insert into MetodoPago (metodoPago, pagoTotal, banco) values (?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, mp.getMetodoPago());
            ps.setDouble(2, mp.getPagoTotal());
            ps.setString(3, mp.getBanco());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    public MetodoPago buscarMetodoPago(int id){
        MetodoPago mp = new MetodoPago();
        String sql = "Select * from MetodoPago where idMetodoPago = "+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                mp.setIdMetodoPago(rs.getInt(1));
                mp.setMetodoPago(rs.getString(2));
                mp.setPagoTotal(rs.getDouble(3));
                mp.setBanco(rs.getString(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return mp;
    }
    
    
    public int actualizarMetodoPago(MetodoPago mp){
        String sql = "Update MetodoPago set metodoPago = ?,pagoTotal = ?, banco = ? where idMetodoPago = ?";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, mp.getMetodoPago());
            ps.setDouble(2, mp.getPagoTotal());
            ps.setString(3, mp.getBanco());
            ps.setInt(4, mp.getIdMetodoPago());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    
    public void eliminarMetodoPago(int id){
        String sql = "delete from MetodoPago where idMetodoPago = "+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
