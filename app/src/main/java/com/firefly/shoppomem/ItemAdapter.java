package com.firefly.shoppomem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by maja.filakovic on 27.4.2016..
 */
public class ItemAdapter extends ArrayAdapter<Item> {

    private Context mContext;
    private int mLayoutResourceId;
    private ArrayList<Item> mItemData = null;

    public ItemAdapter(Context context, int resource, ArrayList<Item> data) {
        super(context, resource, data);
        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.mItemData = data;
    }

    private Context getmContext() {
        return mContext;
    }

    private int getmLayoutResourceId() {
        return mLayoutResourceId;
    }

    private ArrayList<Item> getmItemData() {
        return mItemData;
    }

    @Override
    public Item getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        PlaceHolder holder = null;

        /* If we currently don't have a row View to reuse... */
        if (row == null) {
            /* Inflate the layout for a single row  - create a new view */
            LayoutInflater inflater = LayoutInflater.from(getmContext());
            row = inflater.inflate(getmLayoutResourceId(), parent, false);

            holder = new PlaceHolder();

            /* Get a reference to the different view elements we wish to update */
            holder.addImageView = (ImageView) row.findViewById(R.id.newListRowImageViewAdd);
            holder.deleteImageView = (ImageView) row.findViewById(R.id.newListRowImageViewDelete);
            holder.nameView = (TextView) row.findViewById(R.id.newListRowTextName);
            holder.qtyView = (TextView) row.findViewById(R.id.newListRowTextQuantity);
            holder.infoView = (TextView) row.findViewById(R.id.newListRowTextInfo);

            row.setTag(holder);
        } else {
            holder = (PlaceHolder) row.getTag();
        }

        /* Get the data from the item data array */
        Item item = getmItemData().get(position);

        /* Setup and reuse the same listener for each row for add image */
        holder.addImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "AddImage!", Toast.LENGTH_SHORT).show();
            }
        });

        /* Setup and reuse the same listener for each row for delete from list */
        holder.deleteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Delete the selected item from the list */
                getmItemData().remove(position);
                NewListActivity.getNewListItemAdapter().notifyDataSetChanged();
            }
        });

        /* Setting the view to reflect the data we need to display */
        holder.nameView.setText(item.getItemName());
        holder.infoView.setText(item.getAdditionalInfo());
        holder.qtyView.setText(item.getQuantity());

        return row;
    }


    private class PlaceHolder {
        TextView nameView;
        TextView qtyView;
        TextView infoView;
        ImageView addImageView;
        ImageView deleteImageView;
    }
}
