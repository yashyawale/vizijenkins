package Vizismart.Automation;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Remove_tenant extends BaseTest {
	
	public static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

@Test
public void delete() throws InterruptedException {
//    WebDriverManager.chromedriver().setup();
//    ChromeDriver driver = new ChromeDriver();
    Reporter.log("ChromeDriver initialized", true);

    // Login process...
    driver.get("https://dev.vizismart.com/login");
    Reporter.log("Navigated to Login page", true);
    
    driver.manage().window().fullscreen();

    WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
    emailField.sendKeys("kalyanideshmukh778+11@gmail.com");
    Reporter.log("Entered Email", true);

    WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
    password.sendKeys("12345678");
    Reporter.log("Entered Password", true);
    

    WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
    Login.click();
    Reporter.log("Clicked on Login button", true);
    

    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    Reporter.log("Implicit wait set for 2 seconds", true);
    
    // Delete tenant process...
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    WebElement select_prop = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div")));
    select_prop.click();
    Reporter.log("select the property", true);
    

    WebElement deleteTenant = driver.findElement(By.xpath("//*[@id=\"tenantcard13\"]"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteTenant);
    deleteTenant.click();
    Reporter.log("Clicked on Delete button for tenant", true);

    WebElement sure_btn = driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]"));
    sure_btn.click();
    Reporter.log("Confirmed tenant deletion", true);

  
    
    Thread.sleep(3000);
    Reporter.log("Waited for 3 seconds", true);

    driver.close();
    Reporter.log("Closed the browser", true);

}


}
