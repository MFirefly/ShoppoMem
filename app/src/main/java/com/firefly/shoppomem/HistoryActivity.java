package com.firefly.shoppomem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity implements HistoryListFragment.OnHistoryListSelectedListener{

    private static ArrayList<List> historyList = new ArrayList<>();

    public static ArrayList<List> getHistoryList() {
        return historyList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        /* Check if the activity is using the layout version
         * with FrameLayout. If so, we have to add the fragment.
         * (It won't be done automatically!)*/
        if(findViewById(R.id.historyListContainer) != null) {
            /* Check if we're being restored from the previous state
             * If yes, then don't do anything */
            if(savedInstanceState != null) {
                return;
            }

            /* Create an instance of HistoryListFragment */
            HistoryListFragment historyListFragment = new HistoryListFragment();

            /* In case that the activity was started with special instructions from
             * an Intent, pass the Intent's extras to the fragment as arguments. */
            historyListFragment.setArguments(getIntent().getExtras());

            /* Ask the FragmentManager to add it to the FrameLayout */
            getFragmentManager().beginTransaction()
                    .add(R.id.historyListContainer, historyListFragment)
                    .commit();
        }
    }

    @Override
    public void onHistoryListSelected(int position) {
        /* One of the lists was selected, so the Fragments need to be swapped */
        /* Create Fragment and prepare the arguments*/
        HistoryItemListFragment swapFragment = new HistoryItemListFragment();
        Bundle args = new Bundle();
        args.putInt(HistoryItemListFragment.ARG_POSITION, position);
        swapFragment.setArguments(args);

        /* Swap Fragments */
        getFragmentManager().beginTransaction()
                .replace(R.id.historyListContainer, swapFragment)
                .addToBackStack(null)
                .commit();
    }
}
