package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_Before_After;

import java.util.List;

public class C03_WebTables extends TestBase_Before_After {

    @Test
    public void test01() {
        //Login () methodunu kullanarak sayfaya giris yapalım
        login();

        //input olarak verilen satir sayisi ve sutun sayisina sahip
        //cell'deki text'i yazdiralim
        int satir=3;
        int sutun=4;
        WebElement cell=driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println("Istenilen sutun ve satirdaki text : "+cell.getText());
        //price basligindaki tum numaraları yazdirin
        List<WebElement> priceColumn=driver.findElements(By.xpath("//tbody//td[6]"));
        for (WebElement w: priceColumn) {
            System.out.println(w.getText());
        }

    }

    public void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement userName=driver.findElement(By.xpath("//*[@id='UserName']"));
        Actions actions=new Actions(driver);
        actions.click(userName).
                sendKeys("manager").sendKeys(Keys.TAB).
                sendKeys("Manager1!").sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();



    }
}
