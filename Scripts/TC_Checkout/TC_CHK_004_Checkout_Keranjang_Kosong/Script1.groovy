import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory

/*
 * TC-CHK-004: Checkout dengan keranjang kosong
 * Expected: Muncul pesan error 'Keranjang kosong'
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.maximizeWindow()

// Login
WebUI.setText(findTestObject('Page_Login/input_email'), GlobalVariable.validEmail)
WebUI.setText(findTestObject('Page_Login/input_password'), GlobalVariable.validPassword)
WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(2)

// Bersihkan keranjang via JavaScript
WebDriver driver = DriverFactory.getWebDriver()
WebUI.executeJavaScript("localStorage.removeItem('sqa_cart')", null)

// Buka checkout tanpa menambah produk
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/checkout.php')
WebUI.delay(2)

// Isi form
WebUI.setText(findTestObject('Page_Checkout/textarea_alamat_pengiriman'), 'Jl. Test Alamat Panjang')
WebUI.selectOptionByValue(findTestObject('Page_Checkout/select_metode_pembayaran'), 'transfer_bank', true)

// Klik Buat Pesanan
WebUI.click(findTestObject('Page_Checkout/btn_checkout'))
WebUI.delay(1)

// Verifikasi masih di halaman checkout (keranjang kosong mencegah submit)
WebUI.verifyMatch(WebUI.getUrl(), '.*checkout.php.*', true)

WebUI.closeBrowser()
