package com.marcsys.monitoring;

import com.marcsys.monitoring.benchmark.HistogramController;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class FirstService {

    @Autowired
    private HistogramController histogramController;

    @PostConstruct
    public void setup() {
        histogramController.create();
    }

    @Timed(description = "Time spend to process each execution",
           histogram = true,
           extraTags = {"project", "monitoring", "component", "service-first"})
    @Scheduled(fixedDelay = 50)
    public void publish() throws InterruptedException {
        histogramController.start();
        System.out.println("First service is running");
        Thread.sleep(new Random().nextInt(20));
        histogramController.finish();
    }
}
