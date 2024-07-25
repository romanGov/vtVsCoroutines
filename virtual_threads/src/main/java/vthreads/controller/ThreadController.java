package vthreads.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/thread")
public class ThreadController {
    @Value("${test.property}")
    private String testProperty;

    private static final Logger logger = Logger.getLogger(ThreadController.class.getName());

    @GetMapping("/work")
    public String hard() throws InterruptedException {
        logger.info("working hard");
        Thread.sleep(1000);
        return Thread.currentThread().toString();
    }
    @GetMapping("/property")
    public String property(){
        return testProperty;
    }
}
