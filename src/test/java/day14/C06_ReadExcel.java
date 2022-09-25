package day14;

import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.ss.formula.functions.Value;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class C06_ReadExcel {

    //Excel listesindeki tüm verileri bir variable a atalim


    @Test
    public void excelTest() throws IOException {

        String filePath="src/resources/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(filePath);
        Workbook workbook= WorkbookFactory.create(fis);

        int excelLastRow=workbook.getSheet("Sayfa1").getLastRowNum();

        Map<String,String> excelMap=new HashMap<>();

        for (int i = 0; i <=excelLastRow ; i++) {

            String key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            String value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+
                            ", "+workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+
                            ", "+workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
        excelMap.put(key,value);
        }

        Set<Map.Entry<String, String>> excelListEntrySet=excelMap.entrySet();
        for (Map.Entry w:excelListEntrySet) {
            System.out.println(w);
        }






    }
}
