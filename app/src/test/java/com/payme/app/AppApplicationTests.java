package com.payme.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AppApplicationTests {

	@Test
	void contextLoads() {
	}

	@SpringBootTest
	public class PasswordEncoderTest {

		@Autowired
		private PasswordEncoder passwordEncoder;

		@Test
		public void testPasswordEncoderBean() {
			assertNotNull(passwordEncoder, "PasswordEncoder bean is not loaded!");
		}
	}

}
