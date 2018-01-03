package com.tore.example;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import static org.testng.Assert.*;

public class AlertTest {
	private WebDriver driver;
	
	public Alert getAlert(String buttonId){
		  driver.findElement(By.id(buttonId)).click();
		  return driver.switchTo().alert();
	}
  @Test
  public void simpleAlert() {
	  System.out.println("Running Simple Alert");
	  Alert alert = getAlert("simple");
	  System.out.println(alert.getText());
	  assertEquals(alert.getText(),"Hello! I am an alert box!");
	  alert.accept();		
  }
  @Test
  public void confirmAlert() {
	  System.out.println("Running Confirm Alert");
	  Alert alert = getAlert("confirm");
	  System.out.println(alert.getText());
	  assertEquals(alert.getText(),"Press a button!");
	  alert.accept();		
  }
  @Test
  public void promptAlert() {
	  System.out.println("Running Prompt Alert");
	  Alert alert = getAlert("prompt");
	  System.out.println(alert.getText());
	  String txt = "Chandrahas";
	  alert.sendKeys(txt);
	  alert.accept();		
	  WebElement msg = driver.findElement(By.id("prompt_demo"));
	  assertEquals(msg.getText(),"Hello " + txt + "! How are you today?");
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get("http://cookbook.seleniumacademy.com/Alerts.html");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
}
