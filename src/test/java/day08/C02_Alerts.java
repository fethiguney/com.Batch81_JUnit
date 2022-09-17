package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
    /*
    Bir class olusturun: Alerts
    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın
    ve result mesajının  “You successfully clicked an alert”
    oldugunu test edin.
    Bir metod olusturun: dismissAlert
    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin.
    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void acceptAlert() throws InterruptedException {
        /*
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın
    ve result mesajının  “You successfully clicked an alert”
    oldugunu test edin.
         */
    driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
    Thread.sleep(2000);
    driver.switchTo().alert().accept();
    WebElement message=driver.findElement(By.xpath("//*[@id='result']"));
        System.out.println("Birinci mesaj : "+message.getText());
        Assert.assertTrue(message.isDisplayed());
    }

    @Test
    public void dismissAlert() throws InterruptedException {
    /*
     2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın
     ve result mesajının
     “successfuly” icermedigini test edin.
     */

        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        WebElement message2=driver.findElement(By.xpath("//*[@id='result']"));
        System.out.println("Ikinci mesaj : "+message2.getText());
        Assert.assertFalse(message2.getText().contains("successfully"));

    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        /*
        Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    OK butonuna  tıklayın ve result mesajında
    isminizin görüntülendiğini doğrulayın.
         */
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Fethi");
        driver.switchTo().alert().accept();
        WebElement message3=driver.findElement(By.xpath("//*[@id='result']"));
        System.out.println("Ucuncu mesaj : "+message3.getText());
        Assert.assertTrue(message3.getText().contains("Fethi"));

    }


}
