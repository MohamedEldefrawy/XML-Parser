package services;

import model.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServices {
    private final DocumentBuilderFactory documentFactory;
    private final AddressServices addressServices;
    private final PhoneServices phoneServices;
    private List<Element> addressElements;
    private List<Element> phoneElements;

    public EmployeeServices() {
        documentFactory = DocumentBuilderFactory.newInstance();
        addressServices = new AddressServices();
        phoneServices = new PhoneServices();
        addressElements = new ArrayList<Element>();
        phoneElements = new ArrayList<Element>();
    }

    public Element createEmployee(Employee employee) {

        DocumentBuilder documentBuilder = null;
        Element employeeElement = null;
        try {
            documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            employeeElement = document.createElement("Employee");
            employeeElement.setAttribute("name", employee.getName());
            employeeElement.setAttribute("email", employee.getEmail());
            employeeElement.setAttribute("salary", String.valueOf(employee.getSalary()));

            var phonesElement = document.createElement("Phones");
            var addressesElement = document.createElement("Addresses");

            for (var address : employee.getAddresses()) {
                addressElements.add(addressServices.createAddress(address));
            }
            for (var phone : employee.getPhones()) {
                phoneElements.add(phoneServices.createPhone(phone));
            }

            for (var element : phoneElements) {
                phonesElement.appendChild(element);
            }

            for (var element : addressElements) {
                addressesElement.appendChild(element);
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return employeeElement;
    }
}