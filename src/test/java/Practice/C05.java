package Practice;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C05 {


    @Test
    public void test() {

        //Verify that we have pom.xml file in our project => please try in 4 min s
        String filePath="pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

    }
}
