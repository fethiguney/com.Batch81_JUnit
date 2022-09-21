package day11;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeClass_AfterClass;

public class C03_Faker extends TestBase_BeforeClass_AfterClass {


    @Test
    public void test01() {
        //"https://facebook.com"  Adresine gidin
        //“create new account”  butonuna basin
        //“firstName” giris kutusuna bir isim yazin
        //“surname” giris kutusuna bir soyisim yazin
        //“email” giris kutusuna bir email yazin
        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
        //Kaydol butonuna basın
        //Sayfayi kapatin

        driver.get("https://www.facebook.com");

        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        WebElement firstName=driver.findElement(By.xpath("//*[@name='firstname']"));
        Faker faker=new Faker();
        Actions actions=new Actions(driver);
        String fakerEmail=faker.internet().emailAddress();
        actions.click(firstName).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(fakerEmail).
                sendKeys(Keys.TAB).sendKeys(fakerEmail).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).sendKeys("01").
                sendKeys(Keys.TAB).sendKeys("Oca").
                sendKeys(Keys.TAB).sendKeys("2000").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();


    }
}
