import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-CHK-005: Checkout dengan metode pembayaran COD
 * Expected: Pesanan berhasil, metode tercatat sebagai COD di riwayat
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.maximizeWindow()

// Login
WebUI.setText(findTestObject('Page_Login/input_email'), GlobalVariable.validEmail)
WebUI.setText(findTestObject('Page_Login/input_password'), GlobalVariable.validPassword)
WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(2)

// Tambah produk (Headphone Wireless X)
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/index.php')
WebUI.delay(2)
WebUI.click(findTestObject('Page_Beranda/btn_add_cart_2'))
WebUI.delay(1)
WebUI.click(findTestObject('Page_Beranda/btn_add_cart_2'))
WebUI.delay(1)

// Buka checkout
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/checkout.php')
WebUI.delay(2)

// Isi Alamat
WebUI.setText(findTestObject('Page_Checkout/textarea_alamat_pengiriman'), 'Jl. Test No.5')

// Pilih COD
WebUI.selectOptionByValue(findTestObject('Page_Checkout/select_metode_pembayaran'), 'cod', true)

// Klik Buat Pesanan
WebUI.click(findTestObject('Page_Checkout/btn_checkout'))
WebUI.delay(3)

// Verifikasi redirect ke riwayat
WebUI.verifyMatch(WebUI.getUrl(), '.*riwayat.php.*', true)

WebUI.closeBrowser()
