import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("chromedriver.exe", "C:\\Users\\artem\\IdeaProjects\\Test\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("C:\\Users\\artem\\IdeaProjects\\Test\\src\\main\\resources\\qa-test (1).html");
    }

    @Test
    public void testLoginPageElements() {
        // Проверка наличия полей ввода и кнопки
        WebElement usernameField = driver.findElement(By.id("loginEmail"));
        WebElement passwordField = driver.findElement(By.id("loginPassword"));
        WebElement loginButton = driver.findElement(By.id("authButton"));

        Assert.assertTrue(usernameField.isDisplayed(), "Username field is not displayed");
        Assert.assertTrue(passwordField.isDisplayed(), "Password field is not displayed");
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
    }

    @Test
    public void testEmptyValue() {
        // Авторизация с пустыми данными
        driver.findElement(By.id("loginEmail")).sendKeys("");
        driver.findElement(By.id("loginPassword")).sendKeys("");
        driver.findElement(By.id("authButton")).click();

        WebElement errorMessage = driver.findElement(By.id("emailFormatError"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Неверный формат E-Mail");
        Assert.assertEquals(errorMessage.getText(), "Неверный формат E-Mail", "Сообщение об ошибки не соответствует ожиданиям.");
    }

    @Test
    public void testInvalidLogin() {
        // Ввод неверных учетных данных
        driver.navigate().refresh();
        driver.findElement(By.id("loginEmail")).sendKeys("invalidUser");
        driver.findElement(By.id("loginPassword")).sendKeys("invalidPass");
        driver.findElement(By.id("authButton")).click();

        WebElement errorMessage = driver.findElement(By.id("emailFormatError"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Неверный формат E-Mail");
        Assert.assertEquals(errorMessage.getText(), "Неверный формат E-Mail", "Сообщение об ошибки не соответствует ожиданиям.");
    }

    @Test
    public void testValidLogin() {
        // Ввод верных учетных данных и проверка появившихся элементов.
        driver.navigate().refresh();
        driver.findElement(By.id("loginEmail")).sendKeys("test@protei.ru");
        driver.findElement(By.id("loginPassword")).sendKeys("test");
        driver.findElement(By.id("authButton")).click();

        WebElement email = driver.findElement(By.id("dataEmail"));
        WebElement name = driver.findElement(By.id("dataName"));
        WebElement dataGender = driver.findElement(By.id("dataGender"));

        WebElement checkBox1 = driver.findElement(By.id("dataCheck11"));
        WebElement checkBox2 = driver.findElement(By.id("dataCheck12"));

        WebElement select1 = driver.findElement(By.id("dataSelect21"));
        WebElement select2 = driver.findElement(By.id("dataSelect22"));
        WebElement select3 = driver.findElement(By.id("dataSelect23"));

        WebElement addButton = driver.findElement(By.id("dataSend"));

        WebElement emailInscription = driver.findElement(By.xpath("//table/thead/tr/th[1]"));
        WebElement nameInscription = driver.findElement(By.xpath("//table/thead/tr/th[2]"));
        WebElement genderInscription = driver.findElement(By.xpath("//table/thead/tr/th[3]"));
        WebElement sel1Inscription = driver.findElement(By.xpath("//table/thead/tr/th[4]"));
        WebElement sel2lInscription = driver.findElement(By.xpath("//table/thead/tr/th[5]"));


        Assert.assertTrue(email.isDisplayed(), "Строка ввода имейла не отображается.");
        Assert.assertTrue(name.isDisplayed(), "Строка ввода имени не отображается.");
        Assert.assertTrue(dataGender.isDisplayed(), "Аккордеон выбора пола не отображается.");

        Assert.assertTrue(checkBox1.isDisplayed(), "Вариант 1.1 не отображается.");
        Assert.assertTrue(checkBox2.isDisplayed(), "Вариант 1.2 не отображается.");

        Assert.assertTrue(select1.isDisplayed(), "Вариант 2.1 не отображается.");
        Assert.assertTrue(select2.isDisplayed(), "Вариант 2.2 не отображается.");
        Assert.assertTrue(select3.isDisplayed(), "Вариант 2.3 не отображается.");

        Assert.assertTrue(addButton.isDisplayed(), "Кнопка добавить не отображается.");

        Assert.assertTrue(emailInscription.isDisplayed(), "Надпись имейл не отображается.");
        Assert.assertTrue(nameInscription.isDisplayed(), "Надпись имя не отображается.");
        Assert.assertTrue(genderInscription.isDisplayed(), "Надпись пол не отображается.");
        Assert.assertTrue(sel1Inscription.isDisplayed(), "Надпись выбор1 не отображается.");
        Assert.assertTrue(sel2lInscription.isDisplayed(), "Надпись выбор2 не отображается.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}