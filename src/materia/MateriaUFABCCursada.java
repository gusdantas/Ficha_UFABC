package materia;

import catalogo.Categoria;
import tools.CodigoUFABC;
import tools.Nota;

/**
 * Created by hdant on 28/08/2016.
 */
public class MateriaUFABCCursada extends MateriaUFABC {
	Nota nota;
	Categoria categoria;
    int periodo, ano;

	public MateriaUFABCCursada(CodigoUFABC cUfabc, String no, int cr, String nt, String ca, int pe, int an) {
		super(cUfabc, no, cr);
		this.nota = Nota.valueOf(nt);
		this.categoria = Categoria.valueOf(ca);
        this.periodo = pe;
        this.ano = an;
	}

    public Nota getNota() {
        return nota;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getPeriodo() {
        return periodo;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return super.toString()+" - "+categoria.getCategoria()+" - "+nota+" - "+periodo+" - "+ano;
    }
}
