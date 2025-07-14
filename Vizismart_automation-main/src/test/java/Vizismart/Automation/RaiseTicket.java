package Vizismart.Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RaiseTicket extends BaseTest {

		@Test
		public void raiseticket() {
			
	        // Initialize WebDriver
//	        WebDriverManager.chromedriver().setup();
//	        ChromeDriver driver = new ChromeDriver();
	        Reporter.log("ChromeDriver initialized", true);

	        try {
	            // Navigate to Login Page
	            driver.get("https://dev.vizismart.com/login");
	            Reporter.log("Navigated to Login page", true);

	            // Perform login
	            WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/input"));
	            emailField.sendKeys("deshmukhkalyani2001+314@gmail.com");
	            Reporter.log("Entered Email", true);

	            WebElement password = driver.findElement(By.name("password"));
	            password.sendKeys("12345678");
	            Reporter.log("Entered Password", true);

	            WebElement loginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
	            loginButton.click();
	            Reporter.log("Clicked on Login button", true);

	            // Wait for and click on the conversation icon
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement conversationIcon = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/a[1]/div/div[1]")));
	            conversationIcon.click();
	            Reporter.log("Clicked on Conversation icon", true);

	            // Send first message
	            WebElement tenantMsg1 = wait.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector("input[type='text']")));
	            tenantMsg1.sendKeys("Hii");
	            WebElement sendMsg1 = driver.findElement(By.cssSelector("svg.mr-4.ml-2.w-6.h-6.text-green-500"));
	            sendMsg1.click();
	            Thread.sleep(10000);

	            // Send second message
	            WebElement tenantMsg2 = wait.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector("input[type='text']")));
	            tenantMsg2.sendKeys("I need a painter for painting walls and don't have any photo please schedule the time");
	            WebElement sendMsg2 = driver.findElement(By.cssSelector("svg.mr-4.ml-2.w-6.h-6.text-green-500"));
	            sendMsg2.click();
	            Thread.sleep(15000);

	            // Send date and time
	            WebElement tenantMsg3 = wait.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector("input[type='text']")));
	            tenantMsg3.clear();
	            tenantMsg3.sendKeys("02/01/2026 10:15 AM");
	            WebElement sendMsg3 = driver.findElement(By.cssSelector("svg.mr-4.ml-2.w-6.h-6.text-green-500"));
	            sendMsg3.click();
	            Thread.sleep(8000);

	        } catch (Exception e) {
	            Reporter.log("Error occurred: " + e.getMessage(), true);
	        } finally {
	            // Close the driver
	            driver.close();
	            Reporter.log("Browser closed", true);
	        }
			
		

	}

}
