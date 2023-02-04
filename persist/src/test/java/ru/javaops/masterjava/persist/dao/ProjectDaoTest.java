package ru.javaops.masterjava.persist.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.javaops.masterjava.persist.GroupTestData;
import ru.javaops.masterjava.persist.model.Project;

import static ru.javaops.masterjava.persist.ProjectTestData.*;

public class ProjectDaoTest extends AbstractDaoTest<ProjectDao> {

    public ProjectDaoTest() {
        super(ProjectDao.class);
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
        dao.clean();
        dao.insert(FOR_INSERT);
        Assert.assertEquals(FOR_INSERT, dao.getProjectById(100006));
    }

    @Test
    public void getProjectById() {
        Project actualProject = dao.getProjectById(PROJECT_ID_FOR_TEST);
        Assert.assertEquals(TOPJAVA, actualProject);
    }
}