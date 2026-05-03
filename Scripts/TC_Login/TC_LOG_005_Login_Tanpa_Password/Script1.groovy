import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-LOG-005: Login tanpa mengisi password
 * Expected: Validasi error, muncul pesan 'Password wajib diisi'
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.maximizeWindow()

WebUI.setText(findTestObject('Page_Login/input_email'), GlobalVariable.validEmail)
WebUI.clearText(findTestObject('Page_Login/input_password'))

WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(1)

// Verifikasi masih di halaman login
WebUI.verifyMatch(WebUI.getUrl(), '.*login.php.*', true)

WebUI.closeBrowser()
