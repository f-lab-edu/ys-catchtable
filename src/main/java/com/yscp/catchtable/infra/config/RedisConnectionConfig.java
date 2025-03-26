package com.yscp.catchtable.infra.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import java.time.Duration;

@Configuration
@RequiredArgsConstructor
public class RedisConnectionConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        LettuceClientConfiguration lettuceClientConfiguration = LettuceClientConfiguration.builder()
                .commandTimeout(Duration.ofSeconds(3L))
                .shutdownTimeout(Duration.ofSeconds(1L))
                .build();

        RedisStandaloneConfiguration redisConfiguration = new RedisStandaloneConfiguration();
        redisConfiguration.setHostName("127.0.0.1");
        redisConfiguration.setPort(6379);

        return new LettuceConnectionFactory(redisConfiguration, lettuceClientConfiguration);
    }
}
