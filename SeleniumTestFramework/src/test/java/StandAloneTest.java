
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {

    public static void main(String[] args) {


        WebDriver driver = new SafariDriver(); //use ONLY the Web driver methods implemented by SafariDriver
        // ask the driver to implicitly wait for 5 seconds for ANY element to show up before throwing an exception
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().window().maximize();

        driver.findElement(By.id("userEmail")).sendKeys("john@email.com");
        driver.findElement(By.id("userPassword")).sendKeys("Tester10!");
        driver.findElement(By.id("login")).click();

        // get the list of elements representing the product cards available for sale
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        // Process list as a stream and filter for the product we're looking for
        WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("zara coat 3")).findFirst().orElse(null);
        assert prod != null;
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
    }
}
