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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.*;


WebUI.callTestCase(findTestCase("Test Cases/TC2_SampleLogin_WithoutExcelParameters"), null)

WebUI.mouseOver(findTestObject('Object Repository/WorkShiftManagement/Page_OrangeHRM/Admin_Tab_MouseHover'))
WebUI.mouseOver(findTestObject('Object Repository/WorkShiftManagement/Page_OrangeHRM/Job_MouseHover'))
WebUI.click(findTestObject('Object Repository/WorkShiftManagement/Page_OrangeHRM/ClickOnWorkShift'))

WebDriver driver = DriverFactory.getWebDriver();
WebElement table = driver.findElement(By.xpath("//*[@id='resultTable']/tbody"));
List<WebElement> tableRows = table.findElements(By.tagName("tr"));
println("Total rows: "+tableRows.size());
rowNumber = 1;
Label:
for(WebElement row: tableRows){
	List<WebElement> tableData = row.findElements(By.tagName("td"));
	println("Total colum size: "+tableData.size());
	/*for(WebElement data: tableData){
		if(data.getText() =="General"){
			println("Retrived text: "+data.getText())
			break Label;
		}
	}*/
	for(int i=0; i<=tableData.size()-1; i++){
		println(tableData.get(i).getText() + "Twilight");
		if(tableData.get(i).getText() =="Twilight"){
			println("Value of i: "+i);
			//WebUI.click(findTestObject(tableData.get(i)));
			//driver.findElement(tableData.get(i)).click();
			driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+rowNumber+"]/td["+(i+1)+"]/a")).click();
			//*[@id="resultTable"]/tbody/tr[1]/td[2]/a
			//*[@id="ohrmList_chkSelectRecord_2"]
			//*[@id="resultTable"]/tbody/tr[2]/td[1]
			println(" Retrived text value: "+tableData.get(i).getText())
			break Label;
		}
	}
	rowNumber++;
}
WebUI.closeBrowser()