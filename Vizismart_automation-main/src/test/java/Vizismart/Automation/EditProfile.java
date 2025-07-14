package Vizismart.Automation;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditProfile extends BaseTest {
	
	@Test
	public void Edit() throws InterruptedException {
		
//
//        WebDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver();
        driver.get("https://dev.vizismart.com/login");

        // Login
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
        emailField.sendKeys("kalyanideshmukh778+11@gmail.com");
        Reporter.log("Entered Email", true);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
        password.sendKeys("12345678");
        Reporter.log("Entered Password", true);

        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        Reporter.log("Clicked on Login button", true);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open sidebar menu
        WebElement humbergerIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root > div > div.z-50.bottom-0.fixed.left-0.w-screen > div > div.flex.px-4.z-10.relative.justify-between.bg-black.p-2.py-4.items-center > div > svg")));
        humbergerIcon.click();
        Reporter.log("Clicked on corner bar to expand menu", true);

        // Click profile icon
        WebElement profileIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/div/div[3]/div/div[3]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", profileIcon);
        Reporter.log("Clicked on profile button", true);

        // Click edit icon
        WebElement editIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[3]/div/div/div[1]/button")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editIcon);
        Reporter.log("Clicked on edit button", true);

        // Edit First Name
        WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='First Name']")));
        firstName.clear();
        firstName.sendKeys("selenium");

        // Edit Last Name
        WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Last Name']")));
        lastName.clear();
        lastName.sendKeys("tester");

        // Click Done button
        WebElement doneBtn = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/form/div/div[5]/div/button"));
        doneBtn.click();

        Thread.sleep(2000);
        driver.quit();	
	}
}
