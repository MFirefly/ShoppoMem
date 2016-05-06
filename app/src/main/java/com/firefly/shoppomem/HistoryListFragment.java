package com.firefly.shoppomem;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by maja.filakovic on 4.5.2016..
 */
public class HistoryListFragment extends ListFragment {

    OnHistoryListSelectedListener callback;

    public interface OnHistoryListSelectedListener {
        public void onHistoryListSelected(int position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        /* Make sure that the container Activity has implemented
         * the interface. If not, throw an exception */
        try {
            callback = (OnHistoryListSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement OnHistoryListSelectedListener!");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /* Set list adapter */
        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, HistoryActivity.getHistoryList()));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        /* Notify the parent of the selected item */
        callback.onHistoryListSelected(position);
    }
}
