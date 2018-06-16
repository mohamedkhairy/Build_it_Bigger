package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.logging.Logger;

import javax.inject.Named;

import khairy.com.joke_lib.tell_joke;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {
    private static final Logger logger = Logger.getLogger(MyBean.class.getName());

//    name = "sayHi"
    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(MyBean response) {
//        response = new MyBean();
//        response.setData(name);

//
//        tell_joke tellJoke = new tell_joke();
//        String joke = tellJoke.jokeTelling();
//        response.setData(joke);



        return response;
    }

//    @Named("name") String name

//    @ApiMethod(name = "getjoke")
//    public MyBean getjoke(MyBean response) {
////        MyBean response = new MyBean();
////        response.setData(name);
//
//
////        tell_joke tellJoke = new tell_joke();
////        String joke = tellJoke.jokeTelling();
////        response.setData(joke);
//
//
//        return response;
//    }
}
