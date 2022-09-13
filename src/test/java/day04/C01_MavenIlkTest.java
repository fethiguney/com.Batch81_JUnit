package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C01_MavenIlkTest {
    /*
       1- https://www.amazon.com/ sayfasina gidelim
       2- arama kutusunu locate edelim
       3- “Samsung headphones” ile arama yapalim
       4- Bulunan sonuc sayisini yazdiralim
       5- Ilk urunu tiklayalim
       6- Sayfadaki tum basliklari yazdiralim
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com");

        //arama kutusunu locate edelim
        //“Samsung headphones” ile arama yapalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung headphones"+ Keys.ENTER);

        //Bulunan sonuc sayisini yazdiralim
       WebElement searchResult= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(searchResult.getText());

        //Sadece sonuc sayisini yazdiralim
        System.out.println("Sonuc sayisi :");
        String [] textOfResult=searchResult.getText().split(" ");
        Arrays.stream(textOfResult).limit(3).skip(2).forEach(System.out::println);

        //Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        //Sayfadaki tum basliklari yazdiralim
        System.out.println("Sayfadaki h1 basliklar :");
       List<WebElement> headers= driver.findElements(By.xpath("//h1"));
       headers.stream().map(WebElement::getText).forEach(System.out::println);

       driver.close();



    }


}
