package com.example.yp01;

public class model_Block {
    private String title;
    private String description;
    private String mImage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public model_Block(String title, String description, String mImage) {
        this.title = title;
        this.description = description;
        this.mImage = mImage;
    }

    public model_Block(){

}



}
