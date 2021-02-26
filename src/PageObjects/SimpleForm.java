package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static java.lang.Integer.parseInt;

public class SimpleForm {
    WebDriver driver;
    @FindBy(xpath = "//input[@id=\"user-message\"]")
    WebElement firstInputField;
    @FindBy(xpath = "//input[@id=\"sum1\"]")
    WebElement firstSumField;
    @FindBy(xpath = "//input[@id=\"sum2\"]")
    WebElement secondSumField;
    @FindBy(xpath = "//button[text()=\"Show Message\"]")
    WebElement showMessageButton;
    @FindBy(xpath = "//button[text()=\"Get Total\"]")
    WebElement getTotalButton;
    @FindBy(xpath = "//span[@id=\"display\"]")
    WebElement firstFormMessage;
    @FindBy(xpath = "//span[@id=\"displayvalue\"]")
    WebElement secondFormResult;

    public SimpleForm(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void FillFirstForm(String input){
        firstInputField.sendKeys(input);
    }
    public void SubmitFirstForm(){
        showMessageButton.click();
    }
    public void EvaluateFirstForm(String expectedValue){
        Assert.assertEquals(firstFormMessage.getText(), expectedValue);
        secondFormResult.isDisplayed();
    }
    public void TestFirstForm(String textValue){
        FillFirstForm(textValue);
        SubmitFirstForm();
        EvaluateFirstForm(textValue);
    }

    public void FillSecondForm(String first, String second){
        firstSumField.sendKeys(first);
        secondSumField.sendKeys(second);
    }
    public void SubmitSecondForm(){
        getTotalButton.click();
    }
    public void EvaluateSecondForm(String expectedValue){
        Assert.assertEquals(secondFormResult.getText(), expectedValue);
        secondFormResult.isDisplayed();
    }
    public void TestSecondForm(String first, String second, String result){
        FillSecondForm(first, second);
        SubmitSecondForm();
        EvaluateSecondForm(result);
    }
    public void TestSecondForm(String first, String second){
        FillSecondForm(first, second);
        SubmitSecondForm();
        EvaluateSecondForm(String.valueOf(parseInt(first)+parseInt(second)));
    }



}
