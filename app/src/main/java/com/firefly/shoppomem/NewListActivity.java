package com.firefly.shoppomem;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class NewListActivity extends AppCompatActivity implements AddNewItemDialogFragment.NewItemDialogListener {

    private Toolbar newListToolbar = null;
    private Button addNewItem = null;
    private ListView listView = null;
    private static ItemAdapter newListItemAdapter;
    private static CoordinatorLayout coordinatorLayout;

    public static ItemAdapter getNewListItemAdapter() {
        return newListItemAdapter;
    }

    public static CoordinatorLayout getCoordinatorLayout() {
        return coordinatorLayout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.newListCoordinatorLayout);

        /* Show toolbar */
        newListToolbar = (Toolbar) findViewById(R.id.toolbar_new_list);
        setSupportActionBar(newListToolbar);

        addNewItem = (Button) findViewById(R.id.addNewItemButton);

        /* Add list to the ListView with adapter */
        listView = (ListView) findViewById(R.id.itemsListView);
        newListItemAdapter = new ItemAdapter(getApplicationContext(), R.layout.new_list_row, Data.getInstance().getNewActivityList());

        if (listView != null) {
            listView.setAdapter(newListItemAdapter);
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

        if (id == R.id.save_list) {
            dialog = new SaveNewListDialogFragment();
            dialog.show(getFragmentManager(), "SaveListDialog");
            return super.onOptionsItemSelected(item);
        } else if (id == android.R.id.home) {
            /* If the list is empty, don't show the dialog */
            if (!Data.getInstance().getNewActivityList().isEmpty()) {
                dialog = new BackButtonNewListDialogFragment();
                dialog.show(getFragmentManager(), "GoBack");
            } else {
                onBackPressed();
            }
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
        newListItemAdapter.add(item);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        /* User touched negative button */
        dialog.dismiss();
    }
}
