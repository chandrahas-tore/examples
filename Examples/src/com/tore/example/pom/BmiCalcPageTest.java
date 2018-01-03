package com.tore.example.pom;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import static org.testng.Assert.*;
public class BmiCalcPageTest {
	private WebDriver driver;
  @Test
  public void testCalculateBmi() {
	  BmiCalcPage bmiPage = new BmiCalcPage(driver);
	  bmiPage.setHeight("178");
	  bmiPage.setWeight("65");
	  bmiPage.calculateBmi();
	  assertEquals(bmiPage.getBmi(),"20.5");
	  assertEquals(bmiPage.getBmiCategory(),"Normal");
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get("http://cookbook.seleniumacademy.com/bmicalculator.html");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
