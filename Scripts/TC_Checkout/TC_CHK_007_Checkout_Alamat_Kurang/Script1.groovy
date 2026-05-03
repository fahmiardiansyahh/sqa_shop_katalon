import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-CHK-007: Checkout dengan alamat kurang dari 10 karakter
 * Expected: Validasi error, 'Alamat minimal 10 karakter'
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

// Isi alamat kurang dari 10 karakter
WebUI.setText(findTestObject('Page_Checkout/textarea_alamat_pengiriman'), 'Jl. A')

// Pilih metode
WebUI.selectOptionByValue(findTestObject('Page_Checkout/select_metode_pembayaran'), 'transfer_bank', true)

// Klik Buat Pesanan
WebUI.click(findTestObject('Page_Checkout/btn_checkout'))
WebUI.delay(1)

// Verifikasi masih di halaman checkout
WebUI.verifyMatch(WebUI.getUrl(), '.*checkout.php.*', true)

WebUI.closeBrowser()
