package modelo;


public class MetodoPago {
    private int idMetodoPago;
    private String metodoPago;
    private double pagoTotal;
    private String banco;

    public MetodoPago() {
    }

    public MetodoPago(int idMetodoPago, String metodoPago, double pagoTotal, String banco) {
        this.idMetodoPago = idMetodoPago;
        this.metodoPago = metodoPago;
        this.pagoTotal = pagoTotal;
        this.banco = banco;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(double pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
}
