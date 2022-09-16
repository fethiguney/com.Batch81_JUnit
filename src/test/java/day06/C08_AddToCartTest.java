package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_AddToCartTest {


       /*
        1.“https://www.saucedemo.com”Adresinegidin
        2.Username kutusuna “standard_user”yazdirin
        3.Password kutusuna “secret_sauce”yazdirin
        4.Login tusunabasin
        5.Ilk urunun ismini kaydedin ve bu urunun sayfasinagidin
        6.Add to Cart butonunabasin
        7.Alisveris sepetinetiklayin
        8.Sectiginiz urunun basarili olarak sepete eklendigini controledin
        9.Sayfayikapatin
        */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.saucedemo.com");
    }
    @Test
    public void test1(){
        //Username kutusuna “standard_user”yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @Test
    public void test2(){
        //Password kutusuna “secret_sauce”yazdirin
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
    }

    @Test
    public void test3(){
        //Login tusuna basin
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void test4(){
        //Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement firstProduct=driver.findElement(By.xpath("(//*[@class='inventory_item_name'])[1]"));
        System.out.println("Ilk urun ismi : "+firstProduct.getText());
        firstProduct.click();
    }

    @Test
    public void test5(){
        //Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Test
    public void test6(){
        //Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
    }

    @Test
    public void test7(){
        //Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String expectedProductName="Sauce Labs Backpack";
        String selectedProduct=driver.findElement(By.xpath("//*[@class='inventory_item_name']")).getText();
        Assert.assertEquals(expectedProductName, selectedProduct);
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }




}

