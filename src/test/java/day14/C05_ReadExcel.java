package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {

    @Test
    public void readExcelTest01() throws IOException {

        //-Dosya yolunu bir String degiskene atayalim
        String filePath="src/resources/ulkeler.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(filePath);

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        //-sayfa 2'ye gidip satir sayisinin 6, kullanilan sutun sayisinin ise 3 oldugunu test edin
        int rowNum=workbook.getSheet("Sayfa2").getLastRowNum()+1;
        int columnNum=workbook.getSheet("Sayfa2").getRow(rowNum).getLastCellNum();

        System.out.println(rowNum);
        System.out.println(columnNum);


    }
}
