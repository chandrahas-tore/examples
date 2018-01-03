package com.tore.example.pom;

import org.testng.annotations.*;
import static org.testng.Assert.*;
public class BmiCalcPageFactoryTest {
  @Test
  public void testCalculateBmi() {
	  BmiCalcPageFactory bmiPageFactory = new BmiCalcPageFactory();
	  bmiPageFactory.open();
	  bmiPageFactory.calculateBmi("178","65");
	  assertEquals(bmiPageFactory.getBmi(),"20.5");
	  assertEquals(bmiPageFactory.getBmiCategory(),"Normal");
	  bmiPageFactory.close();
  }
}
