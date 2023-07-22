package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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
        
      }
      
    }catch(Exception e){
      e.printStackTrace();
    }
    
    return sucursal;
   }
  
  //Listar Sucursal
  
  public List listar(){
    String sql = "select * from Sucursal";
    List<Sucursal> listaSucursal = new ArrayList<>();
    try{
      con = cn.Conexion();
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()){
        Sucursal su = new Sucursal();
        su.setIdSucursal(rs.getInt(1));
        su.setNombreSucursal(rs.getString(2));
        su.setDireccionSucursal(rs.getString(3));
        
        listaSucursal.add(su);
      }
    }catch(Exception e){
      e.printStackTrace();
    }
    
    return listaSucursal;
  }
  
  
  //Agregar Sucursal
  
  public int agregar(Sucursal sucur){
    String sql = "insert into Sucursal (nombreSucursal, direccionSucursal, apertura, cierre) values (?,?,?,?)";
    try{
      con = cn.Conexion();
      ps = con.prepareStatement(sql);
      ps.setString(1, sucur.getNombreSucursal());
      ps.setString(2, sucur.getDireccionSucursal());
      
      ps.executeUpdate();
    }catch(Exception e){
      e.printStackTrace();
    }
    
    return resp;
  }
  
  
  //Buscar por código Sucursal
  
  public Sucursal listarIdSucursal(int id){
    //instanciar un objeto de tipo Empleado
    Sucursal sucur = new Sucursal();
    String sql = "Select * from Sucursal where idSucursal = "+id;
    try{
      con = cn.Conexion();
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      while(rs.next()){
        sucur.setNombreSucursal(rs.getString(2));
        sucur.setDireccionSucursal(rs.getString(3));
        //apertura
        //cierre
      }
    }catch(Exception e){
      e.printStackTrace();
    }
    
    return sucur;
  }
  
  
  //Editar Sucursal
  
  public int actualizar(Sucursal sucur){
    String sql = "Update Sucursal set nombreSucursal = ?, direccionSucursal = ?, apertura = ?, cierre = ? where idSucursal = ?";
    try{
      con = cn.Conexion();
      ps = con.prepareStatement(sql);
      ps.setString(1, sucur.getNombreSucursal());
      ps.setString(2, sucur.getDireccionSucursal());
      //apertura
      //cierre
      ps.setInt(5, sucur.getIdSucursal());
      ps.executeUpdate();
    }catch(Exception e){
      e.printStackTrace();
    }
    
    return resp;
  }
  
  
  //Método Eliminar
  
  public void eliminar(int id){
    String sql = "delete from Sucursal where idSucursal = "+id;
    try{
      con = cn.Conexion();
      ps = con.prepareStatement(sql);
      ps.executeUpdate();
    }catch(Exception e){
      e.printStackTrace();
    }
    
  }
  
  
}
