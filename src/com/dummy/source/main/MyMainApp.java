package com.dummy.source.main;

import com.dummy.source.Utils.ReflexionLoginUtil;
import com.dummy.source.service.FirstService;
import com.dummy.source.service.SecondService;

/**
 * Created by andriusbaltrunas on 6/7/2017.
 */
public class MyMainApp {

    public static void main(String[] args) throws NoSuchMethodException {

        FirstService firstService = new FirstService();
        Object ob = ReflexionLoginUtil.log(firstService, "countSum", 55.5, 35.2);
        System.out.println(ob);
        ReflexionLoginUtil.log(firstService, "justPrintValues", "Ben", "Dick");

        SecondService secondService = new SecondService();
        ReflexionLoginUtil.log(secondService, "printInformation", "THIS IS JAVA");
    }
}
