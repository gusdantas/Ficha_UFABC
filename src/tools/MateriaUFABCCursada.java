package tools;

/**
 * Created by hdant on 28/08/2016.
 */
public class MateriaUFABCCursada extends MateriaUFABC {
    Nota nota;
    Categoria categoria;
    public MateriaUFABCCursada(String co, String no, int te, int pr, int in, String n, String c) {
        super(co, no, te, pr, in);
        this.nota = Nota.valueOf(n);
        this.categoria = Categoria.valueOf(c);
    }
}
