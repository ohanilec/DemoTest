package Tests;

import PageObjects.HomePage;
import PageObjects.SimpleForm;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoTest {
    static WebDriver driver = new ChromeDriver();
    static HomePage objHomePage = new HomePage(driver);
    static SimpleForm objSimpleForm = new SimpleForm(driver);

    @BeforeAll
    public static void setup(){
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/");
        objHomePage.OpenSimpleFormDemoPage();
    }

    @AfterAll
    public static void teardown(){
        driver.close();
    }

    @Test
    public void FirstForm(){
        objSimpleForm.TestFirstForm("Cucumber");
    }

    @Test
    public void SecondForm(){
        objSimpleForm.TestSecondForm("5","8");
    }

}
