package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipoEmpleadoDAO {
  Conexion cn = new Conexion();
  Connection con;
  PreparedStatement ps;
  ResultSet rs;
  int resp;

  //Método Listar
  public List<TipoEmpleado> listar() {
    String sql = "SELECT * FROM TipoEmpleado";
    List<TipoEmpleado> listaTipoEmpleado = new ArrayList<>();
    try {
      con = cn.Conexion();
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        TipoEmpleado TEm = new TipoEmpleado();
        TEm.setIdTipoEmpleado(rs.getInt(1));
        TEm.setTipoEmpleado(rs.getString(2));
        TEm.setDescripcion(rs.getString(3));
        TEm.setDepartamento(rs.getString(4));
        listaTipoEmpleado.add(TEm);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return listaTipoEmpleado;
  }

  //Método Agregar
  public int agregar(TipoEmpleado TEm) {
    try {
      String sql = "INSERT INTO TipoEmpleado (idTipoEmpleado, tipoEmpleado, descripcion, departamento) VALUES (?, ?, ?, ?)";
      con = cn.Conexion();
      ps = con.prepareStatement(sql);
      ps.setInt(1, TEm.getIdTipoEmpleado());
      ps.setString(2, TEm.getTipoEmpleado());
      ps.setString(3, TEm.getDescripcion());
      ps.setString(4, TEm.getDepartamento());
      ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return resp;
  }

  //Método Método buscar por código
  public TipoEmpleado listarCodigoEmpleado(int id) {
    //instanciar un objeto de tipo TipoEmpleado
    TipoEmpleado TEm = new TipoEmpleado();
    String sql = "SELECT * FROM TipoEmpleado WHERE idTipoEmpleado = " + id;
    try {
      con = cn.Conexion();
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        TEm.setIdTipoEmpleado(rs.getInt(1));
        TEm.setTipoEmpleado(rs.getString(2));
        TEm.setDescripcion(rs.getString(3));
        TEm.setDepartamento(rs.getString(4));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return TEm;
  }

  //Método Editar
  public int actualizar(TipoEmpleado TEm) {
    String sql = "UPDATE TipoEmpleado SET tipoEmpleado = ?, descripcion = ?, departamento = ? where idTipoEmpleado = ?";
    try {
      con = cn.Conexion();
      ps = con.prepareStatement(sql);
      ps.setInt(1, TEm.getIdTipoEmpleado());
      ps.setString(2, TEm.getTipoEmpleado());
      ps.setString(3, TEm.getDescripcion());
      ps.setString(4, TEm.getDepartamento());
      ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return resp;
  }

  //Método Eliminar
  public void eliminar(int id) {
    String sql = "DELETE FROM TipoEmpleado WHERE idTipoEmpleado = " + id;
    try {
      con = cn.Conexion();
      ps = con.prepareStatement(sql);
      ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
