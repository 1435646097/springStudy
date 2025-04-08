package com.paigu.interview.main;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class RestTemplateMain {
    private static final int TOTAL_THREADS = 2000;
    private static final int CONCURRENT_THREADS = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(CONCURRENT_THREADS);
        CountDownLatch latch = new CountDownLatch(TOTAL_THREADS);
        AtomicInteger successCount = new AtomicInteger(0);
        AtomicInteger failCount = new AtomicInteger(0);

        for (int i = 0; i < TOTAL_THREADS; i++) {
            executor.submit(() -> {
                try {
                    sendRequest();
                    successCount.incrementAndGet();
                } catch (Exception e) {
                    failCount.incrementAndGet();
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await(); // 等待所有请求完成
        executor.shutdown();

        System.out.println("All requests completed.");
        System.out.println("Successful requests: " + successCount.get());
        System.out.println("Failed requests: " + failCount.get());
    }

    private static void sendRequest() {
        String url = "http://localhost:4200/api/apiproxy";

        JSONObject requestBody = new JSONObject();
        requestBody.put("query", new JSONObject());
        requestBody.put("url",
                "http://10.169.42.93:8900/api/equipmentcategorystatisticsstate?deviceCategoryIds=1503,1504&objectId=517000001&pageCategory=2");
        requestBody.put("method", "GET");

        String result = HttpRequest.post(url)
                                   .body(requestBody.toString())
                                   .header("Authorization",
                                           "Bearer eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiLns7vnu5_nrqHnkIblkZgiLCJnZW5lcmF0ZVRpbWUiOjE3MzUwOTMzMDA1NzksInVzZXJJZCI6LTEsImxvZ29uSWQiOiJhZG1pbiIsInJvbGUiOiItMSwxMTQ2MDAwMDMxLDExNDYwMDAwMzgiLCJwZXJzb25JZCI6LTEsInRoZW1lTmFtZSI6ImRlZmF1bHQiLCJuZWVkUmVzZXRQd2QiOmZhbHNlLCJsb2dpblR5cGUiOiJ3ZWIifQ.H27xiaNlXtEln6cMSa36B0c3xMo2lK0yvwe7LYxSlpDhiW4dDucPzMEs4-EZ2X8AyLfFQ8c7Q3ohPyM_ekoM8pR6WSKyOS7qdVPP9i51HIgFjrPnzVkJPajxYMofd1V5iQ_3RpRF8zUpoBNOAh3DtNRlQ9gloXEqTQWOYgp9IoQkl1Y8IO9AjTL30cZWrvL6k0uN8X6hDDSRSeTMnOgZBx5O_AsB3HW8dCAmGX9BWbWN2jL0s_KQ-OOelyjmf6J5hZmOWsJ05Ql7cJNn6mUrUtiPQOO7eM6_Q1xNi3HAO--RSM96niMze0C94_WtkrDmLsVg0ywCFfcakenYkjnYTQ")
                                   .execute()
                                   .body();

        System.out.println("Response: " + result);
    }
}
