package ru.javaops.masterjava.persist;

import com.google.common.collect.ImmutableList;
import ru.javaops.masterjava.persist.dao.CityDao;
import ru.javaops.masterjava.persist.model.City;

import java.util.List;

public class CityTestData {
    public static City KIEV;
    public static City MOSCOW;
    public static City SANKTPETERSBURG;
    public static City YEKATERINBURG;
    public static City CHELYABINSK;
    public static City MINSK;
    public static City TROICK;
    public static List<City> FIRST_SIX_CITIES;
    public static List<City> ALL_CITIES;

    public static void init() {
        KIEV = new City("kiv", "Киев");
        MOSCOW = new City("msk", "Москва");
        SANKTPETERSBURG = new City("spb", "Санкт-Петребург");
        YEKATERINBURG = new City("ekb", "Екатеринбург");
        CHELYABINSK = new City("chel", "Челябинск");
        MINSK = new City("mnsk", "Минск");
        TROICK = new City("trck", "Троицк");
        FIRST_SIX_CITIES = ImmutableList.of(YEKATERINBURG, KIEV, MINSK, MOSCOW, SANKTPETERSBURG, CHELYABINSK);
        ALL_CITIES = ImmutableList.of(YEKATERINBURG, KIEV, MINSK, MOSCOW, SANKTPETERSBURG, TROICK, CHELYABINSK);
    }

    public static void setUp() {
        CityDao dao = DBIProvider.getDao(CityDao.class);
        dao.clean();
        DBIProvider.getDBI().useTransaction((conn, status) -> {
            FIRST_SIX_CITIES.forEach(dao::insert);
        });
    }
}
