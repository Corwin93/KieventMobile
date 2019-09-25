package com.lance.kieventmobile.ui.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.lance.kieventmobile.R;
import com.lance.kieventmobile.model.Event;
import com.squareup.picasso.Picasso;

/**
 * Created by User on 9/18/2017.
 */

public class EventFragment extends Fragment {
    private static final String ARG_EVENT = "argEvent";

    private Event mEvent = null;
    private TextView tvDate;
    private TextView tvTime;
    private TextView tvAddress;
    private TextView tvPrice;
    private ImageView ivEventImage;
    private ImageView ivEventBackground;
    private TextView tvEventTitle;
    private Button btnBuy;
    private Uri orderUri;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if(getArguments().getSerializable(ARG_EVENT) != null) {
            mEvent = (Event) getArguments().getSerializable(ARG_EVENT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        linking(view);
        String tokenizedDates = tokenizeStringWithSpaces(mEvent.getDate());
        String tokenizedTime = tokenizeStringWithSpaces(mEvent.getTime());
        tvDate.setText(tokenizedDates);
        tvTime.setText(tokenizedTime);
        tvPrice.setText(mEvent.getPrice());
        tvAddress.setText(mEvent.getAddress());
        tvEventTitle.setText(mEvent.getTitle());
        orderUri = Uri.parse(mEvent.getOrder());
        btnBuy.setOnClickListener(view1 -> onButtonBuyPressed());
        Picasso.with(getActivity()).load(mEvent.getImage()).into(ivEventImage);
        Picasso.with(getActivity()).load(mEvent.getImage()).into(ivEventBackground);
        return view;
    }

    private void onButtonBuyPressed() {
        Intent buyIntent = new Intent(Intent.ACTION_VIEW);
        buyIntent.setData(orderUri);
        startActivity(buyIntent);
    }

    private void linking(View view) {
        tvDate = view.findViewById(R.id.eventDate);
        tvTime = view.findViewById(R.id.eventTime);
        tvAddress = view.findViewById(R.id.eventAddress);
        tvPrice = view.findViewById(R.id.eventPrice);
        ivEventImage = view.findViewById(R.id.eventImage);
        tvEventTitle = view.findViewById(R.id.eventTitle);
        ivEventBackground = view.findViewById(R.id.eventBackgroundImage);
        btnBuy = view.findViewById(R.id.btnBuy);
    }

    private String tokenizeStringWithSpaces(String target) {
        target = target.trim();
        return target.replace(" ", "\n");
    }

    public static EventFragment newInstance(Event event) {
        EventFragment fragment = new EventFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_EVENT, event);
        fragment.setArguments(args);
        return fragment;
    }
}
