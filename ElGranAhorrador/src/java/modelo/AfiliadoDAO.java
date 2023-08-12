package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AfiliadoDAO {
    
    Conexion cn = new Conexion();

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    String sql;
    
    public List listarAfiliado(){
        sql = "select * from Afiliado";
        List<Afiliado> listaAfiliado = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Afiliado af = new Afiliado();
                af.setIdAfiliado(rs.getInt(1));
                af.setRangoAfiliado(rs.getString(2));
                af.setBeneficios(rs.getString(3));
                af.setPrecioRango(rs.getDouble(4));
                af.setFechaExpiracion(rs.getDate(5));
                listaAfiliado.add(af);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaAfiliado;
    }
    
    public int agregarAfiliado(Afiliado afl){
        sql = "insert into Afiliado(rangoAfiliado, beneficios, precioRango, fechaExpiracion)\n" +
                        "values (?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, afl.getRangoAfiliado());
            ps.setString(2, afl.getBeneficios());
            ps.setDouble(3, afl.getPrecioRango());
            ps.setDate(4, afl.getFechaExpiracion());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public Afiliado buscarAfiliado(int id){
        Afiliado afl = new Afiliado();
        sql = "select A.idAfiliado, \n" +
                "A.rangoAfiliado, \n" +
                "A.beneficios, \n" +
                "A.precioRango, \n" +
                "A.fechaExpiracion\n" +
                    "from Afiliado A\n" +
                    "where idAfiliado = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                afl.setRangoAfiliado(rs.getString(2));
                afl.setBeneficios(rs.getString(3));
                afl.setPrecioRango(rs.getDouble(4));
                afl.setFechaExpiracion(rs.getDate(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return afl;
    }
    
    public int actualizarAfiliado(Afiliado afl){
        sql = "Update Afiliado"
                + "set rangoAfiliado = ?,"
                + "beneficios = ?,"
                + "precioRango = ?,"
                + "fechaExpiracion = ?"
                + "where idAfiliado = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, afl.getRangoAfiliado());
            ps.setString(2, afl.getBeneficios());
            ps.setDouble(3, afl.getPrecioRango());
            ps.setDate(4, afl.getFechaExpiracion());
            ps.setInt(5, afl.getIdAfiliado());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminarAfiliado(int id){
        sql = "delete from Afiliado where idAfiliado = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
