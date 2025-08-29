// src/repositorios/RepositorioCompras.java
package repositorios;

import entidades.Compra;

public interface RepositorioCompras {
    void salvar(Compra compra); // <-- Adicione esta linha
}