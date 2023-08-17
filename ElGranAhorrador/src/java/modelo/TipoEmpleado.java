package modelo;

public class TipoEmpleado {
  private int idTipoEmpleado;
  private String tipoEmpleado;
  private String descripcion;
  private String departamento;

  public TipoEmpleado() {
  }

  public TipoEmpleado(int idTipoEmpleado, String tipoEmpleado, String descripcion, String departamento) {
    this.idTipoEmpleado = idTipoEmpleado;
    this.tipoEmpleado = tipoEmpleado;
    this.descripcion = descripcion;
    this.departamento = departamento;
  }

  public int getIdTipoEmpleado() {
    return idTipoEmpleado;
  }

  public void setIdTipoEmpleado(int idTipoEmpleado) {
    this.idTipoEmpleado = idTipoEmpleado;
  }

  public String getTipoEmpleado() {
    return tipoEmpleado;
  }

  public void setTipoEmpleado(String tipoEmpleado) {
    this.tipoEmpleado = tipoEmpleado;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }
}
