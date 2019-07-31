package com.lexieluv.homeworkeleventh;

//ListView实体类
public class myListView {
    private String title,gonglue;//黑体加粗标题，左下方来源
    private int look,good;//右下方的观看和点赞数量
    private int placeID;//图片来源id

    public myListView(String title, String gonglue, int look, int good, int placeID) {
        this.title = title;
        this.gonglue = gonglue;
        this.look = look;
        this.good = good;
        this.placeID = placeID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGonglue() {
        return gonglue;
    }

    public void setGonglue(String gonglue) {
        this.gonglue = gonglue;
    }

    public int getLook() {
        return look;
    }

    public void setLook(int look) {
        this.look = look;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public int getPlaceID() {
        return placeID;
    }

    public void setPlaceID(int placeID) {
        this.placeID = placeID;
    }
}
