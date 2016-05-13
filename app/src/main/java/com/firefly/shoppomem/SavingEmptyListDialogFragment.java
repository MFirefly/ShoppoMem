package com.firefly.shoppomem;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.app.AlertDialog;

/**
 * Created by maja.filakovic on 13.5.2016..
 */
public class SavingEmptyListDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        /* Builder class for dialog construction */
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(R.string.save_empty_list_message)
                .setPositiveButton(R.string.same_empty_list_ok, null);

        return builder.create();
    }
}
