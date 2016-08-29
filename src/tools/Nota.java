package tools;

import static tools.Situacao.*;

/**
 * Created by hdant on 28/08/2016.
 */
public enum Nota {
    A( 4, APROVADO),
    B( 3, APROVADO),
    C( 2, APROVADO),
    D( 1, APROVADO),
    E(-1, EQUIVALENCIA),
    F( 0, REPROVADO),
    I(-1, APROVADO),
    O( 0, REPROVADO),
    L(-1, APROVEITAMENTO);

    private int creditos;
    private Situacao situacao;

    Nota(int i, Situacao s) {
        this.creditos = i;
        this.situacao = s;
    }

    public int getCreditos() {
        return creditos;
    }

    public Situacao getSituacao() {
        return situacao;
    }
}
