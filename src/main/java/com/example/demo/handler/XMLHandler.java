package com.example.demo.handler;

import lombok.Getter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@Getter
class XMLHandler extends DefaultHandler {

    private Stack<Element> elementStack = new Stack<>();
    private Element root;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        Element element = new Element();
        Map<String, String> attrs = new HashMap<>();
        for (int i = 0; i < attributes.getLength(); i++) {
            attrs.put(attributes.getQName(i), attributes.getValue(i));
        }

        element.setElementName(qName);
        element.setAttributes(attrs);
        if (!elementStack.isEmpty()) {
            elementStack.peek().getChildren().add(element);
        } else {
            root = element;
        }
        elementStack.push(element);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
    }
}
