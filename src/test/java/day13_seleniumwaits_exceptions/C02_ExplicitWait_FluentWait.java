package day13_seleniumwaits_exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait_FluentWait extends TestBase {

    @Test
    public void test01() {


        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();


        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorld = driver.findElement(By.xpath("//h4[.='Hello World!']"));

        FluentWait<WebDriver> wait = new FluentWait<>(driver);

        wait.withTimeout(Duration.ofSeconds(20)).//Fluentwait in maximum beklemesi gereken süreyi belirtiriz
                pollingEvery(Duration.ofMillis(200)).//Fluentwait her 200 milisaniyede bu kosulu kontrol etmesi gerektigini belirtiriz
                withMessage("Webelement ve sureyi kontrol et").//Eger belirtilen sürede eger yine belirtilen kosul gerceklesmezse
                // buradaki hata mesaji TimeOutException ile birlikte konsolda gorunur
                        until(ExpectedConditions.visibilityOf(helloWorld));//helloworld webelementinin gorunur olup olmadigini kontrol eder

        Assert.assertEquals("Hello World!",helloWorld.getText());

    }

    @Test
    public void test02() {


        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();


        //Hello World! Yazının sitede oldugunu test et

        WebElement helloWorld = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(20)).
                pollingEvery(Duration.ofMillis(200)).
                withMessage("Webelementi ve sureyi kontrol et").
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[.='Hello World!']")));

        Assert.assertEquals("Hello World!",helloWorld.getText());

    }

}
