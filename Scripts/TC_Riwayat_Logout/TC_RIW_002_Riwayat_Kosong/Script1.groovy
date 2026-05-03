import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject
import internal.GlobalVariable as GlobalVariable

/*
 * TC-RIW-002: Riwayat kosong jika belum pernah checkout
 * Pre-Condition: User baru, belum pernah checkout
 * Expected: Muncul pesan 'Belum ada pesanan. Mulai belanja'
 */

// Gunakan akun baru yang belum pernah checkout
String newEmail = 'newuser_' + System.currentTimeMillis() + '@test.com'

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/register.php')
WebUI.maximizeWindow()

// Register akun baru
WebUI.setText(findTestObject('Page_Register/input_nama_lengkap'), 'User Baru')
WebUI.setText(findTestObject('Page_Register/input_email'), newEmail)
WebUI.setText(findTestObject('Page_Register/input_password'), 'Test1234')
WebUI.setText(findTestObject('Page_Register/input_konfirmasi_password'), 'Test1234')
WebUI.click(findTestObject('Page_Register/btn_register'))
WebUI.delay(2)

// Login dengan akun baru
WebUI.setText(findTestObject('Page_Login/input_email'), newEmail)
WebUI.setText(findTestObject('Page_Login/input_password'), 'Test1234')
WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(2)

// Buka riwayat
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/riwayat.php')
WebUI.delay(2)

// Verifikasi pesan "Belum ada pesanan"
TestObject emptyMessage = new TestObject('empty_message')
emptyMessage.addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, "//p[contains(.,'Belum ada pesanan')]")
WebUI.verifyElementPresent(emptyMessage, GlobalVariable.timeout)

WebUI.closeBrowser()
