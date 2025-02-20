package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static SelenideElement loginField = $("[data-test-id='login'] .input__control");
    private static SelenideElement passwordField = $("[data-test-id='password'] .input__control");
    private static SelenideElement continueButton = $("[data-test-id='action-login'].button");

    public VerificationPage validLogin(DataHelper.AuthInfo authInfo) {
        loginField.setValue(authInfo.getLogin());
        passwordField.setValue(authInfo.getPassword());
        continueButton.click();
        return new VerificationPage();

    }

}
