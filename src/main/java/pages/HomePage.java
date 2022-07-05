package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage{

    WebDriver driver;

    @FindBy(xpath = "//img[@alt='ctco icon']")
    WebElement logo;

    public HomePage(final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        checkLoad();
    }

    public NavigationBar navigationBar(){
        return new NavigationBar(this.driver);
    }

    private void checkLoad(){
        new WebDriverWait(this.driver, 10).until(ExpectedConditions.visibilityOf(logo));
    }
}
