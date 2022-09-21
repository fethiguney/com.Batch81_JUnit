package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeClass_AfterClass;

public class C01_ActionsKeyBoard extends TestBase_BeforeClass_AfterClass {

    @Test
    public void test01() {

        //https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();

        //Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin
        // ve Enter’a basarak arama  yaptirin
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);
        actions.click(searchBox).
                sendKeys("s").
                sendKeys("a").
                sendKeys("m").
                sendKeys("s").
                sendKeys("u").
                sendKeys("n").
                sendKeys("g").
                sendKeys(" ").keyDown(Keys.SHIFT).
                sendKeys("a").keyUp(Keys.SHIFT).
                sendKeys("7").
                sendKeys("1").sendKeys(Keys.ENTER).
                perform();

        //aramanin gerceklestigini test edin
        WebElement searchResult=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(searchResult.getText().contains("samsung A71"));


    }
}
