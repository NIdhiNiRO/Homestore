package com.myregistry.homestore.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nidhiparekh.
 */

public class Item implements Parcelable {

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
    @SerializedName("itemId")
    @Expose
    private Integer itemId;
    @SerializedName("parentItemId")
    @Expose
    private Integer parentItemId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("msrp")
    @Expose
    private Double msrp;
    @SerializedName("salePrice")
    @Expose
    private Double salePrice;
    @SerializedName("upc")
    @Expose
    private String upc;
    @SerializedName("categoryPath")
    @Expose
    private String categoryPath;
    @SerializedName("shortDescription")
    @Expose
    private String shortDescription;
    @SerializedName("longDescription")
    @Expose
    private String longDescription;
    @SerializedName("brandName")
    @Expose
    private String brandName;
    @SerializedName("thumbnailImage")
    @Expose
    private String thumbnailImage;
    @SerializedName("mediumImage")
    @Expose
    private String mediumImage;
    @SerializedName("largeImage")
    @Expose
    private String largeImage;
    @SerializedName("productTrackingUrl")
    @Expose
    private String productTrackingUrl;
    @SerializedName("ninetySevenCentShipping")
    @Expose
    private Boolean ninetySevenCentShipping;
    @SerializedName("standardShipRate")
    @Expose
    private Double standardShipRate;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("marketplace")
    @Expose
    private Boolean marketplace;
    @SerializedName("shipToStore")
    @Expose
    private Boolean shipToStore;
    @SerializedName("freeShipToStore")
    @Expose
    private Boolean freeShipToStore;
    @SerializedName("modelNumber")
    @Expose
    private String modelNumber;
    @SerializedName("productUrl")
    @Expose
    private String productUrl;
    @SerializedName("customerRating")
    @Expose
    private String customerRating;
    @SerializedName("numReviews")
    @Expose
    private Integer numReviews = 0;
    @SerializedName("customerRatingImage")
    @Expose
    private String customerRatingImage;
    @SerializedName("categoryNode")
    @Expose
    private String categoryNode;
    @SerializedName("bundle")
    @Expose
    private Boolean bundle;
    @SerializedName("clearance")
    @Expose
    private Boolean clearance;
    @SerializedName("preOrder")
    @Expose
    private Boolean preOrder;
    @SerializedName("stock")
    @Expose
    private String stock;
    @SerializedName("addToCartUrl")
    @Expose
    private String addToCartUrl;
    @SerializedName("affiliateAddToCartUrl")
    @Expose
    private String affiliateAddToCartUrl;
    @SerializedName("freeShippingOver50Dollars")
    @Expose
    private Boolean freeShippingOver50Dollars;
    @SerializedName("giftOptions")
    @Expose
    private GiftOptions giftOptions;
    @SerializedName("offerType")
    @Expose
    private String offerType;
    @SerializedName("isTwoDayShippingEligible")
    @Expose
    private Boolean isTwoDayShippingEligible;
    @SerializedName("availableOnline")
    @Expose
    private Boolean availableOnline;

    public Item() {
    }

