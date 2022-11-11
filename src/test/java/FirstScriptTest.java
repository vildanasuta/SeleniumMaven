

import java.time.Duration;

import org.testng.AssertJUnit;
import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;


public class FirstScriptTest {

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
    public void verifyTitle(){
        String title = driver.getTitle();
        assertEquals(title, "Swag Labs");
        System.out.println("Title verified");
    }
    @Test(priority=3)
    public void login(){
        WebElement textBox1= driver.findElement(By.name("user-name"));
        new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(textBox1));

        WebElement textBox2= driver.findElement(By.name("password"));
        new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(textBox2));

        WebElement submitButton = driver.findElement(By.id("login-button"));
        new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(submitButton));

        textBox1.sendKeys("standard_user");
        textBox2.sendKeys("secret_sauce");
        new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        AssertJUnit.assertEquals("https://www.saucedemo.com/inventory.html",driver.getCurrentUrl().toString());
        System.out.println("Logged in successfully");

    }
    @Test(priority = 4)
    public void verifyHeader(){
        WebElement productsHeader=driver.findElement(By.className("title"));
        new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(productsHeader));
        boolean productsHeaderDisplayed=productsHeader.isDisplayed();
        assertEquals(productsHeaderDisplayed,true);
        String productsHeaderText=productsHeader.getText();
        assertEquals(productsHeaderText, "PRODUCTS");
        System.out.println("Header verified");
    }
    @Test(priority=5)
    public void verifyCart(){
        WebElement shoppingCart= driver.findElement(By.id("shopping_cart_container"));
        new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(shoppingCart));
        boolean shoppingCartStatus=shoppingCart.isDisplayed();
        assertEquals(shoppingCartStatus,true);
        System.out.println("Cart verified");
    }
    @Test(priority = 6)
    public void verifyBurgerMenu(){
        WebElement burgerMenu= driver.findElement(By.id("react-burger-menu-btn"));
        new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(burgerMenu));
        boolean burgerMenuStatus=burgerMenu.isDisplayed();
        assertEquals(burgerMenuStatus,true);
        assertEquals(burgerMenu.getLocation().toString(),"(15, 20)");
        System.out.println("Burger menu verified");
    }
    @Test (priority = 7)
    public void verifySocialMediaLinks(){
        WebElement twitter=driver.findElement(By.className("social_twitter"));
        new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(twitter));
        boolean twitterStatus= twitter.isDisplayed();
        assertEquals(twitterStatus,true);
        System.out.println("Twitter link verified");

        WebElement facebook=driver.findElement(By.className("social_facebook"));
        new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(facebook));
        boolean facebookStatus= facebook.isDisplayed();
        assertEquals(facebookStatus,true);
        System.out.println("Facebook link verified");

        WebElement linkedin=driver.findElement(By.className("social_linkedin"));
        new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(linkedin));
        boolean linkedinStatus= linkedin.isDisplayed();
        assertEquals(linkedinStatus,true);
        System.out.println("Linkedin link verified");

    }
    @Test (priority = 8)
    public void logout(){
        WebElement burgerMenu= driver.findElement(By.id("react-burger-menu-btn"));
        new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(burgerMenu)).click();
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))).click();
        System.out.println("Logged out successfully");
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}

