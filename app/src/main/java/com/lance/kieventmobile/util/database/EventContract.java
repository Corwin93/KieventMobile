package com.lance.kieventmobile.util.database;

import android.content.Context;
import android.provider.BaseColumns;

/**
 * Created by Corwin on 06.06.2017.
 */

public final class EventContract {
    private EventContract() {}

    public static class EventsEntry implements BaseColumns {

        public static final String COLUMN_NAME_ID = "event_id";
        public static final String COLUMN_NAME_TITLE = "event_title";
        public static final String COLUMN_NAME_DATE = "event_date";
        public static final String COLUMN_NAME_TIME = "event_time";
        public static final String COLUMN_NAME_ADDRESS = "event_address";
        public static final String COLUMN_NAME_PRICE = "event_price";
        public static final String COLUMN_NAME_IMAGE = "event_image";
        public static final String COLUMN_NAME_CATEGORY = "event_category";
        public static final String COLUMN_NAME_ORDER = "event_order";
    }

    public static final class RockEventsEntry extends EventsEntry {
        public static final String CATEGORY_PLACEHOLDER = "ROCK";

        public static final String TABLE_NAME = "rock";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME_ID + " TEXT, " +
                        COLUMN_NAME_TITLE + " TEXT, " +
                        COLUMN_NAME_DATE + " TEXT, " +
                        COLUMN_NAME_TIME + " TEXT, " +
                        COLUMN_NAME_ADDRESS + " TEXT, " +
                        COLUMN_NAME_PRICE + " TEXT, " +
                        COLUMN_NAME_IMAGE + " TEXT, " +
                        COLUMN_NAME_ORDER + " TEXT, " +
                        COLUMN_NAME_CATEGORY + " TEXT" +
                        ");";
        public static final String SQL_SELECT_ALL_ENTRIES = "SELECT rowid _id,* FROM " + TABLE_NAME;

        public static final String SQL_DROP_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static final class BalletEventsEntry extends EventsEntry {
        public static final String CATEGORY_PLACEHOLDER = "BALLET";

        public static final String TABLE_NAME = "ballet";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NAME_ID + " TEXT, " +
                        COLUMN_NAME_TITLE + " TEXT, " +
                        COLUMN_NAME_DATE + " TEXT, " +
                        COLUMN_NAME_TIME + " TEXT, " +
                        COLUMN_NAME_ADDRESS + " TEXT, " +
                        COLUMN_NAME_PRICE + " TEXT, " +
                        COLUMN_NAME_IMAGE + " TEXT, " +
                        COLUMN_NAME_ORDER + " TEXT, " +
                        COLUMN_NAME_CATEGORY + " TEXT" +
                        ");";

        public static final String SQL_SELECT_ALL_ENTRIES = "SELECT rowid _id,* FROM " + TABLE_NAME;

        public static final String SQL_DROP_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static final class ClubEventsEntry extends EventsEntry {
        public static final String CATEGORY_PLACEHOLDER = "CLUB";

        public static final String TABLE_NAME = "club";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NAME_ID + " TEXT, " +
                        COLUMN_NAME_TITLE + " TEXT, " +
                        COLUMN_NAME_DATE + " TEXT, " +
                        COLUMN_NAME_TIME + " TEXT, " +
                        COLUMN_NAME_ADDRESS + " TEXT, " +
                        COLUMN_NAME_PRICE + " TEXT, " +
                        COLUMN_NAME_IMAGE + " TEXT, " +
                        COLUMN_NAME_ORDER + " TEXT, " +
                        COLUMN_NAME_CATEGORY + " TEXT" +
                        ");";

        public static final String SQL_SELECT_ALL_ENTRIES = "SELECT rowid _id,* FROM " + TABLE_NAME;

        public static final String SQL_DROP_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static final class DolphinEventsEntry extends EventsEntry {
        public static final String CATEGORY_PLACEHOLDER = "DOLPHIN";

        public static final String TABLE_NAME = "dolphin";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NAME_ID + " TEXT, " +
                        COLUMN_NAME_TITLE + " TEXT, " +
                        COLUMN_NAME_DATE + " TEXT, " +
                        COLUMN_NAME_TIME + " TEXT, " +
                        COLUMN_NAME_ADDRESS + " TEXT, " +
                        COLUMN_NAME_PRICE + " TEXT, " +
                        COLUMN_NAME_IMAGE + " TEXT, " +
                        COLUMN_NAME_ORDER + " TEXT, " +
                        COLUMN_NAME_CATEGORY + " TEXT" +
                        ");";

        public static final String SQL_SELECT_ALL_ENTRIES = "SELECT rowid _id,* FROM " + TABLE_NAME;

        public static final String SQL_DROP_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static final class EstradeEventsEntry extends EventsEntry {
        public static final String CATEGORY_PLACEHOLDER = "ESTRADE";

        public static final String TABLE_NAME = "estrade";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NAME_ID + " TEXT, " +
                        COLUMN_NAME_TITLE + " TEXT, " +
                        COLUMN_NAME_DATE + " TEXT, " +
                        COLUMN_NAME_TIME + " TEXT, " +
                        COLUMN_NAME_ADDRESS + " TEXT, " +
                        COLUMN_NAME_PRICE + " TEXT, " +
                        COLUMN_NAME_IMAGE + " TEXT, " +
                        COLUMN_NAME_ORDER + " TEXT, " +
                        COLUMN_NAME_CATEGORY + " TEXT" +
                        ");";

        public static final String SQL_SELECT_ALL_ENTRIES = "SELECT rowid _id,* FROM " + TABLE_NAME;

        public static final String SQL_DROP_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static final class HumourEventsEntry extends EventsEntry {
        public static final String CATEGORY_PLACEHOLDER = "HUMOUR";

        public static final String TABLE_NAME = "humour";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NAME_ID + " TEXT, " +
                        COLUMN_NAME_TITLE + " TEXT, " +
                        COLUMN_NAME_DATE + " TEXT, " +
                        COLUMN_NAME_TIME + " TEXT, " +
                        COLUMN_NAME_ADDRESS + " TEXT, " +
                        COLUMN_NAME_PRICE + " TEXT, " +
                        COLUMN_NAME_IMAGE + " TEXT, " +
                        COLUMN_NAME_ORDER + " TEXT, " +
                        COLUMN_NAME_CATEGORY + " TEXT" +
                        ");";

        public static final String SQL_SELECT_ALL_ENTRIES = "SELECT rowid _id,* FROM " + TABLE_NAME;

        public static final String SQL_DROP_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static final class SpectacleEventsEntry extends EventsEntry {
        public static final String CATEGORY_PLACEHOLDER = "SPECTACLE";

        public static final String TABLE_NAME = "spectacle";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NAME_ID + " TEXT, " +
                        COLUMN_NAME_TITLE + " TEXT, " +
                        COLUMN_NAME_DATE + " TEXT, " +
                        COLUMN_NAME_TIME + " TEXT, " +
                        COLUMN_NAME_ADDRESS + " TEXT, " +
                        COLUMN_NAME_PRICE + " TEXT, " +
                        COLUMN_NAME_IMAGE + " TEXT, " +
                        COLUMN_NAME_ORDER + " TEXT, " +
                        COLUMN_NAME_CATEGORY + " TEXT" +
                        ");";

        public static final String SQL_SELECT_ALL_ENTRIES = "SELECT rowid _id,* FROM " + TABLE_NAME;

        public static final String SQL_DROP_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
