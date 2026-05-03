import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-CHK-003: Checkout tanpa memilih metode pembayaran
 * Expected: Validasi error, muncul pesan 'Pilih metode pembayaran'
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

// Isi alamat
WebUI.setText(findTestObject('Page_Checkout/textarea_alamat_pengiriman'), 'Jl. Merdeka No.1 Jakarta')

// Tidak memilih metode pembayaran (biarkan default "-- Pilih Metode --")

// Klik Buat Pesanan
WebUI.click(findTestObject('Page_Checkout/btn_checkout'))
WebUI.delay(1)

// Verifikasi masih di halaman checkout
WebUI.verifyMatch(WebUI.getUrl(), '.*checkout.php.*', true)

WebUI.closeBrowser()
