package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    //SelenideElements
    CalendarComponent calendar = new CalendarComponent();
    CheckResultComponent results = new CheckResultComponent();
    String stateAndCity = "//*[text()='%s']";
    String gender = "//label[text()='%s']";
    String hobbies = "//label[text()='%s']";


    SelenideElement titleLabel = $x("//*[contains(text(),'Student Registration Form')]"),
            firstNameInput = $x("//input[@id='firstName']"),
            lastNameInput = $x("//input[@id='lastName']"),
            userEmailInput = $x("//*[@id='userEmail']"),
            userNumberInput = $x("//*[@id='userNumber']"),
           // subjectInput = $x("//*[@id='subjectsInput']"),
            uploadPicture = $x("//input[@id='uploadPicture']"),
            currentAddressTextarea = $x("//textarea[@id='currentAddress']"),
            stateSelect = $x("//*[@id='state']"),
          //  citySelect = $x("//div[@class=' css-1wa3eu0-placeholder']"),
            submitButton = $x("//button[@id='submit']");


    //Actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        titleLabel.shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage deleteBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        $x(String.format(gender, value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

   /* public String setRandomSubject(String symbol) {

        subjectInput.click();
        subjectInput.setValue(symbol);

        Random random = new Random();
        ElementsCollection actualSubject =
                $$x(subjectsCollection);
        int randomIndex = random.nextInt(actualSubject.size());

        String subject = actualSubject.get(randomIndex).getText();
        actualSubject.get(randomIndex).click();

        return subject;
    }*/

    public RegistrationPage setHobbies(String value) {
        $x(String.format(hobbies, value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressTextarea.setValue(value);

        return this;
    }

    public RegistrationPage setStateSelect(String value) {
        stateSelect.click();
        $x(String.format(stateAndCity, value)).click();

        return this;
    }

   /* public String setRandomCity() {

        citySelect.click();

        Random random = new Random();
        ElementsCollection actualCity =
                $$x(cityCollection);
        int randomIndex = random.nextInt(actualCity.size());

        String city = actualCity.get(randomIndex).getText();
        actualCity.get(randomIndex).click();

        return city;
    }*/

    public RegistrationPage submit() {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkTitle() {
        results.checkLabel("Thanks for submitting the form");

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        results.checkData(key, value);

        return this;
    }


}