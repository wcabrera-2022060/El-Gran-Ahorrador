package modelo;

public class DetalleCompra {
  int idCliente;
  String nombreCliente;
  String nombreEmpleado;
  String nombreProducto;
  int cantidadProducto;

  public DetalleCompra() {
  }

  public DetalleCompra(int idCliente, String nombreCliente, String nombreEmpleado, String nombreProducto, int cantidadProducto) {
    this.idCliente = idCliente;
    this.nombreCliente = nombreCliente;
    this.nombreEmpleado = nombreEmpleado;
    this.nombreProducto = nombreProducto;
    this.cantidadProducto = cantidadProducto;
  }

  public int getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  public String getNombreCliente() {
    return nombreCliente;
  }

  public void setNombreCliente(String nombreCliente) {
    this.nombreCliente = nombreCliente;
  }

  public String getNombreEmpleado() {
    return nombreEmpleado;
  }

  public void setNombreEmpleado(String nombreEmpleado) {
    this.nombreEmpleado = nombreEmpleado;
  }

  public String getNombreProducto() {
    return nombreProducto;
  }

  public void setNombreProducto(String nombreProducto) {
    this.nombreProducto = nombreProducto;
  }

  public int getCantidadProducto() {
    return cantidadProducto;
  }

  public void setCantidadProducto(int cantidadProducto) {
    this.cantidadProducto = cantidadProducto;
  }

  
  
  
}
