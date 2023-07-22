package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    Conexion cn = new Conexion();
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public Cliente validar(int idCliente, String nombreCliente){
        Cliente cliente = new Cliente();
        String sql = "select*from Clientes where idCliente = ? and nombreCliente = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ps.setString(2, nombreCliente);
            rs = ps.executeQuery();
            while (rs.next()){
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombreCliente(rs.getString("nombreCliente"));
                cliente.setApellidoCliente(rs.getString("apellidoCliente"));
                cliente.setTelefonoCliente(rs.getString("telefonoCliente"));
                cliente.setDireccionCliente(rs.getString("direccionCliente"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return cliente;
    }
    
    public List listar(){
        String sql = "Select"
                + "C.idCliente,"
                + "C.nombreCliente,"
                + "C.apellidoCliente,"
                + "C.telefonoCliente,"
                + "C.direccionCliente,"
                + "C.idLogin, "
                + "C.idAfiliado"
                + "from Clientes C";
        List<Cliente> listaClientes = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setIdCliente(rs.getInt(1));
                cl.setNombreCliente(rs.getString(2));
                cl.setApellidoCliente(rs.getString(3));
                cl.setTelefonoCliente(rs.getString(4));
                cl.setDireccionCliente(rs.getString(5));
                cl.setIdLogin(rs.getInt(6));
                cl.setIdAfiliado(rs.getInt(7));
                listaClientes.add(cl);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaClientes;
    }
    
    public int agregar(Cliente cl){
        String sql = "Insert into Clientes (nombreCliente, apellidoCliente"
                + "telefonoCliente, direccionCliente, idLogin, idAfiliado)"
                + "values(?,?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNombreCliente());
            ps.setString(2, cl.getApellidoCliente());
            ps.setString(3, cl.getTelefonoCliente());
            ps.setString(4, cl.getDireccionCliente());
            ps.setInt(5, cl.getIdLogin());
            ps.setInt(6, cl.getIdAfiliado());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    public Cliente listarCodigoCliente(int id){
        Cliente cl = new Cliente();
        String sql = "Select"
                + "C.idCliente,"
                + "C.nombreCliente,"
                + "C.apellidoCliente,"
                + "C.telefonoCliente,"
                + "C.direccionCliente,"
                + "C.idLogin, "
                + "C.idAfiliado"
                + "from Clientes C where C.idCliente = " + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                cl.setNombreCliente(rs.getString(2));
                cl.setApellidoCliente(rs.getString(3));
                cl.setTelefonoCliente(rs.getString(4));
                cl.setDireccionCliente(rs.getString(5));
                cl.setIdLogin(rs.getInt(6));
                cl.setIdAfiliado(rs.getInt(7));
            }
                        
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return cl;
    }
    
    public int actualizar (Cliente cl){
        String sql = "Update Cliente" 
                +"set nombreCliente = ?,"
                +"apellidoCliente = ?,"
                +"telefonoCliente = ?,"
                +"direccionCliente = ?,";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNombreCliente());
            ps.setString(2, cl.getApellidoCliente());
            ps.setString(3, cl.getTelefonoCliente());
            ps.setString(4, cl.getTelefonoCliente());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(int id){
        String sql = "Delete from Clientes where idCliente = " + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }   
}
