package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VacanciesPage{

    WebDriver driver;

    @FindBy(id = "menu-main-1")
    WebElement mainMenu;

    public VacanciesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public VacanciesPage openVacancyWithTitle(String title){
        mainMenu.findElement(By.xpath(String.format("//li/a[text()='%s']", title))).click();
        return this;
    }

    public Paragraph selectParagraph(String paragraphName){
        return new Paragraph(driver.findElement(By.xpath(String.format("//p/strong[contains(text(), '%s')]/..", paragraphName))));
    }


    public class Paragraph{

        WebElement paragraph;

        Paragraph(WebElement paragraph){
            this.paragraph = paragraph;
        }

        public int countItems(){
            WebElement itemList = paragraph.findElement(By.xpath("//following-sibling::ul[1]"));
            return itemList.findElements(By.tagName("li")).size();
        }
    }



}
