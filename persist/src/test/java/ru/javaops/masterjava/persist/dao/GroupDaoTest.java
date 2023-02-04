package ru.javaops.masterjava.persist.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.javaops.masterjava.persist.GroupTestData;
import ru.javaops.masterjava.persist.model.Group;

import java.util.List;

import static ru.javaops.masterjava.persist.GroupTestData.*;
import static ru.javaops.masterjava.persist.ProjectTestData.PROJECT_ID_FOR_TEST;

public class GroupDaoTest extends AbstractDaoTest<GroupDao> {

    public GroupDaoTest() {
        super(GroupDao.class);
    }

    @BeforeClass
    public static void init() throws Exception {
        GroupTestData.init();
    }

    @Before
    public void setUp() throws Exception {
        GroupTestData.setUp();
    }

    @Test
    public void insert() {
        dao.insert(TOPJAVA_09);
        Group actualGroup = dao.getGroupById(GROUP_ID_TOPJAVA_09);
        actualGroup.setProjectId(PROJECT_ID_FOR_TEST);
        Assert.assertEquals(TOPJAVA_09, actualGroup);

    }

    @Test
    public void getGroupById() {
        dao.insert(TOPJAVA_09);
        Group actualGroup = dao.getGroupById(GROUP_ID_TOPJAVA_09);
        actualGroup.setProjectId(PROJECT_ID_FOR_TEST);
        Assert.assertEquals(TOPJAVA_09, actualGroup);
    }

    @Test
    public void getGroupByProjectId() {
        List<Group> groups = dao.getGroupByProjectId(PROJECT_ID_FOR_TEST);
        groups.forEach(g -> g.setProjectId(PROJECT_ID_FOR_TEST));
        Assert.assertEquals(ALL_GROUPS_FOR_PROJECT_TOPJAVA, groups);
    }
}