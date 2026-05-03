import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject
import internal.GlobalVariable as GlobalVariable

/*
 * TC-RIW-001: Melihat riwayat pesanan setelah checkout
 * Pre-Condition: User sudah melakukan checkout
 * Expected: Daftar pesanan tampil dengan detail item, total, status, dan metode pembayaran
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

// Verifikasi halaman riwayat terbuka
WebUI.verifyMatch(WebUI.getUrl(), '.*riwayat.php.*', true)

// Verifikasi ada section pesanan (checkout-section)
TestObject pesananSection = new TestObject('pesanan_section')
pesananSection.addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, "//div[contains(@class,'checkout-section')]")
WebUI.verifyElementPresent(pesananSection, GlobalVariable.timeout)

// Verifikasi ada badge status
TestObject badgeStatus = new TestObject('badge_status')
badgeStatus.addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, "//span[contains(@class,'badge')]")
WebUI.verifyElementPresent(badgeStatus, GlobalVariable.timeout)

WebUI.closeBrowser()
