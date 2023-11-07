package day07_assertion_dropdown_testbase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_Dropdown {
    /*
    DROPDOW

    Dropdown u automate etmek icin
    1- Dropdown menuyu ilk olarak locate ederiz
    2- Select objesi olusturulur
    3- Select objesi uzerinden cesitli methodlar sayesinde dropdown seceneklerine erisim saglariz

        SYNTAX
        Select select = new Select(Dropdown web elementi);

       Select objecti uzerinden dropdown menuyu handle edebileceğimiz 3 tane method vardir
       a- selectByVisibleText() ->dropdown menudeki elemente gorunur metin ile ulasmak icin kullanilir
       b- selectByIndex() -> Index ile ulasmak icin kullanilir (index 0 (sifir) dan baslar)
       c- selectByValue() -> value attribute degeri ile ulasmak icin kullanilir (option tagi ile baslar)

    4- getOptions() -> Locate ettigimiz dropdown menu deki tum secenekleri bize verir
    5- getFirstSelectedOption() -> Dropdown menudeki secili olan seceneği bize verir

     */
    /*
   Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
   -3 farklı test methodu oluşturalım
       1.Method:
           a. Yil,ay,gün dropdown menu'leri locate ediniz
           b. Select objesi olustur
           c. Select object i kullaarak 3 farkli sekilde secim yapiniz
       2.Method:
           a. Tüm eyalet isimlerini yazdıralım
       3.Method:
           a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

    */
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

    @Test
    public void test01() {


        // 1.Method:
        //           a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil = driver.findElement(By.xpath("//select[@id='year']"));
        WebElement ay = driver.findElement(By.xpath("//select[@id='month']"));
        WebElement gun = driver.findElement(By.xpath("//select[@id='day']"));

        //           b. Select objesi olustur
        Select selectYil = new Select(yil);
        Select selectAy = new Select(ay);
        Select selectGun = new Select(gun);

        //           c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        selectYil.selectByIndex(3);
        selectAy.selectByValue("3");
        selectGun.selectByVisibleText("3");

    }

    @Test
    public void test02() {
        // a. Tüm eyalet isimlerini yazdıralım
        WebElement eyaletler =  driver.findElement(By.xpath("//select[@id='state']"));
        Select select = new Select(eyaletler);
        List<WebElement> eyaletlerListesi =  select.getOptions();

        //1 yol
//        for ( WebElement w: eyaletlerListesi  ) {
//            System.out.println( w.getText());
//        }

        //2 yol
        eyaletlerListesi.forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void test03() {
        //  a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement eyaletler =  driver.findElement(By.xpath("//select[@id='state']"));
        Select select = new Select(eyaletler);

        String expectedOption ="Select a State";
        String actuaOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actuaOption);

    }

    @Test
    public void test04() {
        //genellikle dropdown webelementine sendkeys methodu sayesinde herhangi bir seceneği pratik olarak gonderebilirz
        WebElement eyaletler =  driver.findElement(By.xpath("//select[@id='state']"));
        eyaletler.sendKeys("Alaska");

    }

    @Test
    public void test05() {
        //x path in gücü ile locatini aldigimiz dropdown un tum seceneklerini bir liste koyduk daha sonrada yazdirdik
        List<WebElement> eyaletlerListesi =   driver.findElements(By.xpath("//select[@id='state']/option"));
        eyaletlerListesi.forEach(t-> System.out.println(t.getText()));

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(4000);
        driver.close();
    }
}
