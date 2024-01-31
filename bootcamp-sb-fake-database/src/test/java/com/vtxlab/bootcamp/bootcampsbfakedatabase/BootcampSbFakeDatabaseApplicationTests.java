package com.vtxlab.bootcamp.bootcampsbfakedatabase;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // 模擬Simulate the actual process of "mvn spring-boot:run"
// Testing @SpringBootApplication -> @ComponentScan + @Autowird
// To trigger @SpringBootTest, we use "mvn clean test"
class BootcampSbFakeDatabaseApplicationTests {

	// In @SpringBootTest env,
	// the spring context will contain all your custom beans
	// i.e. @Controller, @Service, @Configuration, @Bean

	@Test // At least one @Test to start up the test env.
	void contextLoads() { // Spring Context load , Call from Spring boot (default public, no need to write)
	}

}
