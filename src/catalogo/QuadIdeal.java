package catalogo;

import materia.MateriaUFABC;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gustavo on 04/09/2016.
 */
public class QuadIdeal {
    List<MateriaUFABC> quadIdeal = new ArrayList<>();
    int periodo, ano;

    public QuadIdeal(int pe, int an){
        this.periodo = pe;
        this.ano = an;
    }

    public void adicionaMateria(MateriaUFABC materiaUFABC){
        quadIdeal.add(materiaUFABC);
    }

    public int getSize(){
        return quadIdeal.size();
    }

    public MateriaUFABC getMateria(int pos){
        return quadIdeal.get(pos);
    }
}
