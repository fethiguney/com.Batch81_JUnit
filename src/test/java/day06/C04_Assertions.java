package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {

    /*
     * https://www.youtube.com adresine gidin
     * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
     * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
     * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
     * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
     * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }

    @Test
    public void test1(){
        //titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle="YouTube";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);


    }

    @Test
    public void test2(){
        //imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
       WebElement logo= driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
       Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void test3(){
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox=driver.findElement(By.xpath("(//*[@id='search'])[2]"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void test4(){
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     String actualTitle=driver.getTitle();
     String unExpectedTitle="youtube";
     Assert.assertNotEquals(unExpectedTitle, actualTitle);
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }



}
