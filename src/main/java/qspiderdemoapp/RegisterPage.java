package qspiderdemoapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="name")
	private WebElement nameTextbox;
	
	@FindBy(id="email")
	private WebElement emailTextbox;
	
	@FindBy(name="password")
	private WebElement pwdTextbox;
	
	@FindBy(xpath = "//button[text()='Register']")
	private WebElement registerButton;

	public WebElement getNameTextbox() {
		return nameTextbox;
	}

	public WebElement getEmailTextbox() {
		return emailTextbox;
	}

	public WebElement getPwdTextbox() {
		return pwdTextbox;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}
	
	public void registerUser(String name, String email, String password) {
		nameTextbox.sendKeys(name);
		emailTextbox.sendKeys(email);
		pwdTextbox.sendKeys(password);
		registerButton.click();
	}

}
