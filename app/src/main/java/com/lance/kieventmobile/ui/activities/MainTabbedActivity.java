package com.lance.kieventmobile.ui.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.lance.kieventmobile.ui.fragments.EventListFragment;
import com.lance.kieventmobile.R;
import com.lance.kieventmobile.model.Category;
import com.lance.kieventmobile.util.page_transformers.ZoomOutPageTransformer;

import java.util.Objects;

public class MainTabbedActivity extends AppCompatActivity {
    private static final int ICONS[] = new int[] {
            R.drawable.ic_microphone_variant_white_48dp,
            R.drawable.ic_guitar_electric_white_48dp,
            R.drawable.ic_theater_white_48dp,
            R.drawable.ic_tag_faces_white_48dp,
            R.drawable.ic_binoculars_white_48dp};

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private TextView tvToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tabbed);

        Toolbar toolbar = findViewById(R.id.main_tabbed_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("");
        tvToolbarTitle = findViewById(R.id.main_toolbar_title);
        tvToolbarTitle.setSelected(true);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        char[] chars = Category.get(0).getValue().toCharArray();
        String firstLetter = String.valueOf(chars[0]);
        firstLetter = firstLetter.toLowerCase();
        chars[0] = firstLetter.toCharArray()[0];
        tvToolbarTitle.setText("Ближайшие ".concat(String.valueOf(chars)));

        mViewPager = findViewById(R.id.list_container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                char[] chars = Category.get(position).getValue().toCharArray();
                tvToolbarTitle.setText(String.valueOf(chars));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        for (int position = 0; position < tabLayout.getTabCount(); position++) {
            tabLayout.getTabAt(position).setIcon(ICONS[position]);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_tabbed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            showAboutDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAboutDialog() {
        final AlertDialog dialog = new AlertDialog(MainTabbedActivity.this) {

        };
        dialog.setMessage(getString(R.string.about_dialog_message));
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.about_dialog_exit_button_label), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return EventListFragment.newInstance(Category.get(position));
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
