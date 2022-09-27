package day16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Before_After;

import java.io.File;
import java.io.IOException;

public class C01_GetScreenShot extends TestBase_Before_After {


    @Test
    public void test01() throws IOException {
        //Amazon sayfasina gidelim
        driver.get("https://amazon.com");

        driver.navigate().refresh();

        //Nutella aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

        //arama sonuc yazisinin resmini alalim
        WebElement searchResult=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));

        File nutellaSearchResult=searchResult.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(nutellaSearchResult, new File("target/ekrangoruntusu/WebElement.jpeg"));





    }
}
