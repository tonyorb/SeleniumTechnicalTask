import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;
import pages.VacanciesPage;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static final String BASE_URL = "https://ctco.lv/en";
    public WebDriver driver;

    private PageList pageList;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    void setupTest() {
        this.driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }

    HomePage openHomePage(){
        driver.get(BASE_URL);
        return pageList().homePage();
    }

    public PageList pageList(){
        if (this.pageList == null){
            pageList = new PageList();
        }
        return pageList;
    }

    class PageList{

        private HomePage homePage;
        private VacanciesPage vacanciesPage;

        private PageList(){
        }

        HomePage homePage(){
            if (this.homePage == null){
                homePage = new HomePage(driver);
            }
            return homePage;
        }

        VacanciesPage vacanciesPage(){
            if (this.vacanciesPage == null){
                vacanciesPage = new VacanciesPage(driver);
            }
            return vacanciesPage;
        }
    }
}
