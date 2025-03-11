package com.automation.calculator.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.calculator.pageObjects.CalculatorHomePage;

public class CalculatorTests extends BaseTest {
	
	@DataProvider(name= "numbers")
	public Object[][] getNumber(){
		return new Object[][] {
			{8,2}
		};
	}
	
	@Test(dataProvider="numbers")
    public void testAddition(int a,int b) {
		WebDriver driver = getDriver();
		CalculatorHomePage calculatorHomePage = new CalculatorHomePage(driver);
		calculatorHomePage.clear();
		int result = calculatorHomePage.add(a, b);
        Assert.assertEquals(result, a+b, "Addition result is incorrect!");
    }

    @Test(dataProvider="numbers")
    public void testSubtraction(int a,int b) {
		WebDriver driver = getDriver();
    	CalculatorHomePage calculatorHomePage = new CalculatorHomePage(driver);
		calculatorHomePage.clear();
		int result = calculatorHomePage.subtract(a, b);
        Assert.assertEquals(result, a-b, "Subtraction result is incorrect!");
    }

    @Test(dataProvider="numbers")
    public void testMultiplication(int a,int b) {
		WebDriver driver = getDriver();
    	CalculatorHomePage calculatorHomePage = new CalculatorHomePage(driver);
		calculatorHomePage.clear();

		int result = calculatorHomePage.multiply(a,b);
    	Assert.assertEquals(result, a*b , "Multiplication result is incorrect!");
    }

    @Test(dataProvider="numbers")
    public void testDivision(int a,int b) {
		WebDriver driver = getDriver();
    	CalculatorHomePage calculatorHomePage = new CalculatorHomePage(driver);
		calculatorHomePage.clear();
		int result = calculatorHomePage.divide(a, b);
        Assert.assertEquals(result, a/b, "Division result is incorrect!");
    }

}
