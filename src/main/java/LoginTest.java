import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.datatype.Duration;

public class LoginTest {

    private  WebDriver driver;
    // Initialize
    @BeforeMethod
    public  void SetUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://shop.gboss.io/login");
    }
    //Test for normal login
    @Test
    public  void Login(){
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement login = driver.findElement(By.className("MuiButton-label"));

        username.sendKeys("shop2@gmail.com");
        password.sendKeys("shop2@gmail.com");
        login.click();

        WebElement sendBTN = new WebDriverWait(driver,10).until(driver -> driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/form/div[3]/div/p")));
        if (sendBTN.getText().equals("Username/ password không chính xác")) {
            System.out.println("False");
        }
        else System.out.println("True");

    }
    // Lưu thông tin đăng nhập
    @Test
    public void SaveLogin () {
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement login = driver.findElement(By.className("MuiButton-label"));
        WebElement SaveLog = driver.findElement(By.name("isSaved"));

        username.sendKeys("shop2@gmail.com");
        password.sendKeys("shop2@gmail.com");
        SaveLog.click();
        login.click();
        WebElement sendBTN = new WebDriverWait(driver,10).until(driver -> driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/form/div[3]/div/p")));
        if (sendBTN.getText().equals("Username/ password không chính xác")) {
            System.out.println("False");
        }
        else System.out.println("True");
    }
    @Test
    // Nhìn mật khẩu
    public void SeePass () {
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement login = driver.findElement(By.className("MuiButton-label"));
        WebElement Seepas = driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiIconButton-root.MuiIconButton-colorInherit"));

        username.sendKeys("shop2@gmail.com");
        password.sendKeys("shop2@gmail.com");
        Seepas.click();
        login.click();
        WebElement sendBTN = new WebDriverWait(driver,10).until(driver -> driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/form/div[3]/div/p")));
        if (sendBTN.getText().equals("Username/ password không chính xác")) {
            System.out.println("False");
        }
        else System.out.println("True");
    }
    //Quên mật khẩu
    @Test
    public void ForgotPass() {
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement login = driver.findElement(By.className("MuiButton-label"));
        WebElement forgot = driver.findElement(By.cssSelector(".MuiTypography-root.MuiLink-root.MuiLink-underlineHover.regular-sm-txt.MuiTypography-colorPrimary"));

        username.sendKeys("shop2@gmail.com");
        forgot.click();

    }
    //Gửi mail xác thực mật khẩu
    @Test
    public void SendMailForgot() {
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement login = driver.findElement(By.className("MuiButton-label"));
        WebElement forgot = driver.findElement(By.cssSelector(".MuiTypography-root.MuiLink-root.MuiLink-underlineHover.regular-sm-txt.MuiTypography-colorPrimary"));

        username.sendKeys("shop2@gmail.com");
        forgot.click();

        WebElement fillIn = new WebDriverWait(driver,10).until(driver -> driver.findElement(By.cssSelector(".MuiInputBase-input.MuiOutlinedInput-input.jss5.MuiInputBase-inputAdornedStart.MuiOutlinedInput-inputAdornedStart")));
        fillIn.sendKeys("shop2@gmail.com");
        WebElement sendBTN = new WebDriverWait(driver,10).until(driver -> driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-containedSizeLarge.MuiButton-sizeLarge")));
        sendBTN.click();
    }
    //Sai format Email
    @Test
    public void FormatEmail() {
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement login = driver.findElement(By.className("MuiButton-label"));

        username.sendKeys("shop2@gmail.com");
        password.sendKeys("shop2@gmail.com");
        login.click();

        WebElement sendBTN = new WebDriverWait(driver,10).until(driver -> driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/form/div[3]/div/p")));
        if (sendBTN.getText().equals("Username/ password không chính xác")) {
            System.out.println("True");
        }
        else System.out.println("False");

    }
    //Đăng ký tk mới ???
    @Test
    public  void Registry() {

    }
    // Facebook login
    @Test
    public  void FacebookLogin() {
        WebElement fbLogin = driver.findElement(By.xpath("//img[@alt='Login Facebook']"));
        fbLogin.click();
    }
    //Đóng trình duyệt
    @AfterMethod
    public  void CleanUp() {
        /*driver.quit();*/
    }
    public static void main(String[] args) {
        LoginTest test = new LoginTest();
        test.SetUp();
        test.Login();
        test.CleanUp();
    }
}