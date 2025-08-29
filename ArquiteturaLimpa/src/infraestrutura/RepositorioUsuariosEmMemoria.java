// src/infraestrutura/RepositorioUsuariosEmMemoria.java
package infraestrutura;

import entidades.Usuario;
import repositorios.RepositorioUsuarios;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RepositorioUsuariosEmMemoria implements RepositorioUsuarios {
    private final Map<String, Usuario> db = new HashMap<>();

    @Override
    public void salvar(Usuario usuario) {
        db.put(usuario.getNomeDeUsuario(), usuario);
    }

    @Override
    public Optional<Usuario> buscarPorId(String usuarioId) {
        return Optional.ofNullable(db.get(usuarioId));
    }
}