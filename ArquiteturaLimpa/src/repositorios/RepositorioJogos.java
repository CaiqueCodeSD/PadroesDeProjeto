// src/repositorios/RepositorioJogos.java
package repositorios;

import entidades.Jogo;
import java.util.Optional;

public interface RepositorioJogos {
    void salvar(Jogo jogo);
    Optional<Jogo> buscarPorId(String jogoId);
}