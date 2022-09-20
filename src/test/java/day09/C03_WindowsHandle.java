package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C03_WindowsHandle {

    /*
    Tests package’inda yeni bir class olusturun: WindowHandle2
    https://the-internet.herokuapp.com/windows adresine gidin.
    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    Click Here butonuna basın.
    Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    Sayfadaki textin “New Window” olduğunu doğrulayın.
    Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.

     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    @Test
    public void test(){
    // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement textMessage=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(textMessage.isDisplayed());

    //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

    //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

    //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin
        List<String> windowList= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

       Assert.assertTrue(driver.getTitle().equals("New Window"));

       //Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement textNew=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(textNew.getText().equals("New Window"));

        //Bir önceki pencereye geri döndükten sonra
        // sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowList.get(0));
        Assert.assertTrue(driver.getTitle().equals("The Internet"));


        

        

    }
}
