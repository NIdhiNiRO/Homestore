package com.myregistry.homestore.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nidhiparekh.
 */
public class GiftOptions implements Parcelable {

    public static final Parcelable.Creator<GiftOptions> CREATOR = new Parcelable.Creator<GiftOptions>() {
        @Override
        public GiftOptions createFromParcel(Parcel source) {
            return new GiftOptions(source);
        }

        @Override
        public GiftOptions[] newArray(int size) {
            return new GiftOptions[size];
        }
    };
    @SerializedName("allowGiftWrap")
    @Expose
    private Boolean allowGiftWrap;
    @SerializedName("allowGiftMessage")
    @Expose
    private Boolean allowGiftMessage;
    @SerializedName("allowGiftReceipt")
    @Expose
    private Boolean allowGiftReceipt;

    public GiftOptions() {
    }

    protected GiftOptions(Parcel in) {
        this.allowGiftWrap = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.allowGiftMessage = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.allowGiftReceipt = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public Boolean getAllowGiftWrap() {
        return allowGiftWrap;
    }

    public void setAllowGiftWrap(Boolean allowGiftWrap) {
        this.allowGiftWrap = allowGiftWrap;
    }

    public Boolean getAllowGiftMessage() {
        return allowGiftMessage;
    }

    public void setAllowGiftMessage(Boolean allowGiftMessage) {
        this.allowGiftMessage = allowGiftMessage;
    }

    public Boolean getAllowGiftReceipt() {
        return allowGiftReceipt;
    }

    public void setAllowGiftReceipt(Boolean allowGiftReceipt) {
        this.allowGiftReceipt = allowGiftReceipt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.allowGiftWrap);
        dest.writeValue(this.allowGiftMessage);
        dest.writeValue(this.allowGiftReceipt);
    }
}


