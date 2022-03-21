package services;

import model.Address;
import model.Employee;
import model.Phone;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServices {
    private final DocumentBuilderFactory documentFactory;
    private final AddressServices addressServices;
    private final PhoneServices phoneServices;
    private final List<Element> addressElements;
    private final List<Element> phoneElements;
    private Document document;
    private DocumentBuilder documentBuilder;


    public EmployeeServices() {
        documentFactory = DocumentBuilderFactory.newInstance();
        addressServices = new AddressServices();
        phoneServices = new PhoneServices();
        addressElements = new ArrayList<>();
        phoneElements = new ArrayList<>();
        try {
            documentBuilder = documentFactory.newDocumentBuilder();
            document = documentBuilder.newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public Element createEmployee(Employee employee) {

        Element employeeElement = null;
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
            var tempPhoneElement = document.importNode(element, true);
            phonesElement.appendChild(tempPhoneElement);
        }

        for (var element : addressElements) {
            var tempAddressElement = document.importNode(element, true);
            addressesElement.appendChild(tempAddressElement);
        }
        employeeElement.appendChild(phonesElement);
        employeeElement.appendChild(addressesElement);

        return employeeElement;
    }

    public List<Employee> getEmployees(Document document) {
        List<Employee> employees = new ArrayList<>();

        var employeesTag = document.getChildNodes().item(0).getChildNodes();

        for (int i = 0; i < employeesTag.getLength(); i++) {
            List<Address> addresses = new ArrayList<>();
            List<Phone> phones = new ArrayList<>();
            var employee = new Employee();

            var employeeNode = employeesTag.item(i);
            if (employeeNode.getNodeType() == Node.ELEMENT_NODE) {

                // get employee attributes
                var employeeElement = (Element) employeeNode;
                employee.setName(employeeElement.getAttribute("name"));
                employee.setEmail(employeeElement.getAttribute("email"));
                employee.setSalary(Integer.parseInt(employeeElement.getAttribute("salary")));

                var addressElements = employeeElement.getElementsByTagName("Addresses").item(0).getChildNodes();
                var phoneElements = employeeElement.getElementsByTagName("Phones").item(0).getChildNodes();

                for (int j = 0; j < addressElements.getLength(); j++) {
                    var address = new Address();

                    if (addressElements.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        var addressElement = (Element) addressElements.item(j);
                        address.setCountry(((Element) addressElement.getElementsByTagName("Country").item(0)).getAttribute("value"));
                        address.setCity(((Element) addressElement.getElementsByTagName("City").item(0)).getAttribute("value"));
                        address.setRegion(((Element) addressElement.getElementsByTagName("Region").item(0)).getAttribute("value"));
                        address.setStreet(((Element) addressElement.getElementsByTagName("Street").item(0)).getAttribute("value"));
                        address.setBuilding(((Element) addressElement.getElementsByTagName("Building").item(0)).getAttribute("value"));
                        addresses.add(address);
                    }
                }


                for (int j = 0; j < phoneElements.getLength(); j++) {
                    var phone = new Phone();

                    if (phoneElements.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        var phoneElement = (Element) phoneElements.item(j);
                        phone.setType(phoneElement.getAttribute("type"));
                        phone.setNumber(phoneElement.getAttribute("value"));
                        phones.add(phone);
                    }
                }

                employee.setAddresses(addresses);
                System.out.println(addresses.size());
                System.out.println(addresses.get(0).getStreet());
                employee.setPhones(phones);
                employees.add(employee);
            }
        }
        return employees;
    }
}
