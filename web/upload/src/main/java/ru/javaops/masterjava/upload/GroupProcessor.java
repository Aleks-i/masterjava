package ru.javaops.masterjava.upload;

import lombok.extern.slf4j.Slf4j;
import ru.javaops.masterjava.dbi.provider.DBIPersistProvider;
import ru.javaops.masterjava.persist.dao.GroupDao;
import ru.javaops.masterjava.persist.model.Group;
import ru.javaops.masterjava.persist.model.type.GroupType;
import ru.javaops.masterjava.xml.util.StaxStreamProcessor;

import javax.xml.stream.XMLStreamException;
import java.util.Map;

@Slf4j
public class GroupProcessor {
    private final GroupDao groupDao = DBIPersistProvider.getDao(GroupDao.class);

    public Map<String, Group> process(StaxStreamProcessor processor, int projectId) throws XMLStreamException {
        Map<String, Group> map = getGroupsAsMap();

        while (processor.startElement("Group", "Project")) {
            String groupName = processor.getAttribute("name");
            if (!map.containsKey(groupName)) {
                Group group = new Group(groupName, GroupType.valueOf(processor.getAttribute("type")), projectId);
                groupDao.insert(group);
                map.put(groupName, group);
                log.info("Insert group" + groupName);
            }
        }
        return map;
    }

    public Map<String, Group> getGroupsAsMap() {
        return groupDao.getAsMap();
    }
}
