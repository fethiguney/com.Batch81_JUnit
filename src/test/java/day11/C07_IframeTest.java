package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Before_After;

import java.util.ArrayList;
import java.util.List;

public class C07_IframeTest extends TestBase_Before_After {

    @Test
    public void test() {

        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe");

        // video'yu gorecek kadar asagi inin
        List<WebElement> iframeList=new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0));

        //videoyu izlemek icin Play tusuna basin
        WebElement video=driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
        video.click();

        //videoyu calistirdiginizi test edin


    }
}
