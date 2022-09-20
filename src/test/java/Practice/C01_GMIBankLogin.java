package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GMIBankLogin {
    public static void main(String[] args) {

        //1-GMIBank https://www.gmibank.com adresine gidiniz
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.gmibank.com");

        driver.findElement(By.xpath("(//*[@class='dropdown-toggle nav-link'])[2]")).click();

        driver.findElement(By.xpath("//*[text()='Sign in']")).click();

        // 3) Username: Batch81, Password: Batch81+
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("Batch81");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Batch81+");

        driver.findElement(By.xpath("//*[@type='submit']")).click();


    }
}
