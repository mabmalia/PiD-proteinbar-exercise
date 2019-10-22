package xmlparser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import proteinbar.ProteinBar;
import proteinbar.Review;

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

    /**
     *
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.contains("BAR")) {
            bar = new ProteinBar(qName.replace("BAR"," BAR"));
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
     *
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {

        if (qName.contains("BAR")) {
            XmlParser.addProteinBar(bar);
        }
    }

    /**
     *
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
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
            System.out.println("ERROR" + new String(ch, start, length));
        }
    }
}