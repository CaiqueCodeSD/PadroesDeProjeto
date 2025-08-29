// src/casos_de_uso/GerenciadorDeBiblioteca.java
package casos_de_uso;

import entidades.Compra;
import entidades.Jogo;
import entidades.Usuario;
import repositorios.RepositorioCompras;
import repositorios.RepositorioJogos;
import repositorios.RepositorioUsuarios;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GerenciadorDeBiblioteca {
    private final RepositorioJogos repositorioJogos;
    private final RepositorioUsuarios repositorioUsuarios;
    private final RepositorioCompras repositorioCompras;

    public GerenciadorDeBiblioteca(RepositorioJogos repositorioJogos, RepositorioUsuarios repositorioUsuarios, RepositorioCompras repositorioCompras) {
        this.repositorioJogos = repositorioJogos;
        this.repositorioUsuarios = repositorioUsuarios;
        this.repositorioCompras = repositorioCompras;
    }

    public String adicionarJogoALoja(String titulo, String desenvolvedora, double preco, String jogoId) {
        Jogo novoJogo = new Jogo(titulo, desenvolvedora, preco, jogoId);
        repositorioJogos.salvar(novoJogo);
        return "Jogo '" + novoJogo.getTitulo() + "' adicionado à loja.";
    }

    public String comprarJogo(String usuarioId, String jogoId) {
        Optional<Usuario> usuarioOpt = repositorioUsuarios.buscarPorId(usuarioId);
        Optional<Jogo> jogoOpt = repositorioJogos.buscarPorId(jogoId);

        if (!usuarioOpt.isPresent()) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        if (!jogoOpt.isPresent()) {
            throw new IllegalArgumentException("Jogo não encontrado.");
        }

        Usuario usuario = usuarioOpt.get();
        Jogo jogo = jogoOpt.get();

        if (usuario.getJogosAdquiridos().contains(jogo.getId())) {
            throw new IllegalStateException("Usuário já possui este jogo.");
        }

        Compra novaCompra = new Compra(usuarioId, jogo.getId(), jogo.getPreco());
        repositorioCompras.salvar(novaCompra);

        usuario.adicionarJogo(jogo.getId());
        repositorioUsuarios.salvar(usuario);

        return "Compra de '" + jogo.getTitulo() + "' efetuada com sucesso para o usuário " + usuario.getNomeDeUsuario() + ".";
    }

    public List<String> listarJogosDaBiblioteca(String usuarioId) {
        Optional<Usuario> usuarioOpt = repositorioUsuarios.buscarPorId(usuarioId);
        if (!usuarioOpt.isPresent()) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }

        Usuario usuario = usuarioOpt.get();
        return usuario.getJogosAdquiridos().stream()
                .map(repositorioJogos::buscarPorId)
                .filter(Optional::isPresent)
                .map(jogoOpt -> jogoOpt.get().getTitulo())
                .collect(Collectors.toList());
    }
}