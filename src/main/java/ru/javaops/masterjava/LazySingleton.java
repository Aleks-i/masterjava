package ru.javaops.masterjava;

public class LazySingleton {
    private static volatile LazySingleton instance;
    private final int i;

    private LazySingleton() {
        i = 5 + 8;
    }

    public static LazySingleton getInstance() {
        return LazyHolder.INSTANSE;
        /*if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;*/
    }

    private static class LazyHolder {
        private static final LazySingleton INSTANSE = new LazySingleton();
    }
}
