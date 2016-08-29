package tools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Created by hdant on 28/08/2016.
 */
public class Utils {
    public static Object[] xmlParaFicha(){
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
                    if ()
                    DayOfWeek dds = DayOfWeek.valueOf(eElement.getElementsByTagName("dia").item(0).getTextContent());
                    Trajeto linha = Trajeto.valueOf("L"+eElement.getElementsByTagName("linha").item(0).getTextContent());

                    int hp = Integer.parseInt(eElement.getElementsByTagName("hp").item(0).getTextContent());
                    int mp = Integer.parseInt(eElement.getElementsByTagName("mp").item(0).getTextContent());
                    int hc = Integer.parseInt(eElement.getElementsByTagName("hc").item(0).getTextContent());
                    int mc = Integer.parseInt(eElement.getElementsByTagName("mc").item(0).getTextContent());
                    linha2p[temp] = new Itinerario2Pontos(linha,dds, LocalTime.of(hp,mp),LocalTime.of(hc,mc));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linha2p;
    }
}
