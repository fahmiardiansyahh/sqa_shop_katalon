import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-LOG-008: Akses halaman login saat sudah login
 * Pre-Condition: User sudah login
 * Expected: Redirect otomatis ke index.php
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.maximizeWindow()

// Login terlebih dahulu
WebUI.setText(findTestObject('Page_Login/input_email'), GlobalVariable.validEmail)
WebUI.setText(findTestObject('Page_Login/input_password'), GlobalVariable.validPassword)
WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(2)

// Akses halaman login secara manual saat sudah login
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.delay(2)

// Verifikasi redirect otomatis ke index.php
WebUI.verifyMatch(WebUI.getUrl(), '.*index.php.*', true)

WebUI.closeBrowser()
