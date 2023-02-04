package ru.javaops.masterjava.persist;

import ru.javaops.masterjava.persist.dao.ProjectDao;
import ru.javaops.masterjava.persist.model.Project;

public class ProjectTestData {

    public static Integer PROJECT_ID_FOR_TEST = 100000;
    public static Project TOPJAVA;
    public static Project MASTGERJAVA;
    public static Project FOR_INSERT;

    public static void init() {
        TOPJAVA = new Project("topjava", "Topjava");
        MASTGERJAVA = new Project("masterjava", "Masterjava");
        FOR_INSERT = new Project("insert", "Insert");
    }

    public static void setUp() {
        ProjectDao dao = DBIProvider.getDao(ProjectDao.class);
        dao.clean();
        dao.restartCommSeq();
        DBIProvider.getDBI().useTransaction((conn, status) -> {
            dao.insert(TOPJAVA);
            dao.insert(MASTGERJAVA);
            CityTestData.init();
            CityTestData.setUp();
        });
    }
}
