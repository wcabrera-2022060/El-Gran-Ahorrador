package modelo;

import modelo.DetalleCompra;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetalleCompraDAO {

  Conexion cn = new Conexion();
  Connection con;
  PreparedStatement ps;
  ResultSet rs;
  int resp;

  public List<DetalleCompra> historialCompras(int id) {
    String sql = "call obtenerDatosCompra(" + id + ")";
    List<DetalleCompra> datos = new ArrayList<>();

    try {
      con = cn.Conexion();
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()) {
        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setIdCliente(rs.getInt(1));
        detalleCompra.setNombreCliente(rs.getString(2));
        detalleCompra.setNombreEmpleado(rs.getString(3));
        detalleCompra.setNombreProducto(rs.getString(4));
        detalleCompra.setCantidadProducto(rs.getInt(5));
        datos.add(detalleCompra);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return datos;
  }
  
  public List<DetalleCompra> todoHistorialCompras() {
    String sql = "call obtenerTodosDatosCompra()";
    List<DetalleCompra> datos = new ArrayList<>();

    try {
      con = cn.Conexion();
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()) {
        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setIdCliente(rs.getInt(1));
        detalleCompra.setNombreCliente(rs.getString(2));
        detalleCompra.setNombreEmpleado(rs.getString(3));
        detalleCompra.setNombreProducto(rs.getString(4));
        detalleCompra.setCantidadProducto(rs.getInt(5));
        datos.add(detalleCompra);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return datos;
  }
}
