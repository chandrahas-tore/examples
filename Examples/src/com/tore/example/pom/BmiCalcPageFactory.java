package com.tore.example.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.*;
public class BmiCalcPageFactory {
	private WebDriver driver;
	//@FindBy(name = "heightCMS")
	private WebElement heightCMS;
	//@FindBy(name = "weightKg")
	private WebElement weightKg;
	//@FindBy(id = "Calculate")
	private WebElement Calculate;
	//@FindBy(name = "bmi")
	private WebElement bmi;
	//@FindBy(name = "bmi_category")
	private WebElement bmi_category;
	private final String url = "http://cookbook.seleniumacademy.com/bmicalculator.html";
	public BmiCalcPageFactory(){
		driver = new FirefoxDriver();
		PageFactory.initElements(driver, this);
	}
	public void open(){
		driver.get(url);		
	}
	public void calculateBmi(String ht, String wt){
		heightCMS.sendKeys(ht);
		weightKg.sendKeys(wt);
		Calculate.click();
	}
	public String getBmi(){
		return bmi.getAttribute("value");
	}
	public String getBmiCategory(){
		return bmi_category.getAttribute("value");
	}
	public void close(){
		driver.quit();
	}
}
