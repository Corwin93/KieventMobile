package com.lance.kieventmobile.util.network;

import android.accounts.NetworkErrorException;
import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.lance.kieventmobile.model.Category;
import com.lance.kieventmobile.model.Event;
import com.lance.kieventmobile.util.database.EventsDbHelper;
import com.lance.kieventmobile.util.network.retrofit.EventsApi;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ПК on 07.04.2018.
 */

public class NetworkTask {
    public static final String TAG = "NetworkTask";

    private DownloadCallback mCallback;
    private String baseUrl;

    public NetworkTask(@NonNull DownloadCallback mCallback, String baseUrl) {
        this.mCallback = mCallback;
        this.baseUrl = baseUrl;
    }

    @SuppressLint("CheckResult")
    public void downloadAll() {
//            NetworkInfo networkInfo = mCallback.getActiveNetworkInfo();
//            if (networkInfo == null || !networkInfo.isConnected() ||
//                    (networkInfo.getType() != ConnectivityManager.TYPE_WIFI
//                            && networkInfo.getType() != ConnectivityManager.TYPE_MOBILE)) {
//                mCallback.onError(new NetworkErrorException());
//            }
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                    .build();
            EventsApi eventsApi = retrofit.create(EventsApi.class);

            for (Category category: Category.values()) {
                mCallback.prepareDatabase(category);
                eventsApi.getData(category.toString()).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(mCallback::onNext, mCallback::onError, mCallback::onComplete);
//                        .enqueue(new Callback<List<Event>>() {
//                    @Override
//                    public void onResponse(@NonNull Call<List<Event>> call, @NonNull Response<List<Event>> response) {
//                        List<Event> eventList = response.body();
//                        if (eventList == null) {
//                            e.onError(new NullPointerException());
//                        } else {
//                            Log.d(getClass().getSimpleName(), "onResponse: list size = ".concat(String.valueOf(eventList.size())));
//                            for (Event event: eventList) {
//                                e.onNext(event); //TODO e is DISPOSED by this moment
//                            }
//                        }
//                        Log.d(TAG, category.toString().concat(" has been processed."));
//                    }
//
//                    @Override
//                    public void onFailure(@NonNull Call<List<Event>> call, @NonNull Throwable t) {
//                        Log.d(getClass().getSimpleName(), "onFailure: ".concat(t.getClass().getSimpleName()));
//                        e.onError(t);
//                    }
//                });
            }

    }
}
