package com.example.demo.controller;

import com.example.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class TestController {

    @Resource
    TestService testService;

    @GetMapping("/getDataRemote")
    public String getDataRemote(String id){
        log.info("----------------getDataRemote start----------------");
        int i = 0;
        while(i++ < 100) {
            long start = System.currentTimeMillis();
            log.info("{} request uri {}, id {} start", "getDataRemote", i, id);
            testService.testRemoteCache(id);
            long end = System.currentTimeMillis();
            log.info(i+"{} request uri {}, id {} end, cost {}", "getDataRemote", i, id, end - start);
        }
        log.info("----------------getDataRemote end----------------");
        return "getDataRemote done";
    }

    @GetMapping("/getDataLocal")
    public String getDataLocal(String id){
        log.info("----------------getDataLocal start----------------");
        int i = 1;
        while(i++ < 100) {
            long start = System.currentTimeMillis();
            log.info("{} request uri {}, id {} start", "getDataRemote", i, id);
            testService.testLocalCache(id);
            long end = System.currentTimeMillis();
            log.info("{} request uri {}, id {} end, cost {}", "getDataRemote", i, id, end - start);
        }
        log.info("----------------getDataLocal end----------------");
        return "getDataLocal done";
    }

    @GetMapping("/getDataBoth")
    public String getDataBoth(String id){
        log.info("----------------getDataBoth start----------------");
        int i = 1;
        String result;
        while(i++ < 100) {
            long start = System.currentTimeMillis();
            log.info("{} request uri {}, id {} start", "getDataBoth",i, id);
            result = testService.testBothCache(id);
            long end = System.currentTimeMillis();
            log.info("{} request uri {}, id {}, result {} end, cost {}", "getDataBoth", i, id, result, end - start);
        }

        log.info("----------------getDataBoth end----------------");
        return "getDataBoth done";
    }

    @GetMapping("/invalidateLocal")
    public String invalidateCache() {
        return testService.deleteLocal("100");
    }

    @GetMapping("/invalidateRemote")
    public String invalidateRemote() {
        return testService.deleteRemote("100");
    }

    @GetMapping("/invalidateBoth")
    public String invalidateBoth() {
        return testService.deleteBoth("100");
    }

    @GetMapping("/changeValue")
    public String changeValue(){
        return testService.changeValue("100");
    }

}
