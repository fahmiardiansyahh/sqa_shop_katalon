import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-LOG-004: Login tanpa mengisi email
 * Expected: Validasi error, muncul pesan 'Email wajib diisi'
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.maximizeWindow()

// Kosongkan email, isi password
WebUI.clearText(findTestObject('Page_Login/input_email'))
WebUI.setText(findTestObject('Page_Login/input_password'), 'Test1234')

WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(1)

// Verifikasi masih di halaman login (validasi mencegah submit)
WebUI.verifyMatch(WebUI.getUrl(), '.*login.php.*', true)

WebUI.closeBrowser()
