package com.firefly.shoppomem;

import java.util.ArrayList;

/**
 * Created by maja.filakovic on 6.5.2016..
 */
public class Data {
    private static Data instance;

    /* Rest of the attributes */
    private ArrayList<Item> newActivityList = new ArrayList<>();
    private ArrayList<List> activeListsActivityList = new ArrayList<>();
    private ArrayList<List> historyActivityList = new ArrayList<>();
    private ArrayList<Item> pendingListActivityList = null;

    /* Private constructor */
    private Data() {
    }

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    public ArrayList<Item> getNewActivityList() {
        return newActivityList;
    }

    public void setNewActivityList(ArrayList<Item> newActivityList) {
        this.newActivityList = newActivityList;
    }

    public ArrayList<List> getActiveListsActivityList() {
        return activeListsActivityList;
    }

    public ArrayList<List> getHistoryActivityList() {
        return historyActivityList;
    }

    public ArrayList<Item> getPendingListActivityList() {
        return pendingListActivityList;
    }

    public void setPendingListActivityList(ArrayList<Item> pendingListActivityList) {
        this.pendingListActivityList = pendingListActivityList;
    }
}
