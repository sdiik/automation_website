package stepDefinition

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

public class Register2 {
	@When("user fills up all required fields except (.*) on the register page")
	public void user_fills_up_all_required_fields_except_on_the_register_page(String field) {
		if(field=="name field") {
			int RandomNumber;
			RandomNumber = (int)(Math.random()*1000)
			WebUI.setText(findTestObject('Object Repository/Register page/TextBox_email'), 'kirana'+RandomNumber+'@gmail.com')
			WebUI.setText(findTestObject('Object Repository/Register page/TextBox_password'), 'Testing123')
		}else if(field=="email field") {
			WebUI.setText(findTestObject('Object Repository/Register page/TextBox_name'), 'Testing1234')
			WebUI.setText(findTestObject('Object Repository/Register page/TextBox_password'), 'Testing123')
		}
	}

	@Then("(.*) will be received by user on the register page")
	public void will_be_received_by_user_on_the_register_page(String message) {
		if(message=="warning message name") {
			WebUI.getAttribute(findTestObject('Object Repository/Register page/TextBox_name'), 'validationMessage')
		}else if(message=="warning message email") {
			WebUI.getAttribute(findTestObject('Object Repository/Register page/TextBox_email'), 'validationMessage')
		}
	}
}