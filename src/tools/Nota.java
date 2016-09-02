package tools;

import static tools.Situacao.*;

/**
 * Created by hdant on 28/08/2016.
 */
public enum Nota {
	A(4, APROVADO, true), B(3, APROVADO, true), C(2, APROVADO, true), D(1, APROVADO, true), E(-1, EQUIVALENCIA,
			true), F(0, REPROVADO, false), I(-1, CURSANDO, false), O(0, REPROVADO, false), L(-1, APROVEITAMENTO, true);

	private int creditos;
	private Situacao situacao;
	private boolean passou;

	Nota(int i, Situacao s, boolean p) {
		this.creditos = i;
		this.situacao = s;
		this.passou = p;
	}

	public int getCreditos() {
		return creditos;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public boolean getPassou() {
		return passou;
	}
}
