package day11_actions_faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_ActionsTest extends TestBase {
    @Test
    public void test01() {

        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Sag ust bolumde bulunan “Account & Lists” menüsüne git  “Account” secenegine tikla
        Actions actions = new Actions(driver);
        WebElement accountLists = driver.findElement(By.cssSelector("#nav-link-accountList"));
        actions.moveToElement(accountLists).perform();

        driver.findElement(By.xpath("//span[.='Account']")).click();

        //Acilan sayfanin Title in “Your Account” oldugunu dogrula
        String expectedData ="Your Account";
        String actualData=driver.getTitle();
        Assert.assertEquals("Actual data ile Expected Data uyumlu degil",expectedData,actualData);

    }

}
