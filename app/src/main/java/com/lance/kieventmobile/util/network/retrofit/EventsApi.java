package com.lance.kieventmobile.util.network.retrofit;

import com.lance.kieventmobile.model.Event;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ПК on 07.04.2018.
 */

public interface EventsApi {
    @GET("{category}.json")
    Observable<List<Event>> getData(@Path("category") String category);
}
