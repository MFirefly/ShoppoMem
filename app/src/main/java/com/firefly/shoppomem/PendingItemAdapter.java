package com.firefly.shoppomem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by maja.filakovic on 2.5.2016..
 */
public class PendingItemAdapter extends ArrayAdapter<Item> {

    private Context mContext;
    private int mLayoutResourceId;
    private ArrayList<Item> mPendingItemData = null;

    public PendingItemAdapter(Context mContext, int mLayoutResourceId, ArrayList<Item> mPendingItemData) {
        super(mContext, mLayoutResourceId, mPendingItemData);
        this.mContext = mContext;
        this.mLayoutResourceId = mLayoutResourceId;
        this.mPendingItemData = mPendingItemData;
    }

    private Context getmContext() {
        return mContext;
    }

    private int getmLayoutResourceId() {
        return mLayoutResourceId;
    }

    private ArrayList<Item> getmPendingItemData() {
        return mPendingItemData;
    }

    @Override
    public Item getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        final PlaceHolder holder;

        /* If we currently don't have a row to reuse... */
        if (row == null) {
            /* Inflate the layout for a single row - create a new view */
            LayoutInflater inflater = LayoutInflater.from(getmContext());
            row = inflater.inflate(getmLayoutResourceId(), parent, false);

            holder = new PlaceHolder();

            /* Get a reference to the different view elements we wish to update */
            holder.nameView = (TextView) row.findViewById(R.id.pendingListRowTextName);
            holder.qtyView = (TextView) row.findViewById(R.id.pendingListRowTextQuantity);
            holder.infoView = (TextView) row.findViewById(R.id.pendingListRowTextInfo);
            holder.checkImageView = (ImageView) row.findViewById(R.id.pendingListRowImageViewCheck);

            row.setTag(holder);
        } else {
            holder = (PlaceHolder) row.getTag();
        }

        /* Get the data from the item data array */
        final Item pendingItem = getmPendingItemData().get(position);

        holder.nameView.setText(pendingItem.getItemName());
        holder.infoView.setText(pendingItem.getAdditionalInfo());
        holder.qtyView.setText(pendingItem.getQuantity());

        /* Set image depending of mSelected flag of the Item */
        if(pendingItem.ismSelected()) {
            holder.checkImageView.setImageResource(R.mipmap.ic_check_circle_black_36dp);
        } else {
            holder.checkImageView.setImageResource(R.mipmap.ic_panorama_fish_eye_black_36dp);
        }

        return row;
    }

    private class PlaceHolder {
        TextView nameView;
        TextView qtyView;
        TextView infoView;
        ImageView checkImageView;
    }
}
