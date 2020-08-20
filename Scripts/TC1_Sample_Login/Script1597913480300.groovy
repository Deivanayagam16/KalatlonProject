import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

for(int rowNum=1;rowNum<= findTestData("SampleData/SampleTestData").getRowNumbers(); rowNum++ ){
	WebUI.openBrowser('https://opensource-demo.orangehrmlive.com/')
	WebUI.setText(findTestObject('Object Repository/TC1_Sample_Login_OR/Page_OrangeHRM/input_LOGIN Panel_txtUsername'), findTestData("SampleData/SampleTestData").getValue(1, rowNum))
	println("Username: "+findTestData("SampleData/SampleTestData").getValue(1, rowNum))
	WebUI.setText(findTestObject('Object Repository/TC1_Sample_Login_OR/Page_OrangeHRM/input_Username_txtPassword'), findTestData("SampleData/SampleTestData").getValue(2, rowNum))
	println("password: "+findTestData("SampleData/SampleTestData").getValue(2, rowNum))
	Thread.sleep(3000)
	WebUI.click(findTestObject('Object Repository/TC1_Sample_Login_OR/Page_OrangeHRM/input_Password_Submit'))
	//WebUI.waitForElementPresent(findTestObject('Object Repository/TC1_Sample_Login_OR/Page_OrangeHRM/input_People who like this post_MP_link'), 10)
	try{
		boolean validation = WebUI.verifyElementPresent(findTestObject('Object Repository/TC1_Sample_Login_OR/Page_OrangeHRM/input_People who like this post_MP_link'), 4)
		if(validation)
		{
			System.out.println("Welcome: "+findTestData("SampleData/SampleTestData").getValue(2, 1))
			KeywordUtil.markPassed("Login successful")
		}
		else{
			KeywordUtil.markFailed("Invalid credentials")
		}
	}
	catch(StepFailedException e){
		println(e.getMessage())
		KeywordUtil.markFailed("Invalid credentials")
	}
	WebUI.closeBrowser()
	
}


