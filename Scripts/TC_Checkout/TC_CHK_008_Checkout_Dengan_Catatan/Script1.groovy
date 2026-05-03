import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-CHK-008: Checkout dengan catatan opsional
 * Expected: Pesanan berhasil, catatan tersimpan di database
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

// Isi semua field + catatan
WebUI.setText(findTestObject('Page_Checkout/textarea_alamat_pengiriman'), 'Jl. Merdeka No.1 Jakarta')
WebUI.selectOptionByValue(findTestObject('Page_Checkout/select_metode_pembayaran'), 'transfer_bank', true)
WebUI.setText(findTestObject('Page_Checkout/textarea_catatan'), 'Tolong packing bubble wrap')

// Klik Buat Pesanan
WebUI.click(findTestObject('Page_Checkout/btn_checkout'))
WebUI.delay(3)

// Verifikasi redirect ke riwayat
WebUI.verifyMatch(WebUI.getUrl(), '.*riwayat.php.*', true)

WebUI.closeBrowser()
