import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-CRT-002: Tambah produk yang sama dua kali
 * Expected: Jumlah produk di keranjang bertambah menjadi 2
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

// Klik Tambah ke Keranjang pada produk yang sama 2 kali (Headphone Wireless X)
WebUI.click(findTestObject('Page_Beranda/btn_add_cart_2'))
WebUI.delay(1)
WebUI.click(findTestObject('Page_Beranda/btn_add_cart_2'))
WebUI.delay(1)

// Verifikasi badge menunjukkan jumlah 2
String badgeText = WebUI.getText(findTestObject('Page_Beranda/cart_badge'))
WebUI.verifyEqual(badgeText, '2')

WebUI.closeBrowser()
