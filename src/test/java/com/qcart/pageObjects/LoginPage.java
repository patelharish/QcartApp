package com.qcart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="(//button[@type=\"button\"])[1]")
	WebElement clickOnLoginBtn;
	
	@FindBy(id="username")
	WebElement txtUserName;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(xpath="(//button[@type=\"button\"])[2]")
	WebElement btnLogin;
	
	public void clickLogin() {
		clickOnLoginBtn.click();
	}
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	
}
