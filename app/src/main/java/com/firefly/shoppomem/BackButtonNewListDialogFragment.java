package com.firefly.shoppomem;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by maja.filakovic on 26.4.2016..
 */
public class BackButtonNewListDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        /* Builder class for dialog construction */
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(R.string.go_back_new_list_message)
                .setTitle(R.string.go_back_new_list_title)
                .setPositiveButton(R.string.go_back_new_list_yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //return to main window
                        getActivity().finish();
                    }
                })
                .setNegativeButton(R.string.go_back_new_list_no, null);

        return builder.create();
    }
}
