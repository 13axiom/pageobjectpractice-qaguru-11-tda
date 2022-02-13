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
    public RegForm openPage() {
        open("/automation-practice-form");
        mainHeader.shouldHave(text("Practice Form"));
        formName.shouldHave(text("Student Registration Form"));
        buttonSubmit.shouldHave(text("Submit"));
        return this;
    }

    public RegForm setFirstName (String firstName) {
        firstNameInput.setValue("Vovan");
        return this;
    }

    public RegForm setLastName (String lastName) {
        lastNameInput.setValue("deMort'");
        return this;
    }

    public RegForm setEmail (String email) {
        emailInput.setValue("vmort@mailinator.com");
        return this;
    }

}
