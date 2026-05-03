import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-REG-007: Registrasi dengan konfirmasi password tidak cocok
 * Pre-Condition: Halaman register terbuka
 * Expected: Validasi error, muncul pesan 'Password tidak cocok'
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/register.php')
WebUI.maximizeWindow()

WebUI.setText(findTestObject('Page_Register/input_nama_lengkap'), 'Test User')
WebUI.setText(findTestObject('Page_Register/input_email'), 'test7@test.com')
WebUI.setText(findTestObject('Page_Register/input_password'), 'Test1234')
WebUI.setText(findTestObject('Page_Register/input_konfirmasi_password'), 'Test5678')

WebUI.click(findTestObject('Page_Register/btn_register'))
WebUI.delay(1)

// Verifikasi masih di halaman register
WebUI.verifyMatch(WebUI.getUrl(), '.*register.php.*', true)

WebUI.closeBrowser()
