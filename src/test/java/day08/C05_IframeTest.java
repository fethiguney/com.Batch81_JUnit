package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_IframeTest {


    /*
    ●https://the-internet.herokuapp.com/iframe adresinegidin.
    ●Bir metod olusturun:iframeTest
    ○“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda
    yazdirin.
    ○Text Box’a “Merhaba Dunya!”yazin.
    ○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsoldayazdirin
     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void test() {
        //“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda
        //    yazdirin

        WebElement text=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text.isEnabled());
        System.out.println(text.getText());

        //Text Box’a “Merhaba Dunya!”yazin.
        WebElement textBoxIFrame=driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(textBoxIFrame);

        WebElement textBox=driver.findElement(By.xpath("//*[@id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");

        //TextBox’in altinda bulunan “Elemental Selenium” linkini
        // textinin gorunur oldugunu dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent();
        WebElement elementalLink=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalLink.isDisplayed());
        System.out.println(elementalLink.getText());

    }


}
