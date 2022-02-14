package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegForm {
    //components
    private CalendarComponent calendarComponent = new CalendarComponent();

    //locators
    SelenideElement mainHeader = $(".main-header"),
            formName = $(".practice-form-wrapper"),
            buttonSubmit = $("#submit"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderFiled = $("#genterWrapper"),
            genderMale = $("[for=gender-radio-1]"),
            genderFemale = $("[for=gender-radio-2]"),
            genderOther = $("[for=gender-radio-3]"),
            phoneNumberInput = $("#userNumber"),
            bdayField = $(".react-datepicker__input-container"),
            subjectInput = $("#subjectsInput"),
            hobbyField = $("#hobbiesWrapper"),
            hobbyReading = $("[for=hobbies-checkbox-2]"),
            hobbySports = $("[for=hobbies-checkbox-1]"),
            hobbyMusic = $("[for=hobbies-checkbox-3]"),
            uploadPictureField = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateChoice = $("#state"),
            cityChoice = $("#city"),
            resultHeader = $("#example-modal-sizes-title-lg"),
            resultTable = $(".table-responsive"),
            buttonClose = $("#closeLargeModal");

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
        bdayField.click();
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

    public RegForm checkDesignOfResult() {
        resultHeader.shouldHave(text("Thanks for submitting the form"));
        buttonClose.should(exist);
        buttonClose.shouldHave(text("Close"));
        return this;
    }

    public RegForm checkResult(String fieldName, String value) {
        resultTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }

    public RegForm scrollToElement(String element) {
        switch (element) {
            case "Name":
                formName.scrollIntoView(true);
                break;
            case "Email":
                emailInput.scrollIntoView(true);
                break;
            case "Gender":
                genderFiled.scrollIntoView(true);
                break;
            case "Mobile":
                phoneNumberInput.scrollIntoView(true);
                break;
            case "Date of Birth":
                bdayField.scrollIntoView(true);
                break;
            case "Subjects":
                subjectInput.scrollIntoView(true);
                break;
            case "Hobbies":
                hobbyField.scrollIntoView(true);
                break;
            case "Picture":
                uploadPictureField.scrollIntoView(true);
                break;
            case "Current Address":
                addressInput.scrollIntoView(true);
                break;
            case "State and City":
                stateChoice.scrollIntoView(true);
                break;
            case "Submit":
                buttonSubmit.scrollIntoView(true);
                break;
            default:
                break;
        }
        return this;
    }
}
