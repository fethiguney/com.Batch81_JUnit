package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClass_AfterClass {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void method1() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void method2() {
        driver.get("https://www.techproeducation.com");
    }

    @Test
    @Ignore
    public void method3() {
        driver.get("https://www.hepsiburada.com");
    }


    @AfterClass
    public static void tearDown () {
        driver.close();
    }
}

