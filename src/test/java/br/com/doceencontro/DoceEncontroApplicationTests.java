package br.com.doceencontro;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest(classes = DoceEncontroApplication.class)
class DoceEncontroApplicationTests {

	@Test
	void contextLoads() {
	}

}
