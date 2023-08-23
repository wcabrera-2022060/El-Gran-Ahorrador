package modelo;

import java.sql.Time;


public class Sucursal{
  private int idSucursal;
  private String nombreSucursal;
  private String direccionSucursal;
  private Time apertura;
  private Time cierre;

  public Sucursal() {
  }

  public Sucursal(int idSucursal, String nombreSucursal, String direccionSucursal, Time apertura, Time cierre) {
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

    public Time getApertura() {
        return apertura;
    }

    public void setApertura(Time apertura) {
        this.apertura = apertura;
    }

    public Time getCierre() {
        return cierre;
    }

    public void setCierre(Time cierre) {
        this.cierre = cierre;
    }

    

   
}
