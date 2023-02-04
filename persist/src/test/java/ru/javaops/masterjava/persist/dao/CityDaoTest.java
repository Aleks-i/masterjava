package ru.javaops.masterjava.persist.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.javaops.masterjava.persist.CityTestData;
import ru.javaops.masterjava.persist.model.City;

import java.util.List;

import static ru.javaops.masterjava.persist.CityTestData.*;

public class CityDaoTest extends AbstractDaoTest<CityDao> {

    public CityDaoTest() {
        super(CityDao.class);
    }

    @BeforeClass
    public static void init() throws Exception {
        CityTestData.init();
    }

    @Before
    public void setUp() throws Exception {
        CityTestData.setUp();
    }

    @Test
    public void testGetAll() {
        List<City> cities = dao.getAll();
        Assert.assertEquals(FIRST_SIX_CITIES, cities);
    }

    @Test
    public void getId() {
        City actualCity = dao.getId("msk");
        Assert.assertEquals(MOSCOW, actualCity);
    }

    @Test
    public void testInsertBatch() {
        dao.insert(TROICK);
        List<City> cities = dao.getAll();
        Assert.assertEquals(ALL_CITIES, cities);
    }
}