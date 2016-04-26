package com.firefly.shoppomem;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by maja.filakovic on 26.4.2016..
 */
public class SaveNewListDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        /* Builder class for dialog construction */
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(R.string.save_new_list_message)
                .setPositiveButton(R.string.save_new_list_save_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Save list
                    }
                })
                .setNegativeButton(R.string.save_new_list_dismiss_button, null);

        return builder.create();
    }
}
