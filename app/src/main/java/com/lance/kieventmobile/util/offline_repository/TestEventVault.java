package com.lance.kieventmobile.util.offline_repository;

import com.lance.kieventmobile.model.Category;
import com.lance.kieventmobile.model.Event;

import java.util.ArrayList;

/**
 * Created by Corwin on 27.05.2015.
 */
public class TestEventVault {
    private static ArrayList<Event> estrade = new ArrayList<>();
    private static ArrayList<Event> rock = new ArrayList<>();
    private static ArrayList<Event> spectacle = new ArrayList<>();
    private static ArrayList<Event> dolphin = new ArrayList<>();
    private static ArrayList<Event> humour = new ArrayList<>();
    private static ArrayList<Event> ballet = new ArrayList<>();
    private static ArrayList<Event> club = new ArrayList<>();

    public static void add(Event e, Category category) {
        switch(category) {
            case ESTRADE:{
                estrade.add(e);
                break;}
            case ROCK:{
                rock.add(e);
                break;}
            case SPECTACLE:{
                spectacle.add(e);
                break;}
            case HUMOUR:{
                humour.add(e);
                break;}
            case BALLET:{
                ballet.add(e);
                break;}
        }
    }

    public static ArrayList<Event> getEstrade() {
        return estrade;
    }

    public static ArrayList<Event> getRock() {
        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event("MARAKESH", "11.05.2017", "20:00", "Sentrum", "170-400 грн.",
                "http://1001bilet.com.ua/img/events/s_2502.jpg",
                "http://1001bilet.com.ua/bron/event.php?id=2502", Category.ROCK));
        events.add(new Event("Blood Brothers", "08.06.2017", "20:00", "Клуб «Atlas»",
                "150-450 грн.", "http://1001bilet.com.ua/img/events/s_2505.jpg",
                "http://1001bilet.com.ua/bron/event.php?id=2505", Category.ROCK));
        events.add(new Event("Рок-хиты. Симфонический оркестр «résonance»", "07.10.2017",
                "19:00", "ДК КПИ", "190-750 грн.", "http://1001bilet.com.ua/img/events/s_1513.jpg",
                "http://1001bilet.com.ua/bron/event.php?id=1513", Category.ROCK));
        return events;
    }

    public static ArrayList<Event> getSpectacle() {
        return spectacle;
    }

    public static ArrayList<Event> getDolphin() {
        return dolphin;
    }

    public static ArrayList<Event> getHumour() {
        return humour;
    }

    public static ArrayList<Event> getBallet() {
        return ballet;
    }

    public static ArrayList<Event> getClub() {
        return club;
    }
}
