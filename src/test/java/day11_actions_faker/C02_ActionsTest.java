package day11_actions_faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsTest extends TestBase {

    @Test
    public void test01() {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");


        //Sayfayı istediğimiz bir miktar aşağıya doğru scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        for (int i = 0; i <5 ; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            waitForSecond(1);
        }


        //Sayfayı istediğimiz bir miktar yukarıya doğru scroll yapalım
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();


        for (int i = 0; i <5 ; i++) {
            actions.sendKeys(Keys.PAGE_UP).perform();
            waitForSecond(1);
        }

    }

        /*
        Bir sayfada otomasyon yaparken locate ettigimiz halde noSuchElementException aliyorsak
        1-Locate i tekrar kontrol ederiz buna ragmen ayni hatayi aliyorsak
        2-Wait / Synacronization / problemi olabilir, cozum olarak implicitly wait de yeterli sure bekledigimizden emin oluruz, o sureyi arttirabiliriz,
        3-Webelementin iframe icinde olup olmadigini kontrol ederiz,(alert...)
        4-Driver webelementi göremiyordur, dolayisiyla actions classi kullanarak scroll yada baska yöntemlere webelementin görünmesini saglayabiliriz

         */

    @Test
    public void test02() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Sayfanın en altına scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();//Sayfanin en altina scroll yapar

        waitForSecond(2);

        //Sayfanın en üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).perform();//sayfanin en ustune scroll yapar

    }

    @Test
    public void test03() {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Events yazısına kadar scroll yapalım
        WebElement event = driver.findElement(By.xpath("//h2[.='Events']"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(event).perform();//locatini aldigimiz webelemente kadar scroll yapar


    }

}
