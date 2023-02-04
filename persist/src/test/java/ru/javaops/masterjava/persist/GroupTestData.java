package ru.javaops.masterjava.persist;

import com.google.common.collect.ImmutableList;
import ru.javaops.masterjava.persist.dao.GroupDao;
import ru.javaops.masterjava.persist.model.Group;
import ru.javaops.masterjava.persist.model.GroupType;

import java.util.List;

public class GroupTestData {

    public static Integer GROUP_ID_TOPJAVA_09 = 100006;
    public static Group TOPJAVA_06;
    public static Group TOPJAVA_07;
    public static Group TOPJAVA_08;
    public static Group TOPJAVA_09;
    public static Group MASTGERJAVA_01;
    public static List<Group> ALL_GROUPS_FOR_PROJECT_TOPJAVA;
    public static List<Group> ALL_GROUPS_FOR_PROJECT_MASTERJAVA;

    public static void init() {
        TOPJAVA_06 = new Group("topjava06", GroupType.FINISHED, 100000);
        TOPJAVA_07 = new Group("topjava07", GroupType.FINISHED, 100000);
        TOPJAVA_08 = new Group("topjava08", GroupType.CURRENT, 100000);
        MASTGERJAVA_01 = new Group("masterjava01", GroupType.CURRENT, 100001);
        ALL_GROUPS_FOR_PROJECT_TOPJAVA = ImmutableList.of(TOPJAVA_06, TOPJAVA_07, TOPJAVA_08);
        ALL_GROUPS_FOR_PROJECT_MASTERJAVA = ImmutableList.of(MASTGERJAVA_01);
        TOPJAVA_09 = new Group("some group", GroupType.CURRENT, 100000);
    }

    public static void setUp() {
        GroupDao dao = DBIProvider.getDao(GroupDao.class);
        init();
        dao.clean();
        DBIProvider.getDBI().useTransaction((conn, status) -> {
            ProjectTestData.init();
            ProjectTestData.setUp();
            ALL_GROUPS_FOR_PROJECT_TOPJAVA.forEach(dao::insert);
            ALL_GROUPS_FOR_PROJECT_MASTERJAVA.forEach(dao::insert);
        });
    }
}
