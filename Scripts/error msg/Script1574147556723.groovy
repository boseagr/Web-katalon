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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('http://www.siacargo.com/ccn/ShipmentTrack.aspx')

WebUI.setText(findTestObject('Object Repository/Page_Track Shipment/input_Air Waybill 1_Suffix1'), '91503532')

WebUI.click(findTestObject('Object Repository/Page_Track Shipment/input__btnQuery'))

WebUI.click(findTestObject('Object Repository/Page_Track Shipment/input_Shipment Delivered_btnSearchAgain'))

for (int i = 1; i < (findTestData('csvdata').getRowNumbers() + 1); i++) {
    WebUI.setText(findTestObject('Object Repository/Page_Track Shipment/input_Air Waybill 2_Suffix2'), findTestData('csvdata').getValue(
            1, i))

    WebUI.setText(findTestObject('Object Repository/Page_Track Shipment/input_Air Waybill 3_Suffix3'), findTestData('csvdata').getValue(
            1, i))

    WebUI.click(findTestObject('Object Repository/Page_Track Shipment/input__btnQuery'))

    msg = WebUI.getText(findTestObject('Object Repository/Page_Track Shipment/span_ Please check entries highlighted'))

    if (msg == '* Please check entries highlighted.') {
        continue
    }
    
    println(msg)

    GlobalVariable.msg = msg

    WebUI.click(findTestObject('Object Repository/Page_Track Shipment/input_Shipment Delivered_btnSearchAgain'))
}

WebUI.closeBrowser()

for (def index : (0..0)) {
}

