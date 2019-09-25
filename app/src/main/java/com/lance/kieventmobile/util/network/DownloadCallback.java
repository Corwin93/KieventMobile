package com.lance.kieventmobile.util.network;

import android.net.NetworkInfo;

import com.lance.kieventmobile.model.Category;
import com.lance.kieventmobile.model.Event;
import com.lance.kieventmobile.util.database.EventsDbHelper;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Sample interface containing bare minimum methods needed for an asynchronous task
 * to update the UI Context.
 */

public interface DownloadCallback<T> extends Observer<T> {

    void prepareDatabase(Category category);

    /**
     * Get the device's active network status in the form of a NetworkInfo object.
     */
    NetworkInfo getActiveNetworkInfo();
}