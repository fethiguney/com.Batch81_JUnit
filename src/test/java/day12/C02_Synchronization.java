package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase_BeforeClass_AfterClass;

import java.time.Duration;

public class C02_Synchronization extends TestBase_BeforeClass_AfterClass {




    // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 4. Remove butonuna basin.
    // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
    // 6. Add buttonuna basin
    // 7. It's back mesajinin gorundugunu test edin

    @Test
    public void test01_implicitlyWait() {
       /* driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement button=driver.findElement(By.xpath("//*[@type='button']"));
        button.click();

        WebElement text=driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(text.isDisplayed());

        button.click();*/




    }

    @Test
    public void test02_explicitlyWait() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement button=driver.findElement(By.xpath("//*[@type='button']"));
        button.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement textMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(textMessage.isDisplayed());

        button.click();
        WebElement textMessage2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(textMessage2.isDisplayed());
    }
}
