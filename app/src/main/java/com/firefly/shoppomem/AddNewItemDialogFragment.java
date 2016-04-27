package com.firefly.shoppomem;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;

public class AddNewItemDialogFragment extends DialogFragment {

    /* The activity that creates an instance of this dialog fragment must
     * implement this interface in order to receive event callbacks.
     * Each method passes the DialogFragment in case the host needs to query it. */
    public interface NewItemDialogListener {
        void onDialogPositiveClick(DialogFragment dialog, Item item);

        void onDialogNegativeClick(DialogFragment dialog);
    }

    /* Use this instance of the interface to deliver action events */
    NewItemDialogListener mListener;

    /* Override the Fragment.onAttach() method to instantiate the NewItemDialogListener */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        /* Verify that the host activity implements the callback interface */
        try {
            /* Instantiate the NewItemDialogListener so we can send events to the host */
            mListener = (NewItemDialogListener) activity;
        } catch (ClassCastException e) {
            /* The activity doesn't implement the interface, throw exception */
            throw new ClassCastException(activity.toString() + " must implement NewItemDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        /* Get the layout inflater */
        LayoutInflater inflater = getActivity().getLayoutInflater();

        /* Inflate and set the layout for the dialog */
        /* Pass null as the parent view because its going in the dialog layout */
        builder.setView(inflater.inflate(R.layout.fragment_add_new_item_dialog, null))
                /* Add action buttons */
                .setPositiveButton(R.string.new_item_add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /* Retrieve data that user entered */
                        Dialog dial = (Dialog) dialog;
                        EditText name = (EditText) dial.findViewById(R.id.newItemNameEdit);
                        EditText quantity = (EditText) dial.findViewById(R.id.newItemQuantityEdit);
                        EditText info = (EditText) dial.findViewById(R.id.newItemNameInfo);

                        /* Add the data to item */
                        Item item = new Item(name.getText().toString(), quantity.getText().toString(), info.getText().toString());

                        /* Send the positive button event back to the host activity */
                        mListener.onDialogPositiveClick(AddNewItemDialogFragment.this, item);
                    }
                })
                .setNegativeButton(R.string.new_item_discard, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /* Sent the negative button event back to the host activity */
                        mListener.onDialogNegativeClick(AddNewItemDialogFragment.this);
                    }
                });

        return builder.create();
    }
}
