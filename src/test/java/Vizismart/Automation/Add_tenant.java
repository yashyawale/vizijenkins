package Vizismart.Automation;

import java.time.Duration;
import java.util.Random;
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

public class Add_tenant extends BaseTest {


	public static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

public static String generateRandomEmail() {
    Random random = new Random();
    int prefixLength = 8 + random.nextInt(5); // Random length between 8 and 12
    StringBuilder emailPrefix = new StringBuilder();
    for (int i = 0; i < prefixLength; i++) {
        char randomChar = (char) ('a' + random.nextInt(26)); // Random lowercase letter
        emailPrefix.append(randomChar);
    }
    return emailPrefix + "@gmail.com";
}

// Function to generate a random phone number
public static String generateRandomPhoneNumber() {
    Random random = new Random();
    int firstDigit = random.nextInt(9) + 1; // Ensure the first digit is not zero
    StringBuilder phoneNumber = new StringBuilder(String.valueOf(firstDigit));
    for (int i = 0; i < 9; i++) {
        phoneNumber.append(random.nextInt(10));
    }
    return phoneNumber.toString();
}


@Test
public void add() throws InterruptedException {
	
//	WebDriverManager.chromedriver().setup();
//	ChromeDriver driver = new ChromeDriver();
	Reporter.log("ChromeDriver initialized", true);
	
	// login process...
    driver.get("https://dev.vizismart.com/login");
    Reporter.log("Navigated to Login page", true);
    
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
    
    // add tenant process...
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    WebElement select_prop = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div")));
    select_prop.click();
    Reporter.log("Select property to add tenant", true);
    
  
    
       
    WebElement add_tenant = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tenantstab3\"]")));
    add_tenant.click();
    Reporter.log("Clicked on Add Tenant button", true);
    
    WebElement first_name = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tpopup6\"]/input[1]")));
    first_name.sendKeys("Automation Test");
    Reporter.log("Entered First Name: temp", true);
    
    WebElement last_name =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tpopup6\"]/input[2]")));
    last_name.sendKeys("tenant");
    Reporter.log("Entered Last Name: tenant", true);
    
    String randomEmail= generateRandomEmail();
    WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tpopup6\"]/input[3]")));
    email.sendKeys(randomEmail);
    Reporter.log("Entered Email", true);
    
    String randomPhone= generateRandomPhoneNumber();
    WebElement phone_number = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tpopup6\"]/input[4]")));
    phone_number.sendKeys(randomPhone);
    Reporter.log("Entered Phone Number", true);
    
    WebElement save_btn = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[1]/div/div/div/form/div[2]/button[1]"));
    save_btn.click();
    Reporter.log("Clicked on Save button", true);
    
  
    
    Thread.sleep(2000);
    Reporter.log("Waited for 2 seconds", true);
    
    driver.close();
    Reporter.log("Closed the browser", true);
}
}
