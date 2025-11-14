package com.kt.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfiguration {
	// redisson에서 분산락 동작은
	// DB에 접근하기전에 락을 획득하고 redis <key, value>에 저장
	// 작업수행
	// 끝나면 락 해제 redis에서 삭제
	// redis는 만료시간을 설정할 수 있음
	// 5초정도 줄까?
	// 100개의 요청을처리하는데 100*5 = 500초가 걸릴수도?

	@Bean
	public RedissonClient redissonClient() {
		var config = new Config();

		config.useSingleServer();

		return Redisson.create(config);
	}
}
