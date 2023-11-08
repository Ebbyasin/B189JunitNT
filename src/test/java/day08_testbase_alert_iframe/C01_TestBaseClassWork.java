package day08_testbase_alert_iframe;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_TestBaseClassWork extends TestBase {

    @Test
    public void test01() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        //        Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        //        -3 farklı test methodu oluşturalım
        //        1.Method:
        //        a. Yil,ay,gün dropdown menu'leri locate ediniz
        //        b. Select objesi olustur
        //        c. Select object i kullaarak 3 farkli sekilde secim yapiniz


        // 1.Method:
        //           a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil = driver.findElement(By.xpath("//select[@id='year']"));
        WebElement ay = driver.findElement(By.xpath("//select[@id='month']"));
        WebElement gun = driver.findElement(By.xpath("//select[@id='day']"));

        selectIndex(yil,3);
        waitForSecond(2);
        selectVisible(ay,"May");
        waitForSecond(2);
        selectVisible(gun,"5");




    }
}
