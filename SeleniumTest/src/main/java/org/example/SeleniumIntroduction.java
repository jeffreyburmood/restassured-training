package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumIntroduction {
    public static void main(String[] args) {

        // Invoke the browser
        // When using a separate browser driver
        // System.setProperty("webdriver.chrome.driver", "/path/chromedriver");
        WebDriver driver = new SafariDriver(); //use ONLY the Web driver methods implemented by SafariDriver
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit(); //close all associated windows and tabs
    }
}