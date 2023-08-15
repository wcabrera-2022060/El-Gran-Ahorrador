package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class LoginDAO {
    
    Conexion cn = new Conexion();
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    String sql;

    public LoginDAO() {
    }
    
    public Login validarLogin(String usuario, String contrasena){
        Login login = new Login();
        sql = "select L.idLogin, \n" +
                "L.usuario, \n" +
                "L.contrasena, \n" +
                "L.tipoUsuario, \n" +
                "L.foto \n" +
                "from Login L where usuario = ? and contrasena = ?";
        try{
           con = cn.Conexion();
           ps = con.prepareCall(sql);
           ps.setString(1, usuario);
           ps.setString(2, contrasena);
           rs = ps.executeQuery();
            while (rs.next()) {
                login.setIdLogin(rs.getInt(1));
                login.setUsuario(rs.getString(2));
                login.setContrasena(rs.getString(3));
                login.setTipoUsuario(rs.getBoolean(4));
                login.setFoto(rs.getBlob(5));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return login;
    }
    
    public List listarLogin(){
        sql = "select idLogin, \n" +
                "L.usuario, \n" +
                "L.contrasena, \n" +
                "L.tipoUsuario, \n" +
                "L.foto \n" +
                    "from Login L;";
        List<Login> listaLogin = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Login lg = new Login();
                lg.setIdLogin(rs.getInt(1));
                lg.setUsuario(rs.getString(2));
                lg.setContrasena(rs.getString(3));
                lg.setTipoUsuario(rs.getBoolean(4));
                lg.setFoto(rs.getBlob(5));
                listaLogin.add(lg);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaLogin;
    }
    
    public int agregarLogin(Login log){
        sql = "insert into Login(usuario, contrasena, tipoUsuario, foto) "
                + "values (?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, log.getUsuario());
            ps.setString(2, log.getContrasena());
            ps.setBoolean(3, log.getTipoUsuario());
            ps.setBlob(4, log.getFoto());
            ps.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public Login buscarLogin(int id){
        Login log = new Login();
        sql = "select idLogin, \n" +
                "L.usuario, \n" +
                "L.contrasena, \n" +
                "L.tipoUsuario, \n" +
                "L.foto \n" +
                    "from Login L " +
                        "where L.idLogin = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                log.setUsuario(rs.getString(2));
                log.setContrasena(rs.getString(3));
                log.setTipoUsuario(rs.getBoolean(4));
                log.setFoto(rs.getBlob(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return log;
    }
    
    public int actualizarLogin(Login log){
        sql = "Update Login"
                + "set usuario = ?,"
                + "contrasena = ?,"
                + "tipoUsuario = ?,"
                + "foto = ?,"
                + "where idLogin = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, log.getUsuario());
            ps.setString(2, log.getContrasena());
            ps.setBoolean(3, log.getTipoUsuario());
            ps.setBlob(4, log.getFoto());
            ps.setInt(5, log.getIdLogin());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
     public void eliminarLogin(int id){
        sql = "delete from Login where codigoEmpleado = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
