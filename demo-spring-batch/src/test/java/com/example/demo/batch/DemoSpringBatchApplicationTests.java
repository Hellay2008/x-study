package com.example.demo.batch;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class DemoSpringBatchApplicationTests {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job consoleJob;

    @Test
    public void testConsoleJob2() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        //构建参数
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time",System.currentTimeMillis())
                .toJobParameters();
        //执行任务
        JobExecution run = jobLauncher.run(consoleJob, jobParameters);
        ExitStatus exitStatus = run.getExitStatus();
        log.debug(exitStatus.toString());
    }

}
