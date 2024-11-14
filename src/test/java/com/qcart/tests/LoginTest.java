package com.qcart.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.qcart.pageObjects.LoginPage;

public class LoginTest extends BaseClass {

    @Test(priority = 1)
    public void loginWithValidCredentials(ITestContext context){
    	
    	 context.setAttribute("driver", driver);
         driver.get(baseURL);   
         log.info("URL is opened...");
         driver.manage().window().maximize();
         LoginPage lp = new LoginPage(driver);
         lp.clickLogin();
         log.info("Login Button clicked ...");
         lp.setUserName(username);
         log.info("Entered username...");
         lp.setPassword(password);
         log.info("Entered password...");
         lp.clickSubmit();
         log.info("Submit Button clicked ...");
         
         String actualTitle = driver.getTitle();         
         String expectedTitle = "QKart";
         Assert.assertEquals(actualTitle, expectedTitle);
         log.info("User logged in successfully...");
         
         //another way to verify assertion
         if(driver.getTitle().equals(expectedTitle)) {
        	 Assert.assertTrue(true);
         }else {
        	 Assert.assertFalse(false);
         }
    }
    
   @Test(priority = 2)
    public void loginWithInvalidCredentials() throws InterruptedException {
    	driver.get(baseURL); 
    	log.info("Again URL opened...");
    	driver.manage().window().maximize();
        LoginPage lp2 = new LoginPage(driver);
        lp2.clickLogin();
        log.info("Login Button clicked ...");
        lp2.setUserName(invusername);
        log.info("Entered invalid Username...");
        lp2.setPassword(invpassword);
        log.info("Entered invalid Password...");
        lp2.clickSubmit();
        log.info("Submit Button clicked...");   
        
        Thread.sleep(3000);
        String actualResult = driver.findElement(By.xpath("//div[@id='notistack-snackbar']")).getText();
        String expectedResult = "Username does not exist";
        Assert.assertEquals(actualResult, expectedResult);
        log.info("Verifying the error message...");  
    }
    
   // @Test(priority = 3)
    public void failure(){
      Assert.assertTrue(false);
    }
    
    //@Test(priority = 4)
    public void failure2(){
      Assert.assertTrue(false);
    }
    
   // @Test(dependsOnMethods = "failure")
    public void skipped() {
        System.out.println("This test will be skipped.");
    }
}
