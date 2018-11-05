package com.teachsoft.updatetestreader;

import java.io.Serializable;
import java.util.HashMap;

class Subject implements Serializable {
    private static final long serialVersionUID = 1L;

    private String mTitle;
    private String mCode;
    private HashMap<String, Chapter> mChapters;

    public Subject(){ mChapters = new HashMap<>(); }

    String getTitle() {
        return mTitle;
    }
    String getCode() {
        return mCode;
    }
    HashMap<String, Chapter> getChapters() { return mChapters; }
    Chapter getChapter(String key) { return mChapters.get(key); }

    public void setTitle(String title) { mTitle = title; }
    public void setCode(String code) {
        mCode = code;
    }
    public void setChapters(HashMap<String, Chapter> chapters) { mChapters = chapters; }
    public void setChapter(String key, Chapter chapter) { mChapters.put(key, chapter); }
}
