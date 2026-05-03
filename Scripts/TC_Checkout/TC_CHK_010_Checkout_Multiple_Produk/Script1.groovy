import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-CHK-010: Checkout dengan multiple produk berbeda
 * Expected: Pesanan berhasil, semua item tercatat di order_items, total dihitung benar
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.maximizeWindow()

// Login
WebUI.setText(findTestObject('Page_Login/input_email'), GlobalVariable.validEmail)
WebUI.setText(findTestObject('Page_Login/input_password'), GlobalVariable.validPassword)
WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(2)

// Bersihkan keranjang terlebih dahulu
WebUI.executeJavaScript("localStorage.removeItem('sqa_cart')", null)

// Tambah 3 produk berbeda
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/index.php')
WebUI.delay(2)

// Produk 1: Laptop Gaming Pro (btnAddCart1)
WebUI.click(findTestObject('Page_Beranda/btn_add_cart_1'))
WebUI.delay(1)

// Produk 2: Headphone Wireless X (btnAddCart2) x2
WebUI.click(findTestObject('Page_Beranda/btn_add_cart_2'))
WebUI.delay(1)
WebUI.click(findTestObject('Page_Beranda/btn_add_cart_2'))
WebUI.delay(1)

// Produk 3: Mouse Gaming Precision (btnAddCart5)
WebUI.click(findTestObject('Page_Beranda/btn_add_cart_5'))
WebUI.delay(1)

// Buka checkout
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/checkout.php')
WebUI.delay(2)

// Isi form lengkap
WebUI.setText(findTestObject('Page_Checkout/textarea_alamat_pengiriman'), 'Jl. Merdeka No.1 Jakarta')
WebUI.selectOptionByValue(findTestObject('Page_Checkout/select_metode_pembayaran'), 'transfer_bank', true)

// Klik Buat Pesanan
WebUI.click(findTestObject('Page_Checkout/btn_checkout'))
WebUI.delay(3)

// Verifikasi redirect ke riwayat
WebUI.verifyMatch(WebUI.getUrl(), '.*riwayat.php.*', true)

WebUI.closeBrowser()
