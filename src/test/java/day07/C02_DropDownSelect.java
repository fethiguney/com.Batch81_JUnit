package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownSelect {
    /*
   ●Bir class oluşturun:C3_DropDownAmazon
   ●https://www.amazon.com/ adresinegidin.
   -Test1
   Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
   oldugunu testedin
   -Test2
   1.Kategori menusunden Books seceneginisecin
   2.Arama kutusuna Java yazin vearatin
   3.Bulunan sonuc sayisiniyazdirin
   4.Sonucun Java kelimesini icerdigini testedin
*/
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test1(){
    // Arama kutusunun yanindaki kategori menusundeki kategori
    // sayisinin 45 oldugunu test edin
    WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
    Select option=new Select(ddm);
    List<WebElement> ddmList=option.getOptions();
    System.out.println(ddmList.size());
    int expectedNumber=45;
    int actualNumber=ddmList.size();

    Assert.assertNotEquals(actualNumber,expectedNumber);
    }

    @Test
    public void test2(){
    //1.Kategori menusunden Books seceneginisecin

    WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
    Select option=new Select(ddm);
    option.selectByVisibleText("Books");
    System.out.println(option.getFirstSelectedOption().getText());

     //2.Arama kutusuna Java yazin ve aratin
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);
    // 3.Bulunan sonuc sayisiniyazdirin
    WebElement result=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
    System.out.println("Sonuc yazisi : "+result.getText());
    // 4.Sonucun Java kelimesini icerdigini testedin
    String expectedWord="Java";
    String actualWord=result.getText();
    Assert.assertTrue(actualWord.contains(expectedWord));

    //Dropdown menude sectigimiz option a ulasmak istersek
      //  System.out.println(option.getFirstSelectedOption().getText());

    }

    @After
    public void tearDown(){
        driver.close();
    }




}
