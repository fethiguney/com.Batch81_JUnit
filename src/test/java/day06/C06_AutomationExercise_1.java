package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C06_AutomationExercise_1 {
    /*

    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and email address
    7. Click 'Signup' button
    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    9. Fill details: Title, Name, Email, Password, Date of birth
    10. Select checkbox 'Sign up for our newsletter!'
    11. Select checkbox 'Receive special offers from our partners!'
    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    13. Click 'Create Account button'
    14. Verify that 'ACCOUNT CREATED!' is visible
    15. Click 'Continue' button
    16. Verify that 'Logged in as username' is visible
    17. Click 'Delete Account' button
    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }

    @Test
    public void test1(){
       //Verify that home page is visible successfully
        String actualTitle=driver.getTitle();
        String expectedTitle="Automation Exercise";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void test2(){
     //Click on 'Signup / Login' button
     driver.findElement(By.xpath("//*[@href='/login']")).click();
    }

    @Test
    public void test3(){
        //Verify 'New User Signup!' is visible
        WebElement newUser=driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(newUser.isDisplayed());
    }

    @Test
    public void test4(){
        //Enter name and email address
        driver.findElement(By.xpath("//*[@type='text']")).
                sendKeys("test");
        driver.findElement(By.xpath("(//*[@type='email'])[2]")).
                sendKeys("newusertest12345@gmail.com");
    }

    @Test
    public void test5(){
        //Click 'Signup' button
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
    }

    @Test
    public void test6(){
        //Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement text=driver.findElement(By.xpath("(//*[@class='title text-center'])[1]"));
        Assert.assertTrue(text.isDisplayed());
    }

    @Test
    public void test7(){
        //Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@for='id_gender1']")).
                click();
        driver.findElement(By.xpath("//*[@id='password']")).
                sendKeys("1234");
        WebElement day=driver.findElement(By.xpath("//*[@id='days']"));
        Select optionDay=new Select(day);
        optionDay.selectByVisibleText("25");

        WebElement month=driver.findElement(By.xpath("//*[@id='months']"));
        Select optionMonth=new Select(month);
        optionMonth.selectByVisibleText("April");

        WebElement year=driver.findElement(By.xpath("//*[@id='years']"));
        Select optionYear=new Select(year);
        optionYear.selectByVisibleText("1986");

    }

    @Test
    public void test8(){
        //Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[@id='newsletter']")).click();
    }

    @Test
    public void test9(){
        //Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@id='optin']")).click();

    }

    @Test
    public void test10(){
        //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

    }

    @Test
    public void test11(){
        //Click 'Create Account button'

    }

    @Test
    public void test12(){
        //Verify that 'ACCOUNT CREATED!' is visible

    }

    @Test
    public void test13(){
        //Click 'Continue' button

    }

    @Test
    public void test14(){
        //Verify that 'Logged in as username' is visible

    }

    @Test
    public void test15(){
        //Click 'Delete Account' button
    }

    @Test
    public void test16(){
        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    }






}
