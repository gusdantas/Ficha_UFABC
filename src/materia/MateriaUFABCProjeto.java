package materia;

import catalogo.Categoria;
import tools.CodigoUFABC;

/**
 * Created by hdant on 11/09/2016.
 */
public class MateriaUFABCProjeto extends MateriaUFABC {
    Categoria categoria;

    public MateriaUFABCProjeto(CodigoUFABC cUfabc, String no, int cr, Categoria ca) {
        super(cUfabc, no, cr);
        this.categoria = ca;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
