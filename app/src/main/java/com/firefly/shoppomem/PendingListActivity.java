package com.firefly.shoppomem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by maja.filakovic on 2.5.2016..
 */
public class PendingListActivity extends AppCompatActivity {

    private Button shoppingDoneButton = null;
    private ListView listView = null;
    private ArrayList<Item> pendingList = null;
    private PendingItemAdapter pendingItemAdapter;

    public ArrayList<Item> getPendingList() {
        return pendingList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_list);

        shoppingDoneButton = (Button) findViewById(R.id.pendingFinishShoppingButton);

        /* Get data from intent */
        Intent intent = getIntent();
        int position = intent.getIntExtra("LISTPOSITION", -1);
        pendingList =  ActiveListsActivity.getActiveLists().get(position).getmItemsList();

        /* Add list to the ListView with adapter */
        listView = (ListView) findViewById(R.id.pendingListListView);
        pendingItemAdapter = new PendingItemAdapter(getApplicationContext(), R.layout.pending_list_row, getPendingList());

        if(listView != null) {
            listView.setAdapter(pendingItemAdapter);
        }

        /* Set click listener for finish shopping button */
        shoppingDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Shopping finished!", Toast.LENGTH_SHORT).show();
            }
        });

        /* Item select click listener */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView imageView = (ImageView) view.findViewById(R.id.pendingListRowImageViewCheck);
                /* Switch the flag */
                getPendingList().get(position).togglemSelected();
                /* Change image and background color */
                if(getPendingList().get(position).ismSelected()) {
                    /* Change picture and background color */
                    imageView.setImageResource(R.mipmap.ic_check_circle_black_36dp);
                } else {
                    imageView.setImageResource(R.mipmap.ic_panorama_fish_eye_black_36dp);
                }
            }
        });
    }
}
