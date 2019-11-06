import org.junit.Test;
import proteinbar.ProteinBar;
import xmlparser.XmlHandler;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class XmlHandlerTest {
    String xmlPath = "src/test/resources/";

    @Test
    public void readXmlAndAddToListTrue(){
        ArrayList<ProteinBar> proteinBars = new ArrayList<>(
                XmlHandler.readProteinBarList(xmlPath));

        assertTrue(proteinBars.size() > 0);
    }

    @Test(expected = NullPointerException.class)
    public void readEmptyXmlAndAddToListThrows(){
        ArrayList<ProteinBar> proteinBars = new ArrayList<>(
                XmlHandler.readProteinBarList("src/test/"));
    }

    @Test
    public void readXmlGetLastBarName(){
        ArrayList<ProteinBar> proteinBars = new ArrayList<>(
                XmlHandler.readProteinBarList(xmlPath));

        assertEquals("YEXCDBAR", proteinBars.get(proteinBars.size()-1).getName());
    }

    @Test
    public void readXmlGetLastBarFett(){
        ArrayList<ProteinBar> proteinBars = new ArrayList<>(
                XmlHandler.readProteinBarList(xmlPath));

        assertTrue(proteinBars.get(proteinBars.size()-1).getFat() == 44.66);
    }
}
