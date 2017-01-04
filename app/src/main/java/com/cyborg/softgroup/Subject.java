package com.cyborg.softgroup;

import java.util.List;

/**
 * Created by Cyborg on 12/28/2016.
 */

public class Subject {

    private String name;
    private int image;
    private List<Integer> soundList;

    public List<Integer> getSoundList() {
        return soundList;
    }

    public void setSoundList(List<Integer> soundList) {
        this.soundList = soundList;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
