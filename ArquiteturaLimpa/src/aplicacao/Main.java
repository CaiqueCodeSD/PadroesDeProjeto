// src/aplicacao/Main.java
package aplicacao;

import casos_de_uso.GerenciadorDeBiblioteca;
import entidades.Usuario;
import infraestrutura.RepositorioComprasEmMemoria;
import infraestrutura.RepositorioJogosEmMemoria;
import infraestrutura.RepositorioUsuariosEmMemoria;
import repositorios.RepositorioCompras;
import repositorios.RepositorioJogos;
import repositorios.RepositorioUsuarios;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Inicialização das dependências (Injeção de Dependência)
        RepositorioJogos repositorioJogos = new RepositorioJogosEmMemoria();
        RepositorioUsuarios repositorioUsuarios = new RepositorioUsuariosEmMemoria();
        RepositorioCompras repositorioCompras = new RepositorioComprasEmMemoria();

        // "Montagem" do caso de uso com as implementações concretas
        GerenciadorDeBiblioteca gerenciador = new GerenciadorDeBiblioteca(
            repositorioJogos,
            repositorioUsuarios,
            repositorioCompras
        );

        // --- Fluxo de uso do sistema ---

        // 1. Adicionar jogos à loja
        System.out.println(gerenciador.adicionarJogoALoja("Cyberpunk 2077", "CD Projekt Red", 199.90, "cp77"));
        System.out.println(gerenciador.adicionarJogoALoja("Elden Ring", "FromSoftware", 249.90, "er"));
        System.out.println(gerenciador.adicionarJogoALoja("Hollow Knight", "Team Cherry", 46.90, "hk"));
        System.out.println("\n--- Loja de jogos inicializada. ---\n");

        // 2. Criar um usuário
        Usuario usuario1 = new Usuario("player1", "player1@email.com");
        repositorioUsuarios.salvar(usuario1);
        System.out.println("Usuário '" + usuario1.getNomeDeUsuario() + "' registrado.");

        // 3. Comprar um jogo
        try {
            System.out.println("\n--- Comprando um jogo ---");
            System.out.println(gerenciador.comprarJogo(usuario1.getNomeDeUsuario(), "er"));
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // 4. Tentar comprar o mesmo jogo novamente
        try {
            System.out.println("\n--- Tentando comprar o mesmo jogo novamente ---");
            System.out.println(gerenciador.comprarJogo(usuario1.getNomeDeUsuario(), "er"));
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // 5. Comprar outro jogo
        try {
            System.out.println("\n--- Comprando outro jogo ---");
            System.out.println(gerenciador.comprarJogo(usuario1.getNomeDeUsuario(), "hk"));
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // 6. Listar a biblioteca do usuário
        System.out.println("\n--- Biblioteca do usuário player1 ---");
        List<String> jogosNaBiblioteca = gerenciador.listarJogosDaBiblioteca(usuario1.getNomeDeUsuario());
        System.out.println("Jogos adquiridos: " + jogosNaBiblioteca);
    }
}