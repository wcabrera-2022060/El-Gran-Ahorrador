package modelo;

import java.time.LocalTime;


public class Sucursal {
  private int idSucursal;
  private String nombreSucursal;
  private String direccionSucursal;
  private LocalTime apertura;
  private LocalTime cierre;

  public Sucursal() {
  }

  public Sucursal(int idSucursal, String nombreSucursal, String direccionSucursal, LocalTime apertura, LocalTime cierre) {
    this.idSucursal = idSucursal;
    this.nombreSucursal = nombreSucursal;
    this.direccionSucursal = direccionSucursal;
    this.apertura = apertura;
    this.cierre = cierre;
  }

  public int getIdSucursal() {
    return idSucursal;
  }

  public void setIdSucursal(int idSucursal) {
    this.idSucursal = idSucursal;
  }

  public String getNombreSucursal() {
    return nombreSucursal;
  }

  public void setNombreSucursal(String nombreSucursal) {
    this.nombreSucursal = nombreSucursal;
  }

  public String getDireccionSucursal() {
    return direccionSucursal;
  }

  public void setDireccionSucursal(String direccionSucursal) {
    this.direccionSucursal = direccionSucursal;
  }

  public LocalTime getApertura() {
    return apertura;
  }

  public void setApertura(LocalTime apertura) {
    this.apertura = apertura;
  }

  public LocalTime getCierre() {
    return cierre;
  }

  public void setCierre(LocalTime cierre) {
    this.cierre = cierre;
  }
  
  
}
