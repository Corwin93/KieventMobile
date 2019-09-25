package com.lance.kieventmobile.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Corwin on 20.05.2015.
 */
public class Event implements Serializable {

    private UUID mId;

    @SerializedName("Title")
    @Expose
    private String mTitle;

    @SerializedName("Date")
    @Expose
    private String mDate;

    @SerializedName("Time")
    @Expose
    private String mTime;

    @SerializedName("Address")
    @Expose
    private String mAddress;

    @SerializedName("Price")
    @Expose
    private String mPrice;

    @SerializedName("Image")
    @Expose
    private String mImage;

    @SerializedName("Category")
    @Expose
    private Category mCategory;

    @SerializedName("Order")
    @Expose
    private String mOrder;

    public Event() {
        mId = UUID.randomUUID();
    }

    public Event(String title, String date, String time, String address, String price, String image,
                 String order, Category category) {
        this.mTitle = title;
        this.mDate = date;
        this.mTime = time;
        this.mAddress = address;
        this.mPrice = price;
        this.mImage = image;
        this.mCategory = category;
        this.mOrder = order;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        this.mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        this.mPrice = price;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        this.mImage = image;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        this.mTime = time;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        this.mAddress = address;
    }

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        this.mCategory = category;
    }

    public String getOrder() {
        return mOrder;
    }

    public void setOrder(String order) {
        this.mOrder = order;
    }
}
