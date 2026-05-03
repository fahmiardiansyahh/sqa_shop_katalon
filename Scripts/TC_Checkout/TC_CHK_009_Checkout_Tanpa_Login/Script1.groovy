import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-CHK-009: Akses halaman checkout tanpa login
 * Pre-Condition: User belum login
 * Expected: Redirect otomatis ke login.php
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/checkout.php')
WebUI.maximizeWindow()
WebUI.delay(2)

// Verifikasi redirect otomatis ke login.php
WebUI.verifyMatch(WebUI.getUrl(), '.*login.php.*', true)

WebUI.closeBrowser()
