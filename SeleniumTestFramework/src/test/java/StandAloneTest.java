
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class StandAloneTest {

    public static void main(String[] args) {


        WebDriver driver = new SafariDriver(); //use ONLY the Web driver methods implemented by SafariDriver
        // ask the driver to implicitly wait for 5 seconds for ANY element to show up before throwing an exception
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("userEmail")).sendKeys("john@email.com");
        driver.findElement(By.id("userPassword")).sendKeys("Tester10!");
        driver.findElement(By.id("login")).click();


    }
}
