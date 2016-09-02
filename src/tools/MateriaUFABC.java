package tools;

/**
 * Created by hdant on 28/08/2016.
 */
public class MateriaUFABC extends Materia {
	int ano;

	public MateriaUFABC(CodigoUFABC cUfabc, String no, int cr) {
		super(cUfabc.getCodigo(), no, cr);
		this.ano = cUfabc.getAno();
	}
}
