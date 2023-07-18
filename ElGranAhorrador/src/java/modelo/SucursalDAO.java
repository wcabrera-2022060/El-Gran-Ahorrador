package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;


public class SucursalDAO {
  Conexion cn = new Conexion();
  Connection con;
  PreparedStatement ps;
  ResultSet rs;
  int resp;
  
  public Sucursal validar(String idSucursal){
    Sucursal sucursal = new Sucursal();
    String sql = "select * from Sucursal where idSucursal = ?";
    try{
      con = cn.Conexion();
      ps = con.prepareStatement(sql);
      ps.setString(1, idSucursal);
      rs = ps.executeQuery();
      while(rs.next()){
        sucursal.setIdSucursal(rs.getInt("idSucursal"));
        sucursal.setNombreSucursal(rs.getString("nombreSucursal"));
        sucursal.setDireccionSucursal(rs.getString("direccionSucursal"));
        //sucursal.setApertura(rs.getLocalTime("apertura"));
        //LocalTime.parse(sucursal.setCierre(rs.getTime("cierre")));
      }
      
    }catch(Exception e){
      e.printStackTrace();
    }
    
    return sucursal;
   }
  
  //Agregar Sucursal
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
