package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_WebappSecurityTest {
    /*
    1.http://zero.webappsecurity.com sayfasinagidin
    2.Signin buttonunatiklayin
    3.Login alanine “username”yazdirin
    4.Password alanine “password”yazdirin
    5.Sign in buttonuna tiklayin
    6.Pay Bills sayfasina gidin
    7.amount kismina yatirmak istediginiz herhangi bir miktariyazin
    8.tarih kismina “2020-09-10”yazdirin
    9.Pay buttonunatiklayin
    10.“The payment was successfully submitted.” mesajinin ciktigini controledin
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void method1() {
        driver.navigate().to("http://zero.webappsecurity.com");
        //Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        //Login alanina “username”yazdirin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
        //Password alanina “password” yazdirin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
        //Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.navigate().back();
        //Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        //amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("1000");

        //tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020-09-10");

        //Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        //“The payment was successfully submitted.” mesajinin ciktigini controledin
        WebElement message=driver.findElement(By.xpath("//*[@id='alert_content']"));
        String expectedMessage="The payment was successfully submitted.";
        if (message.getText().equals(expectedMessage)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

    }


    @After
    public void tearDown() {
        driver.close();
    }



}
