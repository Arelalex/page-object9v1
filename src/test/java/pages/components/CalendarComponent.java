package pages.components;

import com.codeborne.selenide.ElementsCollection;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {
    String actualDatesCollection = "//*[contains(@aria-label,'%d')][contains(@aria-label,'%s')]";

    public String setRandomDate(String month, int year) {

        Random random = new Random();
        ElementsCollection actualDate =
                $$x(String.format(actualDatesCollection, year, month));
        $x("//*[@id='dateOfBirthInput']").click();
        $x("//option[text()='" + month + "']").click();
        $x("//option[@value='" + year + "']").click();
        int randomIndex = random.nextInt(actualDate.size());

        String day = actualDate.get(randomIndex).getText();
        actualDate.get(randomIndex).click();

        return day;
    }
}
