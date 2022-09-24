package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase_Before_After;

import java.util.Set;

public class C01_Cookies extends TestBase_Before_After {
    @Test
    public void test01() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");
        driver.navigate().refresh();

        //-tum cookie’leri listeleyin
       Set<Cookie> allcookies= driver.manage().getCookies();
       System.out.println(allcookies);

        int sayac=1;
        for (Cookie w:allcookies) {
            System.out.println(sayac+". cookie name : "+w.getName());
            System.out.println(sayac+". cookie value : "+w.getValue());
            sayac++;
        }


        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieNumber=allcookies.size();
        int comparingNumber=5;
        Assert.assertTrue(cookieNumber>comparingNumber);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        for (Cookie w:allcookies) {
            if (w.getName().equals("i18n-prefs")) {
                Assert.assertEquals("USD", w.getValue());
            }
        }

        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan
        // bir cookie  olusturun ve sayfaya ekleyin
        Cookie newCookie=new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(newCookie);

       allcookies=driver.manage().getCookies();
       sayac=1;
        for (Cookie w:allcookies) {
            System.out.println(sayac+". cookie name : "+w.getName());
            System.out.println(sayac+". cookie value : "+w.getValue());
            sayac++;
        }

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(allcookies.contains(newCookie));


        //7-ismi skin olan cookie’yi silin ve silindigini test edi
        Cookie name= driver.manage().getCookieNamed("skin");
        Assert.assertFalse(allcookies.contains("skin"));

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        allcookies=driver.manage().getCookies();
        Assert.assertTrue(allcookies.isEmpty());


    }




}
