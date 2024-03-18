package stepDefinition
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class CRUD_product {
	//Post and preview page
	@Given("user has opened selling page")
	public void user_has_opened_selling_page() {
		WebUI.click(findTestObject('Object Repository/Homepage/btn_jual'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Post Product Page/btn_terbitkan'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Post Product Page/btn_terbitkan'), 0)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Post Product Page/btn_preview'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Post Product Page/btn_preview'), 0)
	}

	@When("user input valid credential in all required fields user and select (.*) in selling page")
	public void user_input_valid_credential_in_all_required_fields_user_and_select_in_selling_page(String button) {
		WebUI.setText(findTestObject('Object Repository/Post Product Page/TextBox_namaProduk'), 'beat')
		WebUI.setText(findTestObject('Object Repository/Post Product Page/TextBox_hargaProduk'), '1000')
		WebUI.selectOptionByValue(findTestObject('Object Repository/Post Product Page/select_pilihKategori'), '2', false)
		WebUI.setText(findTestObject('Object Repository/Post Product Page/TextBox_deskripsiProduk'), 'barang bekas')
		WebUI.uploadFile(findTestObject('Object Repository/Post Product Page/img_formImage'), 'C:\\Users\\WINDOWS 10\\Downloads\\sapi.jpg')
		WebUI.delay(1)
		if(button=="terbitkan") {
			WebUI.click(findTestObject('Object Repository/Post Product Page/btn_terbitkan'))
		}else if (button=="preview") {
			WebUI.click(findTestObject('Object Repository/Post Product Page/btn_preview'))
		}
	}
	@Then("user will successfully (.*) product")
	public void user_will_successfully_product(String result) {
		if(result=="post") {
			WebUI.waitForElementPresent(findTestObject('Object Repository/Product Details Page/btn_delete'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Product Details Page/btn_delete'), 0)
			WebUI.waitForElementPresent(findTestObject('Object Repository/Product Details Page/btn_edit'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Product Details Page/btn_edit'), 0)
		}else if(result=="preview") {
			WebUI.waitForElementPresent(findTestObject('Object Repository/Preview Page/btn_terbitkan'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Preview Page/btn_terbitkan'), 0)
			WebUI.waitForElementPresent(findTestObject('Object Repository/Preview Page/btn_edit'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Preview Page/btn_edit'), 0)
		}
	}

	//user doesn't choose category
	@When("user input valid credential in all required except in kategori fields and click terbitkan button in selling page")
	public void user_input_valid_credential_in_all_required_except_in_kategori_fields_and_click_terbitkan_button_in_selling_page() {
		WebUI.setText(findTestObject('Object Repository/Post Product Page/TextBox_namaProduk'), 'beat')
		WebUI.setText(findTestObject('Object Repository/Post Product Page/TextBox_hargaProduk'), '1000')
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Post Product Page/select_pilihKategori'), 'Pilih Kategori', false)
		WebUI.setText(findTestObject('Object Repository/Post Product Page/TextBox_deskripsiProduk'), 'barang bekas')
		WebUI.uploadFile(findTestObject('Object Repository/Post Product Page/img_formImage'), 'C:\\Users\\WINDOWS 10\\Downloads\\sapi.jpg')
		WebUI.click(findTestObject('Object Repository/Post Product Page/btn_terbitkan'))
	}

	@Then("user will fail post new product")
	public void user_will_fail_post_new_product() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Post Product Page/text_errorMessage_kategori'), 0)
		WebUI.closeBrowser()
	}
	//user can edit product
	@Given("user has opened edit product page")
	public void user_has_opened_edit_product_page() {
		WebUI.click(findTestObject('Object Repository/Homepage/btn_daftarJual'))
		//redirect to daftar jual page
		WebUI.waitForElementPresent(findTestObject('Object Repository/Daftar Jual Page/btn_edit'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Daftar Jual Page/btn_edit'), 0)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Daftar Jual Page/btn_productCard'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Daftar Jual Page/btn_productCard'), 0)
		WebUI.click(findTestObject('Object Repository/Daftar Jual Page/btn_productCard'))
		//redirect to product detail page
		WebUI.waitForElementPresent(findTestObject('Object Repository/Product Details Page/btn_delete'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product Details Page/btn_delete'), 0)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Product Details Page/btn_edit'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product Details Page/btn_edit'), 0)
		WebUI.click(findTestObject('Object Repository/Product Details Page/btn_edit'))
		//redirect to edit product page
		WebUI.waitForElementPresent(findTestObject('Object Repository/Edit product page/btn_terbitkan'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Edit product page/btn_terbitkan'), 0)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Edit product page/btn_preview'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Edit product page/btn_preview'), 0)
	}

	@When("user edit valid credential in all required fields and select Terbitkan button in edit product page")
	public void user_edit_valid_credential_in_all_required_fields_and_select_terbitkan_button_in_edit_product_page() {
		WebUI.setText(findTestObject('Object Repository/Edit product page/TextBox_namaProduk'), 'capybara')
		WebUI.setText(findTestObject('Object Repository/Edit product page/TextBox_hargaProduk'), '2000')
		WebUI.selectOptionByValue(findTestObject('Object Repository/Edit product page/select_pilihKategori'), '3', false)
		WebUI.setText(findTestObject('Object Repository/Edit product page/TextBox_deskripsiProduk'), 'capybara dijual')
		WebUI.click(findTestObject('Object Repository/Edit product page/btn_hapusImage'))
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Edit product page/btn_hapusImage'), 0)
		WebUI.uploadFile(findTestObject('Object Repository/Edit product page/img_formImage'), 'C:\\Users\\WINDOWS 10\\Downloads\\sapi.jpg')
		WebUI.click(findTestObject('Object Repository/Edit product page/btn_terbitkan'))
	}
	@Then("user successfully edit product")
	public void successfully_edit_product() {
		WebUI.waitForElementPresent(findTestObject('Object Repository/Edit product page/btn_terbitkan'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Edit product page/btn_terbitkan'), 0)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Edit product page/btn_preview'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Edit product page/btn_preview'), 0)
	}

	//user can't edit product with name fields blank
	@When("user edit nama produk field with empty value and select Terbitkan button in edit product page")
	public void user_edit_nama_produk_field_with_empty_value_and_select_terbitkan_button_in_edit_product_page() {
		WebUI.setText(findTestObject('Object Repository/Edit product page/TextBox_namaProduk'), '')
		WebUI.click(findTestObject('Object Repository/Edit product page/btn_terbitkan'))
	}

	@Then("user will fail save edit product")
	public void user_will_fail_save_edit_product() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Edit product page/text_errorMessage_namaProduk'), 0)
		WebUI.closeBrowser()
	}
}

