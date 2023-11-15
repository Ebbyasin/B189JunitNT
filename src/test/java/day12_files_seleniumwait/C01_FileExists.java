package day12_files_seleniumwait;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExists {

    /*
    Bilgisayarimizdaki herhangi bir dosyanin varligini test edebilmemiz icin;
        1-Oncelikle varligini test etmek istedigimiz dosyanin yolunu almaliyiz
        2-Aldigimiz dosya yolunu Files.exists(Paths.get(dynamicPath)); kodu ile dosyanin varligini test edebiliryz

        ==>Ortak calismalarda bir server uzerinden bir dosya yolu almak istersek her kullanicinin bilgisayarinin ana yolu farkli olabilir
        Ama projedeki dosyanin yeri belli oldugu icin buradaki yol herkeste ortaktir
        Dolayisiyla System.getProperty("user.home") methodu ile bilgisayarimizin ana yolunu alabilir ve projedeki ortak yol ile
        birlestirerek dynamic ve herkes icin calisan bir forma donusturebiliz

     */

    @Test
    public void test01() {

        // System.getProperty("user.dir") komutu java da programin calistigi dizini verir
        //current working directory

        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));

        //System.getProperty("user.home"); kullanici ana yolunu alir ve string olarak return eder
        //Bu yol her kullanici icin farklidir
        //Ornegin eger kullanici adi mehmet ise bu yol ==> C:\Users\mehmet seklinde olacaktir

        String userHome = System.getProperty("user.home");
        System.out.println("userHome = " + userHome);

        //Bilgisayaramizda masaustunde olusturdugumuz dosyanini varligini doğrulayalim

        //C:\Users\mua\Desktop\Batch189.txt

        String ortakYol="C:\\Users\\pc\\IdeaProjects\\B189SeleniumJunitNT";

        //bu satirla biz tum bilgisayarlarda caliscak ortak bir dosya yolunu dynamic olarak olusturduk
        String dynamicPath = userHome + ortakYol;

        boolean isExist = Files.exists(Paths.get(dynamicPath));
        Assert.assertTrue(isExist);

    }
}
