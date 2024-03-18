package stepDefinition

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.security.PublicKey

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

public class Transaction {
	@Given("buyers succefully register to the website")
	public void buyers_succefully_register_to_the_website() {
		WebUI.openBrowser('https://secondhand.binaracademy.org/users/sign_up')
		WebUI.maximizeWindow()

		WebUI.waitForElementPresent(findTestObject('Object Repository/Register page/btn_daftar'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Register page/btn_daftar'), 0)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Register page/TextBox_name'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Register page/TextBox_name'), 0)
		
		int RandomNumber;
		RandomNumber = (int)(Math.random()*1000)

		WebUI.setText(findTestObject('Object Repository/Register page/TextBox_name'), 'Archi')
		WebUI.setText(findTestObject('Object Repository/Register page/TextBox_email'), 'Archi'+RandomNumber+'@mail.com')
		WebUI.setText(findTestObject('Object Repository/Register page/TextBox_password'), '123')
		WebUI.click(findTestObject('Object Repository/Register page/btn_daftar'))
	}
	
	@Given("buyers (.*) completed their profiles")
	public void buyer_completed_their_profiles(String condition) {
		if(condition=="have not") {
			WebUI.waitForElementPresent(findTestObject('Object Repository/Homepage/btn_jual'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Homepage/btn_jual'), 0)
			WebUI.waitForElementPresent(findTestObject('Object Repository/Homepage/btn_profile'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Homepage/btn_profile'), 0)
	
			WebUI.click(findTestObject('Object Repository/Homepage/btn_profile'))
			WebUI.click(findTestObject('Object Repository/Homepage/btn_accountInfo'))
	
			WebUI.waitForElementPresent(findTestObject('Object Repository/Account Info Page/TextArea_nama'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Account Info Page/TextArea_nama'), 0)
			WebUI.waitForElementPresent(findTestObject('Object Repository/Account Info Page/btn_back'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Account Info Page/btn_back'), 0)
	
			WebUI.click(findTestObject('Object Repository/Account Info Page/btn_back'))
		}
		else if(condition=="have") {
			WebUI.waitForElementPresent(findTestObject('Object Repository/Homepage/btn_jual'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Homepage/btn_jual'), 0)
			WebUI.waitForElementPresent(findTestObject('Object Repository/Homepage/btn_profile'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Homepage/btn_profile'), 0)
	
			WebUI.click(findTestObject('Object Repository/Homepage/btn_profile'))
			WebUI.click(findTestObject('Object Repository/Homepage/btn_accountInfo'))
	
			WebUI.waitForElementPresent(findTestObject('Object Repository/Account Info Page/TextArea_nama'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Account Info Page/TextArea_nama'), 0)
			WebUI.waitForElementPresent(findTestObject('Object Repository/Account Info Page/btn_submit'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Account Info Page/btn_submit'), 0)
	
			WebUI.uploadFile(findTestObject('Object Repository/Account Info Page/btn_profilePicture'), 'C:\\Users\\archi_000\\Pictures\\Angsa Kucing.PNG')
			WebUI.setText(findTestObject('Object Repository/Account Info Page/TextArea_nama'), 'Archi Edited')
			WebUI.selectOptionByValue(findTestObject('Object Repository/Account Info Page/dropdown_kota'), '4', false)
			WebUI.setText(findTestObject('Object Repository/Account Info Page/TextArea_alamat'), 'Villa Bintaro Indah')
			WebUI.setText(findTestObject('Object Repository/Account Info Page/TextArea_noHP'), '085814205153')
			WebUI.click(findTestObject('Object Repository/Account Info Page/btn_submit'))
		}
		
		
	}
	
	@When ("buyers input (.*) values and send the trade offer")
	public void buyers_input_values_and_send_the_trade_offer(String condition_two) {
		
		WebUI.waitForElementPresent(findTestObject('Object Repository/Homepage/btn_jual'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Homepage/btn_jual'), 0)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Homepage/card_product'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Homepage/card_product'), 0)

		WebUI.scrollToElement(findTestObject('Object Repository/Homepage/card_product'), 0)
		WebUI.click(findTestObject('Object Repository/Homepage/card_product'))

		WebUI.waitForElementPresent(findTestObject('Object Repository/Buyer Transaction Page/text_sellerInfo'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Buyer Transaction Page/text_sellerInfo'), 0)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Buyer Transaction Page/btn_tertarik_nego'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Buyer Transaction Page/btn_tertarik_nego'), 0)

		WebUI.click(findTestObject('Object Repository/Buyer Transaction Page/btn_tertarik_nego'))

		WebUI.waitForElementPresent(findTestObject('Object Repository/Buyer Transaction Page/TextBox_offer'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Buyer Transaction Page/TextBox_offer'), 0)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Buyer Transaction Page/btn_kirim'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Buyer Transaction Page/btn_kirim'), 0)
		
		if(condition_two=="correct") {
		WebUI.setText(findTestObject('Object Repository/Buyer Transaction Page/TextBox_offer'), '1200')
		WebUI.click(findTestObject('Object Repository/Buyer Transaction Page/btn_kirim'))
		}
		else if(condition_two=="string") {
		WebUI.setText(findTestObject('Object Repository/Buyer Transaction Page/TextBox_offer'), 'ABC')
		}
		
	}
	
	@Then("buyers will (.*) in sending the trade offer")
	public void buyers_will_in_sending_the_trade_offer(String result) {
		if(result=="failed") {
			WebUI.waitForElementPresent(findTestObject('Object Repository/Account Info Page/TextArea_nama'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Account Info Page/TextArea_nama'), 0)
			WebUI.waitForElementPresent(findTestObject('Object Repository/Account Info Page/btn_submit'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Account Info Page/btn_submit'), 0)
		}
		else if(result=="success") {
			WebUI.waitForElementPresent(findTestObject('Object Repository/Buyer Transaction Page/text_sellerInfo'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Buyer Transaction Page/text_sellerInfo'), 0)
		}
		else if(result=="fail inputting string") {
			WebUI.waitForElementPresent(findTestObject('Object Repository/Buyer Transaction Page/btn_kirim'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Buyer Transaction Page/btn_kirim'), 0)
		}
		WebUI.closeBrowser()
	}
	
}
