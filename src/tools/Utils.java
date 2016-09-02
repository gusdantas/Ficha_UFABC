package tools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hdant on 28/08/2016.
 */
public class Utils {
	public static Object[] xmlParaFicha() {
		Object[] mFicha = new Object[0];
		try {
			File fXmlFile = new File("res/ficha.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Disciplinas");
			mFicha = new Object[nList.getLength()];

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String codigo = eElement.getElementsByTagName("codigo").item(0).getTextContent();
					String nome = eElement.getElementsByTagName("disciplina").item(0).getTextContent();
					int creditos = Integer.parseInt(eElement.getElementsByTagName("creditos").item(0).getTextContent());
					String nota = eElement.getElementsByTagName("conceito").item(0).getTextContent();
					String categoria = eElement.getElementsByTagName("categoria").item(0).getTextContent();

					if (categoria.equals("Obrigatória")) {
						categoria = "Obrigatoria";
					} else if (categoria.equals("Opção Limitada")) {
						categoria = "Opcao Limitada";
					}
					categoria.replace(" ", "");

					Pattern codigoRegex = Pattern.compile("[A-Z]{3,4}[0-9]{3,4}-[0-9]{2}");
					Matcher codigoMatcher = codigoRegex.matcher(codigo);

					if (codigoMatcher.find()) {
						CodigoUFABC codigoUFABC = new CodigoUFABC(codigo);
						mFicha[temp] = new MateriaUFABCCursada(codigoUFABC, nome, creditos, nota,
								categoria.toUpperCase());
					} else {
						mFicha[temp] = new MateriaFora(codigo, nome, creditos);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mFicha;
	}
}
