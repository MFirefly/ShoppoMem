package com.firefly.shoppomem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by maja.filakovic on 29.4.2016..
 */
public class List {
    ArrayList<Item> mItemsList;
    Calendar mDate;

    public List(ArrayList<Item> mItemsList, Calendar mDate) {
        this.mItemsList = mItemsList;
        this.mDate = mDate;
    }

    public Calendar getmDate() {
        return mDate;
    }

    public ArrayList<Item> getmItemsList() {
        return mItemsList;
    }

    @Override
    public String toString() {
        return "Made on: " + getmDate().getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US) + ", "
                + getmDate().get(Calendar.DATE) + ". "
                + getmDate().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " "
                + getmDate().get(Calendar.YEAR) + ".";
    }
}
