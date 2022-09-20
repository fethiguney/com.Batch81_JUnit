package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_Before_After;

public class C05_MouseActionTest2 extends TestBase_Before_After {

    /*
    1https://demoqa.com/droppable adresinegidelim
    2“Drag me” butonunu tutup “Drop here” kutusunun ustunebirakalim
    3“Drop here” yazisi yerine “Dropped!” oldugunu testedin
     */

    @Test
    public void test(){

        driver.get("https://demoqa.com/droppable");

        WebElement dragMe=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere= driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));

        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragMe,dropHere).perform();

        //“Drop here” yazisi yerine “Dropped!” oldugunu testedin
        String actualText=driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
        String expectedText="Dropped!";
        Assert.assertEquals(expectedText, actualText);

    }

}
