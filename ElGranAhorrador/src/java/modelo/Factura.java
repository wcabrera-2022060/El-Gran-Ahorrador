
package modelo;

import java.sql.Date;


public class Factura {
    private int idFactura;
    private Date fecha;
    private int idCompra;
    private int idEnvio;
    private int idMetodoPago;
    private int idCupon;

    public Factura() {
    }

    public Factura(int idFactura, Date fecha, int idCompra, int idEnvio, int idMetodoPago, int idCupon) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.idCompra = idCompra;
        this.idEnvio = idEnvio;
        this.idMetodoPago = idMetodoPago;
        this.idCupon = idCupon;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public int getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(int idCupon) {
        this.idCupon = idCupon;
    }
}
    
        