package modelo;

import java.sql.Blob;


public class Login {
    private int idLogin;
    private String usario;
    private String contrasena;
    private boolean tipoUsuario;
    private Blob foto;

    public Login() {
    }

    public Login(int idLogin, String usario, String contrasena, boolean tipoUsuario, Blob foto) {
        this.idLogin = idLogin;
        this.usario = usario;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
        this.foto = foto;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getUsario() {
        return usario;
    }

    public void setUsario(String usario) {
        this.usario = usario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(boolean tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }
}
