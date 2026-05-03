import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-REG-010: Registrasi tanpa mengisi field opsional (alamat & telp)
 * Pre-Condition: Halaman register terbuka
 * Expected: Registrasi berhasil karena alamat dan telepon opsional
 */

String uniqueEmail = 'test10_' + System.currentTimeMillis() + '@test.com'

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/register.php')
WebUI.maximizeWindow()

// Isi hanya field wajib
WebUI.setText(findTestObject('Page_Register/input_nama_lengkap'), 'Test User')
WebUI.setText(findTestObject('Page_Register/input_email'), uniqueEmail)
WebUI.setText(findTestObject('Page_Register/input_password'), 'Test1234')
WebUI.setText(findTestObject('Page_Register/input_konfirmasi_password'), 'Test1234')

// Kosongkan No Telepon dan Alamat
WebUI.clearText(findTestObject('Page_Register/input_no_telepon'))
WebUI.clearText(findTestObject('Page_Register/textarea_alamat'))

WebUI.click(findTestObject('Page_Register/btn_register'))
WebUI.delay(2)

// Verifikasi redirect ke login.php (registrasi berhasil)
WebUI.verifyMatch(WebUI.getUrl(), '.*login.php.*', true)

WebUI.closeBrowser()
