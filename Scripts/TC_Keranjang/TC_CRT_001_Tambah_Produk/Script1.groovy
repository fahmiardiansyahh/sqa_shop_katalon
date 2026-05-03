import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-CRT-001: Tambah produk ke keranjang
 * Pre-Condition: User sudah login, halaman beranda terbuka
 * Expected: Produk ditambahkan, badge keranjang bertambah, muncul notifikasi sukses
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

// Buka beranda
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/index.php')
WebUI.delay(2)

// Klik Tambah ke Keranjang pada produk pertama (Laptop Gaming Pro)
WebUI.click(findTestObject('Page_Beranda/btn_add_cart_1'))
WebUI.delay(2)

// Verifikasi toast notification muncul
WebUI.verifyElementPresent(findTestObject('Page_Beranda/toast_success'), GlobalVariable.timeout)

// Verifikasi badge keranjang tampil
WebUI.verifyElementVisible(findTestObject('Page_Beranda/cart_badge'))

WebUI.closeBrowser()
