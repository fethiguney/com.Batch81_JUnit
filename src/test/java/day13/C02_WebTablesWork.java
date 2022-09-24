package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_Before_After;

import java.util.List;

public class C02_WebTablesWork extends TestBase_Before_After {

    @Test
    public void test01() {


        login();
        table();
        printRows();


    }

    public void printRows() {
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirList=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tablodaki satir sayisi : "+satirList.size());

        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirList.forEach(t-> System.out.println(t.getText()));

        //4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("4.satir : "+driver.findElement(By.xpath("//tbody//tr[4]")).getText());


    }

    public void table() {
        //table( ) metodu oluşturun
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        List<WebElement> sutunSayisi=driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun sayisi : "+sutunSayisi.size());
        WebElement basliklar= driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar : "+basliklar.getText());
        WebElement body=driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum body : "+body.getText());

    }

    public void login() {
        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        //Username : manager
        //Password : Manager1!

        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement userName=driver.findElement(By.xpath("//*[@id='UserName']"));
        Actions actions=new Actions(driver);
        actions.click(userName).
                sendKeys("manager").sendKeys(Keys.TAB).
                sendKeys("Manager1!").sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();


    }
}
