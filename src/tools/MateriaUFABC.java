package tools;

/**
 * Created by hdant on 28/08/2016.
 */
public class MateriaUFABC extends Materia {
    int teoria, pratica, individual;

    public MateriaUFABC(String co, String no, int te, int pr, int in) {
        super(co, no, (te+pr));
        this.teoria = te;
        this.pratica = pr;
        this.individual = in;
    }
}
