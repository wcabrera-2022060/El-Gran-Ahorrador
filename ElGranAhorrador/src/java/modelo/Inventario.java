package modelo;


public class Inventario {
    private int idInventario;
    private int cantidadDisponible;
    private String direccionDisponibilidad;
    private Boolean disponibilidad;

    public Inventario() {
    }

    public Inventario(int idInventario, int cantidadDisponible, String direccionDisponibilidad, Boolean disponibilidad) {
        this.idInventario = idInventario;
        this.cantidadDisponible = cantidadDisponible;
        this.direccionDisponibilidad = direccionDisponibilidad;
        this.disponibilidad = disponibilidad;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getDireccionDisponibilidad() {
        return direccionDisponibilidad;
    }

    public void setDireccionDisponibilidad(String direccionDisponibilidad) {
        this.direccionDisponibilidad = direccionDisponibilidad;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    
}
