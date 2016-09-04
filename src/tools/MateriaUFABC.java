package tools;

/**
 * Created by hdant on 28/08/2016.
 */
public class MateriaUFABC extends Materia {
	CodigoUFABC codigoUfabc;

	public MateriaUFABC(CodigoUFABC cUfabc, String no, int cr) {
		super(cUfabc.toString(), no, cr);
		this.codigoUfabc = cUfabc;
	}

    public CodigoUFABC getCodigoUfabc() {
        return codigoUfabc;
    }
}
