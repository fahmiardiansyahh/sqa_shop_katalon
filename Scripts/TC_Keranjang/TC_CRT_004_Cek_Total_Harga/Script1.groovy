import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-CRT-004: Cek total harga keranjang
 * Expected: Total: Rp 16.750.000 (Laptop Rp15.500.000 + Headphone Rp1.250.000)
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.maximizeWindow()

// Login
WebUI.setText(findTestObject('Page_Login/input_email'), GlobalVariable.validEmail)
WebUI.setText(findTestObject('Page_Login/input_password'), GlobalVariable.validPassword)
WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(2)

// Bersihkan keranjang
WebUI.executeJavaScript("localStorage.removeItem('sqa_cart')", null)

WebUI.navigateToUrl(GlobalVariable.baseUrl + '/index.php')
WebUI.delay(2)

// Tambah Laptop (Rp15.500.000)
WebUI.click(findTestObject('Page_Beranda/btn_add_cart_1'))
WebUI.delay(1)

// Tambah Headphone (Rp1.250.000)
WebUI.click(findTestObject('Page_Beranda/btn_add_cart_2'))
WebUI.delay(1)

// Buka checkout untuk verifikasi total
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/checkout.php')
WebUI.delay(2)

// Verifikasi total harga
String totalText = WebUI.getText(findTestObject('Page_Checkout/span_checkout_total'))
WebUI.verifyMatch(totalText, '.*16.750.000.*', true)

WebUI.closeBrowser()
