package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {

    @Test
    public void readExcelTest01() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);

        //-WorkbookFactory.create(fileInputStream
        //-Turkce baskentler sutununu yazdiralim
        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatir);
        String turceBaskentler="";
        for (int i = 0; i <=sonSatir ; i++) {
            turceBaskentler=workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(turceBaskentler);
        }

        /*
        List<String> list=new ArrayList<>();
        for (int i = 0; i <=sonsatir ; i++) {
         list.add(workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString());
          }
        list.forEach(t-> System.out.println(t));
         */




    }
}
