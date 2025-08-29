// src/entidades/Compra.java
package entidades;

public class Compra {
    private String usuarioId;
    private String jogoId;
    private double valorPago;

    public Compra(String usuarioId, String jogoId, double valorPago) {
        this.usuarioId = usuarioId;
        this.jogoId = jogoId;
        this.valorPago = valorPago;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public String getJogoId() {
        return jogoId;
    }

    public double getValorPago() {
        return valorPago;
    }
}