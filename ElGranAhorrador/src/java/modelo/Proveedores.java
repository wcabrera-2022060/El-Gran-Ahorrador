package modelo;

public class Proveedores {
    private int idProveedor;
    private String proveedor;
    private int cantidadAdquirida;
    private double totalPagar;
    private int idProducto;

    public Proveedores() {
    }

    public Proveedores(int idProveedor, String proveedor, int cantidadAdquirida, double totalPagar, int idProducto) {
        this.idProveedor = idProveedor;
        this.proveedor = proveedor;
        this.cantidadAdquirida = cantidadAdquirida;
        this.totalPagar = totalPagar;
        this.idProducto = idProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getCantidadAdquirida() {
        return cantidadAdquirida;
    }

    public void setCantidadAdquirida(int cantidadAdquirida) {
        this.cantidadAdquirida = cantidadAdquirida;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    
    
}
