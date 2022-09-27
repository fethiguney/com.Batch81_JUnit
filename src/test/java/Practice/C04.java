package Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Before_After;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C04 extends TestBase_Before_After {


    @Test
    public void test() {
        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
         driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis");

        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement iframe=driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // tüm hayvan emojilerine tıklayın
        List<WebElement> animalEmojies=driver.findElements(By.xpath("//*[@class='mdl-tabs__panel is-active']//img"));
        animalEmojies.forEach(WebElement::click);
        driver.switchTo().defaultContent();

        // formu doldurun (dilediğinizi yazabilirsiniz)
        List<WebElement> textBoxes=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        List<String> text=new ArrayList<>(Arrays.asList("Bu","liste","text","doldurmak","icin","hazirlandi","ve","metin","haline","getirildi","input"));

        for (int i = 0; i <textBoxes.size() ; i++) {
            textBoxes.get(i).sendKeys(text.get(i));
        }

        // apply butonuna tıklayın
        driver.findElement(By.xpath("//button[@id='send']")).click();



    }

}
