// src/entidades/Usuario.java
package entidades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nomeDeUsuario;
    private String email;
    private List<String> jogosAdquiridos;

    public Usuario(String nomeDeUsuario, String email) {
        if (nomeDeUsuario == null || nomeDeUsuario.trim().isEmpty() || email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome de usuário e e-mail são obrigatórios.");
        }
        this.nomeDeUsuario = nomeDeUsuario;
        this.email = email;
        this.jogosAdquiridos = new ArrayList<>();
    }

    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getJogosAdquiridos() {
        return jogosAdquiridos;
    }

    public void adicionarJogo(String jogoId) {
        if (!jogosAdquiridos.contains(jogoId)) {
            jogosAdquiridos.add(jogoId);
        }
    }
}