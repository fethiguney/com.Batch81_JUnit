package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownTest2 {

    /*
    1.http://zero.webappsecurity.com/ Adresinegidin
    2.Sign in butonuna basin
    3.Login kutusuna “username” yazin
    4.Password kutusuna “password.”yazin
    5.Sign in tusuna basin
    6.Pay Bills sayfasina gidin
    7.“Purchase Foreign Currency” tusuna basin
    8.“Currency” drop down menusunden Eurozone’u secin
    9.“amount” kutusuna bir sayigirin
    10.“US Dollars” in secilmedigini testedin
    11.“Selected currency” butonunusecin
    12.“Calculate Costs” butonuna basin sonra “purchase” butonunabasin
    13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontroledin
     */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com");
    }
    @Test
    public void test01(){
       // Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
    }

    @Test
    public void test02(){
        // Login kutusuna “username” yazin
        //Password kutusuna “password.”yazin
        //Sign in tusuna basin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        driver.navigate().back();
    }

    @Test
    public void test03(){
        // Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

    }

    @Test
    public void test04(){
        // “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("(//*[@class='ui-state-default ui-corner-top'])[2]")).click();
    }

    @Test
    public void test05(){
        // “Currency” drop down menusunden Eurozone’u secin
        WebElement currency=driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select option=new Select(currency);
        option.selectByVisibleText("Eurozone (euro)");

    }

    @Test
    public void test06(){
        // “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("1000");
    }

    @Test
    public void test07(){
        // “US Dollars” in secilmedigini test edin
        WebElement dollarOption=driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(dollarOption.isSelected());
    }

    @Test
    public void test08(){
        // “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
    }

    @Test
    public void test09(){
        // “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();
    }

    @Test
    public void test10(){
        // “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        WebElement message=driver.findElement(By.xpath("//*[text()='Foreign currency cash was successfully purchased.']"));
        Assert.assertTrue(message.isDisplayed());
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }


}
