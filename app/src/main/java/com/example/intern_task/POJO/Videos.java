
package com.example.intern_task.POJO;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Videos {

    @SerializedName("etag")
    private String mEtag;
    @SerializedName("items")
    private List<Item> mItems;
    @SerializedName("kind")
    private String mKind;
    @SerializedName("nextPageToken")
    private String mNextPageToken;
    @SerializedName("pageInfo")
    private PageInfo mPageInfo;
    @SerializedName("prevPageToken")
    private String mPrevPageToken;
    @SerializedName("regionCode")
    private String mRegionCode;

    public String getEtag() {
        return mEtag;
    }

    public void setEtag(String etag) {
        mEtag = etag;
    }

    public List<Item> getItems() {
        return mItems;
    }

    public void setItems(List<Item> items) {
        mItems = items;
    }

    public String getKind() {
        return mKind;
    }

    public void setKind(String kind) {
        mKind = kind;
    }

    public String getNextPageToken() {
        return mNextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        mNextPageToken = nextPageToken;
    }

    public PageInfo getPageInfo() {
        return mPageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        mPageInfo = pageInfo;
    }

    public String getPrevPageToken() {
        return mPrevPageToken;
    }

    public void setPrevPageToken(String prevPageToken) {
        mPrevPageToken = prevPageToken;
    }

    public String getRegionCode() {
        return mRegionCode;
    }

    public void setRegionCode(String regionCode) {
        mRegionCode = regionCode;
    }

}
