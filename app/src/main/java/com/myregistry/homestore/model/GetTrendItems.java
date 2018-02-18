package com.myregistry.homestore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nidhiparekh.
 */

public class GetTrendItems {

    @SerializedName("time")
    @Expose
    private Long time;
    @SerializedName("items")
    @Expose
    private ArrayList<Item> items = null;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }


}
