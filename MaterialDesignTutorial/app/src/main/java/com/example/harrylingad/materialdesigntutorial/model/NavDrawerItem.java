package com.example.harrylingad.materialdesigntutorial.model;

/**
 * Created by Harry Lingad on 10/24/2016.
 */

public class NavDrawerItem {

    private boolean showNotification;
    private String title;

    public NavDrawerItem(){}

    public NavDrawerItem(boolean showNotification, String title){
        this.showNotification = showNotification;
        this.title = title;
    }

    public boolean isShowNotification() {
        return showNotification;
    }

    public void setShowNotification(boolean showNotification) {
        this.showNotification = showNotification;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
