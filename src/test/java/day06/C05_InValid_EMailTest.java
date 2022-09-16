package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_InValid_EMailTest {

    /*
    1.Bir Class olusturalim Yanlis Email Testi
    2.http://automationpractice.com/index.php sayfasina gidelim
    3.Sign in butonuna basalim
    4.Email kutusuna @isareti olmayan bir mail yazip enter’a
    bastigimizda “Invalid email address” uyarisi ciktigini teste delim
     */
   static WebDriver driver;
   @BeforeClass
   public static void setUp(){

       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       driver.get("http://automationpractice.com/index.php");
   }

   @Test
    public void test1(){
       //Sign in butonuna basalim
       driver.findElement(By.xpath("//*[@class='login']")).click();

   }
    @Test
    public void test2(){
        //Email kutusuna @isareti olmayan bir mail yazip enter’a
        //bastigimizda “Invalid email address” uyarisi ciktigini teste delim
        driver.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys("testgmail.com");
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
        String alertMessage=driver.findElement(By.id("create_account_error")).getText();
        System.out.println(alertMessage);



    }

   /*@AfterClass
    public static void tearDown(){
       driver.close();
   }*/




}
