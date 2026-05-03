import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-LOG-003: Login dengan password salah
 * Expected: Muncul pesan error 'Email atau password salah'
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.maximizeWindow()

WebUI.setText(findTestObject('Page_Login/input_email'), GlobalVariable.validEmail)
WebUI.setText(findTestObject('Page_Login/input_password'), 'SalahPassword')

WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(2)

// Verifikasi muncul pesan error
WebUI.verifyElementPresent(findTestObject('Page_Login/alert_message'), GlobalVariable.timeout)

WebUI.closeBrowser()
