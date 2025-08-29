// src/repositorios/RepositorioUsuarios.java
package repositorios;

import entidades.Usuario;
import java.util.Optional;

public interface RepositorioUsuarios {
    void salvar(Usuario usuario);
    Optional<Usuario> buscarPorId(String usuarioId);
}