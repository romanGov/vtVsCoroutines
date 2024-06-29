package vthreads.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/thread")
public class ThreadController {
    private static final Logger logger = Logger.getLogger(ThreadController.class.getName());
    @GetMapping("/name")
    public String getThreadName() {
        return Thread.currentThread().toString();
    }
    @GetMapping("/work")
    public String hard() throws InterruptedException {
        logger.info("working hard");
        Thread.sleep(1000);
        return Thread.currentThread().toString();
    }
}
