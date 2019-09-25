package com.lance.kieventmobile.ui.activities;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lance.kieventmobile.R;
import com.lance.kieventmobile.model.Category;
import com.lance.kieventmobile.model.Event;
import com.lance.kieventmobile.ui.fragments.EventFragment;
import com.lance.kieventmobile.util.database.EventContract;
import com.lance.kieventmobile.util.database.EventsDbHelper;
import com.lance.kieventmobile.util.page_transformers.DepthPageTransformer;

import java.util.UUID;

public class EventActivity extends AppCompatActivity {
    public static final String EXTRA_CHOSEN_EVENT_POSITION = "com.lance.kieventmobile.chosen_event_POSITION";
    public static final String EXTRA_CHOSEN_CATEGORY = "com.lance.kieventmobile.chosen_category";

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private int mChosenEventPosition;
    private Category mCategory;
    private Cursor mCursor;
    private ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mChosenEventPosition = getIntent().getIntExtra(EXTRA_CHOSEN_EVENT_POSITION, 0);
        mCategory = Category.valueOf(getIntent().getStringExtra(EXTRA_CHOSEN_CATEGORY));
        mCursor = EventsDbHelper.Builder.getInstance(this, mCategory).selectAllEvents();
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.event_container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(mChosenEventPosition);
        mViewPager.setPageTransformer(true, new DepthPageTransformer());
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Event event = new Event();
            if (mCursor.moveToPosition(position)) {
                event.setId(UUID.fromString(mCursor.getString(mCursor.getColumnIndex(EventContract.EventsEntry.COLUMN_NAME_ID))));
                event.setTitle(mCursor.getString(mCursor.getColumnIndex(EventContract.EventsEntry.COLUMN_NAME_TITLE)));
                event.setDate(mCursor.getString(mCursor.getColumnIndex(EventContract.EventsEntry.COLUMN_NAME_DATE)));
                event.setTime(mCursor.getString(mCursor.getColumnIndex(EventContract.EventsEntry.COLUMN_NAME_TIME)));
                event.setAddress(mCursor.getString(mCursor.getColumnIndex(EventContract.EventsEntry.COLUMN_NAME_ADDRESS)));
                event.setPrice(mCursor.getString(mCursor.getColumnIndex(EventContract.EventsEntry.COLUMN_NAME_PRICE)));
                event.setImage(mCursor.getString(mCursor.getColumnIndex(EventContract.EventsEntry.COLUMN_NAME_IMAGE)));
                event.setOrder(mCursor.getString(mCursor.getColumnIndex(EventContract.EventsEntry.COLUMN_NAME_ORDER)));
                event.setCategory(mCategory);
            }
            return EventFragment.newInstance(event);
        }

        @Override
        public int getCount() {
            return mCursor.getCount();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mCategory.toString();
        }
    }
}
