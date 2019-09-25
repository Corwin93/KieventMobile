package com.lance.kieventmobile.ui.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.TextView;

import com.lance.kieventmobile.R;
import com.lance.kieventmobile.model.Category;
import com.lance.kieventmobile.model.Event;
import com.lance.kieventmobile.util.database.EventsDbHelper;
import com.lance.kieventmobile.util.network.DownloadCallback;
import com.lance.kieventmobile.util.network.NetworkTask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import io.reactivex.disposables.Disposable;

/**
 * Created by Corwin on 11.07.2017.
 */

public class LoadingScreenActivity extends FragmentActivity implements DownloadCallback<List<Event>> {
    public static final String SERVER_URL = "https://rollallover.000webhostapp.com/";

    private TextView tvProgressLabel;
    private int downloadProgress = 0;

    // Boolean telling us whether a download is in progress, so we don't trigger overlapping
    // downloads with consecutive button clicks.
    private boolean mDownloading = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        tvProgressLabel = findViewById(R.id.tvProgressLabel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startDownload();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void startDownload() {
        if (!mDownloading) {
            new NetworkTask(this, SERVER_URL).downloadAll();
            mDownloading = true;
        }
    }

    @Override
    public NetworkInfo getActiveNetworkInfo() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return Objects.requireNonNull(connectivityManager).getActiveNetworkInfo();
    }

    public EventsDbHelper getDbHelper(Category category) {
        return EventsDbHelper.Builder.getInstance(this, category);
    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.d(getLocalClassName(), "onSubscribe");
    }



    @Override
    public void onNext(List<Event> eventList) {
        for (Event event: eventList) {
            getDbHelper(event.getCategory()).insertEvent(event);
            Log.d(getLocalClassName(), "onNext: ".concat(event.getTitle()));
        }
        
    }

    @Override
    public void onError(Throwable e) {
        Log.d(getLocalClassName(), "onError: ".concat(e.getClass().getSimpleName()));
        final AlertDialog dialog = new AlertDialog(LoadingScreenActivity.this) {
            @Override
            public void onBackPressed() {
                LoadingScreenActivity.this.finish();
            }
        };
        dialog.setMessage(getString(R.string.failure_server_message));
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.failure_exit_button_label), (dialogInterface, i) -> {
            dialog.dismiss();
            LoadingScreenActivity.this.finish();
        });
        dialog.show();
    }

    @Override
    public void onComplete() {
        downloadProgress += 1;
        tvProgressLabel.setText(String.valueOf(downloadProgress*(100/Category.values().length)).concat("%"));
        if (downloadProgress == Category.values().length) {
            mDownloading = false;
            startActivity(new Intent(LoadingScreenActivity.this, MainTabbedActivity.class));
            finish();
        }
    }

    @Override
    public void prepareDatabase(Category category) {
        EventsDbHelper dbHelper = getDbHelper(category);
        dbHelper.eraseTable();
    }
}
