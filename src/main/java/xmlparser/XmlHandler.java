package xmlparser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import proteinbar.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;

/**
 * This class handles the data inside the XML file.
 */
public class XmlHandler extends DefaultHandler {
    private boolean xmlFett = false;
    private boolean xmlEnergy = false;
    private boolean xmlKolhydrat = false;
    private boolean xmlProtein = false;
    private boolean xmlFiber = false;
    private ProteinBar bar;
    private static ArrayList<ProteinBar> proteinBars;

    /**
     * Returns the XML protein bar list.
     * @return a protein bar list.
     */
    public static ArrayList<ProteinBar> readProteinBarList(String xmlPath) {
        proteinBars = new ArrayList<>();

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XmlHandler xmlHandler = new XmlHandler();
            saxParser.parse(xmlPath + "bars.xml", xmlHandler);

        }
        catch (Exception e) {
            return null;
        }
        return proteinBars;
    }

    /**
     * Method called at the start of a document element.
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     */
    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes) {

        if (qName.contains("BAR")) {
            bar = new ProteinBar(qName);
        }
        else if (qName.equalsIgnoreCase("fett")) {
            xmlFett = true;
        }
        else if (qName.equalsIgnoreCase("energy")) {
            xmlEnergy = true;
        }
        else if (qName.equalsIgnoreCase("kolhydrat")) {
            xmlKolhydrat = true;
        }
        else if (qName.equalsIgnoreCase("protein")) {
            xmlProtein = true;
        }
        else if (qName.equalsIgnoreCase("fiber")) {
            xmlFiber = true;
        }
        else if (qName.equalsIgnoreCase("reviewer")){
            bar.addReview(new Review(attributes.getValue("personID")));
        }
    }

    /**
     * Method called at the end of a document element.
     * @param uri
     * @param localName
     * @param qName
     */
    @Override
    public void endElement(String uri,
                           String localName, String qName) {

        if (qName.contains("BAR")) {
            //add a protein bar to the list
            proteinBars.add(bar);
        }
    }

    /**
     * Method called with the text contents
     *  in between the start and end tags of an XML document element.
     * @param ch
     * @param start
     * @param length
     */
    @Override
    public void characters(char ch[], int start, int length) {
        //multiple occurrences to avoid creating empty doubles
        try {
            if (xmlFett) {
                bar.setFett(Double.parseDouble(new String(ch, start, length)));
                xmlFett = false;
            } else if (xmlEnergy) {
                bar.setEnergy(Double.parseDouble(new String(ch, start, length)));
                xmlEnergy = false;
            } else if (xmlKolhydrat) {
                bar.setKolhydrat(Double.parseDouble(new String(ch, start, length)));
                xmlKolhydrat = false;
            } else if (xmlProtein) {
                bar.setProtein(Double.parseDouble(new String(ch, start, length)));
                xmlProtein = false;
            } else if (xmlFiber) {
                bar.setFiber(Double.parseDouble(new String(ch, start, length)));
                xmlFiber = false;
            }
        }
        catch(NumberFormatException e){
            System.out.println("ERROR READING \'" + new String(ch, start, length) + "\'");
        }
    }
}