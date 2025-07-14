package Vizismart.Automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddProperty extends BaseTest{
	
	@Test(priority=1)
    public void add_single_family_property() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver();
        Reporter.log("ChromeDriver initialized", true);

        driver.get("https://dev.vizismart.com/login");
        Reporter.log("Navigated to Login page", true);
        
        // Login as property manager process ...
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
        emailField.sendKeys("kalyanideshmukh778+11@gmail.com");
        Reporter.log("Entered email address", true);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
        password.sendKeys("12345678");
        Reporter.log("Entered Password", true);
        
        WebElement Login = driver.findElement(By.xpath("//*[@id=\"login13\"]"));
        Login.click();
        Reporter.log("Clicked on Login button", true);
        
        // Add single family process ...
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Property_icon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"Properties6\"]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Property_icon);
        Property_icon.click();
        Reporter.log("Clicked on Property icon", true);
        
        WebElement Address = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/form/div[1]/input[1]"));
        // Scroll to the Address field
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Address);
        Address.sendKeys("Shivar chowk");
        Reporter.log("Entered the address.", true);
        
        WebElement City = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/form/div[1]/input[2]"));
        // Scroll to the City field
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", City);
        City.sendKeys("Pune");
        Reporter.log("Entered the city.", true);
        
        WebElement State = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/form/div[1]/input[3]"));
        // Scroll to the State field
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", State);
        State.sendKeys("Maharashtra");
        Reporter.log("Entered the state.", true);
        
        WebElement Zipcode = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/form/div[1]/input[4]"));
        // Scroll to the Zipcode field
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Zipcode);
        Zipcode.sendKeys("411057");
        Reporter.log("Entered the zip code.", true);
        
        WebElement SaveBtn = driver.findElement(By.xpath("//*[@id=\"add23\"]"));
        // Scroll to the Save button
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
        SaveBtn.click();
        Reporter.log("Clicked on save button", true);
        

        
        Thread.sleep(2000);
        
        driver.close();

 }
	
	
      
	}


