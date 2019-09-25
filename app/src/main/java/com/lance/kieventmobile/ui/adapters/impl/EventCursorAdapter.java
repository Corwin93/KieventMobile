package com.lance.kieventmobile.ui.adapters.impl;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lance.kieventmobile.ui.activities.EventActivity;
import com.lance.kieventmobile.R;
import com.lance.kieventmobile.ui.adapters.CursorRecyclerViewAdapter;
import com.lance.kieventmobile.util.database.EventContract;
import com.squareup.picasso.Picasso;

import static com.lance.kieventmobile.ui.activities.EventActivity.EXTRA_CHOSEN_CATEGORY;
import static com.lance.kieventmobile.ui.activities.EventActivity.EXTRA_CHOSEN_EVENT_POSITION;

/**
 * Created by User on 8/13/2017.
 */

public class EventCursorAdapter extends CursorRecyclerViewAdapter<EventCursorAdapter.ViewHolder> {
    private Context mCurrentContext;
    private RecyclerView mRecyclerView;

    public EventCursorAdapter(Context context, Cursor cursor) {
        super(context,cursor);
        mCurrentContext = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvDate;
        TextView tvPrice;
        ImageView ivImage;
        CardView cvRoot;
        public ViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.list_item_title);
            tvDate = view.findViewById(R.id.list_item_date);
            tvPrice = view.findViewById(R.id.list_item_price);
            ivImage = view.findViewById(R.id.list_item_image);
            cvRoot = view.findViewById(R.id.card_view);
        }
    }

    @Override
    public EventCursorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event, parent, false);
        return new EventCursorAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final EventCursorAdapter.ViewHolder viewHolder, Cursor cursor) {
        viewHolder.tvTitle.setText(cursor.getString(cursor.getColumnIndex(EventContract.RockEventsEntry.COLUMN_NAME_TITLE)));
        viewHolder.tvDate.setText(cursor.getString(cursor.getColumnIndex(EventContract.RockEventsEntry.COLUMN_NAME_DATE)));
        viewHolder.tvPrice.setText(cursor.getString(cursor.getColumnIndex(EventContract.RockEventsEntry.COLUMN_NAME_PRICE)));
        Picasso.with(mCurrentContext)
                .load(cursor.getString(cursor.getColumnIndex(EventContract.RockEventsEntry.COLUMN_NAME_IMAGE)).trim())
                .into(viewHolder.ivImage);
        viewHolder.cvRoot.setOnClickListener(view -> {
            int position = viewHolder.getAdapterPosition();
            Intent intent = new Intent(mCurrentContext, EventActivity.class);
            intent.putExtra(EXTRA_CHOSEN_EVENT_POSITION, position);
            intent.putExtra(EXTRA_CHOSEN_CATEGORY, EventCursorAdapter.this.getCursor().getString(EventCursorAdapter.this.getCursor().getColumnIndex(EventContract.RockEventsEntry.COLUMN_NAME_CATEGORY)));
            mCurrentContext.startActivity(intent);
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }
}