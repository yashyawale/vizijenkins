package Vizismart.Automation;

import java.time.Duration;

import org.apache.hc.core5.http.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SendQuoteBYVendor extends BaseTest {

	@Test
	public void SendQuote() throws InterruptedException {
		
//	    WebDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver();
        Reporter.log("ChromeDriver initialized", true);
 
        driver.get("https://dev.vizismart.com/login");
        Reporter.log("Navigated to Login page", true);
        driver.manage().window().maximize();
 
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
        emailField.sendKeys("kalyanideshmukh102+312@gmail.com");
        Reporter.log("Entered Email", true);
 
        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
        password.sendKeys("12345678");
        Reporter.log("Entered Password", true);
 
        WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        Login.click();
        Reporter.log("Clicked on Login button", true);
 
        Thread.sleep(2000);
 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // send quote process...
        
        WebElement ticket_page= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[6]/div/div[3]/div")));
        ticket_page.click();
        Reporter.log("Clicked on maintenance tickets page", true);
        
        WebElement ticket= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[3]/div/div/table/tbody/tr[1]")));
        ticket.click();
        Reporter.log("Clicked on maintenance ticket", true);
        
        Thread.sleep(1000);
        WebElement QuoteAmount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[3]/div/div/div[4]/div/div[1]/input")));
        QuoteAmount.sendKeys("121");
        Reporter.log("Entered quote amount", true);
        
        
        WebElement message = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[3]/div/div/div[4]/div/div[1]/textarea")));
        message.sendKeys("Automation testing");
        Reporter.log("Entered message ", true);
        
        Thread.sleep(1000);
        WebElement accept_btn = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div[4]/div/div[2]/button[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", accept_btn);
        Reporter.log("Clicked on accept button", true);
        
		Thread.sleep(1000);
		
		driver.close();
	}

}
