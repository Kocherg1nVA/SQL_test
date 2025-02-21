package ru.netology.test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationPage;

public class LoginTest {
    LoginPage loginPage;
    VerificationPage verificationPage;
    DashboardPage dashboardPage;

    @AfterAll
    static void down() {
        SQLHelper.cleanDataBase();
    }

    @Test
    public void shouldSuccessLogin() {
        loginPage = Selenide.open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfoForTestData();
        verificationPage = loginPage.validLogin(authInfo);
        dashboardPage = verificationPage.validVerify(authInfo);
    }
}
