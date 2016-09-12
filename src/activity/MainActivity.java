package activity;

import materia.MateriaUFABC;
import materia.MateriaUFABCProjeto;
import tools.Utils;

/**
 * Created by hdant on 28/08/2016.
 */
public class MainActivity {

	public static void main(String[] args) {
		Object[] ficha = Utils.xmlParaFicha();
		MateriaUFABC[] cat12 = Utils.xmlParaCatalogo(12);
		MateriaUFABC[] cat16 = Utils.xmlParaCatalogo(16);
		MateriaUFABCProjeto[] ei13 = Utils.xmlParaProjeto("ei13");
		MateriaUFABCProjeto[] ei17 = Utils.xmlParaProjeto("ei17");
		
		/*for (Object aFicha : ficha) {
			System.out.println(aFicha.toString());
		}*/
	}
}
