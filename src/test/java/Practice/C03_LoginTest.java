package Practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeClass_AfterClass;

public class C03_LoginTest extends TestBase_BeforeClass_AfterClass {

    @Test
    public void test01() {
        driver.get("https://www.koalaresorthotels.com");

        driver.findElement(By.xpath("(//*[@class='nav-link'])[7]")).click();


        //Log in sayfanızda oldugunuzu 4 farkli sekilde dogrulayin

        //1.yol
        String expectedText="Log in";
        String actualText=driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedText, actualText);

        //2.yol
        Assert.assertTrue(driver.getTitle().contains("Log in"));

        //3.yol
        WebElement logInElement=driver.findElement(By.xpath("//*[@class='mb-4']"));
        Assert.assertTrue(logInElement.isDisplayed());

        //4.yol
        Assert.assertTrue(driver.getCurrentUrl().contains("Logon"));








    }
}
