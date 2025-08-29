// src/infraestrutura/RepositorioJogosEmMemoria.java
package infraestrutura;

import entidades.Jogo;
import repositorios.RepositorioJogos;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RepositorioJogosEmMemoria implements RepositorioJogos {
    private final Map<String, Jogo> db = new HashMap<>();

    @Override
    public void salvar(Jogo jogo) {
        db.put(jogo.getId(), jogo);
    }

    @Override
    public Optional<Jogo> buscarPorId(String jogoId) {
        return Optional.ofNullable(db.get(jogoId));
    }
}