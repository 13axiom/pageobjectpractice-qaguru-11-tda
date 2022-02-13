package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegForm {
    //something for calendar

    //locators
    SelenideElement mainHeader = $(".main-header"),
                    formName = $(".practice-form-wrapper"),
                    buttonSubmit = $("#submit"),
                    firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    emailInput = $("#userEmail"),
                    genderChoice,
                    phoneNumberInput = $("#userNumber"),
                    //calendar //todo
                    subjectInput = $("#subjectsInput"),
                    hobbyChoice,
                    uploadPictureField = $("#uploadPicture"),
                    addressInput = $("#currentAddress"),
                    stateChoice = $("#state"),
                    cityChoice = $("#city"),
                    resultHeader = $("#example-modal-sizes-title-lg"),
                    resultTable = $(".table-responsive");

    //actions

}
