import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-REG-006: Registrasi dengan password kurang dari 6 karakter
 * Pre-Condition: Halaman register terbuka
 * Expected: Validasi error, muncul pesan 'Password minimal 6 karakter'
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/register.php')
WebUI.maximizeWindow()

WebUI.setText(findTestObject('Page_Register/input_nama_lengkap'), 'Test User')
WebUI.setText(findTestObject('Page_Register/input_email'), 'test6@test.com')
WebUI.setText(findTestObject('Page_Register/input_password'), '123')
WebUI.setText(findTestObject('Page_Register/input_konfirmasi_password'), '123')

WebUI.click(findTestObject('Page_Register/btn_register'))
WebUI.delay(1)

// Verifikasi masih di halaman register
WebUI.verifyMatch(WebUI.getUrl(), '.*register.php.*', true)

WebUI.closeBrowser()
