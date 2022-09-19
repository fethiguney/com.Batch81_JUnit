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
    public void test01(){
       //Verify that home page is visible successfully
        String actualTitle=driver.getTitle();
        String expectedTitle="Automation Exercise";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void test02(){
     //Click on 'Signup / Login' button
     driver.findElement(By.xpath("//*[@href='/login']")).click();
    }

    @Test
    public void test03(){
        //Verify 'New User Signup!' is visible
        WebElement newUser=driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(newUser.isDisplayed());
    }

    @Test
    public void test04(){
        //Enter name and email address
        driver.findElement(By.xpath("//*[@type='text']")).
                sendKeys("username");
        driver.findElement(By.xpath("(//*[@type='email'])[2]")).
                sendKeys("newusertest1234567@gmail.com");
    }

    @Test
    public void test05(){
        //Click 'Signup' button
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
    }

    @Test
    public void test06(){
        //Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement text=driver.findElement(By.xpath("(//*[@class='title text-center'])[1]"));
        Assert.assertTrue(text.isDisplayed());
    }

    @Test
    public void test07(){
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
    public void test08(){
        //Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[@id='newsletter']")).click();
    }

    @Test
    public void test09(){
        //Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@id='optin']")).click();

    }

    @Test
    public void test10(){
        //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("username");
        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("surname");
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("Address");
        driver.findElement(By.xpath("//*[@id='country']")).sendKeys("Canada");
        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("Ontario");
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Toronto");
        driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys("00000");
        driver.findElement(By.xpath("//*[@id='mobile_number']")).sendKeys("+10000000");

    }

    @Test
    public void test11(){
        //Click 'Create Account button'
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();

    }

    @Test
    public void test12(){
        //Verify that 'ACCOUNT CREATED!' is visible
        WebElement message=driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(message.isDisplayed());

    }

    @Test
    public void test13(){
        //Click 'Continue' button
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();

    }

    @Test
    public void test14(){
        //Verify that 'Logged in as username' is visible
        WebElement log=driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(log.isDisplayed());
    }

    @Test
    public void test15(){
        //Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@class='fa fa-trash-o']")).click();

    }

    @Test
    public void test16(){
        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    }






}
