package com.lance.kieventmobile.util.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.lance.kieventmobile.model.Category;
import com.lance.kieventmobile.model.Event;

/**
 * Created by Corwin on 25.06.2017.
 */

public abstract class EventsDbHelper extends SQLiteOpenHelper {
    static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Events.db";
    private static final String LOG_TAG = "EventsDbHelper";

    EventsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "--- onCreate database ---");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        DATABASE_VERSION++;
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public abstract void eraseTable();

    public abstract long insertEvent(Event event);

    public abstract Cursor selectAllEvents();

    public static class Builder {
        public static EventsDbHelper getInstance(Context context, Category category) {
            if (category.equals(Category.ROCK)) {
                return RockEventsDbHelper.getInstance(context);
            } else if (category.equals(Category.BALLET)) {
                return BalletEventsDbHelper.getInstance(context);
            } else if (category.equals(Category.ESTRADE)) {
                return EstradeEventsDbHelper.getInstance(context);
            } else if (category.equals(Category.HUMOUR)) {
                return HumourEventsDbHelper.getInstance(context);
            } else if (category.equals(Category.SPECTACLE)) {
                return SpectacleEventsDbHelper.getInstance(context);
            }
            return null;
        }
    }

    private static final class RockEventsDbHelper extends EventsDbHelper {
        private static RockEventsDbHelper instance;

        private static RockEventsDbHelper getInstance(Context context) {
            if (instance == null) {
                instance = new RockEventsDbHelper(context);
            }
            return instance;
        }

        RockEventsDbHelper(Context context) {
            super(context);
        }



        @Override
        public void onCreate(SQLiteDatabase db) {
            super.onCreate(db);
            db.execSQL(EventContract.RockEventsEntry.SQL_DROP_TABLE);
            db.execSQL(EventContract.RockEventsEntry.SQL_CREATE_TABLE);
        }

        @Override
        public void eraseTable() {
            getWritableDatabase().execSQL(EventContract.RockEventsEntry.SQL_DROP_TABLE);
            getWritableDatabase().execSQL(EventContract.RockEventsEntry.SQL_CREATE_TABLE);
        }

        @Override
        public long insertEvent(Event event) {
            ContentValues values = new ContentValues();
            values.put(EventContract.RockEventsEntry.COLUMN_NAME_ID, event.getId().toString());
            values.put(EventContract.RockEventsEntry.COLUMN_NAME_TITLE, event.getTitle());
            values.put(EventContract.RockEventsEntry.COLUMN_NAME_DATE, event.getDate());
            values.put(EventContract.RockEventsEntry.COLUMN_NAME_TIME, event.getTime());
            values.put(EventContract.RockEventsEntry.COLUMN_NAME_ADDRESS, event.getAddress());
            values.put(EventContract.RockEventsEntry.COLUMN_NAME_PRICE, event.getPrice());
            values.put(EventContract.RockEventsEntry.COLUMN_NAME_IMAGE, event.getImage());
            values.put(EventContract.RockEventsEntry.COLUMN_NAME_ORDER, event.getOrder());
            values.put(EventContract.RockEventsEntry.COLUMN_NAME_CATEGORY, EventContract.RockEventsEntry.CATEGORY_PLACEHOLDER);
            return getWritableDatabase().insert(EventContract.RockEventsEntry.TABLE_NAME, null, values);
        }

        @Override
        public Cursor selectAllEvents() {
            SQLiteDatabase db = getReadableDatabase();
            return db.rawQuery(EventContract.RockEventsEntry.SQL_SELECT_ALL_ENTRIES, null);
        }
    }

    private static final class ClubEventsDbHelper extends EventsDbHelper {
        private static ClubEventsDbHelper instance;

        private static ClubEventsDbHelper getInstance(Context context) {
            if (instance == null) {
                instance = new ClubEventsDbHelper(context);
            }

            return instance;
        }

        ClubEventsDbHelper(Context context) {
            super(context);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            super.onCreate(db);
            db.execSQL(EventContract.ClubEventsEntry.SQL_DROP_TABLE);
            db.execSQL(EventContract.ClubEventsEntry.SQL_CREATE_TABLE);
        }

        @Override
        public void eraseTable() {
            getWritableDatabase().execSQL(EventContract.ClubEventsEntry.SQL_DROP_TABLE);
            getWritableDatabase().execSQL(EventContract.ClubEventsEntry.SQL_CREATE_TABLE);
        }

        @Override
        public long insertEvent(Event event) {
            ContentValues values = new ContentValues();
            values.put(EventContract.ClubEventsEntry.COLUMN_NAME_ID, event.getId().toString());
            values.put(EventContract.ClubEventsEntry.COLUMN_NAME_TITLE, event.getTitle());
            values.put(EventContract.ClubEventsEntry.COLUMN_NAME_DATE, event.getDate());
            values.put(EventContract.ClubEventsEntry.COLUMN_NAME_TIME, event.getTime());
            values.put(EventContract.ClubEventsEntry.COLUMN_NAME_ADDRESS, event.getAddress());
            values.put(EventContract.ClubEventsEntry.COLUMN_NAME_PRICE, event.getPrice());
            values.put(EventContract.ClubEventsEntry.COLUMN_NAME_IMAGE, event.getImage());
            values.put(EventContract.ClubEventsEntry.COLUMN_NAME_ORDER, event.getOrder());
            values.put(EventContract.ClubEventsEntry.COLUMN_NAME_CATEGORY, EventContract.ClubEventsEntry.CATEGORY_PLACEHOLDER);
            return getWritableDatabase().insert(EventContract.ClubEventsEntry.TABLE_NAME, null, values);
        }

        @Override
        public Cursor selectAllEvents() {
            SQLiteDatabase db = getReadableDatabase();
            return db.rawQuery(EventContract.ClubEventsEntry.SQL_SELECT_ALL_ENTRIES, null);
        }
    }

    private static final class SpectacleEventsDbHelper extends EventsDbHelper {
        private static SpectacleEventsDbHelper instance;

        private static SpectacleEventsDbHelper getInstance(Context context) {
            if (instance == null) {
                instance = new SpectacleEventsDbHelper(context);
            }

            return instance;
        }

        SpectacleEventsDbHelper(Context context) {
            super(context);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            super.onCreate(db);
            db.execSQL(EventContract.SpectacleEventsEntry.SQL_DROP_TABLE);
            db.execSQL(EventContract.SpectacleEventsEntry.SQL_CREATE_TABLE);
        }

        @Override
        public void eraseTable() {
            getWritableDatabase().execSQL(EventContract.SpectacleEventsEntry.SQL_DROP_TABLE);
            getWritableDatabase().execSQL(EventContract.SpectacleEventsEntry.SQL_CREATE_TABLE);
        }

        @Override
        public long insertEvent(Event event) {
            ContentValues values = new ContentValues();
            values.put(EventContract.SpectacleEventsEntry.COLUMN_NAME_ID, event.getId().toString());
            values.put(EventContract.SpectacleEventsEntry.COLUMN_NAME_TITLE, event.getTitle());
            values.put(EventContract.SpectacleEventsEntry.COLUMN_NAME_DATE, event.getDate());
            values.put(EventContract.SpectacleEventsEntry.COLUMN_NAME_TIME, event.getTime());
            values.put(EventContract.SpectacleEventsEntry.COLUMN_NAME_ADDRESS, event.getAddress());
            values.put(EventContract.SpectacleEventsEntry.COLUMN_NAME_PRICE, event.getPrice());
            values.put(EventContract.SpectacleEventsEntry.COLUMN_NAME_IMAGE, event.getImage());
            values.put(EventContract.SpectacleEventsEntry.COLUMN_NAME_ORDER, event.getOrder());
            values.put(EventContract.SpectacleEventsEntry.COLUMN_NAME_CATEGORY, EventContract.SpectacleEventsEntry.CATEGORY_PLACEHOLDER);
            return getWritableDatabase().insert(EventContract.SpectacleEventsEntry.TABLE_NAME, null, values);
        }

        @Override
        public Cursor selectAllEvents() {
            SQLiteDatabase db = getReadableDatabase();
            return db.rawQuery(EventContract.SpectacleEventsEntry.SQL_SELECT_ALL_ENTRIES, null);
        }
    }

    private static final class HumourEventsDbHelper extends EventsDbHelper {
        private static HumourEventsDbHelper instance;

        private static HumourEventsDbHelper getInstance(Context context) {
            if (instance == null) {
                instance = new HumourEventsDbHelper(context);
            }

            return instance;
        }

        HumourEventsDbHelper(Context context) {
            super(context);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            super.onCreate(db);
            db.execSQL(EventContract.HumourEventsEntry.SQL_DROP_TABLE);
            db.execSQL(EventContract.HumourEventsEntry.SQL_CREATE_TABLE);
        }

        @Override
        public void eraseTable() {
            getWritableDatabase().execSQL(EventContract.HumourEventsEntry.SQL_DROP_TABLE);
            getWritableDatabase().execSQL(EventContract.HumourEventsEntry.SQL_CREATE_TABLE);
        }

        @Override
        public long insertEvent(Event event) {
            ContentValues values = new ContentValues();
            values.put(EventContract.HumourEventsEntry.COLUMN_NAME_ID, event.getId().toString());
            values.put(EventContract.HumourEventsEntry.COLUMN_NAME_TITLE, event.getTitle());
            values.put(EventContract.HumourEventsEntry.COLUMN_NAME_DATE, event.getDate());
            values.put(EventContract.HumourEventsEntry.COLUMN_NAME_TIME, event.getTime());
            values.put(EventContract.HumourEventsEntry.COLUMN_NAME_ADDRESS, event.getAddress());
            values.put(EventContract.HumourEventsEntry.COLUMN_NAME_PRICE, event.getPrice());
            values.put(EventContract.HumourEventsEntry.COLUMN_NAME_IMAGE, event.getImage());
            values.put(EventContract.HumourEventsEntry.COLUMN_NAME_ORDER, event.getOrder());
            values.put(EventContract.HumourEventsEntry.COLUMN_NAME_CATEGORY, EventContract.HumourEventsEntry.CATEGORY_PLACEHOLDER);
            return getWritableDatabase().insert(EventContract.HumourEventsEntry.TABLE_NAME, null, values);
        }

        @Override
        public Cursor selectAllEvents() {
            SQLiteDatabase db = getReadableDatabase();
            return db.rawQuery(EventContract.HumourEventsEntry.SQL_SELECT_ALL_ENTRIES, null);
        }
    }

    private static final class DolphinEventsDbHelper extends EventsDbHelper {
        private static DolphinEventsDbHelper instance;

        private static DolphinEventsDbHelper getInstance(Context context) {
            if (instance == null) {
                instance = new DolphinEventsDbHelper(context);
            }

            return instance;
        }

        DolphinEventsDbHelper(Context context) {
            super(context);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            super.onCreate(db);
            db.execSQL(EventContract.DolphinEventsEntry.SQL_DROP_TABLE);
            db.execSQL(EventContract.DolphinEventsEntry.SQL_CREATE_TABLE);
        }

        @Override
        public void eraseTable() {
            getWritableDatabase().execSQL(EventContract.DolphinEventsEntry.SQL_DROP_TABLE);
            getWritableDatabase().execSQL(EventContract.DolphinEventsEntry.SQL_CREATE_TABLE);
        }

        @Override
        public long insertEvent(Event event) {
            ContentValues values = new ContentValues();
            values.put(EventContract.DolphinEventsEntry.COLUMN_NAME_ID, event.getId().toString());
            values.put(EventContract.DolphinEventsEntry.COLUMN_NAME_TITLE, event.getTitle());
            values.put(EventContract.DolphinEventsEntry.COLUMN_NAME_DATE, event.getDate());
            values.put(EventContract.DolphinEventsEntry.COLUMN_NAME_TIME, event.getTime());
            values.put(EventContract.DolphinEventsEntry.COLUMN_NAME_ADDRESS, event.getAddress());
            values.put(EventContract.DolphinEventsEntry.COLUMN_NAME_PRICE, event.getPrice());
            values.put(EventContract.DolphinEventsEntry.COLUMN_NAME_IMAGE, event.getImage());
            values.put(EventContract.DolphinEventsEntry.COLUMN_NAME_ORDER, event.getOrder());
            values.put(EventContract.DolphinEventsEntry.COLUMN_NAME_CATEGORY, EventContract.DolphinEventsEntry.CATEGORY_PLACEHOLDER);
            return getWritableDatabase().insert(EventContract.DolphinEventsEntry.TABLE_NAME, null, values);
        }

        @Override
        public Cursor selectAllEvents() {
            SQLiteDatabase db = getReadableDatabase();
            return db.rawQuery(EventContract.DolphinEventsEntry.SQL_SELECT_ALL_ENTRIES, null);
        }
    }

    private static final class BalletEventsDbHelper extends EventsDbHelper {
        private static BalletEventsDbHelper instance;

        private static BalletEventsDbHelper getInstance(Context context) {
            if (instance == null) {
                instance = new BalletEventsDbHelper(context);
            }

            return instance;
        }

        BalletEventsDbHelper(Context context) {
            super(context);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            super.onCreate(db);
            db.execSQL(EventContract.BalletEventsEntry.SQL_DROP_TABLE);
            db.execSQL(EventContract.BalletEventsEntry.SQL_CREATE_TABLE);
        }

        @Override
        public void eraseTable() {
            getWritableDatabase().execSQL(EventContract.BalletEventsEntry.SQL_DROP_TABLE);
            getWritableDatabase().execSQL(EventContract.BalletEventsEntry.SQL_CREATE_TABLE);
        }

        @Override
        public long insertEvent(Event event) {
            ContentValues values = new ContentValues();
            values.put(EventContract.BalletEventsEntry.COLUMN_NAME_ID, event.getId().toString());
            values.put(EventContract.BalletEventsEntry.COLUMN_NAME_TITLE, event.getTitle());
            values.put(EventContract.BalletEventsEntry.COLUMN_NAME_DATE, event.getDate());
            values.put(EventContract.BalletEventsEntry.COLUMN_NAME_TIME, event.getTime());
            values.put(EventContract.BalletEventsEntry.COLUMN_NAME_ADDRESS, event.getAddress());
            values.put(EventContract.BalletEventsEntry.COLUMN_NAME_PRICE, event.getPrice());
            values.put(EventContract.BalletEventsEntry.COLUMN_NAME_IMAGE, event.getImage());
            values.put(EventContract.BalletEventsEntry.COLUMN_NAME_ORDER, event.getOrder());
            values.put(EventContract.BalletEventsEntry.COLUMN_NAME_CATEGORY, EventContract.BalletEventsEntry.CATEGORY_PLACEHOLDER);
            return getWritableDatabase().insert(EventContract.BalletEventsEntry.TABLE_NAME, null, values);
        }

        @Override
        public Cursor selectAllEvents() {
            SQLiteDatabase db = getReadableDatabase();
            return db.rawQuery(EventContract.BalletEventsEntry.SQL_SELECT_ALL_ENTRIES, null);
        }
    }

    private static final class EstradeEventsDbHelper extends EventsDbHelper {
        private static EstradeEventsDbHelper instance;

        private static EstradeEventsDbHelper getInstance(Context context) {
            if (instance == null) {
                instance = new EstradeEventsDbHelper(context);
            }

            return instance;
        }

        EstradeEventsDbHelper(Context context) {
            super(context);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            super.onCreate(db);
            db.execSQL(EventContract.EstradeEventsEntry.SQL_DROP_TABLE);
            db.execSQL(EventContract.EstradeEventsEntry.SQL_CREATE_TABLE);
        }

        @Override
        public void eraseTable() {
            getWritableDatabase().execSQL(EventContract.EstradeEventsEntry.SQL_DROP_TABLE);
            getWritableDatabase().execSQL(EventContract.EstradeEventsEntry.SQL_CREATE_TABLE);
        }

        @Override
        public long insertEvent(Event event) {
            ContentValues values = new ContentValues();
            values.put(EventContract.EstradeEventsEntry.COLUMN_NAME_ID, event.getId().toString());
            values.put(EventContract.EstradeEventsEntry.COLUMN_NAME_TITLE, event.getTitle());
            values.put(EventContract.EstradeEventsEntry.COLUMN_NAME_DATE, event.getDate());
            values.put(EventContract.EstradeEventsEntry.COLUMN_NAME_TIME, event.getTime());
            values.put(EventContract.EstradeEventsEntry.COLUMN_NAME_ADDRESS, event.getAddress());
            values.put(EventContract.EstradeEventsEntry.COLUMN_NAME_PRICE, event.getPrice());
            values.put(EventContract.EstradeEventsEntry.COLUMN_NAME_IMAGE, event.getImage());
            values.put(EventContract.EstradeEventsEntry.COLUMN_NAME_ORDER, event.getOrder());
            values.put(EventContract.EstradeEventsEntry.COLUMN_NAME_CATEGORY, EventContract.EstradeEventsEntry.CATEGORY_PLACEHOLDER);
            return getWritableDatabase().insert(EventContract.EstradeEventsEntry.TABLE_NAME, null, values);
        }

        @Override
        public Cursor selectAllEvents() {
            SQLiteDatabase db = getReadableDatabase();
            return db.rawQuery(EventContract.EstradeEventsEntry.SQL_SELECT_ALL_ENTRIES, null);
        }
    }
}


