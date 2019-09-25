package com.lance.kieventmobile.ui.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lance.kieventmobile.R;
import com.lance.kieventmobile.model.Category;
import com.lance.kieventmobile.ui.adapters.impl.EventCursorAdapter;
import com.lance.kieventmobile.util.database.EventsDbHelper;

import java.util.Objects;

/**
 * Created by Corwin on 02.05.2017.
 */

public class EventListFragment extends Fragment {
    private static final String ARGUMENT_CATEGORY = "com.lance.kieventmobile.mCategory";

    private FragmentActivity mCurrentContext;
    private EventCursorAdapter mAdapter;
    private Category mCategory;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mCategory = Category.valueOf(getArguments().getString(ARGUMENT_CATEGORY, "ROCK"));
        Cursor cursor = Objects.requireNonNull(EventsDbHelper.Builder.getInstance(mCurrentContext, mCategory)).selectAllEvents();
        mAdapter = new EventCursorAdapter(getActivity(), cursor);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_list, container, false);
        mRecyclerView = rootView.findViewById(R.id.events_recycler);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setNestedScrollingEnabled(true);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCurrentContext = getActivity();
    }

    public static EventListFragment newInstance(Category category) {
        EventListFragment newFragment = new EventListFragment();
        Bundle args = new Bundle();
        args.putString(ARGUMENT_CATEGORY, category.toString());
        newFragment.setArguments(args);
        return newFragment;
    }
}
