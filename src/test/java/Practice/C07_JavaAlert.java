package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Before_After;

public class C07_JavaAlert extends TestBase_Before_After {


    @Test
    public void test() {

    // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
    driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

    // 2. JavaScript alertin "CLICK ME!" seçeneğine tıklayın
        driver.findElement(By.xpath("//*[@id='button1']")).click();


    // 3. Açılır metni alın
        String actualMessage=driver.switchTo().alert().getText();


     // 4. Mesajın "I am an alert box!" olduğunu doğrulayın.
        String expectedMessage="I am an alert box!";
        Assert.assertEquals(expectedMessage, actualMessage);

    // 5. Açılır pencereyi kabul edin
        driver.switchTo().alert().accept();

    }
}
