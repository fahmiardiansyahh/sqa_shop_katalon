import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-REG-003: Registrasi dengan nama kurang dari 3 karakter
 * Pre-Condition: Halaman register terbuka
 * Expected: Validasi error, muncul pesan 'Nama minimal 3 karakter'
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/register.php')
WebUI.maximizeWindow()

// Isi nama hanya 2 karakter
WebUI.setText(findTestObject('Page_Register/input_nama_lengkap'), 'Ab')
WebUI.setText(findTestObject('Page_Register/input_email'), 'test3@test.com')
WebUI.setText(findTestObject('Page_Register/input_password'), 'Test1234')
WebUI.setText(findTestObject('Page_Register/input_konfirmasi_password'), 'Test1234')

// Klik Daftar
WebUI.click(findTestObject('Page_Register/btn_register'))
WebUI.delay(1)

// Verifikasi masih di halaman register
WebUI.verifyMatch(WebUI.getUrl(), '.*register.php.*', true)

WebUI.closeBrowser()
