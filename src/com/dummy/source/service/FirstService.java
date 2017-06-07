package com.dummy.source.service;

import com.dummy.source.annotations.Trace;

/**
 * Created by andriusbaltrunas on 6/7/2017.
 */
public class FirstService {

    @Trace
    public <T extends Number> T countSum(T numb1, T numb2) {
        Double sum = Double.sum(numb1.doubleValue(), numb2.doubleValue());
        return (T) sum;
    }

    public <T> void justPrintValues(T val1, T val2){
        System.out.println("Here is first val -> "+ val1 +"\n Here is second value -> " +val2);
    }

}
