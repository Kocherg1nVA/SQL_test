package ru.netology.data;

import lombok.Value;

public class DataHelper {

    public DataHelper() {}

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }
    @Value
    public static class VerificationCode {
        String verificationCode;
    }

    public static AuthInfo getUserInfo(String login, String password) {
        return new AuthInfo(login, password);
    }

    public static VerificationCode getVerificationCode(String verificationCode) {
        return new VerificationCode(verificationCode);
    }
}
