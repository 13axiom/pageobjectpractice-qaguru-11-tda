package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegForm {
    //components
    CalendarComponent calendarComponent = new CalendarComponent();

    //locators
    SelenideElement mainHeader = $(".main-header"),
            formName = $(".practice-form-wrapper"),
            buttonSubmit = $("#submit"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderMale = $("[for=gender-radio-1]"),
            genderFemale = $("[for=gender-radio-2]"),
            genderOther = $("[for=gender-radio-3]"),
            phoneNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbyReading = $("[for=hobbies-checkbox-2]"),
            hobbySports = $("[for=hobbies-checkbox-1]"),
            hobbyMusic = $("[for=hobbies-checkbox-3]"),
            uploadPictureField = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateChoice = $("#state"),
            cityChoice = $("#city"),
            resultTable = $(".table-responsive");

    //actions
    public RegForm openPage() {
        open("/automation-practice-form");
        mainHeader.shouldHave(text("Practice Form"));
        formName.shouldHave(text("Student Registration Form"));
        buttonSubmit.shouldHave(text("Submit"));
        return this;
    }

    public RegForm setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegForm setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegForm setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegForm chooseGender(String gender) {
        if (gender == "Male") {
            genderMale.click();
        } else {
            if (gender == "Female") {
                genderFemale.click();
            } else {
                genderOther.click();
            }
        }
        return this;
    }

    public RegForm setPhone(String phone) {
        phoneNumberInput.setValue(phone);
        return this;
    }

    public RegForm setBirthDate(int day, String month, String year) {
        $(".react-datepicker__input-container").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegForm setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegForm chooseHobby(String hobby) {
        if (hobby == "Sports") {
            hobbySports.click();
        } else {
            if (hobby == "Reading") {
                hobbyReading.click();
            } else {
                hobbyMusic.click();
            }
        }
        return this;
    }

    public RegForm uploadPicture(String pictureUrl) {
        File file = new File(pictureUrl);
        uploadPictureField.uploadFile(file);
        return this;
    }

    public RegForm setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegForm chooseState(String state) {
        stateChoice.click();
        $(byText(state)).click();
        return this;
    }

    public RegForm chooseCity(String city) {
        cityChoice.click();
        $(byText(city)).click();
        return this;
    }

    public RegForm clickButton(String button) {
        if (button == "Submit") {
            buttonSubmit.click();
        }
        return this;
    }

    public RegForm checkResult(String fieldName, String value) {
                resultTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }
}
