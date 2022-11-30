package ru.javaops.masterjava.xml.util;

import com.google.common.io.Resources;
import ru.javaops.masterjava.xml.schema.ObjectFactory;
import ru.javaops.masterjava.xml.schema.Payload;
import ru.javaops.masterjava.xml.schema.User;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainXml {
    public static void main(String[] args) throws IOException, JAXBException {
        JaxbParser parser = new JaxbParser(ObjectFactory.class);
        parser.setSchema(Schemas.ofClasspath("payload.xsd"));
        Payload payload = parser.unmarshal(Resources.getResource("payload.xml").openStream());

        List<User> users = getUsersWithProject(payload.getUsers().getUser(), "topjava");
        users.forEach(System.out::println);
    }

    private static List<User> getUsersWithProject(List<User> users, String project) throws IOException, JAXBException {
        List<User> userList = new ArrayList<>();
        users.forEach(u -> {
            u.getProjects().getProject().forEach(p -> {
                if (p.getProjectType().getId().equals(project)) {
                    userList.add(u);
                }
            });
        });
        return userList.stream()
                .sorted(Comparator.comparing(User::getFullName))
                .collect(Collectors.toList());
    }
}