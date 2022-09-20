package day10;

import org.junit.Test;
import utilities.TestBase_Before_After;

public class C01_IlkTestBaseClass extends TestBase_Before_After {


    @Test
    public void test1(){
        driver.get("https://amazon.com");
    }
}
