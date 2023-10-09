package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new SafariDriver(); //use ONLY the Web driver methods implemented by SafariDriver

        // ask the driver to implicitly wait for 5 seconds for ANY element to show up before throwing an exception
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        // ID locator
        driver.findElement(By.id("inputUsername")).sendKeys("tester");
        // Name locator
        driver.findElement(By.name("inputPassword")).sendKeys("randomtofail");
        // Classname locator
        driver.findElement(By.className("signInBtn")).click();
        // CSS Selector locator
        // cssSelector("tagname.classname")
        // cssSelector("tagname[attribute='value']")
        // cssSelector("tagname#id")
        // check for number of instances in console - >$('p.error') - wrap in SINGLE QUOTES!
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        // Link text locator - requires "a" anchor tag
        driver.findElement(By.linkText("Forgot your password?")).click();

        ///////////////// need an explicit wait here to allow the sliding page time to transition
        Thread.sleep(1000);
        //
        // XPath locator
        // xpath("//tagname[@attribute='value']")
        // check for number of instances in console - >$x('//input[@placeholder="Name"]') - wrap in SINGLE QUOTES
        driver.findElement(By.xpath("//input[@placeholder=\"Name\"]")).sendKeys("myname");
        // CSS Selector - custom locator
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@random.com");
        // XPath Selector - custom locator using index
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        // CSS Selector - custom locator using index string
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gamil.com");
        // XPath Selector - custom locator using only tags (no attributes) and index
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("520999999");

        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        // CSS Selector - custom locator using only tags (no attributes)
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        // go back to login screen
        driver.findElement(By.className("go-to-login-btn")).click();
        Thread.sleep(1000);

        // Now log into the application
        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("myname");

        // CSS Selector - custom locator using tagmane - attribute with regular expression
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.id("chkboxOne")).click();

        // XPath selector - custom locator using classname with regular expression
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        driver.quit();
    }
}
