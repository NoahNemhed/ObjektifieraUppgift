package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//(Onödig klass i detta fall men ville bara testa använda en abstrakt klass.)
abstract class parser {

    abstract ArrayList<String> readFile(String fileName) throws IOException, SAXException, ParserConfigurationException;

}
