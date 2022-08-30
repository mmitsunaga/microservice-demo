package com.microservices.demo.twitter.to.kafka.service;

import com.microservices.demo.twitter.to.kafka.service.config.TwitterKafkaServiceConfigData;
import com.microservices.demo.twitter.to.kafka.service.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class TwitterKafkaServiceApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(TwitterKafkaServiceApplication.class);

    private final TwitterKafkaServiceConfigData configData;

    private final StreamRunner streamRunner;

    public TwitterKafkaServiceApplication(TwitterKafkaServiceConfigData configData, StreamRunner streamRunner) {
        this.configData = configData;
        this.streamRunner = streamRunner;
    }

    public static void main(String[] args) {
        SpringApplication.run(TwitterKafkaServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(Arrays.toString(configData.getTwitterKeywords().toArray(new String[]{})));
        streamRunner.start();
    }
}
