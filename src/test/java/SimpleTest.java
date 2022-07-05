import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SimpleTest extends TestBase{

    @Test
    public void verifyProfessionalSkillsCount(){
        int expectedCount = 5;

        openHomePage()
                .navigationBar()
                .openDropDownMenu("Careers")
                .selectFromDropDownMenu("Vacancies");

        int actualCount =
            pageList()
                    .vacanciesPage()
                    .openVacancyWithTitle("TEST AUTOMATION ENGINEER")
                    .selectParagraph("Professional skills and qualification:")
                    .countItems();

        Assert.assertEquals("Amount of items doesn't match expectations:", expectedCount, actualCount);
}
}
