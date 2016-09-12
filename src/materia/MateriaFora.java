package materia;

/**
 * Created by hdant on 28/08/2016.
 */
public class MateriaFora extends Materia {
    int periodo, ano;

	public MateriaFora(String co, String no, int cr, int pe, int an) {
		super(co, no, cr);
        this.periodo = pe;
        this.ano = an;
	}

    public int getPeriodo() {
        return periodo;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return super.toString()+" - Livre Escolha - E - "+periodo+" - "+ano;
    }
}
