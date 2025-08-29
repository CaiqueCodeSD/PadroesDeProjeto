// src/infraestrutura/RepositorioComprasEmMemoria.java
package infraestrutura;

import entidades.Compra;
import repositorios.RepositorioCompras;
import java.util.ArrayList;
import java.util.List;

public class RepositorioComprasEmMemoria implements RepositorioCompras {
    private final List<Compra> db = new ArrayList<>();

    @Override
    public void salvar(Compra compra) {
        db.add(compra);
    }
}