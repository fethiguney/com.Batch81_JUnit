package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_BeforeClass_AfterClass;

import java.util.List;

public class C04_GenelTekrar extends TestBase_BeforeClass_AfterClass {
    @Test
    public void test01() {
        //amazongidin
        driver.get("https://amazon.com");
        driver.navigate().refresh();

        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        List<WebElement> ddmValues=select.getOptions();
        ddmValues.stream().map(WebElement::getText).forEach(System.out::println);

        //dropdown menude 28 eleman olduğunu dogrulayın

        int ddmValueNumber=ddmValues.size();
        int expectedValueNumber=28;
        Assert.assertEquals(ddmValueNumber, expectedValueNumber);

    }

    @Test
    public void test02() {
        //1-dropdown menuden elektronik bölümü seçin
        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        ddm.sendKeys("Electronics");

        //2-arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        WebElement searchResult=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Arama sonuc yazisi : "+searchResult.getText());

        //3-sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(searchResult.getText().contains("iphone"));

        //4-ikinci ürüne relative locater kullanarak tıklayin


        //5-ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        driver.findElement(By.xpath("(//*[@class='s-image'])[6]")).click();
    }

    @Test
    public void test03() {
        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //dropdown’dan bebek bölümü secin
        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        ddm.sendKeys("Baby");

        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bebek puset", Keys.ENTER);
        WebElement searchResult=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Arama sonuc yazisi : "+searchResult.getText());

        //sonuç yazsının puset içerdiğini testedin
        Assert.assertFalse(searchResult.getText().contains("bebek puset"));

        //üçüncü ürüne relative locater kullanaraktıklayin
        //title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin Test4
        //sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarakdoğrulayın

    }






}
