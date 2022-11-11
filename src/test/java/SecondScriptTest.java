

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
import static org.testng.AssertJUnit.assertTrue;

public class SecondScriptTest {
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

        textBox1.sendKeys("standard_user");
        textBox2.sendKeys("secret_sauce");

        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        AssertJUnit.assertEquals("https://www.saucedemo.com/inventory.html",driver.getCurrentUrl().toString());
        System.out.println("Logged in successfully");
    }
    @Test(priority = 3)
    public void clickOnBackpack() {
        WebElement linkSauceLabsBackpack = driver.findElement(By.linkText("Sauce Labs Backpack"));
        boolean linkSauceLabsBackpackStatus = linkSauceLabsBackpack.isDisplayed();
        assertTrue(linkSauceLabsBackpackStatus);
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(linkSauceLabsBackpack)).click();
        System.out.println("Click on product works");
    }
    @Test(priority = 4)
    public void verifyTitleDescriptionPrice() {
        WebElement title = driver.findElement(By.className("inventory_details_name"));
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(title));
        boolean titleStatus = title.isDisplayed();
        assertTrue(titleStatus);
        assertEquals(title.getText(), "Sauce Labs Backpack");

        System.out.println("Title verified");

        WebElement description = driver.findElement(By.className("inventory_details_desc"));
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(description));
        boolean descriptionStatus = description.isDisplayed();
        assertTrue(descriptionStatus);

        System.out.println("Description verified");

        WebElement price = driver.findElement(By.className("inventory_details_price"));
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(price));
        boolean priceStatus = price.isDisplayed();
        assertTrue(priceStatus);
        System.out.println("Price verified");

    }
    @Test(priority = 5)
    public void addToCart() {
        WebElement addToCart = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        boolean addToCartStatus = addToCart.isDisplayed();
        assertTrue(addToCartStatus);
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(addToCart)).click();
        System.out.println("Added to cart");
    }
    @Test(priority = 6)
    public void backToProducts() {
        WebElement backToProducts = driver.findElement(By.id("back-to-products"));
        boolean backToProductsStatus = backToProducts.isDisplayed();
        assertTrue(backToProductsStatus);
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(backToProducts)).click();
        System.out.println("Back to products worked");
    }
    @Test(priority = 7)
    public void addToCartFromHome(){
        WebElement buyJacket=driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket"));
        boolean buyJacketStatus=buyJacket.isDisplayed();
        assertTrue(buyJacketStatus);
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(buyJacket)).click();
        System.out.println("Add to cart verified");
    }
    @Test(priority = 8)
    public void viewCart(){
        WebElement cart=driver.findElement(By.className("shopping_cart_link"));
        boolean cartStatus=cart.isDisplayed();
        assertTrue(cartStatus);
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(cart)).click();
        System.out.println("Cart preview verified");
    }
    @Test(priority = 9)
    public void checkout(){
        WebElement checkout=driver.findElement(By.id("checkout"));
        boolean checkoutStatus=checkout.isDisplayed();
        assertTrue(checkoutStatus);
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(checkout)).click();
        System.out.println("Checkout link verified");
    }
    @Test(priority = 10)
    public void enterDataFinish(){
        WebElement firstName=driver.findElement(By.id("first-name"));
        boolean firstNameStatus=firstName.isDisplayed();
        assertTrue(firstNameStatus);
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(firstName)).click();
        firstName.sendKeys("Vildana");

        System.out.println("Name entered successfully");

        WebElement lastName=driver.findElement(By.id("last-name"));
        boolean lastNameStatus=lastName.isDisplayed();
        assertTrue(lastNameStatus);
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(lastName)).click();
        lastName.sendKeys("Suta");

        System.out.println("Last name entered successfully");


        WebElement zipcode=driver.findElement(By.id("postal-code"));
        boolean zipcodeStatus=zipcode.isDisplayed();
        assertTrue(zipcodeStatus);
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(zipcode)).click();
        zipcode.sendKeys("88305");

        System.out.println("Zipcode entered successfully");


        WebElement clickContinue=driver.findElement(By.id("continue"));
        boolean clickContinueStatus=clickContinue.isDisplayed();
        assertTrue(clickContinueStatus);
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(clickContinue)).click();

        System.out.println("Continue clicked successfully");


        WebElement clickFinish=driver.findElement(By.id("finish"));
        boolean clickFinishStatus=clickFinish.isDisplayed();
        assertTrue(clickFinishStatus);
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(clickFinish)).click();

        System.out.println("Finish clicked successfully");

    }
    @Test(priority = 11)
    public void verifyThankYouMessage(){
        WebElement thankYou=driver.findElement(By.className("complete-header"));
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(thankYou));
        boolean thankYouStatus=thankYou.isDisplayed();
        assertTrue(thankYouStatus);
        assertEquals(thankYou.getText(),"THANK YOU FOR YOUR ORDER");
        System.out.println("Thank you message verified");

    }
    @Test (priority = 12)
    public void logout(){
        WebElement burgerMenu= driver.findElement(By.id("react-burger-menu-btn"));
        new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(burgerMenu)).click();
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))).click();
        System.out.println("Logout verified");

    }
    @AfterClass
    public void quit() {
        driver.quit();
    }
}
