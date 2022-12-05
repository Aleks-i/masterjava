package ru.javaops.masterjava.xml.util.MainXml;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MainXml {
    public static void main(String[] args) throws JAXBException, IOException, XMLStreamException {
        MainXmlJAXB JAXBXml = new MainXmlJAXB("topjava");
        JAXBXml.getSortedUserWithProject().forEach(System.out::println);

        System.out.println();

        MainXmlStAX StAXXml = new MainXmlStAX("topjava");
        List<MainXmlStAX.UserTO> userTOS = StAXXml.getSortedUserWithProject();
        userTOS.forEach(System.out::println);
        String html = StAXXml.toHtml(userTOS, "topjava");

        System.out.println();

        System.out.println(html);
        try (Writer writer = Files.newBufferedWriter(Paths.get("out/users.html"))) {
            writer.write(html);
        }
    }
}