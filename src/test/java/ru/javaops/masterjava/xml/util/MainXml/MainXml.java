package ru.javaops.masterjava.xml.util.MainXml;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class MainXml {
    public static void main(String[] args) throws JAXBException, IOException {
        MainXmlJAXB JAXBXml = new MainXmlJAXB("masterjava");
        JAXBXml.getSortedUserWithProject().forEach(System.out::println);
    }
}