import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-LOG-007: Login dengan format email tidak valid
 * Expected: Validasi error format email
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.maximizeWindow()

WebUI.setText(findTestObject('Page_Login/input_email'), 'buditest')
WebUI.setText(findTestObject('Page_Login/input_password'), 'Test1234')

WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(1)

// Verifikasi masih di halaman login (validasi HTML5 mencegah submit)
WebUI.verifyMatch(WebUI.getUrl(), '.*login.php.*', true)

WebUI.closeBrowser()
