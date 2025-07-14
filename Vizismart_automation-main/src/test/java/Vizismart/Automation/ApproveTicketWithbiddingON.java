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

public class ApproveTicketWithbiddingON extends BaseTest {

	
	@Test	
	public void ApproveTicketWithBiddingON() throws InterruptedException {	
		
//	    WebDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver();
        Reporter.log("ChromeDriver initialized", true);
 
        driver.get("https://dev.vizismart.com/login");
        Reporter.log("Navigated to Login page", true);
        driver.manage().window().maximize();
 
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
        emailField.sendKeys("kalyanideshmukh778+313@gmail.com");
        Reporter.log("Entered Email", true);
 
        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
        password.sendKeys("qweqweqwe");
        Reporter.log("Entered Password", true);
 
        WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        Login.click();
        Reporter.log("Clicked on Login button", true);
 
        Thread.sleep(2000);
 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
        WebElement Smart_panel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[6]/div/div[3]/div")));
        Smart_panel.click();
        Reporter.log("Clicked on Notification icon", true);
 
        Thread.sleep(2000);
        WebElement Maintenance_ticket = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/table/tbody/tr[1]/td[1]")));
        Maintenance_ticket.click();
        Reporter.log("Click on the maintenance ticket", true);
 
        WebElement Bidding_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[3]/div/div[4]/button")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Bidding_btn);
        Thread.sleep(1000);
        Bidding_btn.click();
        Reporter.log("While approving the ticket make sure bidding is ON", true);
 
        WebElement AcceptBidding = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[6]/button[1]")));
        AcceptBidding.click();
        Reporter.log("Accept the bidding ON", true);
 
        WebElement Approve_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[3]/div/div[5]/button[1]")));
        Approve_btn.click();
        Reporter.log("Clicked on approve button", true);
 
        Thread.sleep(1000);
 
        // ✅ UPDATED CODE: Click on OK button in modal
        WebElement okBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", okBtn);
        Thread.sleep(500);
 
        try {
            wait.until(ExpectedConditions.elementToBeClickable(okBtn)).click();
        } catch (Exception e) {
            Reporter.log("Standard click failed, trying JS click", true);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", okBtn);
        }
 
        Reporter.log("Clicked on OK button in modal", true);
 
        Thread.sleep(3000);
        driver.close();		
    		
	}
	

}
