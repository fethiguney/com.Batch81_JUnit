package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_Before_After;

import java.util.ArrayList;
import java.util.List;

public class C06_MouseActionsTest3 extends TestBase_Before_After {
    /*
    1https://www.amazon.com/adresinegidelim
    2Sag ust bolumde bulunan “Account & Lists” menusunun acilmasiicin
    mouse’u bu menunun ustunegetirelim
    3“Create a list” butonunabasalim
    4Acilan sayfada “Your Lists” yazisi oldugunu test edelim
     */

    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();

        //Sag ust bolumde bulunan “Account & Lists” menusunun acilmasiicin
        //    mouse’u bu menunun ustune getirelim
        WebElement element=driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();

        //“Create a list” butonuna basalim
        driver.findElement(By.xpath("//*[@class='nav-text']")).click();

        //Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        String actualText=driver.findElement(By.xpath("//*[@role='heading']")).getText();
        String expectedText="Your Lists";
        Assert.assertEquals(expectedText, actualText);



    }

}
