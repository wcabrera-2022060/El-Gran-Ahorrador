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

    public List<Sucursal> listarSucursal() {
        String sql = "SELECT * FROM Sucursales";
        List<Sucursal> listaSucursal = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sucursal Su = new Sucursal();
                Su.setIdSucursal(rs.getInt(1));
                Su.setNombreSucursal(rs.getString(2));
                Su.setDireccionSucursal(rs.getString(3));
                Su.setApertura(rs.getTime(4));
                Su.setCierre(rs.getTime(5));
                listaSucursal.add(Su);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaSucursal;
    }

    public int agregarSucursal(Sucursal Su) {
        try {
            String sql = "INSERT INTO Sucursales (nombreSucursal, direccionSucursal, apertura, cierre) VALUES (?, ?, ?, ?)";
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Su.getNombreSucursal());
            ps.setString(2, Su.getDireccionSucursal());
            ps.setTime(3, Su.getApertura());
            ps.setTime(4, Su.getCierre());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resp;
    }

    public Sucursal listarCodigoSucursal(int id) {

        Sucursal Su = new Sucursal();
        String sql = "SELECT * FROM Sucursales WHERE idSucursal = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Su.setIdSucursal(rs.getInt(1));
                Su.setNombreSucursal(rs.getString(2));
                Su.setDireccionSucursal(rs.getString(3));
                Su.setApertura(rs.getTime(4));
                Su.setCierre(rs.getTime(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Su;
    }

    public int actualizarSucursal(Sucursal Su) {
        String sql = "UPDATE Sucursales SET nombreSucursal = ?, direccionSucursal = ?, apertura = ?, cierre = ? where idSucursal = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Su.getNombreSucursal());
            ps.setString(2, Su.getDireccionSucursal());
            ps.setTime(3, Su.getApertura());
            ps.setTime(4, Su.getCierre());
            ps.setInt(5, Su.getIdSucursal());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resp;
    }

    public void eliminarSucursal(int id) {
        String sql = "DELETE FROM Sucursales WHERE idSucursal = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
