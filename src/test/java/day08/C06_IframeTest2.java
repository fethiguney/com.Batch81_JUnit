package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C06_IframeTest2 {


    /*
    1)http://demo.guru99.com/test/guru99home sitesinegidiniz
    2)sayfadaki iframe sayısını bulunuz.
    3)ilk iframe'deki (Youtube) play butonuna tıklayınız.
    4)ilk iframe'den çıkıp ana sayfaya dönünüz
    5)ikinci iframe'deki (Jmeter Made Easy) linke(https://www.guru99.com/live-selenium-project.html)
    tıklayınız
     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.guru99.com/test/guru99home");
    }

    @Test
    public void test(){
        //sayfadaki iframe sayısını bulunuz
        List<WebElement> iframeList=new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        System.out.println("Sayfadaki iframe sayisi : "+iframeList.size());

        //ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(iframeList.get(1));
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();

        //ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        //ikinci iframe'deki (Jmeter Made Easy) linke(https://www.guru99.com/live-selenium-project.html)
        //tıklayın
        driver.switchTo().frame(iframeList.get(2));
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();


    }




}
