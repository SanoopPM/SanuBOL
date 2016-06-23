package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CAMMainPage {

	public WebDriver driver;

	@FindBy(xpath = "//div[@class='breadCrumbsInner']//li[1]/a")
	private WebElement currentapplicationselected;

	@FindBy(xpath = "//ul/li/div[@class='menuMainItem']/a[text()='Applications']")
	private WebElement ApplicationButton;

	@FindBy(xpath = "//tbody/tr//div/a[contains(text(),'Business')]")
	private WebElement BusinessOnlineApplication;

	@FindBy(xpath = "//tbody/tr//div/a[contains(text(),'MyABB')]")
	private WebElement MyABBApplication;

	@FindBy(xpath = "//div[@id='changeReasonContainer']/a")
	private WebElement EditModeButton;

	@FindBy(xpath = "//textarea[@id='change_reason']")
	private WebElement EditModeChangeReasonTextBox;

	@FindBy(xpath = "//input[@class='button']")
	private WebElement EditModeSaveButton;

	@FindBy(xpath = "//ul/li/div[@class='menuMainItem']/a[text()='Users']")
	private WebElement UsersButton;
	
	@FindBy(xpath = "//div[@id='filter.search.fields']//input[@name='filter']")
//	private WebElement UsersSearchByTextBox;
	private WebElement SearchByTextBox;

	@FindBy(xpath = "//div[@id='fielter.buttons']//input[@id='DataTableFilterSearchButton']")
//	private WebElement UsersSearchButton;
	private WebElement SearchButton;

	
	@FindBy(xpath = "//div[@class='dataTableContent']//tbody//a")
//	private WebElement UsersSearchResult;
	private WebElement SearchResult;
	
	@FindBy(xpath="//div[@class='camDataTablePaggingSection']//b")
	private WebElement NoofSearchResult;
	
	@FindBy(xpath="//div[@id='productMenu']//a[text()='Details']")
	private WebElement UsersDetailsTab;
	
	@FindBy(xpath="//div[@class='fieldset_7']/div[@class='topDetails section']//input[@value='Edit']")
	private WebElement UserDetailsTabEditButton;
	
	@FindBy(xpath="//ul/li//a[contains(text(),'Create new user')]")
	private WebElement CreateNewUser;
	
	@FindBy(id="username")
	private WebElement UserName;
	
	@FindBy(id="company_name")
	private WebElement CompanyName;
	
//	@FindBy(xpath="//[@id='country']//option/")
//	private WebElement Country;
	
	@FindBy(id="firstname")
	private WebElement FirstName;
	
	@FindBy(id="middlename")
	private WebElement MiddleName;
	
	@FindBy(id="lastname")
	private WebElement LastName;
	
	@FindBy(id="email")
	private WebElement Email;
	
	@FindBy(id="phone")
	private WebElement PhoneNumber;
	
//	@FindBy(xpath="//select[@id='internal']/option[text()='Internal']")
//	private WebElement Internal;
	
	@FindBy(id="prefered_language")
	private WebElement PreferredLanguage;
	
	@FindBy(xpath="//form[@name='mainform']//input[@value='Create']")
	private WebElement UserDetailsTabCreateButton;
	
	@FindBy(xpath="//form[@name='mainform']//input[@value='Save']")
	private WebElement UserDetailsTabSaveButton;
	
	@FindBy(xpath = "//div[@id='productMenu']//a[text()='Attributes']")
	private WebElement UsersAttributeTab;

	@FindBy(xpath = "//div[@class='fieldset_10']/div[@class='topDetails section']//input[@value='Edit']")
	private WebElement UserAttributeTabEditButton;
	
	@FindBy(xpath = "//div[@id='productMenu']//a[text()='Groups']")
	private WebElement UsersGroupsTab;
	
	@FindBy(xpath="//a[contains(text(),'Add to group')]")
	private WebElement AddtoGroupButton;

//	@FindBy(xpath = "//a[contains(text(),'Customer GUID:')]")
	@FindBy(xpath="//input[@id='CustomerGUID']")
	private WebElement UserAttributeCustomerGUID;
	
	@FindBy(xpath="//a[contains(text(),'Customer GUID:')]/../../../../div[@class='camFormInputField']")
	private WebElement CustomerGUIDValue;

	@FindBy(xpath = "//form[@name='mainform']//input[@value='Save']")
	private WebElement UserAttributeSaveButton;
	
	@FindBy(xpath="//ul/li/div[@class='menuMainItem']/a[text()='Groups']")
	private WebElement GroupButton;
	
	@FindBy(xpath="//div[@id='memberListEdit']//input[@class='button']")
	private WebElement GroupRelationEditButton;
	
	@FindBy(xpath="//div[@class='dataTableContent']//tbody//td[6]//a")
	private WebElement AddRemoveUserfromGroupRelationTab;
	
	@FindBy(xpath="//fieldset[@id='groupSection']//tr/td[2]/div")
	private WebElement UserAvailableGroup;
	
	@FindBy(xpath="//div[@class='dataTableContent']//tbody//td[4]//a")
	private WebElement UserGrouptabAddRemove;

	public CAMMainPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}




	public void currentapplication() {
		if (currentapplicationselected.getText().contains("MyABB")) {
			System.out.println(driver.getCurrentUrl());
		}

		else {

			ApplicationButton.click();

			// BusinessOnlineApplication.click();
			MyABBApplication.click();
		}
	}

	public void gotoEditMode(String Reason) {
		EditModeButton.click();
		EditModeChangeReasonTextBox.sendKeys(Reason);
		EditModeSaveButton.click();
		
	}

	public void clickUsersButton() {
		UsersButton.click();
	}

	public void setSearchByTextBox(String SearchInput) {
		SearchByTextBox.clear();
		SearchByTextBox.sendKeys(SearchInput);
	}

	public void clickSearchButton() {
		SearchButton.click();
	}
	


	public void clickSearchResult() {
			
		if (NoofSearchResult.getText().contains("0"))
		{
			System.out.println("----No Search Result Found----");
//			out.println("----No Search Result Found----");
			
		} 
		else
		{
			System.out.println("Search result "+ CAMMainPage.this.SearchByTextBox.getAttribute("Value"));
//			out.print("Search result "+ CAMMainPage.this.SearchByTextBox.getAttribute("Value"));
			SearchResult.click();
		}
		
	}
	
	public void setUserName(String UN)
	{
		UserName.clear();
		UserName.sendKeys(UN);
	}
	
	public void setCompanyName(String CompName)
	{
		CompanyName.clear();
		CompanyName.sendKeys(CompName);
	}
	
	public void setCountry(String countryCode)
	{
		WebElement country = driver.findElement(By.xpath("//select[@id='country']//option[@value='" +countryCode+"']"));
		country.click();
	}
	
	public void setFirstName(String FName)
	{
		FirstName.clear();
		FirstName.sendKeys(FName);
	}
	
	public void setMiddleName(String MName)
	{
		MiddleName.clear();
		MiddleName.sendKeys(MName);
	}
	
	public void setLastName(String Lname)
	{
		LastName.clear();
		LastName.sendKeys(Lname);
	}
	
	public void setEmail(String mailID)
	{
		Email.clear();
		Email.sendKeys(mailID);
	}
	
	public void setPhoneNumber(String PhNo)
	{
		PhoneNumber.clear();
		PhoneNumber.sendKeys(PhNo);
	}
	
	public void setInternal(String Internal1)
	{
		WebElement Internal = driver.findElement(By.xpath("//select[@id='internal']/option[text()='" +Internal1+"']"));
		Internal.click();
	}
	
	public void clickUsersAttributeTab() {
		UsersAttributeTab.click();
	}

	public void clickUserAttributeTabEditButton() {
		UserAttributeTabEditButton.click();
	}
	
	public void clickUserGroupsTab(){
		UsersGroupsTab.click();
		
	}
	
	public void clickAddtoGroupButton()
	{
		AddtoGroupButton.click();
		
	}

	public void setUserAttributeCustomerGUID(String CGUID) {
	
			UserAttributeCustomerGUID.clear();
			UserAttributeCustomerGUID.sendKeys(CGUID);
		
	}

	public void clickUserAttributeSaveButton() {
		UserAttributeSaveButton.click();
	}
	
	public void clickGroupButton()
	{

		GroupButton.click();
	}
	
	public void clickGroupRelationEditButton()
	{
		GroupRelationEditButton.click();
	}
	
	public void ManageUserinGroup()

	{
		try {
			
			if (NoofSearchResult.getText().contains("0"))
			{
				System.out.println("No Search Result Found**********  " + CAMMainPage.this.SearchByTextBox.getAttribute("value") );
				Reporter.log("No Search Result Found**********  " + CAMMainPage.this.SearchByTextBox.getAttribute("value"),true);
			} 
			else
			{
				if(AddRemoveUserfromGroupRelationTab.getText().contains("Cancel") || AddRemoveUserfromGroupRelationTab.getText().contains("Remove"))
				{
					
					System.out.println(CAMMainPage.this.SearchByTextBox.getAttribute("value") + " ---Already added to group");
					Reporter.log(CAMMainPage.this.SearchByTextBox.getAttribute("value") + " ---Already added to group",true);
				}
				else
				{
					AddRemoveUserfromGroupRelationTab.click();
					System.out.println(CAMMainPage.this.SearchByTextBox.getAttribute("value") + " ---sucessessfully Added");
					Reporter.log(CAMMainPage.this.SearchByTextBox.getAttribute("value") + " ---sucessessfully Added",true);
				}
			}
			
		} catch (Exception e) {
			
			System.out.println(CAMMainPage.this.SearchByTextBox.getAttribute("value") + " ++++Reached Exception Block++++ ");
			Reporter.log(CAMMainPage.this.SearchByTextBox.getAttribute("value") + " ++++Reached Exception Block++++ ",true);
		}
		
	}
	
	//Check GUID is same / Different
	
	public void checkCustomerGUIDValue(String GUID)
	{
		if(CustomerGUIDValue.getText().equals(GUID))
		{
			System.out.println("GUID are same ");
			Reporter.log("GUID are same ",true);
//			out.println("GUID are same");
		}
		
		else
		{
			System.out.println("GUID values are Diffrent----- ");
			Reporter.log("GUID values are Diffrent----- ",true);
//			out.print("GUID values are Diffrent----- ");
			setGUIDValue(GUID);			
		}
	}
	
	// Set GUID if its differnt
	public void setGUIDValue(String CGUID)
	{
		clickUserAttributeTabEditButton();
		setUserAttributeCustomerGUID(CGUID);
		clickUserAttributeSaveButton();
		System.out.println("GUID is set as mentioned");
		Reporter.log("GUID is set as mentioned",true);
	}
	
	
	//Method created to check whether user already exist if not create a new user
	
	public void createUser(String UN, String CompName, String CountCode, String FN, String MN, String LN, String mailID, String PhNo, String Int)
	{
		try {
			
			clickUsersButton();
			setSearchByTextBox(UN);
			clickSearchButton();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			if (NoofSearchResult.getText().contains("0"))
			{
//				System.out.println("----No Search Result Found---- "+ CAMMainPage.this.SearchByTextBox.getAttribute("Value"));
				Reporter.log("----No Search Result Found--- " + CAMMainPage.this.SearchByTextBox.getAttribute("Value"),true);
				CreateNewUser.click();
				setUserName(UN);
				setCompanyName(CompName);
				setCountry(CountCode);
				setFirstName(FN);
				setMiddleName(MN);
				setLastName(LN);
				setEmail(mailID);
				setPhoneNumber(PhNo);
				setInternal(Int);
//				PreferredLanguage.sendKeys(PreLang);
				UserDetailsTabCreateButton.click();
//				System.out.println("User created successfully");
				Reporter.log("User created successfully",true);
				
			} 
			else
			{
//				System.out.println("Search result "+ CAMMainPage.this.SearchByTextBox.getAttribute("Value"));
				Reporter.log("Search Result  " + CAMMainPage.this.SearchByTextBox.getAttribute("Value"),true);
				
			}		

			
		} catch (Exception e) {
//			System.out.println("Exception Occured" + CAMMainPage.this.SearchByTextBox.getAttribute("Value"));
			Reporter.log("Exception Occured  " + CAMMainPage.this.SearchByTextBox.getAttribute("Value"),true);
		}
		

	}
	
	//To check whether GUID is present or not
	
	public void CheckGUIDSetisPresent(String cUser, String cGUID)
	{
		
		try {
			
			clickUsersButton();
			setSearchByTextBox(cUser);
			clickSearchButton();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			if (NoofSearchResult.getText().contains("0"))
			{
//				System.out.println("----No Search Result Found---- " + CAMMainPage.this.SearchByTextBox.getAttribute("Value"));
				Reporter.log("----No Search Result Found---- " + CAMMainPage.this.SearchByTextBox.getAttribute("Value"), true);

				
				
			} 
			else
			{
//				System.out.println("Search result "+ CAMMainPage.this.SearchByTextBox.getAttribute("Value"));
				Reporter.log("Search result "+ CAMMainPage.this.SearchByTextBox.getAttribute("Value") , true);
				SearchResult.click();
				clickUsersAttributeTab();
				checkCustomerGUIDValue(cGUID);		
			}

			
		} catch (Exception e) {
			
//			System.out.println("Exception Occured "+ CAMMainPage.this.SearchByTextBox.getAttribute("Value"));
			Reporter.log("Exception Occured "+ CAMMainPage.this.SearchByTextBox.getAttribute("Value"),true);
			
		}
	}
		
		public void AddUserstoGroup(String UserName, String GroupName)
		{
			try {
				clickUsersButton();
				setSearchByTextBox(UserName);
				clickSearchButton();
				clickSearchResult();
				clickUserGroupsTab();
//				ArrayList<String> UserAvailGroup=new ArrayList<String>();
//				UserAvailGroup.add(UserAvailableGroup);
				
				if(UserAvailableGroup.getText().contains(GroupName))
				{
					System.out.println("User already added to the group --> " +UserName +" --> " +GroupName);
//					Reporter.log("User already added to the group --> " +UserName +" --> " +GroupName, true);
				}
				else
				{
					clickAddtoGroupButton();
					setSearchByTextBox(GroupName);
					clickSearchButton();
					if (NoofSearchResult.getText().contains("0"))
					{
						System.out.println("No Search Result Found**********  " + CAMMainPage.this.SearchByTextBox.getAttribute("value"));
//						Reporter.log("No Search Result Found**********  " + CAMMainPage.this.SearchByTextBox.getAttribute("value"),true);
					}
					else
					{
						if(UserGrouptabAddRemove.getText().contains("Cancel") || UserGrouptabAddRemove.getText().contains("Remove"))
						{
							System.out.println(CAMMainPage.this.SearchByTextBox.getAttribute("value") + " ---Already added to group");
//							Reporter.log(CAMMainPage.this.SearchByTextBox.getAttribute("value") + " ---Already added to group",true);
						}
						else
						{
							UserGrouptabAddRemove.click();
							System.out.println(CAMMainPage.this.SearchByTextBox.getAttribute("value") + " ---sucessessfully Added");
//							Reporter.log(CAMMainPage.this.SearchByTextBox.getAttribute("value") + " ---sucessessfully Added",true);
						}
					}
					}
				
			
				
			} catch (Exception e) {
				System.out.println("!!!!  Reached exception Block  !!!");
//				Reporter.log("!!!!  Reached exception Block  !!!");
			}
		}
}