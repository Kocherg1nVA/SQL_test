package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {

    private static final QueryRunner runner = new QueryRunner();

    public SQLHelper() {
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    @SneakyThrows
    public static void updateUsers(String id, String login, String password) {
        var dataSQL = "INSERT INTO users(id, login, password) VALUES (?, ?, ?);";
        try (var conn = getConnection()) {
            runner.update(conn, dataSQL, id, login, password);
        }
    }

    @SneakyThrows
    public static String getVerificationCode(String login){
        var verificationCodeSQL = "SELECT auth_codes.code, users.login FROM auth_codes, users " +
                "WHERE auth_codes.user_id = users.id AND users.login = ? ORDER BY created DESC";
        try (var conn = getConnection()) {
            return runner.query(conn, verificationCodeSQL, new ScalarHandler<>(), login);
        }
    }
}
