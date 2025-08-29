// src/entidades/Jogo.java
package entidades;

public class Jogo {
    private String titulo;
    private String desenvolvedora;
    private double preco;
    private String id;

    public Jogo(String titulo, String desenvolvedora, double preco, String id) {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço do jogo não pode ser negativo.");
        }
        this.titulo = titulo;
        this.desenvolvedora = desenvolvedora;
        this.preco = preco;
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public double getPreco() {
        return preco;
    }

    public String getId() {
        return id;
    }
}