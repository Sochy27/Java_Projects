import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {
    //Import selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        //locate where the chrome driver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your chrome broswer
        driver = new ChromeDriver();
        //2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com/)
        driver.get("https://selenium-blog.herokuapp.com");
        //Test1. Verify the user input the right url and his on the right webpage
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");

        // Wait globally for full loading
        Thread.sleep(5000);
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Click on signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }


    @Test (priority = 0)
    public void positiveSignUp() throws InterruptedException {
        //Test7. Verify that user is successfully signed up when valid details are inputted.
        //5. Input your username on the username field
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).sendKeys("sochy2100");
        //6. Input an email address on the email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("sochy2100@mailinator.com");
        //7. Input your password on the password field
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("sochima");
        //8. Click on the signup button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 1)
    public void clickUser1Item() throws InterruptedException {
        //9. Click on User1 item on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //Test2. Verify that when user clicks on the signup button, the user is directed to the signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com";
        String actualUrl = driver.getCurrentUrl();
            if(actualUrl.contains(expectedUrl))
                //Pass
                System.out.println("Correct Webpage");
            else
                //Fail
                System.out.println("Wrong Webpage");

        Thread.sleep(5000);
    }
    @Test (priority = 2)
    public void verifyItem() throws InterruptedException {
        //10. Search for an item and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        //Test9. Confirm User1 pageurl
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Correct User1page");
        else
            //Fail
            System.out.println("Wrong User1page");

        Thread.sleep(5000);
    }

    @Test (priority = 3)
    public void logoutSuccessfully(){
        //11. Click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test10. Verify that when the user logout, he/she is directed back to the home page
        String expectedTitle = "AlphBlog";
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(expectedTitle))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");

    }

    @Test (priority = 4)
    public void negativeSignUp() throws InterruptedException {
        //4. Click on signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test3. Verify that user cannot signup with username less than 3 characters
        //5. Input your username on the username field
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).sendKeys("no");
        //6. Input an email address on the email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("sochy1100@mailinator.com");
        //7. Input your password on the password field
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("sochima");
        //8. Click on the signup button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 5)
    public void invalidEmail() throws InterruptedException {
        //Test4. Verify that user cannot signup with invalid email address
        //5. Input your username on the username field
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).sendKeys("sochy410");
        //6. Input an email address on the email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("sochy410mailinator.com");
        //7. Input your password on the password field
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("sochima");
        //8. Click on the signup button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }
//    @Test (priority = 6)
//    public void invalidPassword() throws InterruptedException {
//        //Test4. Verify that user cannot signup with invalid password
//        //5. Input your username on the username field
//        driver.findElement(By.id("user_username")).sendKeys("sochy090");
//        //6. Input an email address on the email field
//        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("sochy090@mailinator.com");
//        //7. Input your password on the password field
//        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("so**");
//        //8. Click on the signup button
//        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
//        Thread.sleep(5000);
//    }
//    @Test (priority = 7)
//    public void emptyFields() throws InterruptedException {
//        //Test4. Verify that user cannot signup with empty fields
//        //5. Input your username on the username field
//        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).sendKeys("");
//        //6. Input an email address on the email field
//        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("");
//        //7. Input your password on the password field
//        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("");
//        //8. Click on the signup button
//        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
//        Thread.sleep(5000);
//    }


    @AfterTest
        public void closeBrowser(){
                //12. Quit Browser
                driver.quit();

        }



}