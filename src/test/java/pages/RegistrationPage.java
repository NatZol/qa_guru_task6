package pages;

import java.io.File;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private String pageTitle = ".practice-form-wrapper h5",
            pageUrl = "https://demoqa.com/automation-practice-form",
            adCloseIcon = "a#close-fixedban",
            firstNameInput = "#firstName",
            lastNameInput = "#lastName",
            userEmailInput = "#userEmail",
            userNumberInput = "#userNumber",
            datePicker = "#dateOfBirthInput",
            monthSelect = ".react-datepicker__month-select",
            yearSelect = ".react-datepicker__year-select",
            daySelect = ".react-datepicker__day--0",
            subjectInput = "#subjectsInput",
            hobbiesSelect = "#hobbiesWrapper",
            uploadPictureSelect = "#uploadPicture",
            addressInput = "textarea#currentAddress",
            stateInput = "#state input",
            cityInput = "#city input",
            submitButton = "#submit",
            tableTitle = "#example-modal-sizes-title-lg",
            table = ".table-responsive";

    public void openPage() {
        open(pageUrl);
        $(pageTitle).shouldHave(text("Student Registration Form"));
    }

    public void closeAd() {
        $(adCloseIcon).click();
    }

    public void typeFirstName(String firstName) {
        $(firstNameInput).val(firstName);
    }

    public void typeLastName(String lastName) {
        $(lastNameInput).val(lastName);
    }

    public void typeEmail(String email) {
        $(userEmailInput).val(email);
    }

    public void chooseGender(String gender) {
        $("input[value='" + gender + "']").parent().click();
    }

    public void typeUserNumber(String number) {
        $(userNumberInput).val(number);
    }

    public void chooseDateOfBirth(String day, String month, String year) {
        $(datePicker).click();
        $(monthSelect).selectOption(month);
        $(yearSelect).selectOption(year);
        $(daySelect + day).click();
    }

    public void chooseSubject(String subject) {
        $(subjectInput).val(subject).pressEnter();
    }

    public void chooseHobby(String hobby) {
        $(hobbiesSelect).$(byText(hobby)).click();
    }

    public void upLoadPicture(String pathname) {
        $(uploadPictureSelect).uploadFile(new File(pathname));
    }

    public void typeAddress(String address) {
        $(addressInput).setValue(address);
    }

    public void chooseState(String state) {
        $(stateInput).setValue(state).pressEnter();
    }

    public void chooseCity(String city) {
        $(cityInput).setValue(city).pressEnter();
    }

    public void submitForm() {
        $(submitButton).click();
    }

    public void checkRegistrationResults(String firstName, String lastName, String email, String gender, String phoneNumber, String day, String month, String year, String subject, String hobby, String picture, String address, String state, String city) {
        $(tableTitle).shouldHave(text("Thanks for submitting the form"));
        $(table).shouldHave(text("Label"), text("Values"));
        $(table).shouldHave(text("Student Name"), text(firstName + " " + lastName));
        $(table).shouldHave(text("Student Email"), text(email));
        $(table).shouldHave(text("Gender"), text(gender));
        $(table).shouldHave(text("Mobile"), text(phoneNumber));
        $(table).shouldHave(text("Date of Birth"), text(day + " " + month + "," + year));
        $(table).shouldHave(text("Subjects"), text(subject));
        $(table).shouldHave(text("Hobbies"), text(hobby));
        $(table).shouldHave(text("Picture"), text(picture));
        $(table).shouldHave(text("Address"), text(address));
        $(table).shouldHave(text("State and City"), text(state + " " + city));
    }
}
