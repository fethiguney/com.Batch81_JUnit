package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_GoogleSearchTest {
    /*
    1-C01_TekrarTestiisimlibirclassolusturun
    2-https://www.google.com/adresinegidin
    3-cookiesuyarisinikabulederekkapatin
    4Sayfabasliginin“Google”ifadesiicerdiginitestedin
    5Aramacubuguna“Nutella”yaziparatin
    6Bulunansonucsayisiniyazdirin
    7sonucsayisinin10milyon’danfazlaoldugunutestedin
    8Sayfayikapatin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://google.com");
    }

    @Test
    public void test1(){
        Assert.assertTrue(driver.getTitle().contains("Google"));
    }

    @Test
    public void test2(){
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Nutella"+ Keys.ENTER);

    }
    @Test
    public void test3(){
        String [] result=driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println("Bulunan sonuc sayisi : "+result[1]);
    }

    @Test
    public void test4(){
    //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String [] result=driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        String resultNumber=result[1].replaceAll("\\D", "");
        int numberOfResult=Integer.valueOf(resultNumber);
        int comparingNumber=10000000;
        Assert.assertTrue(numberOfResult>comparingNumber);
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }



}
