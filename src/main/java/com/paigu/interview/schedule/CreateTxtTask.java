package com.paigu.interview.schedule;

import com.paigu.interview.config.FileConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class CreateTxtTask {
    public static final String TXT_FILE = ".txt";
    @Autowired
    FileConfig fileConfig;

    @Scheduled(fixedDelay = 30 * 1000)
    public void createTxtTask() throws IOException {
        //String fileName = IdUtil.simpleUUID();
        //File file = FileUtil.newFile(fileConfig.getFilePath());
        ////文件夹是否为空
        //FileUtil.mkdir(file);
        //OutputStreamWriter outputStreamWriter = new FileWriter(fileConfig.getFilePath() + fileName + TXT_FILE);
        //outputStreamWriter.write(IdUtil.simpleUUID());
        //IoUtil.close(outputStreamWriter);
        //log.info("成功完成一次文件的写操作");
    }
}
