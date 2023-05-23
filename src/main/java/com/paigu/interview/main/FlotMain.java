package com.paigu.interview.main;

import cn.hutool.http.webservice.SoapProtocol;
import cn.hutool.http.webservice.SoapUtil;

public class FlotMain {
    public static Integer i = 0;
    public static volatile Integer count = 2;

    public static Object lock = new Object();
    public static void main(String[] args) {
        System.out.println(SoapUtil.createClient("http://localhost:8080/services/test", SoapProtocol.SOAP_1_1,
                                           "http://nmdidmsso.taiwanmobile.com")
                      .setMethod("reconciliationAccounts")
                                   .send(true));
    }

    public Integer add() {
        int a = 20;
        int b = 30;
        int c = a + b;
        return sub();
    }

    public Integer sub() {
        int c = 10;
        return c - 5;
    }
}
