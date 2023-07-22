package modelo;

// Luis Gerardo Cruz Muñoz 2019072 - Entidad Compra

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
public List listar(){
    String sql = "select C.cantidadProducto , C.idEmpleado , C.idCliente , C.idProducto from Compra C";
    List<Compra> listaCompra = new ArrayList<>();
    try{
         con = cn.Conexion();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
            Compra co = new Compra();
            co.setIdCompra(rs.getInt(1));
            co.setCantidadProducto(rs.getInt(2));
            co.setIdEmpleado(rs.getInt(3));
            co.setIdCliente(rs.getInt(4));
            co.setIdProducto(rs.getInt(5));
            listaCompra.add(co);
        }
        
    }catch (Exception e) {
        e.printStackTrace();
    }
        return listaCompra;
    }


    public int agregar (Compra com){
        String sql = "insert into Compra (idCompra, cantidadProducto, idEmpleado, idCliente, idProducto)\n" +
                        "values (?, ?, ?, ?, ?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1,com.getIdCompra());
            ps.setInt(2,com.getCantidadProducto());
            ps.setInt(3,com.getIdEmpleado());
            ps.setInt(4,com.getIdCliente());
            ps.setInt(5,com.getIdProducto());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return resp;
    }

    public Compra listarCodigoCompra (int id) {
        Compra comp = new Compra  ();
        String sql = "select C.cantidadProducto , C.idEmpleado , C.idCliente , C.idProducto from Compra C Where C.idCompra = " + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
                while (rs.next()) {
                    comp.setCantidadProducto(rs.getInt(2));
                    comp.setIdEmpleado(rs.getInt(3));
                    comp.setIdCliente(rs.getInt(4));
                    comp.setIdProducto(rs.getInt(5));
                
                }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return comp;
}     
 
    public int actualizar (Compra comp) {
        String sql = "UPDATE Compra SET CantidadProducto = ? , idEmpleado = ? , idCliente = ? , idProducto = ?" ;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(2,comp.getCantidadProducto());
            ps.setInt(3,comp.getIdEmpleado());
            ps.setInt(4,comp.getIdCliente());
            ps.setInt(5,comp.getIdProducto());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return resp;
    }
    
    public void eliminar(int id) {
        String sql = "delete from Compra = where idCompra" + id;
            try{
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
    
    
    }
    

    }