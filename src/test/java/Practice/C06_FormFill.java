package Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase_Before_After;

import java.time.Duration;

public class C06_FormFill extends TestBase_Before_After {


    @Test
    public void name() {

        // ...Exercise3...
        // go to url : https://www.techlistic.com/p/selenium-practice-form.html
       driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        //fill the firstname
        driver.findElement(By.xpath("//*[@name='firstname']")).
                sendKeys("user");

        //fill the lastname
        driver.findElement(By.xpath("//*[@name='lastname']")).
                sendKeys("test");

        //check the gender
        driver.findElement(By.xpath("//*[@id='sex-0']")).
                click();

        //check the experience
        driver.findElement(By.xpath("//*[@id='exp-2']")).
                click();

        //fill the date
        driver.findElement(By.xpath("//*[@id='datepicker']")).
                sendKeys("2022/09/28");

        //choose your profession -> Automation Tester
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement profession=driver.findElement(By.xpath("//*[@id='profession-1']"));
        wait.until(ExpectedConditions.elementToBeClickable(profession));
        profession.click();

        //choose your tool -> Selenium Webdriver
        driver.findElement(By.xpath("//*[@id='tool-2']")).click();

        //choose your continent -> Antartica
        driver.findElement(By.xpath("//*[@id='continents']")).
                sendKeys("Antartica");

        //choose your command  -> Browser Commands
        driver.findElement(By.xpath("//*[@id='selenium_commands']")).
                sendKeys("Browser Commands");

        //click submit button
        driver.findElement(By.xpath("//*[@id='submit']")).click();



    }
}
