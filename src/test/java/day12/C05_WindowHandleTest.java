package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_Before_After;

import java.util.ArrayList;
import java.util.List;

public class C05_WindowHandleTest extends TestBase_Before_After {

    @Test
    public void test01() throws InterruptedException {

        //1."http://webdriveruniversity.com/"adresinegidin
        driver.get("http://webdriveruniversity.com");

        //2."Login Portal" a kadar asagiinin
       Actions actions=new Actions(driver);
       actions.sendKeys(Keys.PAGE_DOWN).perform();

       Thread.sleep(1000);
        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();

        //4.Diger window'a gecin
        List<String> windowList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        Thread.sleep(1000);
        //5."username" ve "password" kutularina deger yazdirin
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys("username");
        actions.sendKeys(Keys.TAB).sendKeys("password").
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        Thread.sleep(1000);
        //6."login" butonuna basin
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String actualMessage=driver.switchTo().alert().getText();
        String expectedMessage="validation failed";
        Assert.assertEquals(actualMessage, expectedMessage);

        Thread.sleep(1000);
        // 8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        Thread.sleep(1000);
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(windowList.get(0));

        //10.Ilk sayfaya donuldugunu testedin
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="http://webdriveruniversity.com/";
        Assert.assertTrue(actualUrl.equals(expectedUrl));



    }
}
