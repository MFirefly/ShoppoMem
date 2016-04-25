package com.firefly.shoppomem;

import android.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.zip.Inflater;

public class NewListActivity extends AppCompatActivity {

    private Toolbar newListToolbar = null;
    private Button addNewItem = null;
    private ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);

        newListToolbar = (Toolbar) findViewById(R.id.toolbar_new_list);
        setSupportActionBar(newListToolbar);

        addNewItem = (Button) findViewById(R.id.addNewItemButton);
        listView = (ListView) findViewById(R.id.itemsListView);

        /* Get a support ActionBar corresponding to this toolbar
        * Enable the Up Button*/
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        addNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Open dialogue */
                DialogFragment newDialog = new AddNewItemDialogFragment();
                newDialog.show(getFragmentManager(), "Add");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Inflate the menu. This adds items to action bar, if it's present */
        getMenuInflater().inflate(R.menu.menu_new_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /* Handle action bar item clicks here. The action bar will
        * automatically handle clicks on the Home/Up button, so long
        * as you specify a parent activity in AndroidManifest.xml */
        int id = item.getItemId();

        if(id == R.id.save_list) {
                Toast.makeText(this, R.string.message_action_save, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}