package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase_BeforeClass_AfterClass;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExist extends TestBase_BeforeClass_AfterClass {

    //Tests packagenin altina bir class oluşturalim : C04_FileDownload
    //Iki tane metod oluşturun : isExist( ) ve downloadTest( )
    //downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
    //https://the-internet.herokuapp.com/download adresine gidelim.
    //test.txt dosyasını indirelim
    //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test
    public void test01_isExist() {

        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//*[text()='test.txt']")).click();


    }

    @Test
    public void test02_downloadTest() {
        String filePath="C:\\Users\\user\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

    }
}
