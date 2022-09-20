package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_Before_After;

import java.util.ArrayList;
import java.util.List;

public class C04_MouseActionsTest extends TestBase_Before_After {

    /*
    Yeni bir class olusturalim: MouseActions1
    https://the-internet.herokuapp.com/context_menu sitesine gidelim
    Cizili alan uzerinde sag click yapalim
    Alert’te cikan yazinin “You selected a context menu” oldugunu
    test edelim.
    Tamam diyerek alert’i kapatalim
    Elemental Selenium linkine tiklayalim
    Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Cizili alan uzerinde sag click yapalim
        WebElement element=driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(element).perform();

        //Alert’te cikan yazinin “You selected a context menu” oldugunu
        // test edelim.
        String actualText=driver.switchTo().alert().getText();
        System.out.println(actualText);
        String expectedText="You selected a context menu";
        Assert.assertEquals(expectedText, actualText);

        //Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();



        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[@target='_blank']")).click();

        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        List<String> windowHandles=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));

        String actualText2=driver.findElement(By.xpath("//h1")).getText();
        System.out.println(actualText2);
        String expectedText2="Elemental Selenium";
        Assert.assertEquals(expectedText2, actualText2);


    }


}
