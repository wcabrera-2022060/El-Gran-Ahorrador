/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author weslly
 */
public class TipoProductoDAO {
    Conexion cn = new Conexion();
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
    //Método Listar TipoProducto
    public List listarTipoProducto(){
        String sql = "select T.idTipoProducto, T.tipoProducto, T.descripcion, T.categoria from TipoProducto T";
        List<TipoProducto> listaTipoProducto = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                TipoProducto tp = new TipoProducto();
                tp.setIdTipoProducto(rs.getInt(1));
                tp.setTipoProducto(rs.getString(2));
                tp.setDescripcion(rs.getString(3));
                tp.setCategoria(rs.getString(4));
                listaTipoProducto.add(tp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaTipoProducto;
    }
    
    //Método Buscar TipoProducto
    public TipoProducto buscarTipoProducto(int id){
        TipoProducto tp = new TipoProducto();
        String sql = "select T.idTipoProducto, T.tipoProducto, T.descripcion, T.categoria from TipoProducto T where T.idTipoProducto = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                tp.setIdTipoProducto(rs.getInt(1));
                tp.setTipoProducto(rs.getString(2));
                tp.setDescripcion(rs.getString(3));
                tp.setCategoria(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tp;
    }
    
    //Método agregar TipoProducto
    public int agregarTipoProducto(TipoProducto tp){
        String sql = "Insert into TipoProducto(tipoProducto, descripcion, categoria)\n" +
                    "values (?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tp.getTipoProducto());
            ps.setString(2, tp.getDescripcion());
            ps.setString(3, tp.getCategoria());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    //Método Editar TipoProducto
    public int actualizar(TipoProducto tp){
        String sql = "update TipoProducto T"
                + "set T.tipoProducto = ?,"
                + "T.descripcion = ?,"
                + "T.categoria = ?,"
                + "where T.idTipoProducto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tp.getTipoProducto());
            ps.setString(2, tp.getDescripcion());
            ps.setString(3, tp.getCategoria());
            ps.setInt(4, tp.getIdTipoProducto());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    //Método Eliminar TipoProducto
    public void eliminarTipoProducto(int id){
        String sql = "delete from TipoProducto where idTipoProducto = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
