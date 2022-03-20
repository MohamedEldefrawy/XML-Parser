package utilities;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class XmlReader {

    private final DocumentBuilderFactory documentFactory;

    public XmlReader() {
        documentFactory = DocumentBuilderFactory.newInstance();
    }

    public Element getRootElement(String xmlFilePath) {
        DocumentBuilder documentBuilder;
        Document document = null;
        try {
            documentFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            documentBuilder = documentFactory.newDocumentBuilder();
            document = documentBuilder.parse(new File(xmlFilePath));
            document.getDocumentElement().normalize();
            return document.getDocumentElement();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return null;
    }
}
