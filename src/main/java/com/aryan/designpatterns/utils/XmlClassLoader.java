package com.aryan.designpatterns.utils;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.Function;

public class XmlClassLoader {


    public static <T> Map<Integer, T> loadClassesFromXml(String xmlFileName, String elementTag, Class<T> clazz) {
        Map<Integer, T> instances = new HashMap<>();
        NodeList nodeList = parseXml(xmlFileName, elementTag);

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                int id = Integer.parseInt(element.getAttribute("id"));
                String className = element.getElementsByTagName("class").item(0).getTextContent();
                try {
                    T instance = clazz.cast(Class.forName(className).getDeclaredConstructor().newInstance());
                    instances.put(id, instance);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to create instance of " + className, e);
                }
            }
        }
        return instances;
    }

    public static <T, R> Map<Integer, Function<T, R>> loadFunctionsFromXml(
            String xmlFileName, String elementTag, Class<T> clazz, Class<R> returnClass) {

        Map<Integer, Function<T, R>> functionMap = new HashMap<>();
        NodeList nodeList = parseXml(xmlFileName, elementTag);

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                int id = Integer.parseInt(element.getAttribute("id"));
                String className = element.getElementsByTagName("class").item(0).getTextContent();

                Function<T, R> decoratorFunc = (T input) -> {
                    try {
                        return returnClass.cast(
                                Class.forName(className)
                                        .getDeclaredConstructor(clazz)
                                        .newInstance(input)
                        );
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to create decorator " + className, e);
                    }
                };
                functionMap.put(id, decoratorFunc);
            }
        }
        return functionMap;
    }


    private static NodeList parseXml(String xmlFileName, String elementTag) {
        try {
            InputStream is = XmlClassLoader.class.getClassLoader().getResourceAsStream(xmlFileName);
            if (is == null) {
                throw new RuntimeException(xmlFileName + " not found in resources folder!");
            }

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            Document doc = builder.parse(is);
            return doc.getElementsByTagName(elementTag);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException("Failed to parse XML " + xmlFileName, e);
        }
    }
}