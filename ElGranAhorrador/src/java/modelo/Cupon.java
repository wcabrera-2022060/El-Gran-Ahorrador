package modelo;

import java.sql.Date;


public class Cupon {
    private int idCupon;
    private Date fechaCaducidad;
    private double descuento;
    private boolean validez;

    public Cupon() {
    }

    public Cupon(int idCupon, Date fechaCaducidad, double descuento, boolean validez) {
        this.idCupon = idCupon;
        this.fechaCaducidad = fechaCaducidad;
        this.descuento = descuento;
        this.validez = validez;
    }

    public int getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(int idCupon) {
        this.idCupon = idCupon;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public boolean getValidez() {
        return validez;
    }

    public void setValidez(boolean validez) {
        this.validez = validez;
    }

        
}
