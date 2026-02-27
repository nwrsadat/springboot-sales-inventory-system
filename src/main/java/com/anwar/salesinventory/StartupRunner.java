package com.anwar.salesinventory;

import com.anwar.salesinventory.mapper.HealthMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupRunner implements CommandLineRunner {

    private final HealthMapper healthMapper;
    Logger logger = LoggerFactory.getLogger(StartupRunner.class);

    @Override
    public void run(String... args) {
        Integer result = healthMapper.check();
        logger.info("Database check result : {}", result);
    }
}