    protected Item(Parcel in) {
        this.itemId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.parentItemId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.msrp = (Double) in.readValue(Double.class.getClassLoader());
        this.salePrice = (Double) in.readValue(Double.class.getClassLoader());
        this.upc = in.readString();
        this.categoryPath = in.readString();
        this.shortDescription = in.readString();
        this.longDescription = in.readString();
        this.brandName = in.readString();
        this.thumbnailImage = in.readString();
        this.mediumImage = in.readString();
        this.largeImage = in.readString();
        this.productTrackingUrl = in.readString();
        this.ninetySevenCentShipping = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.standardShipRate = (Double) in.readValue(Double.class.getClassLoader());
        this.size = in.readString();
        this.color = in.readString();
        this.marketplace = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.shipToStore = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.freeShipToStore = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.modelNumber = in.readString();
        this.productUrl = in.readString();
        this.customerRating = in.readString();
        this.numReviews = (Integer) in.readValue(Integer.class.getClassLoader());
        this.customerRatingImage = in.readString();
        this.categoryNode = in.readString();
        this.bundle = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.clearance = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.preOrder = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.stock = in.readString();
        this.addToCartUrl = in.readString();
        this.affiliateAddToCartUrl = in.readString();
        this.freeShippingOver50Dollars = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.giftOptions = in.readParcelable(GiftOptions.class.getClassLoader());
        this.offerType = in.readString();
        this.isTwoDayShippingEligible = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.availableOnline = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(Integer parentItemId) {
        this.parentItemId = parentItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMsrp() {
        return msrp;
    }

    public void setMsrp(Double msrp) {
        this.msrp = msrp;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getMediumImage() {
        return mediumImage;
    }

    public void setMediumImage(String mediumImage) {
        this.mediumImage = mediumImage;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public String getProductTrackingUrl() {
        return productTrackingUrl;
    }

    public void setProductTrackingUrl(String productTrackingUrl) {
        this.productTrackingUrl = productTrackingUrl;
    }

    public Boolean getNinetySevenCentShipping() {
        return ninetySevenCentShipping;
    }

    public void setNinetySevenCentShipping(Boolean ninetySevenCentShipping) {
        this.ninetySevenCentShipping = ninetySevenCentShipping;
    }

    public Double getStandardShipRate() {
        return standardShipRate;
    }

    public void setStandardShipRate(Double standardShipRate) {
        this.standardShipRate = standardShipRate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(Boolean marketplace) {
        this.marketplace = marketplace;
    }

    public Boolean getShipToStore() {
        return shipToStore;
    }

    public void setShipToStore(Boolean shipToStore) {
        this.shipToStore = shipToStore;
    }

    public Boolean getFreeShipToStore() {
        return freeShipToStore;
    }

    public void setFreeShipToStore(Boolean freeShipToStore) {
        this.freeShipToStore = freeShipToStore;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(String customerRating) {
        this.customerRating = customerRating;
    }

    public Integer getNumReviews() {
        return numReviews;
    }

    public void setNumReviews(Integer numReviews) {
        this.numReviews = numReviews;
    }

    public String getCustomerRatingImage() {
        return customerRatingImage;
    }

    public void setCustomerRatingImage(String customerRatingImage) {
        this.customerRatingImage = customerRatingImage;
    }

    public String getCategoryNode() {
        return categoryNode;
    }

    public void setCategoryNode(String categoryNode) {
        this.categoryNode = categoryNode;
    }

    public Boolean getBundle() {
        return bundle;
    }

    public void setBundle(Boolean bundle) {
        this.bundle = bundle;
    }

    public Boolean getClearance() {
        return clearance;
    }

    public void setClearance(Boolean clearance) {
        this.clearance = clearance;
    }

    public Boolean getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(Boolean preOrder) {
        this.preOrder = preOrder;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getAddToCartUrl() {
        return addToCartUrl;
    }

    public void setAddToCartUrl(String addToCartUrl) {
        this.addToCartUrl = addToCartUrl;
    }

    public String getAffiliateAddToCartUrl() {
        return affiliateAddToCartUrl;
    }

    public void setAffiliateAddToCartUrl(String affiliateAddToCartUrl) {
        this.affiliateAddToCartUrl = affiliateAddToCartUrl;
    }

    public Boolean getFreeShippingOver50Dollars() {
        return freeShippingOver50Dollars;
    }

    public void setFreeShippingOver50Dollars(Boolean freeShippingOver50Dollars) {
        this.freeShippingOver50Dollars = freeShippingOver50Dollars;
    }

    public GiftOptions getGiftOptions() {
        return giftOptions;
    }

    public void setGiftOptions(GiftOptions giftOptions) {
        this.giftOptions = giftOptions;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public Boolean getIsTwoDayShippingEligible() {
        return isTwoDayShippingEligible;
    }

    public void setIsTwoDayShippingEligible(Boolean isTwoDayShippingEligible) {
        this.isTwoDayShippingEligible = isTwoDayShippingEligible;
    }

    public Boolean getAvailableOnline() {
        return availableOnline;
    }

    public void setAvailableOnline(Boolean availableOnline) {
        this.availableOnline = availableOnline;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.itemId);
        dest.writeValue(this.parentItemId);
        dest.writeString(this.name);
        dest.writeValue(this.msrp);
        dest.writeValue(this.salePrice);
        dest.writeString(this.upc);
        dest.writeString(this.categoryPath);
        dest.writeString(this.shortDescription);
        dest.writeString(this.longDescription);
        dest.writeString(this.brandName);
        dest.writeString(this.thumbnailImage);
        dest.writeString(this.mediumImage);
        dest.writeString(this.largeImage);
        dest.writeString(this.productTrackingUrl);
        dest.writeValue(this.ninetySevenCentShipping);
        dest.writeValue(this.standardShipRate);
        dest.writeString(this.size);
        dest.writeString(this.color);
        dest.writeValue(this.marketplace);
        dest.writeValue(this.shipToStore);
        dest.writeValue(this.freeShipToStore);
        dest.writeString(this.modelNumber);
        dest.writeString(this.productUrl);
        dest.writeString(this.customerRating);
        dest.writeValue(this.numReviews);
        dest.writeString(this.customerRatingImage);
        dest.writeString(this.categoryNode);
        dest.writeValue(this.bundle);
        dest.writeValue(this.clearance);
        dest.writeValue(this.preOrder);
        dest.writeString(this.stock);
        dest.writeString(this.addToCartUrl);
        dest.writeString(this.affiliateAddToCartUrl);
        dest.writeValue(this.freeShippingOver50Dollars);
        dest.writeParcelable(this.giftOptions, flags);
        dest.writeString(this.offerType);
        dest.writeValue(this.isTwoDayShippingEligible);
        dest.writeValue(this.availableOnline);
    }
}

