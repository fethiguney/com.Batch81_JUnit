package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeClass_AfterClass;
import utilities.TestBase_Before_After;

public class C03_Actions extends TestBase_Before_After {

    @Test
    public void test1(){
        /*
        Amazon sayfasına gidelim
        Account menusunden create a list linkine tıklayalım
         */

        driver.get("https://amazon.com");

        WebElement element=driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();

    }
}
