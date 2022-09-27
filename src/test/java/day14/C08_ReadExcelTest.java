package day14;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_Before_After;

import java.io.*;

public class C08_ReadExcelTest extends TestBase_Before_After {


    @Test
    public void test01() throws IOException {

        //Test Yapılacak URL adresi
        //https://www.hotelmycamp.com/admin/HotelRoomAdmin


        String dosyaYolu="src/resources/testData.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        // 1 - resources klasöründeki "testData.xlsx" dosyası, Sheet1 sayfasın üzerinde çalışılacaktır.
        // 2 - Bu Excel dökümanı Sheet1 sayfasında 2. satır, 1.sütunundaki ( A2 ) URL bilgisini bir String değişkene aktarın.
        String url=workbook.getSheet("Sheet1").getRow(1).getCell(0).toString();

        // 3 - Sayfadaki 2.satırdaki "Kullanıcı Adı" hücresindeki veriyi ( B2 ) bir Stringe aktarın.
        String userName=workbook.getSheet("Sheet1").getRow(1).getCell(1).toString();

        // 4 - Sayfadaki 2.satırdaki "Şifre" hücresindeki veriyi ( C2 ) bir Stringe aktarın.
        String password=workbook.getSheet("Sheet1").getRow(1).getCell(2).toString();

        // 5 - Excel sayfasındaki istenen URL'ye gidin.
        driver.get(url);

        // 6 - Açılan URL'de User Name ve Pasword kısmına, excel dosyasından aldığınız bilgileri girin. Giriş'e basın
        WebElement userNameBox=driver.findElement(By.xpath("//*[@id='UserName']"));
        Actions actions=new Actions(driver);
        actions.click(userNameBox).sendKeys(userName).
                sendKeys(Keys.TAB).sendKeys(password).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

         // 7 - Login olduğunuzu doğrulayın ( Mesela; LIST OF HOTELROOMS yazısı görünüyor ise Login olmuşsunuz demektir )
       WebElement login=driver.findElement(By.xpath("//*[@class='username username-hide-on-mobile']"));
       Assert.assertTrue(login.isDisplayed());

        // 8 - Login olduğunuz sayfanın ekren resmini alın ve target/screenShot klasörüne kaydedin.
        TakesScreenshot ts= (TakesScreenshot) driver;
        File tumResim=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumResim, new File("target/ekrangoruntusu/"+tarih+".jpeg"));

        // 9 - Excel sayfasında 2. Satır 4.Sütuna ( D2 ); "TEST PASSED" yazdırın.
        workbook.getSheet("Sheet1").getRow(1).createCell(3).setCellValue("TEST PASSED");

        // 10 - Excel sayfasında 2. Satır 5.Sütuna ( E2 ); ekran resminin dosya adını yazdırın.
        workbook.getSheet("Sheet1").getRow(1).createCell(4).setCellValue("target/ekrangoruntusu/"+tarih+".jpeg");

        // 11 - Üzerine veri eklediğiniz Excel dosyasını kaydedin.
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();



    }
}
