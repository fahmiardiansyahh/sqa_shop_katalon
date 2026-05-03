import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-CHK-002: Checkout tanpa mengisi alamat pengiriman
 * Expected: Validasi error, muncul pesan 'Alamat minimal 10 karakter'
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.maximizeWindow()

// Login
WebUI.setText(findTestObject('Page_Login/input_email'), GlobalVariable.validEmail)
WebUI.setText(findTestObject('Page_Login/input_password'), GlobalVariable.validPassword)
WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(2)

// Tambah produk
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/index.php')
WebUI.delay(2)
WebUI.click(findTestObject('Page_Beranda/btn_add_cart_1'))
WebUI.delay(1)

// Buka checkout
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/checkout.php')
WebUI.delay(2)

// Kosongkan alamat
WebUI.clearText(findTestObject('Page_Checkout/textarea_alamat_pengiriman'))

// Pilih metode pembayaran
WebUI.selectOptionByValue(findTestObject('Page_Checkout/select_metode_pembayaran'), 'cod', true)

// Klik Buat Pesanan
WebUI.click(findTestObject('Page_Checkout/btn_checkout'))
WebUI.delay(1)

// Verifikasi masih di halaman checkout (validasi mencegah submit)
WebUI.verifyMatch(WebUI.getUrl(), '.*checkout.php.*', true)

WebUI.closeBrowser()
