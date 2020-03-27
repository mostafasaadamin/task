
package com.example.intern_task.POJO;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("etag")
    private String mEtag;
    @SerializedName("id")
    private Id mId;
    @SerializedName("kind")
    private String mKind;

    public String getEtag() {
        return mEtag;
    }

    public void setEtag(String etag) {
        mEtag = etag;
    }

    public Id getId() {
        return mId;
    }

    public void setId(Id id) {
        mId = id;
    }

    public String getKind() {
        return mKind;
    }

    public void setKind(String kind) {
        mKind = kind;
    }

}
