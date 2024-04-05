import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//1. Visit the URL Konga
//2. Sign in to Konga Successfully
//3. From the Categories, click on the “Computers and Accessories”
//4. Click on the Laptop SubCategory
//5. Click on the Apple MacBooks-Add an item to the cart
//6. Select Address-Continue to make payment
//7. Select a Card Payment Method
//8. Input invalid card details
//9. Print Out the error message: Invalid card number
//10. Close the iFrame that displays the input card Mode
//11. Quit the browser.


public class Konga_Test {

    //Import Selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void startBrowser() throws InterruptedException {
        //Locate Chrome Driver by path
        System.setProperty("WebDriver.chrome.driver", "resources/chromedriver.exe");
        //Open Chrome browser
        driver = new ChromeDriver();
        //1. Visit the URL "https://www.konga.com"
        //Input Konga URL
        driver.get("https://www.konga.com");
        Thread.sleep(5000);
        //Maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void signInSuccessfully() throws InterruptedException {
        //2. Sign in to Konga Successfully
        //Click on SignIn button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
        //Input Registered email/Phone number in the Email/Phone number field
        driver.findElement(By.id("username")).sendKeys("");
        Thread.sleep(5000);
        //Input Registered Password in the password field
        driver.findElement(By.id("password")).sendKeys("");
        //Click on the login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void selectCategory() throws InterruptedException {
        //3. From the Categories, Hover on the “Computers and Accessories”
        //Select Computer and Accessories Category
        WebElement elementToHover = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]"));
        // Create an instance of Actions class
        Actions actions = new Actions(driver);
        // Hover over the element
        actions.moveToElement(elementToHover).build().perform();
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void selectItem() throws InterruptedException {
        //4. Click on Laptops Subcategory
        //5. Click on the Apple MacBooks - Add an item to cart
        //Select the Apple Macbook option
        driver.findElement(By.xpath("//*[@id=\"subFixId\"]/div/div/div[1]/a[6]")).click();
        Thread.sleep(5000);
        //Select an item to buy
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[2]/div/div/div[1]/a[1]/picture/img")).click();
        Thread.sleep(5000);
        //Click on "Buy Now"
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[3]/div[1]/div[1]/div[2]/div[2]/form/div[5]/div[1]/button")).click();
        Thread.sleep(15000);
    }

    @Test (priority = 3)
    public void proceedToCheckOut() throws InterruptedException {
        //6. Select Address-Continue to make payment
        //Click on "Continue to checkout" button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[4]/div/div[6]/div/a")).click();
        Thread.sleep(15000);
        //Click on "Pay now"
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(10000);
        //Click on "Continue to Payment" button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(10000);
    }

    @Test (priority = 4)
    public void selectPaymentMethod() throws InterruptedException {
        //7. Select a Card Payment Method
        //Switch to iframe
        WebElement payment = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame("kpg-frame-component");
        Thread.sleep(10000);
        //Select card payment method
        driver.findElement(By.className("Card")).click();
        Thread.sleep(10000);
    }

    @Test (priority = 5)
    public void inputCardDetails() throws InterruptedException {
        //8. Input invalid card details
        //Input card number
        driver.findElement(By.xpath("//*[@id=\"card-number\"]")).sendKeys("5300230065003400");
        Thread.sleep(3000);
        //Input date
        driver.findElement(By.xpath("//*[@id=\"expiry\"]")).sendKeys("0324");
        Thread.sleep(3000);
        //Input CVV
        driver.findElement(By.xpath("//*[@id=\"cvv\"]")).sendKeys("640");
        Thread.sleep(3000);
        /*
        Input card pin
         driver.findElement(By.xpath("//*[@id=\"card-pin-new\"]")).sendKeys("1357");
        */
        driver.findElement(By.xpath("//*[@id=\"card-pin-new\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[7]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[10]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[3]")).click();
        Thread.sleep(3000);
        //Click on "Pay Now" button
        driver.findElement(By.xpath("//*[@id=\"validateCardForm\"]")).click();
        Thread.sleep(3000);
    }

    @Test (priority = 6)
    public void printErrorMessage() throws InterruptedException {
        //9. Print Out the error message: Invalid card number
        WebElement message = driver.findElement(By.xpath("//*[@id=\"card-number_unhappy\"]"));
        System.out.println(message.getText());
        Thread.sleep(5000);
    }

    @Test (priority = 7)
    public void exitIframe() throws InterruptedException {
        //10. Close the iFrame that displays the input card Mode
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
        Thread.sleep(5000);
        //Switch to default browser
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }

    @AfterTest
    public void quitBrowser(){
        //11. Quit your browser
        driver.quit();
    }

}