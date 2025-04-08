package com.paigu.interview.main;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.core.lang.Console;

public class HttpGetExample {
    public static void main(String[] args) {
        // 定义请求URL
        String url = "http://localhost:8900/api/currentaccountconfig";

        // 定义Bearer Token
        String bearerToken = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiLns7vnu5_nrqHnkIblkZgiLCJnZW5lcmF0ZVRpbWUiOjE3MzUwOTMzMDA1NzksInVzZXJJZCI6LTEsImxvZ29uSWQiOiJhZG1pbiIsInJvbGUiOiItMSwxMTQ2MDAwMDMxLDExNDYwMDAwMzgiLCJwZXJzb25JZCI6LTEsInRoZW1lTmFtZSI6ImRlZmF1bHQiLCJuZWVkUmVzZXRQd2QiOmZhbHNlLCJsb2dpblR5cGUiOiJ3ZWIifQ.H27xiaNlXtEln6cMSa36B0c3xMo2lK0yvwe7LYxSlpDhiW4dDucPzMEs4-EZ2X8AyLfFQ8c7Q3ohPyM_ekoM8pR6WSKyOS7qdVPP9i51HIgFjrPnzVkJPajxYMofd1V5iQ_3RpRF8zUpoBNOAh3DtNRlQ9gloXEqTQWOYgp9IoQkl1Y8IO9AjTL30cZWrvL6k0uN8X6hDDSRSeTMnOgZBx5O_AsB3HW8dCAmGX9BWbWN2jL0s_KQ-OOelyjmf6J5hZmOWsJ05Ql7cJNn6mUrUtiPQOO7eM6_Q1xNi3HAO--RSM96niMze0C94_WtkrDmLsVg0ywCFfcakenYkjnYTQ";

        try {
            // 发送GET请求
            HttpResponse response = HttpRequest.get(url)
                                               .header("Authorization", "Bearer " + bearerToken)
                                               .execute();

            // 获取响应状态码
            int statusCode = response.getStatus();
            Console.log("响应状态码: {}", statusCode);

            // 获取响应体
            String body = response.body();
            Console.log("响应体: {}", body);

        } catch (Exception e) {
            Console.error("发送请求时发生错误: {}", e.getMessage());
        }
    }
}

