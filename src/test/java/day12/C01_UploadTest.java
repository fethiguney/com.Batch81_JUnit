package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeClass_AfterClass;

public class C01_UploadTest extends TestBase_BeforeClass_AfterClass {


    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement chooseFile=driver.findElement(By.xpath("//*[@id='file-upload']"));

        //Yuklemek istediginiz dosyayi secelim.
        chooseFile.sendKeys("C:\\Users\\user\\Desktop\\Yeni Metin Belgesi.txt");

        //Upload butonuna basalim.
        WebElement upload=driver.findElement(By.id("file-submit"));
        upload.click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
       WebElement text= driver.findElement(By.xpath("//*[@class='example']"));
        Assert.assertTrue(text.isDisplayed());


    }
}
