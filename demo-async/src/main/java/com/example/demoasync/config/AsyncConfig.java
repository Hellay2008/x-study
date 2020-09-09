package com.example.demoasync.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

//@Configuration
//@EnableAsync
public class AsyncConfig extends AsyncConfigurerSupport {

	private final Logger log = LoggerFactory.getLogger("AsyncConfig");
	@Value("${task.pool.corePoolSize}")
	private int corePoolSize;
	@Value("${task.pool.maxPoolSize}")
	private int maxPoolSize;
	@Value("${task.pool.keepAliveSeconds}")
	private int keepAliveSeconds;
	@Value("${task.pool.queueCapacity}")
	private int queueCapacity;
	@Value("${task.pool.awaitTerminationSeconds}")
	private int awaitTerminationSeconds;
	@Value("${task.pool.waitForJobsToCompleteOnShutdown}")
	private boolean waitForJobsToCompleteOnShutdown;

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(corePoolSize);
		taskExecutor.setMaxPoolSize(maxPoolSize);
		taskExecutor.setQueueCapacity(queueCapacity);
		taskExecutor.setKeepAliveSeconds(keepAliveSeconds);
		taskExecutor.setThreadNamePrefix("async-task-");
		// 线程池对拒绝任务（无线程可用）的处理策略，目前只支持AbortPolicy、CallerRunsPolicy；默认为后者
		taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		// 调度器shutdown被调用时等待当前被调度的任务完成
		taskExecutor.setWaitForTasksToCompleteOnShutdown(waitForJobsToCompleteOnShutdown);
		// 等待时长
		taskExecutor.setAwaitTerminationSeconds(awaitTerminationSeconds);
		taskExecutor.initialize();
		return taskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return (throwable, method, objects) -> log.info("AsyncUncaughtExceptionHandler 出错了throwable={}，method={},params={}", throwable, method, objects);
	}

}
