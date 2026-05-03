import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-CHK-001: Checkout dengan data lengkap dan valid
 * Pre-Condition: User sudah login, keranjang berisi minimal 1 produk
 * Expected: Pesanan berhasil dibuat, redirect ke riwayat.php, keranjang dikosongkan
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.maximizeWindow()

// Login terlebih dahulu
WebUI.setText(findTestObject('Page_Login/input_email'), GlobalVariable.validEmail)
WebUI.setText(findTestObject('Page_Login/input_password'), GlobalVariable.validPassword)
WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(2)

// Buka halaman beranda dan tambah produk ke keranjang
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/index.php')
WebUI.delay(2)

// Tambah produk pertama (Laptop Gaming Pro)
WebUI.click(findTestObject('Page_Beranda/btn_add_cart_1'))
WebUI.delay(1)

// Buka checkout
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/checkout.php')
WebUI.delay(2)

// Isi Alamat Pengiriman
WebUI.setText(findTestObject('Page_Checkout/textarea_alamat_pengiriman'), 'Jl. Merdeka No.1 Jakarta')

// Pilih Metode Pembayaran - Transfer Bank
WebUI.selectOptionByValue(findTestObject('Page_Checkout/select_metode_pembayaran'), 'transfer_bank', true)

// Klik Buat Pesanan
WebUI.click(findTestObject('Page_Checkout/btn_checkout'))
WebUI.delay(3)

// Verifikasi redirect ke riwayat.php
WebUI.verifyMatch(WebUI.getUrl(), '.*riwayat.php.*', true)

WebUI.closeBrowser()
