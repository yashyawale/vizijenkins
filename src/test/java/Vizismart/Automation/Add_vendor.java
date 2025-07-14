package Vizismart.Automation;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Add_vendor extends BaseTest {
	
	public static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
	

    @Test
    public void add() throws InterruptedException {

//        WebDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver();
        Reporter.log("ChromeDriver initialized", true);

        // Login process...
        driver.get("https://dev.vizismart.com/login");
        Reporter.log("Navigated to Login page", true);
        
        driver.manage().window().maximize();

        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
        emailField.sendKeys("kalyanideshmukh778+5@gmail.com");
        Reporter.log("Entered Email", true);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
        password.sendKeys("12345678");
        Reporter.log("Entered Password", true);
        

        WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        Login.click();
        Reporter.log("Clicked on Login button", true);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Reporter.log("Implicit wait set for 2 seconds", true);

        // Add vendor process...
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement select_prop = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div")));
        select_prop.click();
        Reporter.log("Select property to add vendor", true);


        WebElement vendor_tab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[3]/div/div[2]/button[2]")));
        vendor_tab.click();
        
        WebElement add_Vendor = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"vstab2\"]")));
        add_Vendor.click();
        Reporter.log("Clicked on Add Vendor icon", true);
        
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Reporter.log("Implicit wait set for 10 seconds", true);

        WebElement Search_Vendor = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[3]/div/div[1]/input")));
        Search_Vendor.sendKeys("temp");
        Reporter.log("Search the vendor in the list", true);
        
        Thread.sleep(1000);
        WebElement Assign_spl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"vendorcard13\"]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Assign_spl);
        Assign_spl.click();
        Reporter.log("Clicked on assign button", true);
        
        WebElement Specailty_one = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[3]/div/div[2]/div[1]/div/div/div[2]/div/ul/li")));
        Specailty_one.click();
        Reporter.log("Seleted first speciality of vendor", true);
        
    
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300);");
        
        WebElement Submit_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"vendorcard18\"]")));
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Submit_btn);
        // Click the submit button
        Submit_btn.click();
        Reporter.log("Clicked on submit button", true);
        
        Thread.sleep(4000);
        
        Reporter.log("Waited for 2 seconds", true);

        driver.close();
        Reporter.log("Closed the browser", true);
    }

}
