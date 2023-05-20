package com.example;

import com.example.model.flower_HW_1_2.Flower;
import com.example.parser_HW_1_2_3.FlowerDOMParser;
import com.example.parser_HW_1_2_3.FlowerSAXParser;
import com.example.parser_HW_1_2_3.FlowerSTAXParser;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Nadia  Filatova
 * @since 5/13/23
 */

public class FlowerMain {
    private static final String XML_FILE_URI = "src/main/resources/greenhouse/greenhouse.xml";
    private static final String XSD_FILE_URI = "src/main/resources/greenhouse/greenhouse.xsd";
    private static final String SAX = "SAX";
    private static final String DOM = "DOM";
    private static final String STAX = "STAX";
    private static final String JAXB = "JAXB";
    private static final String XPATH = "XPath";
    private static final String EXIT = "exit";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XMLStreamException, JAXBException, XPathExpressionException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Choose an option for parsing: SAX/DOM/STAX/JAXB/XPath or exit: ");
            String input = scanner.nextLine();
            switch (input) {
                case SAX -> runSAX();
                case DOM -> runDOM();
                case STAX -> runSTAX();
                case JAXB -> runJAXB();
                case XPATH -> runXPath();
                case EXIT -> {
                    return;
                }
                default -> System.out.println("Wrong input, try again");
            }
        }
    }

    private static void runXPath() throws XPathExpressionException, FileNotFoundException {
        XPathExpression expression = XPathFactory.newInstance().newXPath().compile("//plant/* | //plant/@*");
        InputSource source = new InputSource(new FileInputStream(XML_FILE_URI));
        NodeList list = (NodeList) expression.evaluate(source, XPathConstants.NODESET);

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            System.out.print("Node name: " + node.getNodeName());
            System.out.print("\t\t Node value: " + node.getFirstChild().getNodeValue());
            System.out.print("\n");
            if ((node.getNodeName().equals("visualParameters")) || node.getNodeName().equals("growingTips")) {
                System.out.println(" Node name: " + node.getChildNodes().item(1).getNodeName());
                System.out.print("\t\t Node value: " + node.getChildNodes().item(1).getFirstChild().getNodeValue());
                System.out.println(" Node name: " + node.getChildNodes().item(3).getNodeName());
                System.out.print("\t\t Node value: " + node.getChildNodes().item(3).getFirstChild().getNodeValue());
                System.out.println(" Node name: " + node.getChildNodes().item(5).getNodeName());
                System.out.print("\t\t Node value: " + node.getChildNodes().item(5).getFirstChild().getNodeValue());
            }

            if (node.getNodeName().equals("multiplyingType")) {
                System.out.println("________element_________");
            }
        }
    }

    private static void runJAXB() throws JAXBException {
        File file = new File(XML_FILE_URI);
        JAXBContext jaxbContext = JAXBContext.newInstance(Flower.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Flower flower = (Flower) jaxbUnmarshaller.unmarshal(file);
        System.out.println(flower);
    }

    private static void runSTAX() throws XMLStreamException, IOException {
        FlowerSTAXParser flowerSTAXParser = new FlowerSTAXParser();
        Flower flower = flowerSTAXParser.parse(XML_FILE_URI);
        System.out.println(flower);
    }

    private static void runDOM() throws IOException {
        FlowerDOMParser flowerDOMParser = new FlowerDOMParser();
        Flower flower = flowerDOMParser.getFlower(XML_FILE_URI);
        System.out.println(flower);
    }

    private static void runSAX() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        FlowerSAXParser flowerSAXParser = new FlowerSAXParser();
        saxParser.parse(XML_FILE_URI, flowerSAXParser);
        Flower flower = flowerSAXParser.getFlower();
        System.out.println(flower);
        validateSAX();
    }

    private static void validateSAX() throws SAXException, IOException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(new File(XSD_FILE_URI));
        Schema schema = factory.newSchema(schemaFile);
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(new File(XML_FILE_URI)));
    }
}
