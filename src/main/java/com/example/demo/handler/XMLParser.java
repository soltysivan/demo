package com.example.demo.handler;

import org.springframework.core.io.Resource;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XMLParser {

    public static Element parseXMLFile(Resource resource) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            saxParser.parse(resource.getFile(), handler);
            return handler.getRoot();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
