import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-LOG-OUT-002: Akses halaman protected setelah logout
 * Pre-Condition: User sudah logout
 * Expected: Redirect ke login.php
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.maximizeWindow()

// Login terlebih dahulu
WebUI.setText(findTestObject('Page_Login/input_email'), GlobalVariable.validEmail)
WebUI.setText(findTestObject('Page_Login/input_password'), GlobalVariable.validPassword)
WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(2)

// Logout
WebUI.click(findTestObject('Page_Navbar/link_logout'))
WebUI.delay(2)

// Verifikasi logout berhasil (redirect ke index.php)
WebUI.verifyMatch(WebUI.getUrl(), '.*index.php.*', true)

// Akses checkout.php secara manual setelah logout
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/checkout.php')
WebUI.delay(2)

// Verifikasi redirect ke login.php
WebUI.verifyMatch(WebUI.getUrl(), '.*login.php.*', true)

// Akses riwayat.php secara manual setelah logout
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/riwayat.php')
WebUI.delay(2)

// Verifikasi redirect ke login.php
WebUI.verifyMatch(WebUI.getUrl(), '.*login.php.*', true)

WebUI.closeBrowser()
