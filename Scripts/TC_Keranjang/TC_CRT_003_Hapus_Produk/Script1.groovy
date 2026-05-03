import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-CRT-003: Hapus produk dari keranjang
 * Pre-Condition: Keranjang berisi minimal 1 produk
 * Expected: Produk terhapus dari keranjang, total diperbarui
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.maximizeWindow()

// Login
WebUI.setText(findTestObject('Page_Login/input_email'), GlobalVariable.validEmail)
WebUI.setText(findTestObject('Page_Login/input_password'), GlobalVariable.validPassword)
WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(2)

// Bersihkan dan tambah produk
WebUI.executeJavaScript("localStorage.removeItem('sqa_cart')", null)
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/index.php')
WebUI.delay(2)

// Tambah produk
WebUI.click(findTestObject('Page_Beranda/btn_add_cart_1'))
WebUI.delay(1)

// Buka checkout (dimana tombol hapus berada)
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/checkout.php')
WebUI.delay(2)

// Klik tombol hapus
WebUI.click(findTestObject('Page_Checkout/btn_remove_item'))
WebUI.delay(1)

// Verifikasi total menjadi Rp 0
String totalText = WebUI.getText(findTestObject('Page_Checkout/span_checkout_total'))
WebUI.verifyEqual(totalText, 'Rp 0')

WebUI.closeBrowser()
