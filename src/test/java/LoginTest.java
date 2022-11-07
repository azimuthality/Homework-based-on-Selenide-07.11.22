import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;


public class LoginTest {

    private static java.lang.String baseUrl = "https://idemo.bspb.ru/";
    private SelenideElement loginInput = $(By.xpath("//input[@name='username']"));
    private SelenideElement passwordInput = $(By.xpath("//input[@name='password']"));
    private SelenideElement loginBtn = $(By.xpath("//button[@id='login-button']"));
    private  SelenideElement otpCode = $(By.xpath("//input[@id='otp-code']"));
    private SelenideElement loginOtpBtn = $(By.xpath("//button[@id='login-otp-button']"));

    @BeforeAll
    static void beforeConfig() {
        Configuration.timeout = 3000;
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void before() {
        open(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {
       loginInput.should(Condition.visible).val("demo");
       passwordInput.should(Condition.visible).val("demo");
       loginBtn.should(Condition.visible).click();
       otpCode.should(Condition.visible).val("0000");
       loginOtpBtn.should(Condition.visible).click();

       sleep(100000);
    }

    @AfterEach
    public void after(){
    }
}
