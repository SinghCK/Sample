package ddtandpom;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import qspiderdemoapp.FileUtility;
import qspiderdemoapp.LoginPage;
import qspiderdemoapp.RegisterPage;

public class ToRegisterAndLoginAUser {

	public static void main(String[] args) throws IOException {
		FileUtility file = new FileUtility();
		String url=file.fetchDataFromPropertyFile("url");
		String name=file.fetchDataFromExcel("details", 1, 1);
		String email=file.fetchDataFromExcel("details", 1, 2);
		String pwd=file.fetchDataFromExcel("details", 1, 3);
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		RegisterPage register = new RegisterPage(driver);
		LoginPage login = new LoginPage(driver);
		
		register.registerUser(name, email, pwd);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(login.getRegisteredSuccessfullMsg()));
		if(login.getRegisteredSuccessful())
			System.out.println("PASS: The user has registered");
		else
			System.out.println("FAIL: The user has not registered");
		
		login.LoginUser(email, pwd);
		
		wait.until(ExpectedConditions.elementToBeClickable(login.getSiginSuccessfullMsg()));
		if(login.getLoginSuccessful())
			System.out.println("PASS: The user is logged in");
		else
			System.out.println("FAIL: The user is not logged in");

	}

}
