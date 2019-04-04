			package com.cgg.Pages;
			
			import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
			import org.openqa.selenium.WebElement;
			import org.openqa.selenium.support.FindBy;
			import org.openqa.selenium.support.PageFactory;
			
			import com.cgg.constants.NewUserRegistrationConstant;
import com.cgg.testcases.TestBase;
import com.cgg.util.AssertionsUtil;
			import com.cgg.util.FunctionUtil;
import com.cgg.util.WaitUtil;
			
			public class NewRegistrationFormPage extends TestBase{
				
				private WebDriver driver;
			
				public NewRegistrationFormPage(WebDriver driver){
					this.driver=driver;
					PageFactory.initElements(driver, this);
				}
				
				@FindBy(xpath=NewUserRegistrationConstant.NAME)
				private WebElement Name;
				
				@FindBy(xpath=NewUserRegistrationConstant.DISTRICT)
				private WebElement District;
				
				@FindBy(xpath=NewUserRegistrationConstant.MANDAL)
				private WebElement Mandal;
				
				@FindBy(xpath=NewUserRegistrationConstant.MOBILENUMBER)
				private WebElement MobileNumber;
				
				@FindBy(xpath=NewUserRegistrationConstant.EMAILID)
				private WebElement EMailId;
			
				@FindBy(xpath=NewUserRegistrationConstant.LOGINID)
				private WebElement LoginId;
				
				@FindBy(xpath=NewUserRegistrationConstant.PASSWORD)
				private WebElement Password;
				
				@FindBy(xpath=NewUserRegistrationConstant.CONFIRMPASSWORD)
				private WebElement ConfirmPassword;
				
				@FindBy(xpath=NewUserRegistrationConstant.REGISTERBUTTON)
				private WebElement RegisterButton;
				
				public void sendName(String name){
sendKeysToTextBox(this.Name, name);
				}
				
					//District	
						public void selectDistrict(String district){
//							try{
//					FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.District, district);
//						}
//							catch(NoSuchElementException e)
//							{
//								
//							}
							select_Option_In_DropDown_ByVisibleText(this.District, district);
						}
						public void selectMandal(String mandal){
							
//							
//							try{
//								FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Mandal, mandal);
//									}
//										catch(NoSuchElementException e)
//										{
//											
//										}
							select_Option_In_DropDown_ByVisibleText(this.Mandal, mandal);
						}
											
			
						public void sendMobileNumber(String mobileNumber )
						{
					sendKeysToTextBox(this.MobileNumber, mobileNumber);
						}
						
						public void sendEmailId(String emailId )
						{
							sendKeysToTextBox(this.EMailId,emailId);
						}
						public void sendLoginId(String loginId )
						{
							sendKeysToTextBox(this.LoginId,loginId);
						}
						
						public void sendPassword(String password )
						{
							sendKeysToTextBox(this.Password, password);
						}
						
					
						public void sendConfirmPassword(String confirmPassword )
						{
							sendKeysToTextBox(this.ConfirmPassword, confirmPassword);
						}
						
				
							public void clickOnRegisterButton( )
							{
								WaitUtil.waitForElementClickable(this.RegisterButton);
								clickOnButton(this.RegisterButton);
							}
					
				
					
				
					
				
				public boolean isRegistrationPageOpened()
				{
					try {
						return AssertionsUtil.isElementPresent(this.Name);
					} catch (NoSuchElementException e) {
						return false;
					}
					
					
				}
				
			
				
			//	public boolean isRegistrationFormPageOpened()
			//	{
			//		return 
			//		
			//		
			//	}
			//	 
				
				
			}
