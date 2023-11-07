package day07_assertion_dropdown_testbase;

import org.junit.Assert;
import org.junit.Test;

public class C01_Assertion {

      /*
    Assertion, bir test sirasinda beklenen(expected) ve gerceklesen(actual) sonuclar arasindaki uyumu dogrulamak icin kullanilir
    Eger beklenen sonuc, gerçeklesen sonucla uyusmuyorsa assertionError firlatir ve test basarisiz olur
    Junit'te bir assertion basarisiz oldugunda o anda calismakta olan test methodu durdurulur
    Ancak class icin de diger test methodlari bu durumdan etkilenmez ve kendi icilerindeki assertion lar basarisiz olmadigi sürece
    calismaya devam ederler
     */
    //1.assertEquals(expected , actual): Parantez icinde belirtilen iki degerin esit olup olmadigini kontrol eder ve
    //esitse test basarili olur esit degilse test basarisiz olur

    @Test
    public void test01() {
        String expectedData = "Selenium";
        String actualData = "selenium";
        Assert.assertEquals(expectedData,actualData);
    }

    //2. assertTrue(boolean): Parantez icinde belirtilen bir kosulun true olup olmadigini kontrol eder, eger parantez icindeki
    //deger true ise test basarili olur false ise test basarisiz olur

    @Test
    public void test02() {
        Assert.assertTrue("JAVA".contains("A"));//passed
    }

    //3. assertFalse(boolean): Parantez icinde belirtilen bir kosulun false olup olmadigini kontrol eder, eger parantez icindeki
    // deger false ise test basarili olur true ise test basarisiz olur

    @Test
    public void test03() {
        Assert.assertFalse("SELENIUM".contains("a"));//PASSED
        Assert.assertFalse("JAVA".contains("A"));//FAILED
    }

    //4. assertNotEquals(expected , actual) : parantez icinde belirtilen parametreler esit degilse test basarili olur
    //esit se test basarisiz olur


    @Test
    public void test04() {

        Assert.assertNotEquals("SELENIUM","JAVA");//PASSED
        Assert.assertNotEquals("SELENIUM","SELENIUM");//FAILED
    }
}
