package day11_actions_faker;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C05_Faker {

    @Test
    public void faker() {

        Faker faker = new Faker();

        //faker objesi ile fake bir isim yazdırınız
        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

        //faker objesi ile fake bir soyisim yazdırınız
        String lastName =faker.name().lastName();
        System.out.println("lastName = " + lastName);

        //faker objesi ile fake bir adress yazdırınız
        String fullAdress =faker.address().fullAddress();
        System.out.println("fullAdress = " + fullAdress);

        //faker objesi ile fake bir telefon No yazdırınız
        String phoneNumber =faker.phoneNumber().phoneNumber();
        System.out.println("phoneNumber = " + phoneNumber);

        //faker objesi ile fake bir email yazdırınız
        String emailAdress= faker.internet().emailAddress();
        System.out.println("emailAdress = " + emailAdress);

        //faker objesi ile fake bir rastgele 15 haneli bir sayi yazdırınız
        String number = faker.number().digits(15);
        System.out.println("number = " + number);

        //faker objesi ile fake bir isimsoyisim yazdırınız
        System.out.println(faker.name().fullName());


    }
}
