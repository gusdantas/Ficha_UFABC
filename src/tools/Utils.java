package tools;

import catalogo.Categoria;
import materia.MateriaFora;
import materia.MateriaUFABC;
import materia.MateriaUFABCCursada;
import materia.MateriaUFABCProjeto;
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
			NodeList nList = doc.getElementsByTagName("Disciplina");
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
                    int periodo = Integer.parseInt(eElement.getElementsByTagName("periodo").item(0).getTextContent());
                    int ano = Integer.parseInt(eElement.getElementsByTagName("ano").item(0).getTextContent());


                    switch (categoria) {
                        case "ObrigatÃ³ria":
                            categoria = "Obrigatoria";
                            break;
                        case "OpÃ§Ã£o Limitada":
                            categoria = "Limitada";
                            break;
                        default:
                            categoria = "Livre";
                            break;
                    }

					Pattern codigoRegex = Pattern.compile("[A-Z]{3,4}[0-9]{3,4}-[0-9]{2}");
					Matcher codigoMatcher = codigoRegex.matcher(codigo);

					if (codigoMatcher.find()) {
						CodigoUFABC codigoUFABC = new CodigoUFABC(codigo);
						mFicha[temp] = new MateriaUFABCCursada(codigoUFABC, nome, creditos, nota,
								categoria.toUpperCase(), periodo, ano);
					} else {
						mFicha[temp] = new MateriaFora(codigo, nome, creditos, periodo, ano);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mFicha;
	}

	public static MateriaUFABC[] xmlParaCatalogo(int ano) {
		MateriaUFABC[] mCatalogo = new MateriaUFABC[0];
		try {
			File fXmlFile;
			if (ano == 12){
				fXmlFile = new File("res/catalogo12.xml");
			} else {
				fXmlFile = new File("res/catalogo16.xml");
			}
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("materia");
			mCatalogo = new MateriaUFABC[nList.getLength()];

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String codigo = eElement.getElementsByTagName("CÃ“DIGO").item(0).getTextContent();
					String nome = eElement.getElementsByTagName("DISCIPLINA").item(0).getTextContent();
					int teoria = Integer.parseInt(eElement.getElementsByTagName("TEORIA").item(0).getTextContent());
                    int pratica = Integer.parseInt(eElement.getElementsByTagName("PRÃ�TICA").item(0).getTextContent());

                    mCatalogo[temp] = new MateriaUFABC(new CodigoUFABC(codigo), nome, (teoria+pratica));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mCatalogo;
	}

    public static MateriaUFABCProjeto[] xmlParaProjeto(String projeto) {
        MateriaUFABCProjeto[] mProjeto = new MateriaUFABCProjeto[0];
        try {
        	File fXmlFile;
        	switch (projeto){
	        	case "ei13":
	        		fXmlFile = new File("res/ei13.xml");
	        		break;
	        	default:
	        		fXmlFile = new File("res/ei17.xml");
	        	}
        	
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("materia");
            mProjeto = new MateriaUFABCProjeto[nList.getLength()];

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String codigo = eElement.getElementsByTagName("CÃ“DIGO").item(0).getTextContent();
                    String nome = eElement.getElementsByTagName("DISCIPLINA").item(0).getTextContent();
                    int creditos = Integer.parseInt(eElement.getElementsByTagName("CRÃ‰DITOS").item(0).getTextContent());
                    Categoria categoria = Categoria.valueOf(eElement.getElementsByTagName("CATEGORIA").item(0).getTextContent());

                    mProjeto[temp] = new MateriaUFABCProjeto(new CodigoUFABC(codigo), nome, creditos, categoria);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mProjeto;
    }
}
