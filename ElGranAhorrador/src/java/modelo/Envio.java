package modelo;

public class Envio {

    private int idEnvio;
    private String direccionEnvio;
    private String telefonoContacto;
    private int idEmpleado;

    public Envio() {
    }

    public Envio(int idEnvio, String direccionEnvio, String telefonoContacto, int idEmpleado) {
        this.idEnvio = idEnvio;
        this.direccionEnvio = direccionEnvio;
        this.telefonoContacto = telefonoContacto;
        this.idEmpleado = idEmpleado;
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

}
