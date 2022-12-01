package ru.javaops.masterjava.xml.util.MainXml;

import com.google.common.io.Resources;
import ru.javaops.masterjava.xml.schema.ObjectFactory;
import ru.javaops.masterjava.xml.schema.Payload;
import ru.javaops.masterjava.xml.schema.User;
import ru.javaops.masterjava.xml.util.JaxbParser;
import ru.javaops.masterjava.xml.util.Schemas;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainXmlJAXB {
    JaxbParser parser;
    Payload payload;
    String project;

    public MainXmlJAXB(String project) throws IOException, JAXBException {
        this.parser = new JaxbParser(ObjectFactory.class);
        parser.setSchema(Schemas.ofClasspath("payload.xsd"));
        payload = parser.unmarshal(Resources.getResource("payload.xml").openStream());
        this.project = project;
    }

    public List<User> getSortedUserWithProject() {
        List<User> users = new ArrayList<>();
        payload.getUsers().getUser().forEach(u -> {
            u.getProjects().getProject().forEach(p -> {
                if (p.getProjectType().getId().equals(project)) {
                    users.add(u);
                }
            });
        });
        return users.stream()
                .sorted(Comparator.comparing(User::getFullName))
                .collect(Collectors.toList());
    }
}