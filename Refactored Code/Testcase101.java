import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Testcase101 {

    private WebDriver driver;
    private WebDriverWait wait;

    public void setup() {
        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void login(String username, String password) {
        driver.get("https://interview.supporthive.com/staff/");
        driver.findElement(By.id("id_username")).sendKeys(username);
        driver.findElement(By.id("id_password")).sendKeys(password);
        driver.findElement(By.id("btn-submit")).click();
    }

    public void navigateToStatuses() {
        WebElement tickets = driver.findElement(By.id("ember29"));
        tickets.click();
        WebElement statuses = driver.findElement(By.linkText("Statuses"));
        statuses.click();
    }

    public void createIssue(String issueName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='hf-entity-footer_primary hf-primary-action ember-view']"))).click();
        driver.findElement(By.tagName("input")).sendKeys(issueName);
        WebElement statusColourSelect = driver.findElement(By.xpath("//div[@class='sp-replacer sp-light']"));
        statusColourSelect.click();
        WebElement statusColourEnter = driver.findElement(By.xpath("//input[@class='sp-input']"));
        statusColourEnter.clear();
        statusColourEnter.sendKeys("#47963f");
    }

    public void tearDown() {
        driver.quit();
    }
    
    public static void main(String[] args) {
        Testcase101 test = new Testcase101();
        test.setup();
        test.login("Agent", "Agent@123");
        test.navigateToStatuses();
        test.createIssue("Issue Created");
        test.tearDown();
    }
}
