package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

public class RegistrationTest extends TestBase {


    TestData testData = new TestData();

    RegistrationPage registrationPage = new RegistrationPage();

    CalendarComponent calendar = new CalendarComponent();
    CheckResultComponent checkResult = new CheckResultComponent();

    @Test
    @DisplayName("Successful fill form registration")
    void successfulFillFormTest() {
        //заполнение формы
        registrationPage.openPage()
                .deleteBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.mobile);
        String day = calendar.setRandomDate(testData.month, testData.year);
        String subject = testData.setRandomSubject(testData.symbol);
        registrationPage.setHobbies(testData.hobbies)
                .uploadPicture(testData.picture)
                .setCurrentAddress(testData.address)
                .setStateSelect(testData.state);
        String city = testData.setRandomCity();
        registrationPage.submit();

        // check
        registrationPage.checkTitle()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.mobile)
                .checkResult("Date of Birth", checkResult.addZeroWithDateWithOneChar(day) + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + city);
    }


}
