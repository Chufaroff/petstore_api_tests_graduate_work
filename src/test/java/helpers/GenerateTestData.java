package helpers;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateTestData {

    Faker faker = new Faker();
    String [] status = {"accepted", "closed", "urgent"};
    String [] tags = {"cat", "dog", "fish", "bird"};
    Boolean [] bool = {true, false};

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
    public String getRandomUserName() {
        return faker.pokemon().name();
    }
    public String getRandomFirstName() {
        return faker.name().firstName();
    }
    public String getRandomLastName() {
        return faker.name().lastName();
    }
    public String getRandomEmail() {
        return faker.internet().emailAddress();
    }
    public String getRandomPhoneNumber(int phoneNumberLength) {
        String phoneNumber = faker.number().digits(phoneNumberLength);
        return phoneNumber;
    }
    public int getRandomId() {
        int id = getRandomInt(1, 999);
        return id;
    }
    public String getRandomPassword() {
        String password = faker.gameOfThrones().dragon() + getRandomInt(0, 9);
        return password;
    }
    public String getRandomStatus() {
        return faker.options().option(status);
    }

    public String getRandomTag() {
        return faker.options().option(tags);
    }

    public Boolean getRandomBoolean() {
        return faker.options().option(bool);
    }
    public String getRandomDate() {
        return getRandomInt(1999, 2023)  + "-" + getRandomInt(11, 12) + "-" + getRandomInt(11, 26) +
                "T"+ getRandomInt(11, 23) + ":" + getRandomInt(11, 59) +
                ":"+ getRandomInt(11, 59) + ".0" + getRandomInt(11, 99) + "+" + "0000";
    }
}
