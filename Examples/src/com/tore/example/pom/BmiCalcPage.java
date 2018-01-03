package com.tore.example.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
public class BmiCalcPage {
	private WebDriver driver;
	@FindBy(name = "heightCMS")
	private WebElement height;
	@FindBy(name = "weightKg")
	private WebElement weight;
	@FindBy(id = "Calculate")
	private WebElement calcButton;
	@FindBy(name = "bmi")
	private WebElement bmi;
	@FindBy(name = "bmi_category")
	private WebElement bmi_category;
	
	public BmiCalcPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setHeight(String ht){
		height.sendKeys(ht);
	}
	public void setWeight(String wt){
		weight.sendKeys(wt);
	}
	public void calculateBmi(){
		calcButton.click();
	}
	public String getBmi(){
		return bmi.getAttribute("value");
	}
	public String getBmiCategory(){
		return bmi_category.getAttribute("value");
	}
}
