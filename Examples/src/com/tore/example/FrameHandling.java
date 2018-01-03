package com.tore.example;

import org.testng.annotations.*;
import org.testng.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class FrameHandling {
	private WebDriver driver;
	private WebElement msg;
	
	public void moveToFrame(String id){
		switch(id){
			case "left":
				  driver.switchTo().frame("left");
				  break;
			case "right":
				  driver.switchTo().frame("right");
				  break;
		}
	  msg = driver.findElement(By.tagName("p"));
	  System.out.println(msg.getText());
	  System.out.println("Frame Title: " + driver.getTitle());
	}
  @Test
  public void moveToLeftFrame() {
	  moveToFrame("left");
	  Assert.assertEquals(msg.getText(), "This is Left Frame");
  }
  @Test
  public void moveToRightFrame() {
	  moveToFrame("right");
	  Assert.assertEquals(msg.getText(), "This is Right Frame");
  }
  @AfterMethod
  public void afterMethod(){
	  System.out.println("Moving back to page...");
	  driver.switchTo().defaultContent();
	  System.out.println("Page Title: " + driver.getTitle());
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get("http://cookbook.seleniumacademy.com/Frames.html");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
}
