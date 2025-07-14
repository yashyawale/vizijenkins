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

public class RemoveProperty extends BaseTest {

	 @Test
	public void RemoveProp() throws InterruptedException {
//		 WebDriverManager.chromedriver().setup();
//		    ChromeDriver driver = new ChromeDriver();
		    Reporter.log("ChromeDriver initialized", true);

		        // Login process
		        driver.get("https://dev.vizismart.com/login");
		        Reporter.log("Navigated to Login page", true);
		        driver.manage().window().maximize();

		        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
		        emailField.sendKeys("kalyanideshmukh778+11@gmail.com");
		        Reporter.log("Entered Email", true);

		        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
		        password.sendKeys("12345678");
		        Reporter.log("Entered Password", true);

		        WebElement login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		        login.click();
		        Reporter.log("Clicked on Login button", true);

		        // Remove property process
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        WebElement selectProp = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div")));
		        selectProp.click();
		        Reporter.log("Selected property to add vendor", true);

		        Thread.sleep(1000);
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollBy(0,500)");
		        
		        // Wait for the Remove button to be visible
		        WebElement removeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[3]/div/div[5]/div/button")));
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", removeBtn);
		        removeBtn.click();

		        WebElement sure_btn= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[6]/button[1]")));
		        sure_btn.click();
		        
		        
		        Reporter.log("Removed the property successfully.", true);

		        Thread.sleep(2000); // Optional
		        driver.close();	
		        
	}

}
