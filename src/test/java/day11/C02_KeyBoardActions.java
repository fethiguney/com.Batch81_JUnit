package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeClass_AfterClass;

public class C02_KeyBoardActions extends TestBase_BeforeClass_AfterClass {

    //1- https://www.facebook.com adresine gidelim
    // 2- Yeni hesap olustur butonuna basalim
    //3- Ad, soyad, mail ve sifre kutularina deger yazalim
    // 4- Kaydol tusuna basalim


    @Test
    public void test01() {

        driver.get("https://www.facebook.com");

        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        WebElement firstName=driver.findElement(By.xpath("//*[@name='firstname']"));
        firstName.sendKeys("user");

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys("Enduser").
                sendKeys(Keys.TAB).sendKeys("user@gmail.com").
                sendKeys(Keys.TAB).sendKeys("1234").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("01").sendKeys(Keys.TAB).
                sendKeys("Oca").sendKeys(Keys.TAB).
                sendKeys("2000").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                perform();




    }
}
