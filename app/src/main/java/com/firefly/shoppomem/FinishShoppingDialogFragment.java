package com.firefly.shoppomem;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by maja.filakovic on 3.5.2016..
 */
public class FinishShoppingDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        /* Builder class for dialog fragment */
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.finish_shopping_title)
                .setMessage(R.string.finish_shopping_message)
                .setPositiveButton(R.string.finish_shopping_finish, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Data.getInstance().getHistoryActivityList().add(new List(Data.getInstance().getPendingListActivityList(), Calendar.getInstance()));
                        Toast.makeText(getActivity().getApplicationContext(), "List saved in history.", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(R.string.finish_shopping_continue, null);


        return builder.create();
    }
}
