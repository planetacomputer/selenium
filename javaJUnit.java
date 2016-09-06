package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class javaJUnit {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost/selenium/login.php");
		selenium.start();
	}

	@Test
	public void testJavaJUnit() throws Exception {
		selenium.open("/selenium/login.php");
		assertEquals("Formulari login", selenium.getTitle());
		selenium.type("name=user", "admin");
		selenium.type("name=password", "1111");
		selenium.click("css=button.w3-btn.w3-blue-grey");
		selenium.waitForPageToLoad("30000");
		assertEquals("Login correcte", selenium.getText("id=ok"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
