package com.paigu.interview.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MergeSQLFiles {
    public static void main(String[] args) {
        // 指定目录路径
        String directoryPath = "C:\\company\\code\\siteweb-server-release\\core\\src\\main\\resources\\db\\changelog\\siteweb\\postgres\\sql";
        // 输出合并后的文件名
        String outputFilePath = "C:\\company\\code\\siteweb-server-release\\core\\src\\main\\resources\\db\\changelog\\siteweb\\postgres\\sql\\sql-merged.sql";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".sql"));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            if (files != null) {
                for (File file : files) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            writer.write(line);
                            writer.newLine(); // 添加换行符以分隔文件内容
                        }
                    }
                }
            }
            System.out.println("所有 SQL 文件已合并到 " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

