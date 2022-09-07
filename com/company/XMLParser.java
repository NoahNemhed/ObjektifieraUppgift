package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class XMLParser extends parser {
    ArrayList<String> array_list = new ArrayList<String>();

    @Override
    ArrayList<String> readFile(String fileName) throws IOException, SAXException, ParserConfigurationException {
        File file = new File(fileName);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse(file);

        doc.getDocumentElement().normalize();

        NodeList list = doc.getElementsByTagName("row");

        for (int temp = 0; temp < list.getLength(); temp++) {
            Node node = list.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String[] array = new String[8];
                array[0] = element.getElementsByTagName("OrderDate").item(0).getTextContent();
                array[1] = element.getElementsByTagName("Region").item(0).getTextContent();
                array[2] = element.getElementsByTagName("Rep1").item(0).getTextContent();
                array[3] = element.getElementsByTagName("Rep2").item(0).getTextContent();
                array[4] = element.getElementsByTagName("Item").item(0).getTextContent();
                array[5] = element.getElementsByTagName("Units").item(0).getTextContent();
                array[6] = element.getElementsByTagName("UnitCost").item(0).getTextContent();
                array[7] = element.getElementsByTagName("Total").item(0).getTextContent();
                array_list.add(Arrays.toString(array).replace("[","").replace("]","").replace(" ", ""));
            }
        }
        return array_list;
    }

}
