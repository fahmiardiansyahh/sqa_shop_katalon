import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-CHK-006: Checkout dengan metode pembayaran E-Wallet
 * Expected: Pesanan berhasil, metode tercatat sebagai E-Wallet di riwayat
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.maximizeWindow()

// Login
WebUI.setText(findTestObject('Page_Login/input_email'), GlobalVariable.validEmail)
WebUI.setText(findTestObject('Page_Login/input_password'), GlobalVariable.validPassword)
WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(2)

// Tambah produk (Mouse Gaming)
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/index.php')
WebUI.delay(2)
WebUI.click(findTestObject('Page_Beranda/btn_add_cart_5'))
WebUI.delay(1)

// Buka checkout
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/checkout.php')
WebUI.delay(2)

// Isi Alamat
WebUI.setText(findTestObject('Page_Checkout/textarea_alamat_pengiriman'), 'Jl. Test No.10')

// Pilih E-Wallet
WebUI.selectOptionByValue(findTestObject('Page_Checkout/select_metode_pembayaran'), 'e_wallet', true)

// Klik Buat Pesanan
WebUI.click(findTestObject('Page_Checkout/btn_checkout'))
WebUI.delay(3)

// Verifikasi redirect ke riwayat
WebUI.verifyMatch(WebUI.getUrl(), '.*riwayat.php.*', true)

WebUI.closeBrowser()
