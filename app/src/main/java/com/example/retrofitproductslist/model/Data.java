package com.example.retrofitproductslist.model;

import com.google.gson.annotations.SerializedName;

public class Data {

    String albumId;
    String id;
    String title;

    @SerializedName("url")
    String image;

    @SerializedName("thumbnailUrl")
    String thumbnail;

    public Data(String albumId, String id, String title, String image, String thumbnail) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.image = image;
        this.thumbnail = thumbnail;
    }


    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
