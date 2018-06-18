package com.udacity.gradle.builditbigger.tests;

import android.app.Application;

import android.test.ApplicationTestCase;


import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import java.util.concurrent.CountDownLatch;

import java.util.concurrent.TimeUnit;

public class NonEmptyTest extends ApplicationTestCase<Application> implements EndpointsAsyncTask.OnJokeCallback {

    String joke ;
    CountDownLatch latch;

    public NonEmptyTest() {
        super(Application.class);
    }


    public void testResult(){

        try {
            latch = new CountDownLatch(1);

            EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext(), null);
            endpointsAsyncTask.execute(this);
            latch.await(10, TimeUnit.SECONDS);
            assertNotNull(joke);

        } catch (Exception e) {
            fail();
            e.printStackTrace();
        }


    }

    @Override
    public void resultCallback(String result) {
        this.joke = result;
        latch.countDown();
    }
}
