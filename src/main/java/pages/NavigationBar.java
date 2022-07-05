package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NavigationBar {

    WebDriver driver;

    public NavigationBar(WebDriver driver){
        this.driver = driver;
    }

    public DropDownMenu openDropDownMenu(String name){
        WebElement dropDownMenu = driver.findElement(By.xpath(
                String.format("//ul[@class='sub-menu']/preceding-sibling::a[contains(text(),'%s')]/..", name)));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropDownMenu).perform();
        return new DropDownMenu(dropDownMenu);
    }

    public class DropDownMenu{
        WebElement dropDownMenu;
        DropDownMenu(WebElement dropDownMenu){
            this.dropDownMenu = dropDownMenu;
        }
        public void selectFromDropDownMenu(String item){
            dropDownMenu.findElement(By.xpath(String.format("//a[contains(text(),'%s')]", item))).click();
        }
    }
}
