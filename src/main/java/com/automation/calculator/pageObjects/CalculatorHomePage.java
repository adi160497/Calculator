package com.automation.calculator.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorHomePage {
	
	private final WebDriver driver;
    private final WebDriverWait wait;
    public CalculatorHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    
    //Objects
    String button = "input[value='%s']";
    String result = "div[id='display'] div";
    String divide = "divide";
    String multiply = "multiply";
    String addition = "add";
    String subtraction = "subtract";
    String clear = "input[value='C']";
    String equal = "input[value='=']";
    
    //Functions
    
    public void clickButton(int a) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(String.format(button, a))));
    	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(String.format(button, a))));
        driver.findElement(By.cssSelector(String.format(button, a))).click();
    }

    public int getResult() {

    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(result)));
        String resultOnDisplay = driver.findElement(By.cssSelector(result)).getText(); 
        return Integer.valueOf(resultOnDisplay);
    }

    public void clear() {
       // Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(clear)));
        String resultOnDisplay = driver.findElement(By.cssSelector(result)).getText();
        if(!resultOnDisplay.equals("0")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(clear)));
            driver.findElement(By.cssSelector(clear)).click();
        }

    }
    
    public void selectAddition() {
    	wait.until(ExpectedConditions.elementToBeClickable(By.id(addition)));
    	driver.findElement(By.id(addition)).click();
    }
    public void selectSubtraction() {
    	wait.until(ExpectedConditions.elementToBeClickable(By.id(subtraction)));
    	driver.findElement(By.id(subtraction)).click();
    }
    public void selectMultiplication() {
    	wait.until(ExpectedConditions.elementToBeClickable(By.id(multiply)));
    	driver.findElement(By.id(multiply)).click();
    }
    public void selectDivision() {
    	wait.until(ExpectedConditions.elementToBeClickable(By.id(divide)));
    	driver.findElement(By.id(divide)).click();
    }
    public void selectEquals() {
    	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(equal)));
    	driver.findElement(By.cssSelector(equal)).click();
    }
    
    public int add(int a, int b) {
    	clickButton(a);
    	selectAddition();
    	clickButton(b);
    	selectEquals();
    	return getResult();
    }
    
    public int subtract(int a, int b) {
    	clickButton(a);
    	selectSubtraction();
    	clickButton(b);
    	selectEquals();
    	return getResult();
    }
    public int multiply(int a, int b) {
    	clickButton(a);
    	selectMultiplication();
    	clickButton(b);
    	selectEquals();
    	return getResult();
    }
    public int divide(int a, int b) {
    	clickButton(a);
    	selectDivision();
    	clickButton(b);
    	selectEquals();
    	return getResult();
    }

}
