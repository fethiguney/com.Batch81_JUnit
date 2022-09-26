package guru99Test;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Before_After;

public class T01_LoginTest extends TestBase_Before_After {

    @Test
    public void loginTest() {

        //User ID :	mngr442980
        //Password :pegYdAm

        driver.get("https://demo.guru99.com/V4");

        driver.findElement(By.xpath("//*[@name='uid']")).sendKeys("mngr442980");

        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("pegYdAm");

        driver.findElement(By.xpath("//*[@name='btnLogin']")).click();


    }
}
