package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void readExcelTest01() throws IOException {

        /*
        Belirtilen satirNo ve sutunNo degerlerini parametre olarak alip
        o cell'deki text'i konsola yazdiralim sonra dosyadaki metnin konsolda yazan
        aynı olup olmadigini dogrulayin
         */

        int satir=12;
        int sutun=2;

        String dosyaYolu="src/resources/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workBook= WorkbookFactory.create(fis);

        String actualData=workBook.getSheet("Sayfa1").
                          getRow(satir-1).getCell(sutun-1).toString();
        System.out.println(actualData);
        String expectedData="Baku";
        Assert.assertEquals(expectedData, actualData);






    }
}
