package com.udacity.gradle.builditbigger.backend;

import java.util.logging.Logger;

import khairy.com.joke_lib.tell_joke;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {
        return myData;
    }

    public MyBean() {
        this.myData = new tell_joke().jokeTelling();
    }
}