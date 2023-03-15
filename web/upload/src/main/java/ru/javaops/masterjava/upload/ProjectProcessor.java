package ru.javaops.masterjava.upload;

import lombok.extern.slf4j.Slf4j;
import ru.javaops.masterjava.dbi.provider.DBIPersistProvider;
import ru.javaops.masterjava.persist.dao.ProjectDao;
import ru.javaops.masterjava.persist.model.Group;
import ru.javaops.masterjava.persist.model.Project;
import ru.javaops.masterjava.xml.util.StaxStreamProcessor;

import javax.xml.stream.XMLStreamException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ProjectProcessor {
    private final ProjectDao projectDao = DBIPersistProvider.getDao(ProjectDao.class);
    private final GroupProcessor groupProcessor = new GroupProcessor();

    public Map<String, Group> process(StaxStreamProcessor processor) throws XMLStreamException {
        Map<String, Project> projectMap = projectDao.getAsMap();
        Map<String, Group> projectGroup = new HashMap<>();

        while (processor.startElement("Project", "Projects")) {
            String projectName = processor.getAttribute("name");
            if (!projectMap.containsKey(projectName)) {
                int projectId = projectDao.insert(new Project(projectName, processor.getElementValue("description")));
                log.info("Insert project" + projectName);
                projectGroup = groupProcessor.process(processor, projectId);
            }
        }
        return projectGroup.isEmpty() ? groupProcessor.getGroupsAsMap() : projectGroup;
    }
}
