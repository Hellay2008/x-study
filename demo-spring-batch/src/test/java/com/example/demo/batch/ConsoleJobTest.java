package com.example.demo.batch;

import com.example.demo.DemoSpringBatchApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@SpringBootTest(classes = {DemoSpringBatchApplication.class, ConsoleBatchConfig.class})
public class ConsoleJobTest {
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job processJob;

    public void testConsoleJob2() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        //构建参数
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time",System.currentTimeMillis())
                .toJobParameters();
        //执行任务
        JobExecution run = jobLauncher.run(processJob, jobParameters);
        ExitStatus exitStatus = run.getExitStatus();
        log.debug(exitStatus.toString());
    }
}