package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegForm;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class RegFormTests {

    RegForm regForm = new RegForm();

    String userName = "Vovan",
            userSurnname = "deMort'",
            userEmail = "vmort@mailinator.com",
            userGender = "Male",
            userPhone = "9005553311",
            userBdayMonth = "September",
            userBdayYear = "1999",
            userSubject = "History",
            userHobby = "Reading",
            userPictureUrl = "./src/test/resources/img/cat_4_qaguru_11.jpeg",
            userPictureName = "cat_4_qaguru_11.jpeg",
            userCurrAddress = "Main street,90210",
            userState = "Uttar Pradesh",
            userCity = "Merrut",
            buttonSubmit = "Submit";
    int userBdayDay = 30;

    SelenideElement scrollToPlace = $("#currentAddress"),
                      resultHeader = $("#example-modal-sizes-title-lg"),
                      resultTable = $(".table-responsive");

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillPracticeForm() {
        regForm.openPage()
                .setFirstName(userName)
                .setLastName(userSurnname)
                .setEmail(userEmail)
                .chooseGender(userGender)
                .setPhone(userPhone)
                .setBirthDate(userBdayDay,userBdayMonth,userBdayYear)
                .setSubject(userSubject)
                .chooseHobby(userHobby)
                .uploadPicture(userPictureUrl);
        scrollToPlace.scrollIntoView(true);
        regForm.setAddress(userCurrAddress)
                .chooseState(userState)
                .chooseCity(userCity)
                .clickButton(buttonSubmit);

        resultHeader.shouldHave(text("Thanks for submitting the form"));
        resultTable.shouldHave(text("Label"),text("Values"));
        regForm.checkResult("Student Name",userName + " " + userSurnname)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender",userGender)
                .checkResult("Mobile",userPhone)
                .checkResult("Date of Birth",userBdayDay + " " + userBdayMonth + "," +userBdayYear)
                .checkResult("Subjects",userSubject)
                .checkResult("Hobbies",userHobby)
                .checkResult("Picture",userPictureName)
                .checkResult("Address",userCurrAddress)
                .checkResult("State and City", userState + " " + userCity);
    }
}
