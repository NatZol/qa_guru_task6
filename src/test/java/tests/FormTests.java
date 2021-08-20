package tests;

import com.github.javafaker.Faker;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

public class FormTests {

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Female",
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            month = "December",
            year = "1990",
            day = "15",
            subject = "Computer Science",
            hobby = "Reading",
            pathname = "src/test/resources/1.jpeg",
            picture = "1.jpeg",
            address = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setUpConfig() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    void successSubmitFormTest() {

        step("Open page and close Ad", () -> {
            registrationPage.openPage();
            registrationPage.closeAd();
        });

        step("Fill in Registration Form", () -> {
            registrationPage.typeFirstName(firstName);
            registrationPage.typeLastName(lastName);
            registrationPage.typeEmail(email);
            registrationPage.chooseGender(gender);
            registrationPage.typeUserNumber(phoneNumber);
        });

        step("Set date", () -> {
            registrationPage.chooseDateOfBirth(day, month, year);
        });

        step("Set subject", () -> {
            registrationPage.chooseSubject(subject);
        });

        step("Set hobbies", () -> {
            registrationPage.chooseHobby(hobby);
        });

        step("Upload image", () -> {
            registrationPage.upLoadPicture(pathname);
        });

        step("Set address", () -> {
            registrationPage.typeAddress(address);
            registrationPage.chooseState(state);
            registrationPage.chooseCity(city);
        });

        step("Submit form", () -> {
            registrationPage.submitForm();
        });

        step("Check results", () -> {
            registrationPage.checkRegistrationResults(firstName, lastName, email, gender, phoneNumber, day, month, year, subject, hobby, picture, address, state, city);
        });
    }
}