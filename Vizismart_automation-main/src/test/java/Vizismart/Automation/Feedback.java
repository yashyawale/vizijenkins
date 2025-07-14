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

public class Feedback extends BaseTest{
	
	@Test
	public void feedbackOFPM() throws InterruptedException {
		
//		 	WebDriverManager.chromedriver().setup();
//	        ChromeDriver driver = new ChromeDriver();
	        Reporter.log("ChromeDriver initialized", true);

	        // Login process of tenant ...
	        driver.get("https://dev.vizismart.com/login");
	        Reporter.log("Navigated to Login page", true);

	        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/input"));
	        emailField.sendKeys("kalyanideshmukh778+5@gmail.com");
	        Reporter.log("Entered Email", true);

	        WebElement password = driver.findElement(By.name("password"));
	        password.sendKeys("12345678");
	        Reporter.log("Entered Password", true);

	        WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
	        Login.click();
	        Reporter.log("Clicked on Login button", true);
	        
	        // feedback process....
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        WebElement Humberger_icon = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#root > div > div.z-50.bottom-0.fixed.left-0.w-screen > div > div.flex.px-4.z-10.relative.justify-between.bg-black.p-2.py-4.items-center > div > svg")));
	        Humberger_icon.click();
	        Reporter.log("Clicked on corner bar to expand menu", true);
	        
	        Thread.sleep(1000);
	        WebElement feedback = driver.findElement(By.cssSelector("#root > div > div.z-50.bottom-0.fixed.left-0.w-screen > div > div.flex.text-white.flex-col.absolute.right-0.transition-all.top-14.self-end.bg-black.p-3.fade-in.rounded-\\[4px\\] > div > div:nth-child(2)"));
	        feedback.click();
	        Reporter.log("Click on feedbak icon", true);
	        
	        WebElement feature_input = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/input"));
	        feature_input.sendKeys("feedback from property manager");
	        Reporter.log("Entered the feature input", true);
	        
	        WebElement about = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/textarea"));
	        about.sendKeys("Gooddd from automation testing");
	        Reporter.log("Entered the feedback", true);
	        
	        WebElement stars= driver.findElement(By.cssSelector("#root > div > div.h-full.w-screen.overflow-y-scroll > div > div:nth-child(4) > svg:nth-child(5) > path"));
	        stars.click();
	        Reporter.log("Give rating as five.", true);
	        
	        WebElement submit_btn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/button"));

	     // Scroll into view
	     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit_btn);

	     // Optional: wait a bit after scroll
	     Thread.sleep(500); // or use WebDriverWait if preferred

	     submit_btn.click();
	        
	        
	        WebElement OK_btn= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[6]/button[1]")));
	        OK_btn.click();
	        
	        
	        Thread.sleep(1000);
	        
	        driver.close();
	        Reporter.log("Browser closed", true);
	        
	        
		
	}

}
