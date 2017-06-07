package com.dummy.source.service;

import com.dummy.source.annotations.Trace;

/**
 * Created by andriusbaltrunas on 6/7/2017.
 */
public class SecondService <T>{

    @Trace
    public void printInformation(T parameter){
        System.out.println(parameter);
    }

}
