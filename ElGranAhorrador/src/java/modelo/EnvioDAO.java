package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnvioDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List<Envio> listarEnvio() {
        String sql = "SELECT * FROM Envio";
        List<Envio> listaEnvio = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Envio En = new Envio();
                En.setIdEnvio(rs.getInt(1));
                En.setDireccionEnvio(rs.getString(2));
                En.setTelefonoContacto(rs.getString(3));
                En.setIdEmpleado(rs.getInt(4));
                listaEnvio.add(En);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaEnvio;
    }

    public int agregarEnvio(Envio En) {
        try {
            String sql = "INSERT INTO Envio (direccionEnvio, telefonoContacto, idEmpleado) VALUES (?, ?, ?)";
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, En.getIdEnvio());
            ps.setString(2, En.getDireccionEnvio());
            ps.setString(3, En.getTelefonoContacto());
            ps.setInt(4, En.getIdEmpleado());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resp;
    }

    public Envio listarCodigoEnvio(int id) {

        Envio En = new Envio();
        String sql = "SELECT * FROM Envio WHERE idEnvio = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                En.setIdEnvio(rs.getInt(1));
                En.setDireccionEnvio(rs.getString(2));
                En.setTelefonoContacto(rs.getString(3));
                En.setIdEmpleado(rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return En;
    }

    public int actualizarEnvio(Envio En) {
        String sql = "UPDATE Envio SET direccionEnvio = ?, telefonoContacto = ? where idEnvio = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, En.getDireccionEnvio());
            ps.setString(2, En.getTelefonoContacto());
            ps.setInt(3, En.getIdEnvio());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resp;
    }

    public void eliminarEnvio(int id) {
        String sql = "DELETE FROM Envio WHERE idEnvio = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
