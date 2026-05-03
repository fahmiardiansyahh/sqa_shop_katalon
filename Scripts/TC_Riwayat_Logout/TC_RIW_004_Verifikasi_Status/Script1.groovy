import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject
import internal.GlobalVariable as GlobalVariable

/*
 * TC-RIW-004: Verifikasi status pesanan tampil dengan benar
 * Pre-Condition: Pesanan sudah ada
 * Expected: Status 'Pending' tampil dengan badge warna kuning (warning)
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.maximizeWindow()

// Login
WebUI.setText(findTestObject('Page_Login/input_email'), GlobalVariable.validEmail)
WebUI.setText(findTestObject('Page_Login/input_password'), GlobalVariable.validPassword)
WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(2)

// Buka riwayat
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/riwayat.php')
WebUI.delay(2)

// Verifikasi badge status Pending tampil
TestObject badgePending = new TestObject('badge_pending')
badgePending.addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, "//span[contains(@class,'badge-warning') and contains(.,'Pending')]")
WebUI.verifyElementPresent(badgePending, GlobalVariable.timeout)

WebUI.closeBrowser()
