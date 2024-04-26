package com.example.demo.handler;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class Element {

    String elementName;
    Map<String, String> attributes;
    List<Element> children = new ArrayList<>();

}
