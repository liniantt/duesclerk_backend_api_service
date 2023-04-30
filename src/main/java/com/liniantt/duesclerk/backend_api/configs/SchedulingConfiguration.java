package com.liniantt.duesclerk.backend_api.configs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ConditionalOnProperty(
    name = "com.liniantt.duesclerk.backend_api.scheduling.enabled",
    havingValue = "true",
    matchIfMissing = true)
public class SchedulingConfiguration {
}
