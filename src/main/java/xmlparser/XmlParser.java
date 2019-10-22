package xmlparser;

import proteinbar.ProteinBar;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;

public class XmlParser {
    public static ArrayList<ProteinBar> proteinBars;

    public XmlParser(){
        proteinBars = new ArrayList<>();
    }

    /**
     * To parse the XML file.
     * @return a list with protein bars.
     */
    public ArrayList<ProteinBar> xmlParser() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XmlHandler xmlHandler = new XmlHandler();
            saxParser.parse("src/main/resources/bars.xml", xmlHandler);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return proteinBars;
    }

    /**
     * To add a protein bar to the list.
     */
    public static void addProteinBar(ProteinBar proteinBar) {
        proteinBars.add(proteinBar);
    }

    /**
     * To add a protein bar to the list.
     */
    public int proteinBarSize() {
        return proteinBars.size();
    }
}