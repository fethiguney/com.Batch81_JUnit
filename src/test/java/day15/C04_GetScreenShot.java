package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase_Before_After;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenShot extends TestBase_Before_After {

    @Test
    public void test01() throws IOException {
        //Amazon sayfasinin tum resmini alalim

        driver.get("https://amazon.com");

        TakesScreenshot ts= (TakesScreenshot) driver;

        File tumSayfaResmi=ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(tumSayfaResmi, new File("target/ekrangoruntusu/"+tarih+".jpeg"));





    }
}
