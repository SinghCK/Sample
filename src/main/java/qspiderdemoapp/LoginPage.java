package qspiderdemoapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	private WebElement emailTextbox;
	
	@FindBy(id = "password")
	private WebElement pwdTextbox;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[text()='Registered successfully']")
	private WebElement registeredSuccessfullMsg;
	
	@FindBy(xpath = "//div[text()='Signin successful']")
	private WebElement siginSuccessfullMsg;

	public WebElement getEmailTextbox() {
		return emailTextbox;
	}

	public WebElement getPwdTextbox() {
		return pwdTextbox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public boolean getRegisteredSuccessful() {
		return registeredSuccessfullMsg.isDisplayed();
	}
	
	public boolean getLoginSuccessful() {
		return siginSuccessfullMsg.isDisplayed();
	}
	
	
	public WebElement getRegisteredSuccessfullMsg() {
		return registeredSuccessfullMsg;
	}

	public WebElement getSiginSuccessfullMsg() {
		return siginSuccessfullMsg;
	}

	public void LoginUser(String email, String pwd) {
		emailTextbox.sendKeys(email);
		pwdTextbox.sendKeys(pwd);
		loginButton.click();
	}

}
