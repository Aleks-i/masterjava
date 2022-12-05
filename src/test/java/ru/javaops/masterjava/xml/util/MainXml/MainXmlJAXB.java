package ru.javaops.masterjava.xml.util.MainXml;

import com.google.common.io.Resources;
import ru.javaops.masterjava.xml.schema.ObjectFactory;
import ru.javaops.masterjava.xml.schema.Payload;
import ru.javaops.masterjava.xml.schema.User;
import ru.javaops.masterjava.xml.util.JaxbParser;
import ru.javaops.masterjava.xml.util.Schemas;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainXmlJAXB {
    JaxbParser parser;
    Payload payload;
    Map<String, List<User>> projectsStorage;
    String project;

    public MainXmlJAXB(String project) throws IOException, JAXBException {
        this.parser = new JaxbParser(ObjectFactory.class);
        parser.setSchema(Schemas.ofClasspath("payload.xsd"));
        payload = parser.unmarshal(Resources.getResource("payload.xml").openStream());
        this.projectsStorage = new HashMap<>();
        this.project = project;
    }

    public List<User> getSortedUserWithProject() {
        payload.getUsers().getUser().forEach(this::fillingProjectsStorage);
        return projectsStorage.containsKey(project) ? projectsStorage.get(project).stream()
                .sorted(Comparator.comparing(User::getFullName))
                .collect(Collectors.toList()) : Collections.emptyList();
    }

    private void fillingProjectsStorage(User user) {
        user.getProjects().getProject().forEach(p -> {
            String projectName = p.getProjectType().getId();
            projectsStorage.computeIfAbsent(projectName, v -> saveInProjectStorage(new ArrayList<>(), user));
            projectsStorage.computeIfPresent(projectName, (k, v) -> saveInProjectStorage(v, user));
        });
    }

    private List<User> saveInProjectStorage(List<User> users, User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
        return users;
    }
}