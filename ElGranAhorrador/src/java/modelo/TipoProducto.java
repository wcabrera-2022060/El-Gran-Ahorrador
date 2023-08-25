/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author weslly
 */
public class TipoProducto {
    private int idTipoProducto;
    private String tipoProducto;
    private String descripcion;
    private String categoria;

    public TipoProducto() {
        
    }

    public TipoProducto(int idTipoProducto, String tipoProducto, String descripcion, String categoria) {
        this.idTipoProducto = idTipoProducto;
        this.tipoProducto = tipoProducto;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
   
    
}
