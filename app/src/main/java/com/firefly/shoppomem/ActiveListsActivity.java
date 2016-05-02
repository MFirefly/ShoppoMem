package com.firefly.shoppomem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class ActiveListsActivity extends AppCompatActivity {

    private static ArrayList<List> activeLists = new ArrayList<>();
    ListView activeListView = null;
    ArrayAdapter<List> activeListAdapter;

    public static ArrayList<List> getActiveLists() {
        return activeLists;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_lists);

        /* Add list to ListView with adapter */
        activeListView = (ListView) findViewById(R.id.activeListsListView);
        activeListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,  activeLists);

        if(activeListView != null) {
            activeListView.setAdapter(activeListAdapter);
        }

        activeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ActiveListsActivity.this, PendingListActivity.class);
                i.putExtra("LISTPOSITION", position);
                startActivity(i);
            }
        });
    }
}
