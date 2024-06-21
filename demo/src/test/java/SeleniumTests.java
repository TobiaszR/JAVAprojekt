import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;
import java.util.List;
public class SeleniumTests {
    WebDriver driver;
    // tag -> TEST
    @BeforeEach //przed każdym testem
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterEach //po każdym teście
    public void driverClose(){
        //zamyka przeglądarkę, ale nie drivera
        //driver.close();
        //zamyka przeglądarkę i drivera
        driver.quit();
    }
    @Test
    public void firstTest(){
        driver.get("https://skleptest.pl/");
    }
    @Test
    public void secondTest(){
        driver.get("https://skleptest.pl/");
        WebElement searchInput = driver.findElement(By.id("search-field-top-bar"));
        searchInput.clear();
        searchInput.sendKeys("DRESS");
        WebElement searchButton = driver.findElement(By.className("search-top-bar-submit"));
        searchButton.click();
    }
    @Test
    public void thirdTest(){
        driver.get("https://skleptest.pl/my-account/");
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement userLoginButton = driver.findElement(By.name("login"));
        usernameInput.clear();
        usernameInput.sendKeys("null");
        userLoginButton.click();
        WebElement information = driver.findElement(By.xpath("//ul[@class=\"woocommerce-error\"]"));
        String message = information.getText();
        String komunikat = "Error: The password field is empty.";
        //Assertions.assertNotNull(information);
        //Assertions.assertTrue(true);
        //Assertions.assertFalse(false);
        Assertions.assertEquals(komunikat, message);
    }
    @Test
    public void newsletterSubscribeTest(){
        driver.get("https://skleptest.pl/");
        WebElement newsletterSubscribeButton = driver.findElement(By.name("es_txt_button"));
        WebElement newsletterEmailInput = driver.findElement(By.id("es_txt_email"));
        WebElement newsletterNameInput = driver.findElement(By.id("es_txt_name"));
        newsletterEmailInput.clear();
        newsletterEmailInput.sendKeys("null");
        newsletterNameInput.clear();
        newsletterNameInput.sendKeys("name");
        newsletterSubscribeButton.click();
    }
    @Test
    public void findMenthodsTest(){
        driver.get("https://skleptest.pl/");
        WebElement newsletterSubscribeButton = driver.findElement(By.name("es_txt_button"));
        List<WebElement> listaElementow = driver.findElements(By.xpath("//ul[@id=\"desktop-menu\"]/li"));
        System.out.println(listaElementow.size());
    }
}