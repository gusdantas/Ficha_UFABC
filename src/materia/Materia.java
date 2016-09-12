package materia;

/**
 * Created by hdant on 28/08/2016.
 */
public abstract class Materia {
	String codigo, nome;
	int creditos;

	public Materia(String co, String no, int cr) {
		this.codigo = co;
		this.nome = no;
		this.creditos = cr;
	}

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCreditos() {
        return creditos;
    }

    @Override
    public String toString() {
        return codigo+" - "+nome+" - "+creditos;
    }
}
