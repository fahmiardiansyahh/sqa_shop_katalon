import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-LOG-006: Login tanpa mengisi semua field
 * Expected: Validasi error pada kedua field
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.maximizeWindow()

// Kosongkan semua field
WebUI.clearText(findTestObject('Page_Login/input_email'))
WebUI.clearText(findTestObject('Page_Login/input_password'))

WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(1)

// Verifikasi masih di halaman login
WebUI.verifyMatch(WebUI.getUrl(), '.*login.php.*', true)

WebUI.closeBrowser()
