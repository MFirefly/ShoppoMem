package com.firefly.shoppomem;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by maja.filakovic on 29.4.2016..
 */
public class List {
    ArrayList<Item> mItemsList;
    Date date;

    public List(ArrayList<Item> mItemsList, Date date) {
        this.mItemsList = mItemsList;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Made on: " + getDate().toString();
    }
}
