package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    @FindBy(xpath="//a[text()=\"Input Forms\"]")
    WebElement inputFormsLink;
    @FindBy(xpath="//li[@class=\"tree-branch\"]//a[text()=\"Simple Form Demo\"]")
    WebElement simpleFormDemoLink;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void OpenInputFormsMenu(){
        inputFormsLink.click();
    }

    public void OpenSimpleFormDemoPage(){
        OpenInputFormsMenu();
        simpleFormDemoLink.click();
    }

}
