package com.firefly.shoppomem;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by maja.filakovic on 26.4.2016..
 */
public class SaveNewListDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        /* Builder class for dialog construction */
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(R.string.save_new_list_message)
                .setPositiveButton(R.string.save_new_list_save_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /* Create new list with added items and current date */
                        List list = new List(Data.getInstance().getNewActivityList(), Calendar.getInstance());
                        /* Add it to the list of active lists */
                        Data.getInstance().getActiveListsActivityList().add(list);
                        /* Empty the items list */
                        Data.getInstance().setNewActivityList(new ArrayList<Item>());
                        /* Finish activity after saving */
                        getActivity().finish();
                    }
                })
                .setNegativeButton(R.string.save_new_list_dismiss_button, null);

        return builder.create();
    }
}
