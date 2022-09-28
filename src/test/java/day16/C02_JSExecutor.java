package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase_Before_After;

import java.time.Duration;

public class C02_JSExecutor extends TestBase_Before_After {


    @Test
    public void test() {

        //Amazona gidelim
        driver.get("https://amazon.com");

        driver.navigate().refresh();

        //Asagidaki careers butonunu goruncuye kadar js ile scroll down yapalim
        WebElement careers=driver.findElement(By.xpath("//*[text()='Careers']"));

        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", careers);


        //Careers butonuna js ile click yapalim
        jse.executeScript("arguments[0].click();", careers);




    }
}
