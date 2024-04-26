package com.example.demo.handler;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.Map;

public class XMLComparator {

    public static void compareXMLFiles(String filePath1, String filePath2) {
        Resource resource1 = new ClassPathResource(filePath1);
        Resource resource2 = new ClassPathResource(filePath2);

        Element element1 = XMLParser.parseXMLFile(resource1);
        Element element2 = XMLParser.parseXMLFile(resource2);

        compareElements(element1, element2);
    }

    public static void compareElements(Element e1, Element e2) {
        if (!compareAttributes(e1.getAttributes(), e2.getAttributes())) {
            System.out.println("Attributes are not the same.");
            System.out.println("Attributes in Element 1: " + e1.getElementName() + " attributes :"  + e1.getAttributes());
            System.out.println("Attributes in Element 2: " + e2.getElementName() + " attributes :"  + e2.getAttributes());
        }

        List<Element> children1 = e1.getChildren();
        List<Element> children2 = e2.getChildren();

        if (children1.size() != children2.size()) {
            System.out.println("Different number of children.");
            return;
        }


        for (int i = 0; i < children1.size(); i++) {
            compareElements(children1.get(i), children2.get(i));
        }
    }

    private static boolean compareAttributes(Map<String, String> attributes1, Map<String, String> attributes2) {
        return attributes1.equals(attributes2);
    }

    public static void main(String[] args) {
        compareXMLFiles("bpmn/http-connector-test.bpmn","bpmn/http-connector-test1.bpmn");
    }

}
