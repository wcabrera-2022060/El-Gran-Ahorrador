package modelo;

import java.sql.Date;


public class Carrito {
    private int idCarrito;
    private int item;
    private int idCliente;
    private int idEmpleado;
    private int idProducto;
    private int cantidad;
    private String nombreProducto;
    private Date fechaVencimiento;
    private double precioProducto;
    private double subTotal;
    private Double totalPagar;

    public Carrito() {
    }

    public Carrito(int idCarrito, int item, int idCliente, int idEmpleado, int idProducto, int cantidad, String nombreProducto, Date fechaVencimiento, double precioProducto, double subTotal, Double totalPagar) {
        this.idCarrito = idCarrito;
        this.item = item;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.nombreProducto = nombreProducto;
        this.fechaVencimiento = fechaVencimiento;
        this.precioProducto = precioProducto;
        this.subTotal = subTotal;
        this.totalPagar = totalPagar;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }
    
    

    
    
    
    
}