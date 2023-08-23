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

public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    //Método Listar Empleados
    public List listarEmpleados() {
        String sql = "Select * from Empleados";
        List<Empleado> listarEmpleados = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado empleados = new Empleado();
                empleados.setIdEmpleado(rs.getInt(1));
                empleados.setNombreEmpleado(rs.getString(2));
                empleados.setApellidoEmpleado(rs.getString(3));
                empleados.setSueldo(rs.getDouble(4));
                empleados.setIdTipoEmpleado(rs.getInt(5));
                empleados.setIdSucursal(rs.getInt(6));
                listarEmpleados.add(empleados);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listarEmpleados;

    }

    //Método Agregar Empleado
public int agregar(Empleado empleados) {
        String sql = "Insert into Empleados(nombreEmpleado, apellidoEmpleado, sueldo, idTipoEmpleado, idSucursal) values('?','?','?',1,1)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, empleados.getNombreEmpleado());
            ps.setString(2, empleados.getApellidoEmpleado());
            ps.setDouble(3, empleados.getSueldo());
            ps.setInt(4, empleados.getIdTipoEmpleado());
            ps.setInt(5, empleados.getIdSucursal());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;

    }

    //Método Buscar por codigoEmpleado
    public Empleado listarIdEmpleado(int id) {
        Empleado empleados = new Empleado();
        String sql = "Select * from Empleados where idEmpleado =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                empleados.setIdEmpleado(rs.getInt(1));
                empleados.setNombreEmpleado(rs.getString(2));
                empleados.setApellidoEmpleado(rs.getString(3));
                empleados.setSueldo(rs.getDouble(4));
                empleados.setIdTipoEmpleado(rs.getInt(5));
                empleados.setIdSucursal(rs.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleados;
    }

    //Método Editar Factura
    public int actualizar(Empleado empleados) {
        String sql = "Update Empleados set nombreEmpleado=?, apellidoEmpleado=?, sueldo=? where idEmpleado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, empleados.getNombreEmpleado());
            ps.setString(2, empleados.getApellidoEmpleado());
            ps.setDouble(3, empleados.getSueldo());
            ps.setInt(4, empleados.getIdTipoEmpleado());
            ps.setInt(5, empleados.getIdSucursal());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
      public void eliminar(int id){
        String sql = "delete from Empleados where idEmpleado = " + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
