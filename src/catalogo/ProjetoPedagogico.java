package catalogo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gustavo on 04/09/2016.
 */
public class ProjetoPedagogico {
    List<QuadIdeal> projetoPed = new ArrayList<>();
    String nomeDoCurso;
    int ano;

    public ProjetoPedagogico(String no, int an){
        this.nomeDoCurso = no;
        this.ano = an;
    }

    public String getNomeDoCurso(){
        return nomeDoCurso;
    }

    public int getAno(){
        return ano;
    }

    public void adicionaQuad(QuadIdeal quadIdeal){
        projetoPed.add(quadIdeal);
    }
}
