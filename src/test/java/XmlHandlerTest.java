import org.junit.Test;
import xmlparser.XmlParser;

import static org.junit.Assert.*;

public class XmlHandlerTest {
    @Test
    public void readXmlAndAddToListTrue(){
        XmlParser parser = new XmlParser();

        parser.xmlParser();

        assertTrue(parser.proteinBarSize() == 500);
    }

    @Test
    public void readXmlAndAddToListFalse(){
        XmlParser parser = new XmlParser();

        assertFalse(parser.proteinBarSize() > 0);
    }
}
