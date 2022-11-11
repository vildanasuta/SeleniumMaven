import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TryNegativeTesting {
    public static WebDriver driver;

    @BeforeClass
    public void setup() {
        String workingDir = System.getProperty("user.dir");
        String path=workingDir+"/src/test/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        driver=new ChromeDriver();
    }

    @Test(priority=1)
    public void openUrl() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        System.out.println("URL open successfully");
    }
    @Test(priority = 2)
    public void login() {
        WebElement textBox1 = driver.findElement(By.name("user-name"));
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(textBox1));
        WebElement textBox2 = driver.findElement(By.name("password"));
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(textBox2));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(submitButton));

        textBox1.sendKeys("negative");
        textBox2.sendKeys("negative");

        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        WebElement error=driver.findElement(By.className("error-message-container"));
        assertTrue(error.isDisplayed());
        System.out.println(error.getText());
    }




    @AfterClass
    public void quit() {
        driver.quit();
    }



}
