package org.selenium.example;

import org.junit.Test;
import org.selenium.example.resources.CommonMethods;
import org.selenium.example.resources.Constants;
import org.selenium.example.resources.IntegrationTestParent;

import static org.selenium.example.resources.CommonMethods.verifyAndCloseIfCristmasSalesPagePresent;
import static org.selenium.example.resources.CommonMethods.waitUntilElementWillVisibleByCssSelector;


public class BuyGoodTest extends IntegrationTestParent {

    @Test
    public void test() throws InterruptedException {

        // 1. Verify top Menu
        CommonMethods.verifyTopMenu();

        // 2. Close Spam page if present
        verifyAndCloseIfCristmasSalesPagePresent();

        // 3. Wait until spam page will be closed
        CommonMethods.waitUntilElementWillVisibleById("topMenuWrapper");

        CommonMethods.clickAndVerifyTextButtonByCssSelector(".RootGroup > .mmHasChild:nth-child(3) > a", Constants.MENS);
        CommonMethods.clickAndVerifyTextButtonByLinkText("Trainers", Constants.TRAINERS);
        CommonMethods.clickAndVerifyTextButtonByCssSelector("li:nth-child(1) .rtimg", "");
        CommonMethods.clickAndVerifyTextButtonByCssSelector("#dnn_ctr175232963_ViewTemplate_ctl00_ctl14_rptSizes_ctl00_liItem span", Constants.SHOES_SIZE_BUTTON);
        CommonMethods.clickAndVerifyTextButtonByCssSelector(".addToBag", Constants.ADD_TO_BAG);
        CommonMethods.waitUntilElementWillVisibleByCssSelector(".HeaderCheckoutLink");
        CommonMethods.clickAndVerifyTextButtonByCssSelector(".HeaderCheckoutLink", Constants.CHECKOUT);
        CommonMethods.clickAndVerifyTextButtonById("dnn_ctr175232949_ViewBasket_lnkBtnContinueSecurely", Constants.CONTINUE_SECURELY);

        // Mail page
        CommonMethods.clickOnTextFieldById("txtGuestCustomerEmailAddress");
        CommonMethods.fillTextFieldById("txtGuestCustomerEmailAddress", "test@tests.com");
        CommonMethods.clickAndVerifyTextButtonById("dnn_ctr175233219_Launch_btnGuestCustomer", Constants.CONTINUE_SECURELY);

        //Person page
        fillPersonPage();

        // Continue with next page
        CommonMethods.clickAndVerifyTextButtonById("dnn_ctr175233229_Delivery_DeliveryGroupSelection_btnPersonalDetailsChange", "");

        // Delivery page
        CommonMethods.clickAndVerifyTextButtonByXpath("//label/div/div[3]/span", "");
        CommonMethods.clickAndVerifyTextButtonById("dnn_ctr175233229_Delivery_btnContinue", "");

        //Payment page
        CommonMethods.clickAndVerifyTextButtonByXpath("//span[3]/span", "");

    }

    private void fillPersonPage(){
        CommonMethods.fillTextFieldById("dnn_ctr175233229_Delivery_DeliveryGroupSelection_DeliveryAddressForm_txtFirstName", Constants.PERSON_NAME);
        CommonMethods.fillTextFieldById("dnn_ctr175233229_Delivery_DeliveryGroupSelection_DeliveryAddressForm_txtLastName", Constants.PERSON_LAST_NAME);
        CommonMethods.fillTextFieldById("dnn_ctr175233229_Delivery_DeliveryGroupSelection_DeliveryAddressForm_txtAddress1", Constants.STREET_NAME);
        waitUntilElementWillVisibleByCssSelector(".pcaselected");
        CommonMethods.clickTextButtonByCssSelector(".pcaselected");
        waitUntilElementWillVisibleByCssSelector(".pcaselected");
        CommonMethods.clickTextButtonByCssSelector(".pcaselected");
        CommonMethods.fillTextFieldById("dnn_ctr175233229_Delivery_DeliveryGroupSelection_TelephoneNumberEntry_txtTelephone", Constants.PHONE_NUMBER);
        CommonMethods.scrollDown();
    }
}
