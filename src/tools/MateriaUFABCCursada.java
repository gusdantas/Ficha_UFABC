package tools;

/**
 * Created by hdant on 28/08/2016.
 */
public class MateriaUFABCCursada extends MateriaUFABC {
    Nota nota;
    Categoria categoria;
    public MateriaUFABCCursada(CodigoUFABC cUfabc, String no, int cr, String nt, String ca) {
        super(cUfabc, no, cr);
        this.nota = Nota.valueOf(nt);
        this.categoria = Categoria.valueOf(ca);
    }
}
