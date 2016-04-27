package com.firefly.shoppomem;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NewListActivity extends AppCompatActivity implements AddNewItemDialogFragment.NewItemDialogListener{

    private Toolbar newListToolbar = null;
    private Button addNewItem = null;
    private ListView listView = null;
    ArrayList<Item> list = new ArrayList<Item>();
    //ArrayAdapter<Item> adapter;
    ItemAdapter mItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);

        /* Show toolbar */
        newListToolbar = (Toolbar) findViewById(R.id.toolbar_new_list);
        setSupportActionBar(newListToolbar);

        addNewItem = (Button) findViewById(R.id.addNewItemButton);

        /* Add list to the ListView with adapter */
        listView = (ListView) findViewById(R.id.itemsListView);
        mItemAdapter = new ItemAdapter(getApplicationContext(), R.layout.new_list_row, list);

        if(listView != null) {
            listView.setAdapter(mItemAdapter);
        }

        /* Get a support ActionBar corresponding to this toolbar
         * Enable the Up Button*/
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        /* Set click listener for add new item button */
        addNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Create instance of the dialog fragment and show it */
                DialogFragment newDialog = new AddNewItemDialogFragment();
                newDialog.show(getFragmentManager(), "AddNewItemDialog");
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
        DialogFragment dialog;

        if(id == R.id.save_list) {
            dialog = new SaveNewListDialogFragment();
            dialog.show(getFragmentManager(), "SaveListDialog");
            return super.onOptionsItemSelected(item);
        } else if(id == android.R.id.home) {
            dialog = new BackButtonNewListDialogFragment();
            dialog.show(getFragmentManager(), "GoBack");
        }
        return true;
    }

    /* The dialog fragment receives reference to this Activity through the
     * Fragment.onAttach() callback, which it uses to call the following methods
     * defined by the DialogListener interface. */
    @Override
    public void onDialogPositiveClick(DialogFragment dialog, Item item) {
        /* User touched positive button */
        /* Add new item to the list view */
        mItemAdapter.add(item);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        /* User touched negative button */
        dialog.dismiss();
    }
}
