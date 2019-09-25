package com.lance.kieventmobile.model;

/**
 * Created by Corwin on 27.05.2015.
 */
public enum Category {
    ESTRADE("Эстрадные выступления"), ROCK("Рок концерты"),
    BALLET("Танцевальные шоу и балетные выступления"),
    HUMOUR("Концерты юмористов"), SPECTACLE("Гастрольные спектакли");

    private final String mValue;

    Category(String value) {
        mValue = value;
    }

    public String getValue() {
        return mValue;
    }

    public static Category get(int position) {
        switch (position) {
            case 0:
                return ESTRADE;
            case 1:
                return ROCK;
            case 2:
                return BALLET;
            case 3:
                return HUMOUR;
            case 4:
                return SPECTACLE;
            default:
                return ROCK;
        }
    }
}
