package com.btc.kafka.integration.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringUtilsTest {

	@Test
	public void isPalindromeTest() {
		
		StringUtils utils = new StringUtils();
		assertTrue(utils.isPalindrome(""));
	}
	
	@Test
	public void isPalindromeTest1() {
		
		StringUtils utils = new StringUtils();
		assertFalse(utils.isPalindrome("NAN"));
	}
}
