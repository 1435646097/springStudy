package com.paigu.interview.service.impl;

import com.paigu.interview.service.FileTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
@Slf4j
public class FileTaskServiceImpl implements FileTaskService {
    @Qualifier("bookTaskExecutor")
    @Autowired
    TaskExecutor taskExecutor;

    @PostConstruct
    public void startFileTask() {
        taskExecutor.execute(this::afterPropertiesSet);
    }

    public static final BlockingQueue<String> BLOCKING_QUEUE = new LinkedBlockingQueue<>();

    @Override
    public void addTask(String file) {
        BLOCKING_QUEUE.add(file);
    }

    public void afterPropertiesSet() {
        for (; ; ) {
            try {
                String take = BLOCKING_QUEUE.take();
                log.info("任务执行完毕:{}", take);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
