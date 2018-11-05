package com.teachsoft.updatetestreader;

import java.io.Serializable;
import java.util.HashMap;

class Chapter implements Serializable {
    private static final long serialVersionUID = 1L;

    private String mTitle;
    private String mCode;
    private HashMap<String, Exercise> mExercises;

    public Chapter(){ mExercises = new HashMap<>(); }

    String getTitle() {
        return mTitle;
    }
    String getCode() {
        return mCode;
    }
    HashMap<String, Exercise> getExercises() { return mExercises; }
    Exercise getExercise(String key) { return mExercises.get(key); }

    public void setTitle(String title) {
        mTitle = title;
    }
    public void setCode(String code) {
        mCode = code;
    }
    public void setExercises(HashMap<String, Exercise> exercises) { mExercises = exercises; }
    public void setExercise(String key, Exercise exercise) { mExercises.put(key, exercise); }
}
