import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-REG-005: Registrasi dengan email yang sudah terdaftar
 * Pre-Condition: Email budi@test.com sudah terdaftar
 * Expected: Muncul pesan error 'Email sudah terdaftar'
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/register.php')
WebUI.maximizeWindow()

WebUI.setText(findTestObject('Page_Register/input_nama_lengkap'), 'Budi Dua')
WebUI.setText(findTestObject('Page_Register/input_email'), 'budi@test.com')
WebUI.setText(findTestObject('Page_Register/input_password'), 'Test1234')
WebUI.setText(findTestObject('Page_Register/input_konfirmasi_password'), 'Test1234')

WebUI.click(findTestObject('Page_Register/btn_register'))
WebUI.delay(2)

// Verifikasi redirect kembali ke register.php
WebUI.verifyMatch(WebUI.getUrl(), '.*register.php.*', true)

// Verifikasi muncul pesan error email sudah terdaftar
WebUI.verifyElementPresent(findTestObject('Page_Register/alert_message'), GlobalVariable.timeout)
String alertText = WebUI.getText(findTestObject('Page_Register/alert_message'))
WebUI.verifyMatch(alertText, '.*Email sudah terdaftar.*', true)

WebUI.closeBrowser()
