package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegForm;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegFormTests {

    RegForm regForm = new RegForm();

    String userName = "Vovan",
            userSurnname = "deMort'",
            userEmail = "vmort@mailinator.com",
            userGender = "Male",
            userPhone = "9005553311",
            //userBirthDay
            userSubject = "History",
            userHobby = "Reading",
            userPicUrl = "src/test/resources/img/cat_4_qaguru_11.jpeg",
            userCurrAddress = "Main street,90210",
            userState = "Uttar Pradesh",
            userCity = "Merrut";

    SelenideElement scrollToPlace = $("#currentAddress");

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillPracticeForm() {
        regForm.openPage();

        $("#firstName").setValue("Vovan");
        $("#lastName").setValue("deMort");
        $("#userEmail").setValue("vmort@mailinataror.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("1234567890");

        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").selectOption(3);
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day.react-datepicker__day--021").click();

        $("#subjectsInput").setValue("Math").pressEnter();
        sleep(3000);
        $("#subjectsInput").clear(); //todo not work
        sleep(5000);
        $(".subjects-auto-complete__value-container.subjects-auto-complete__value-container--is-multi.css-1hwfws3").click();
        $("#subjectsInput").setValue("Hi");
        $(byText("History")).click();

        $("[for=hobbies-checkbox-2]").click();
        File file = new File("./src/test/resources/img/cat_4_qaguru_11.jpeg");
        $("#uploadPicture").uploadFile(file);
        scrollToPlace.scrollIntoView(true);
        $("#currentAddress").setValue("Main street,90210");
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Merrut")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Label"),text("Values"),
                text("Student Name"),text("Vovan deMort"),
                text("Student Email"),text("vmort@mailinataror.com"),
                text("Gender"),text("Male"),
                text("Mobile"),text("1234567890"),
                text("Date of Birth"),text("21 April,1999"),
                text("Subjects"),text("History"),
                text("Hobbies"),text("Reading"),
                text("Picture"),text("cat_4_qaguru_11.jpeg"),
                text("Address"),text("Main street,90210"),
                text("State and City"),text("Uttar Pradesh Merrut"));
    }
}
