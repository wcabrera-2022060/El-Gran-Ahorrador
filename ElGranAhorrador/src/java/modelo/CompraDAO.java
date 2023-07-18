package modelo;

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
    String sql = "Select * from compra";
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
        String sql = "insert into Compra ( idCompra, cantidadProducto, idEmpleado, idCliente, idProducto) values (?,?,?,?,?)";
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

}    
    
    

