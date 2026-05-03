import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

/*
 * TC-CRT-005: Tombol 'Tambah ke Keranjang' tidak muncul jika belum login
 * Pre-Condition: User belum login
 * Expected: Tombol berubah menjadi 'Login untuk Membeli'
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/index.php')
WebUI.maximizeWindow()
WebUI.delay(2)

// Verifikasi tombol "Login untuk Membeli" muncul
WebUI.verifyElementPresent(findTestObject('Page_Beranda/btn_login_untuk_membeli'), GlobalVariable.timeout)

// Verifikasi tombol "Tambah ke Keranjang" TIDAK muncul
WebUI.verifyElementNotPresent(findTestObject('Page_Beranda/btn_add_cart_1'), GlobalVariable.timeout, FailureHandling.OPTIONAL)

WebUI.closeBrowser()
