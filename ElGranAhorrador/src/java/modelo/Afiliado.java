package modelo;

import java.sql.Date;


public class Afiliado {
    private int idAfiliado;
    private String rangoAfiliado;
    private String beneficios;
    private double precioRango;
    private Date fechaExpiracion;

    public Afiliado() {
    }

    public Afiliado(int idAfiliado, String rangoAfiliado, String beneficios, double precioRango, Date fechaExpiracion) {
        this.idAfiliado = idAfiliado;
        this.rangoAfiliado = rangoAfiliado;
        this.beneficios = beneficios;
        this.precioRango = precioRango;
        this.fechaExpiracion = fechaExpiracion;
    }

    public int getIdAfiliado() {
        return idAfiliado;
    }

    public void setIdAfiliado(int idAfiliado) {
        this.idAfiliado = idAfiliado;
    }

    public String getRangoAfiliado() {
        return rangoAfiliado;
    }

    public void setRangoAfiliado(String rangoAfiliado) {
        this.rangoAfiliado = rangoAfiliado;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public double getPrecioRango() {
        return precioRango;
    }

    public void setPrecioRango(double precioRango) {
        this.precioRango = precioRango;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
