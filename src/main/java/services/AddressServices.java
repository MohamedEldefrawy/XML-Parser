package services;

import model.Address;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class AddressServices {

    private final DocumentBuilderFactory documentFactory;

    public AddressServices() {
        documentFactory = DocumentBuilderFactory.newInstance();
    }


    public Element createAddress(Address address) {
        DocumentBuilder documentBuilder = null;
        Element addressElement = null;
        try {
            documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            addressElement = document.createElement("Address");
            var countryElement = document.createElement("Country");
            var cityElement = document.createElement("City");
            var regionElement = document.createElement("Region");
            var streetElement = document.createElement("Street");
            var buildingElement = document.createElement("Building");

            countryElement.setAttribute("value", address.getCountry());
            cityElement.setAttribute("value", address.getCity());
            regionElement.setAttribute("value", address.getRegion());
            streetElement.setAttribute("value", address.getStreet());
            buildingElement.setAttribute("value", address.getBuilding());

            addressElement.appendChild(countryElement);
            addressElement.appendChild(cityElement);
            addressElement.appendChild(regionElement);
            addressElement.appendChild(streetElement);
            addressElement.appendChild(buildingElement);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return addressElement;
    }
}
