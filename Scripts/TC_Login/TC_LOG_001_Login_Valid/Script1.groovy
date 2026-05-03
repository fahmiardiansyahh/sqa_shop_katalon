import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * TC-LOG-001: Login dengan email dan password valid
 * Pre-Condition: Akun budi@test.com sudah terdaftar
 * Expected: Login berhasil, redirect ke index.php, nama user tampil di navbar
 */

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/login.php')
WebUI.maximizeWindow()

// Verifikasi halaman login terbuka
WebUI.verifyElementPresent(findTestObject('Page_Login/input_email'), GlobalVariable.timeout)

// Isi email dan password
WebUI.setText(findTestObject('Page_Login/input_email'), GlobalVariable.validEmail)
WebUI.setText(findTestObject('Page_Login/input_password'), GlobalVariable.validPassword)

// Klik Login
WebUI.click(findTestObject('Page_Login/btn_login'))
WebUI.delay(2)

// Verifikasi redirect ke index.php
WebUI.verifyMatch(WebUI.getUrl(), '.*index.php.*', true)

// Verifikasi link logout muncul (user sudah login)
WebUI.verifyElementPresent(findTestObject('Page_Navbar/link_logout'), GlobalVariable.timeout)

WebUI.closeBrowser()
