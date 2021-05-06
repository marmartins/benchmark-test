package com.marcsys.monitoring.benchmark;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class HistogramConfig {

    @Value("${metrics.border.mean.count}")
    private int maxCount;

    @Value("${metrics.folder}")
    private String metricsFolder;

    @Value("${spring.application.name}")
    private String applicationName;

}
