package ru.javaops.masterjava.xml.util.MainXml;

import com.google.common.io.Resources;
import j2html.tags.ContainerTag;
import ru.javaops.masterjava.xml.util.StaxStreamProcessor;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static j2html.TagCreator.*;

public class MainXmlStAX {
    private final XMLStreamReader reader;
    private final String project;
    private static final String TAG_USER = "User";
    private static final String TAG_FULL_NAME = "fullName";
    private static final String TAG_PROJECT = "Project";

    public MainXmlStAX(String project) throws IOException, XMLStreamException {
        try (StaxStreamProcessor processor =
                     new StaxStreamProcessor(Resources.getResource("payload.xml").openStream())) {
            reader = processor.getReader();
        }
        this.project = project;
    }

    public List<UserTO> getSortedUserWithProject() throws XMLStreamException {
        List<UserTO> userTOS = new ArrayList<>();
        String userName = "";
        String email = "";
        while (reader.hasNext()) {
            int event = reader.next();
            if (event == XMLEvent.START_ELEMENT && TAG_USER.equals(reader.getLocalName())) {
                for (int i = 0, n = reader.getAttributeCount(); i < n; ++i) {
                    if ("email".equals(reader.getAttributeLocalName(i))) {
                        email = reader.getAttributeValue(i);
                    }
                }
            } else if (event == XMLEvent.START_ELEMENT && TAG_FULL_NAME.equals(reader.getLocalName())) {
                userName = reader.getElementText();
            } else if (event == XMLEvent.START_ELEMENT && TAG_PROJECT.equals(reader.getLocalName()) &&
                    project.equals(reader.getAttributeValue(0))) {
                userTOS.add(new UserTO(userName, email));
            }
        }
        return userTOS.stream()
                .sorted(Comparator.comparing(UserTO::getName).thenComparing(UserTO::getEmail))
                .collect(Collectors.toList());
    }

    public String toHtml(List<UserTO> users, String projectName) {
        final ContainerTag table = table().with(
                        tr().with(th("FullName"), th("email")))
                .attr("border", "1")
                .attr("cellpadding", "8")
                .attr("cellspacing", "0");

        users.forEach(u -> table.with(tr().with(td(u.getName()), td(u.getEmail()))));

        return html().with(
                head().with(title(projectName + " users")),
                body().with(h1(projectName + " users"), table)
        ).render();
    }

    public static class UserTO {
        private final String name;
        private final String email;

        public UserTO(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public String toString() {
            return "UserNameMail{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
}
