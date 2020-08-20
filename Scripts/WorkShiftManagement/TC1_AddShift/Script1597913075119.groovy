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

WebUI.callTestCase(findTestCase("Test Cases/TC2_SampleLogin_WithoutExcelParameters"), null)
WebUI.mouseOver(findTestObject('Object Repository/WorkShiftManagement/Page_OrangeHRM/Admin_Tab_MouseHover'))
WebUI.mouseOver(findTestObject('Object Repository/WorkShiftManagement/Page_OrangeHRM/Job_MouseHover'))
WebUI.click(findTestObject('Object Repository/WorkShiftManagement/Page_OrangeHRM/ClickOnWorkShift'))
WebUI.click(findTestObject('Object Repository/WorkShiftManagement/Page_OrangeHRM/input_AddButton'))
WebUI.setText(findTestObject('Object Repository/WorkShiftManagement/Page_OrangeHRM/input__workShiftname'), 'Night Shift')
WebUI.selectOptionByLabel(findTestObject('Object Repository/WorkShiftManagement/Page_OrangeHRM/select_FromTime'), '14:00', false)
WebUI.selectOptionByLabel(findTestObject('Object Repository/WorkShiftManagement/Page_OrangeHRM/select_ToTime'), '23:00', false)
WebUI.selectOptionByLabel(findTestObject('Object Repository/WorkShiftManagement/Page_OrangeHRM/select_AvailableEmployees'), 'Test 1', false)
WebUI.click(findTestObject('Object Repository/WorkShiftManagement/Page_OrangeHRM/AddEmployee'))
WebUI.verifyOptionPresentByLabel(findTestObject('Object Repository/WorkShiftManagement/Page_OrangeHRM/select_AssignedEmployees'), 'Test 1', false, 4)
WebUI.click(findTestObject('Object Repository/WorkShiftManagement/Page_OrangeHRM/input__SaveButton'))
WebUI.closeBrowser()