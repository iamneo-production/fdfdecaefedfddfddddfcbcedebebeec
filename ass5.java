import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SnapdealLoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the driver path for Chrome browser
        System.setProperty("webdriver.chrome.driver", "C:\Users\Yash\workspace\libs\chromeDriver36\chromedriver.exe");
        // Initialize ChromeDriver instance
        driver = new ChromeDriver();
        // Navigate to Snapdeal website
        driver.get("https://www.snapdeal.com");
    }

    @Test(priority = 1)
    public void signInButtonTest() {
        // Find the sign in button
        WebElement signInButton = driver.findElement(By.xpath("//div[@class='accountInner']"));
        // Hover over the sign in button
        Actions action = new Actions(driver);
        action.moveToElement(signInButton).build().perform();
        // Verify the sign in button text
        WebElement signInButtonText = driver.findElement(By.xpath("//div[@class='accountInner']//span[text()='Sign In']"));
        Assert.assertEquals(signInButtonText.getText(), "Sign In");
        // Click on the sign in button
        signInButton.click();
    }

    @Test(priority = 2)
    public void loginTest() {
        // Find the email input field
        WebElement emailInput = driver.findElement(By.id("userName"));
        // Enter the email address
        emailInput.sendKeys("email@example.com");
        // Click on the continue button
        WebElement continueButton = driver.findElement(By.id("checkUser"));
        continueButton.click();
        // Find the password input field
        WebElement passwordInput = driver.findElement(By.id("j_password_login_uc"));
        // Enter the password
        passwordInput.sendKeys("password");
        // Click on the login button
        WebElement loginButton = driver.findElement(By.id("submitLoginUC"));
        loginButton.click();
        // Verify the login
        WebElement loggedInUserName = driver.findElement(By.xpath("//div[@class='accountInner']//span[@class='accountUserName col-xs-12 reset-padding']"));
        Assert.assertEquals(loggedInUserName.getText(), "Welcome, username");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}