import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-LOG-OUT-001: Logout dari sistem
 * Pre-Condition: User sudah login
 * Expected: Sesi berakhir, redirect ke login.php, tidak bisa akses halaman protected
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.maximizeWindow()

// Login
WebUI.setText(findTestObject('Page_Login/input_email'), GlobalVariable.validEmail)
WebUI.setText(findTestObject('Page_Login/input_password'), GlobalVariable.validPassword)
WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(2)

// Verifikasi sudah login
WebUI.verifyElementPresent(findTestObject('Page_Navbar/link_logout'), GlobalVariable.timeout)

// Klik Logout
WebUI.click(findTestObject('Page_Navbar/link_logout'))
WebUI.delay(2)

// Verifikasi redirect ke index.php (logout.php redirect ke index.php)
WebUI.verifyMatch(WebUI.getUrl(), '.*index.php.*', true)

// Verifikasi tidak bisa akses halaman protected
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/checkout.php')
WebUI.delay(2)
WebUI.verifyMatch(WebUI.getUrl(), '.*login.php.*', true)

WebUI.closeBrowser()
