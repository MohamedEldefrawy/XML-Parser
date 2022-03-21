package utilities;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class XmlHandler {


    private Document document;
    private DocumentBuilderFactory documentFactory;
    private DocumentBuilder documentBuilder;
    private final String xmlFilePath;


    public Document getDocument() {
        return document;
    }

    public XmlHandler(String xmlFilePath) {

        this.xmlFilePath = xmlFilePath;
        try {
            documentFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentFactory.newDocumentBuilder();
            document = documentBuilder.parse(new File(this.xmlFilePath));
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private Node getRootElement() {
        Element root = null;
        try {
            documentFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentFactory.newDocumentBuilder();
            document = documentBuilder.parse(new File(this.xmlFilePath));
            root = document.getDocumentElement();


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return root;
    }


    // write doc to output stream
    public void save() {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(this.document);
            FileOutputStream file = new FileOutputStream(xmlFilePath);
            StreamResult result = new StreamResult(file);

            transformer.transform(source, result);
        } catch (FileNotFoundException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
