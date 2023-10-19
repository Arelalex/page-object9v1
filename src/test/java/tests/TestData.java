package tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class TestData {


    Faker faker = new Faker(new Locale("en"));
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            mobile = faker.phoneNumber().subscriberNumber(10),
            month = faker.options().option("January", "February", "March",
                    "April", "May", "June", "July", "August", "September", "October",
                    "November", "December"),
            symbol = faker.options().option("A", "B", "C", "E", "I", "O", "U", "Y",
                    "D", "G", "H", "L", "M", "N", "P", "R", "S", "T", "V"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            picture = "10.jpg",
            address = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            subjectsCollection = "//div[contains(@class, 'menu-list')]/div",
            cityCollection = "//div[contains(@class, ' css-11unzgr')]/div";

    int year = faker.number().numberBetween(1900, 2010);

    SelenideElement subjectInput = $x("//*[@id='subjectsInput']"),
            citySelect = $x("//div[@class=' css-1wa3eu0-placeholder']");


    public String setRandomSubject(String symbol) {

        subjectInput.click();
        subjectInput.setValue(symbol);

        Random random = new Random();
        ElementsCollection actualSubject =
                $$x(subjectsCollection);
        int randomIndex = random.nextInt(actualSubject.size());

        String subject = actualSubject.get(randomIndex).getText();
        actualSubject.get(randomIndex).click();

        return subject;
    }

    public String setRandomCity() {

        citySelect.click();

        Random random = new Random();
        ElementsCollection actualCity =
                $$x(cityCollection);
        int randomIndex = random.nextInt(actualCity.size());

        String city = actualCity.get(randomIndex).getText();
        actualCity.get(randomIndex).click();

        return city;
    }


}
