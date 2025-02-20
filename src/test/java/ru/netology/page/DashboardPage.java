package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private static SelenideElement header = $("[data-test-id='dashboard']");

    public DashboardPage() {
        header.shouldBe(Condition.visible);
    }
}
