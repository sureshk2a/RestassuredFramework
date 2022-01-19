package com.apiautomation.constants;

public final class ApplicationConstants {

    private ApplicationConstants(){}

    private static final String BASEURL = "http://dummy.restapiexample.com/api/v1";

    public static String getBaseurl(){
        return BASEURL;
    }

}
