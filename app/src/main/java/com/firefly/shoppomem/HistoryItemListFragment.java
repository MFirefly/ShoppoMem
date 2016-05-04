package com.firefly.shoppomem;

import android.annotation.TargetApi;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by maja.filakovic on 4.5.2016..
 */
public class HistoryItemListFragment extends ListFragment {

    final static String ARG_POSITION = "POSITION";
    private int currentPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            /* If we recreated this Fragment restore the previous list selection
             * by getting it here */
            currentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        /* Inflate the view for this fragment */
        View myFragmentView = inflater.inflate(R.layout.history_item_list_fragment, container, false);
        return myFragmentView;
    }

    @TargetApi(23)
    public void updateListView(int position) {
        View v = getListView();
        ListView listView = (ListView) v.findViewById(android.R.id.list);
        listView.setAdapter(new PendingItemAdapter(getContext(), R.layout.pending_list_row, HistoryActivity.getHistoryList().get(position).getmItemsList()));
        currentPosition = position;
    }

    @Override
    public void onStart() {
        super.onStart();

        /* Check if there are arguments(data) passed to this Fragment. We know that layout
         * has already been applied to the Fragment so we can safely call the method
         * that sets the list of items.*/
        Bundle args = getArguments();
        if (args != null) {
            /* Set item list based on the argument passed in */
            updateListView(args.getInt(ARG_POSITION));
        } else if (currentPosition != -1) {
            /* Set the item list based on the saved instance state defined during onCreateView*/
            updateListView(currentPosition);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        /* Save the current selection for later recreation of this Fragment */
        outState.putInt(ARG_POSITION, currentPosition);
    }
}
