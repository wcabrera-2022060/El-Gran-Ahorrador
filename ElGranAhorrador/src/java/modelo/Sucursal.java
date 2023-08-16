package modelo;

import java.util.Date;


public class Sucursal{
  private int idSucursal;
  private String nombreSucursal;
  private String direccionSucursal;
  private Date apertura;
  private Date cierre;

  public Sucursal() {
  }

  public Sucursal(int idSucursal, String nombreSucursal, String direccionSucursal, Date apertura, Date cierre) {
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

    public Date getApertura() {
        return apertura;
    }

    public void setApertura(Date apertura) {
        this.apertura = apertura;
    }

    public Date getCierre() {
        return cierre;
    }

    public void setCierre(Date cierre) {
        this.cierre = cierre;
    }

   
}
