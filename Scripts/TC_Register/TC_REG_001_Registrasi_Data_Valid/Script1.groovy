import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/*
 * TC-REG-001: Registrasi dengan semua data valid
 * Pre-Condition: Halaman register terbuka, belum login
 * Expected: Registrasi berhasil, redirect ke login.php dengan pesan sukses
 */

// Generate unique email agar tidak duplikat
String uniqueEmail = 'testuser_' + System.currentTimeMillis() + '@test.com'

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl + '/register.php')
WebUI.maximizeWindow()

// Verifikasi halaman register terbuka
WebUI.verifyElementPresent(findTestObject('Page_Register/input_nama_lengkap'), GlobalVariable.timeout)

// Isi semua field dengan data valid
WebUI.setText(findTestObject('Page_Register/input_nama_lengkap'), 'Budi Santoso')
WebUI.setText(findTestObject('Page_Register/input_email'), uniqueEmail)
WebUI.setText(findTestObject('Page_Register/input_password'), 'Test1234')
WebUI.setText(findTestObject('Page_Register/input_konfirmasi_password'), 'Test1234')
WebUI.setText(findTestObject('Page_Register/input_no_telepon'), '081234567890')
WebUI.setText(findTestObject('Page_Register/textarea_alamat'), 'Jl. Merdeka No.1')

// Klik tombol Daftar
WebUI.click(findTestObject('Page_Register/btn_register'))

// Verifikasi redirect ke login.php
WebUI.waitForPageLoad(GlobalVariable.timeout)
WebUI.verifyMatch(WebUI.getUrl(), '.*login.php.*', true)

// Verifikasi muncul pesan sukses
WebUI.verifyElementPresent(findTestObject('Page_Login/alert_message'), GlobalVariable.timeout)

WebUI.closeBrowser()
