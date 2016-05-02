package com.firefly.shoppomem;

/**
 * Created by maja.filakovic on 27.4.2016..
 */
public class Item {

    private String itemName;
    private String quantity;
    private String additionalInfo;
    private boolean mSelected = false;

    public Item(String itemName, String quantity, String additionalInfo) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.additionalInfo = additionalInfo;
    }

    public String getItemName() {
        return itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public boolean ismSelected() {
        return mSelected;
    }

    public void setmSelected(boolean mSelected) {
        this.mSelected = mSelected;
    }

    @Override
    public String toString() {
        return getItemName() + "  x" + getQuantity() + "\n" + getAdditionalInfo();
    }
}
