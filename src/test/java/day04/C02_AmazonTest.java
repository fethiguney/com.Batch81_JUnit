package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AmazonTest {
    /*1-C01_TekrarTesti isimli bir class olusturun
        2- https://www.amazon.com/ adresine gidin
            3- Browseri tam sayfa yapin
    Sayfayi “refresh” yapin
    Sayfa basliginin “Spend less” ifadesi icerdigini test edin
    Gift Cards sekmesine basin
    Birthday butonuna basin
    Best Seller bolumunden ilk urunu tiklayin
         9- Gift card details’den 25 $’i secin
        10-Urun ucretinin 25$ oldugunu test edin
        10-Sayfayi kapatin
         */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.amazon.com/");

        driver.navigate().refresh();

        //Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String pageTitle=driver.getTitle();
        String expectedWord="Spend less";
        if (pageTitle.contains(expectedWord)) {
            System.out.println("Sayfa basligi \'Spend Less\' iceriyor Test PASSED");
        } else {
            System.out.println("Sayfa basligi \'Spend Less\' icermiyor Test FAILED");
        }

        //Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[text()='Gift Cards']")).click();

        //Birthday butonuna basin
        driver.findElement(By.xpath("//*[@alt='Birthday gift cards']")).click();

        //Best Sellers bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='nav-a-content'])[2]")).click();
        driver.findElement(By.xpath("(//*[@class='a-dynamic-image p13n-sc-dynamic-image p13n-product-image']) [1]")).click();

        //Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("(//*[@id='gc-mini-picker-amount-1'])[1]")).click();

        // Urun ucretinin 25$ oldugunu test edin
        WebElement price=driver.findElement(By.xpath("(//*[text()='$25.00'])[1]"));
        if (price.getText().equals("$25.00")) {
            System.out.println("Urun ucreti 25 dolar Test PASSED");
        } else {
            System.out.println("Urun ucreti 25 dolar degil Test FAILED");
        }








    }
}