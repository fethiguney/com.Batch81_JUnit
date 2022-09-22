package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeClass_AfterClass;

public class C06_ActionsClassTest extends TestBase_BeforeClass_AfterClass {


    @Test
    public void test01() throws InterruptedException {

    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

    // 2- Hover over Me First" kutusunun ustune gelin
        WebElement element1=driver.findElement(By.xpath("//*[@class='dropbtn']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(element1).perform();



    //Link 1" e tiklayin
        driver.findElement(By.xpath("//*[@class='list-alert']")).click();



    //Popup mesajini yazdirin
        System.out.println("Pop up mesaji : "+driver.switchTo().alert().getText());

     //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();



    //"Click and hold" kutusuna basili tutun
        WebElement element2=driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(element2).perform();



    //7-"Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("Click and hold button text : "+element2.getText());



        //8- "Double click me" butonunu cift tiklayin
        WebElement element3=driver.findElement(By.xpath("//*[@id='double-click']"));
        actions.doubleClick(element3).perform();




    }
}
