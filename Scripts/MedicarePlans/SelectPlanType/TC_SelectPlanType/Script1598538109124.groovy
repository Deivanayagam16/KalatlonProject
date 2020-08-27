import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.concurrent.TimeUnit

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.*

WebDriver driver = DriverFactory.getWebDriver();
WebUI.click(findTestObject('Object Repository/Medicare Plans/SelectPlanType/Page_Medicare Insurance Program/a_Medicare Advantage Plans  45 plans available'))
//WebUI.click(findTestObject('Object Repository/Medicare Plans/SelectPlanType/Page_Medicare Insurance Program/Company'))
driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
WebElement company = driver.findElement(By.xpath("//*[@id='filter 6']/div/div/div/ul"));
List<WebElement> companyList = company.findElements(By.tagName("li"));
println ("List size: "+ companyList.size())
for(int i=1; i<=companyList.size(); i++){
	String companyName = driver.findElement(By.xpath("//*[@id='filter 6']/div/div/div/ul/li["+i+"]/span/label/span/span")).getText();
	//*[@id="filter 6"]/div/div/div/ul/li[3]/span/label/span/span
	if(companyName == "Blue Shield of California"){
		println("Blue shield of california")
	}
}

