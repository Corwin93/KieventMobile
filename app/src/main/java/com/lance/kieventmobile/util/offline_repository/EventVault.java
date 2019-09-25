package com.lance.kieventmobile.util.offline_repository;

import com.lance.kieventmobile.model.Category;
import com.lance.kieventmobile.model.Event;

import java.util.ArrayList;

/**
 * Created by Corwin on 27.05.2015.
 */
public class EventVault {
    private static int accessCount;
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
        access();
    }
    public static void access() {
        accessCount++;
    }

    public static int getAccessCount() {
        return accessCount;
    }

    public static ArrayList<Event> getEstrade() {
        return estrade;
    }

    public static ArrayList<Event> getRock() {
        return rock;
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
