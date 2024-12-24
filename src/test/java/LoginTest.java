import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("chromedriver.exe", "C:\\Users\\artem\\IdeaProjects\\Test\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        driver.get("C:\\Users\\artem\\IdeaProjects\\Test\\src\\main\\resources\\qa-test (1).html");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}