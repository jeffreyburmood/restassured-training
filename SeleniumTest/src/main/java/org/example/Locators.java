package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Locators {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new SafariDriver(); //use ONLY the Web driver methods implemented by SafariDriver
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("tester");
        driver.findElement(By.name("inputPassword")).sendKeys("randomtofail");
        driver.findElement(By.className("signInBtn")).click();

        driver.quit();
    }
}
