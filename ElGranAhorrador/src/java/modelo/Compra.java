package modelo;

// idCompra , cantidadProducto, idEmpleado, idCliente, idProducto

public class Compra {
    private int idCompra;
    private int cantidadProducto;
    private int idEmpleado;
    private int idCliente;
    private int idProducto;

    public Compra() {
    }

public Compra(int idCompra, int cantidadProducto, int idEmpleado, int idCliente, int idProducto){
    this.idCompra = idCompra;
    this.cantidadProducto = cantidadProducto;
    this.idEmpleado = idEmpleado;
    this.idCliente = idCliente;
    this.idProducto = idProducto;
}

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    
}
