package Base;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;


import java.time.Duration;

public class BaseSelenium {


   public WebDriver driver;


    public String baseUrl = "https://stage.ourpetpolicy.com/";
    public LoginPage loginPage;



    @BeforeClass
    public void setUp(){
//      System.setProperty("webdriver.chrome.driver","Executable path");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.login("rud1995harutyunyan@gmail.com", "123456");
    }



}
