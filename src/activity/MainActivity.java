package activity;

import tools.Utils;

/**
 * Created by hdant on 28/08/2016.
 */
public class MainActivity {

    public static void main(String[] args) {
        Object[] ficha = Utils.xmlParaFicha();
        for (Object aFicha:
             ficha) {
            System.out.println(aFicha.toString());
        }
    }
}
