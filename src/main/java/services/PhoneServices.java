package services;

import model.Address;
import model.Phone;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class PhoneServices {
    private final DocumentBuilderFactory documentFactory;

    public PhoneServices() {
        documentFactory = DocumentBuilderFactory.newInstance();
    }

    public Element createPhone(Phone phone) {
        DocumentBuilder documentBuilder = null;
        Element phoneElement = null;
        try {
            documentBuilder = documentFactory.newDocumentBuilder();
            var document = documentBuilder.newDocument();
            phoneElement = document.createElement("Phone");

            phoneElement.setAttribute("type", phone.getType());
            phoneElement.setAttribute("value", phone.getNumber());

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return phoneElement;
    }
}
