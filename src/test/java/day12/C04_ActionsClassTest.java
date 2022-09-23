package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Before_After;

public class C04_ActionsClassTest extends TestBase_Before_After {

    @Test
    public void test01() {

        //1.“http://webdriveruniversity.com/IFrame/index.html”sayfasinagidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");


        //2.“Our Products” butonunabasin
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));

        driver.findElement(By.xpath("//*[text()='Our Products']")).click();

        //3.“Cameras product”i tiklayin
        driver.findElement(By.xpath("(//*[@class='sub-heading'])[2]")).click();

        //4.Popup mesajini yazdirin

        System.out.println(driver.findElement(By.xpath("//h4")).getText());

        //5.“close” butonunabasin
        driver.findElement(By.xpath("//*[text()='Close']")).click();

        driver.switchTo().defaultContent();

        //6."WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.findElement(By.xpath("//*[text()='WebdriverUniversity.com (IFrame)']")).click();


        //7."http://webdriveruniversity.com/index.html" adresine gittigini testedin
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="http://webdriveruniversity.com/index.html";
        Assert.assertEquals(expectedUrl, actualUrl);

        //Assert.assertTrue(actualUrl.equals(expectedUrl));






    }
}
