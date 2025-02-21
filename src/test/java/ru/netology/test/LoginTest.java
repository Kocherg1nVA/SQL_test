package ru.netology.test;

import com.codeborne.selenide.Selenide;
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

    @Test
    public void shouldLogin(){
        loginPage = Selenide.open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuhInfo();
        SQLHelper.updateUsers(authInfo.getId(), authInfo.getLogin(), authInfo.getPassword());
        verificationPage = loginPage.validLogin(authInfo);
        dashboardPage = verificationPage.validVerify(authInfo);
    }
}
