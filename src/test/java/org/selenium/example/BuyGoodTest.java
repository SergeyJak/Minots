package org.selenium.example;

import org.junit.Test;
import org.selenium.example.resources.CommonMethods;
import org.selenium.example.resources.Constants;
import org.selenium.example.resources.IntegrationTestParent;

import static org.selenium.example.resources.CommonMethods.verifyAndCloseIfCristmasSalesPagePresent;


public class BuyGoodTest extends IntegrationTestParent {

    @Test
    public void test() throws InterruptedException {

        // 1. Close Spam page if present
        verifyAndCloseIfCristmasSalesPagePresent();

        // 2. Wait until spam page will be closed
        CommonMethods.waitUntilElementWillVisibleById(Constants.TOP_MENU_ID);

        // 3. Verify top Menu
        CommonMethods.verifyTopMenu();

        // 4. Choose MENS goods
        CommonMethods.clickAndVerifyTextButtonByXpath(Constants.MENS_BUTTON_XPATH, Constants.MENS);

        // 5. Trainers sub directory
        CommonMethods.clickAndVerifyTextButtonByLinkText(Constants.TRAINERS);

        //6. Choose good
        CommonMethods.clickAndVerifyTextButtonByXpath(Constants.SHOES_IMAGE_BUTTON_XPATH, Constants.NO_REGEX);

        //7. Set size of good
        CommonMethods.clickAndVerifyTextButtonByLinkText(Constants.SHOES_SIZE_BUTTON);

        //8. Add to bag
        CommonMethods.clickAndVerifyTextButtonById(Constants.ADD_TO_BAG_BUTTON_ID, Constants.ADD_TO_BAG);

        // 9. Go to checkout page
        CommonMethods.waitUntilElementWillVisibleByXpath(Constants.CHECKOUT_BUTTON_XPATH);
        CommonMethods.clickAndVerifyTextButtonByXpath(Constants.CHECKOUT_BUTTON_XPATH, Constants.CHECKOUT);

        //10. Press "Continue Securely" to start purchase
        CommonMethods.clickAndVerifyTextButtonById(Constants.CS_BUTTON_BASKET_ID, Constants.CONTINUE_SECURELY);

        // 11. Mail page, continue as guest
        CommonMethods.clickOnTextFieldById(Constants.MAIL_FIELD_ID);
        CommonMethods.fillTextFieldById(Constants.MAIL_FIELD_ID, Constants.PERSON_MAIL);
        CommonMethods.clickAndVerifyTextButtonById(Constants.CS_BUTTON_MAIL_ID, Constants.CONTINUE_SECURELY);

        // 12. Person page, fill all mandatory fields
        CommonMethods.fillPersonInformationPage();
        CommonMethods.clickAndVerifyTextButtonById(Constants.CS_BUTTON_PERSON_INFORMATION_ID, Constants.NO_REGEX);

        // 13. Delivery page, chose Standard delivery.
        CommonMethods.clickAndVerifyTextButtonByXpath(Constants.DELIVERY_BUTTON_XPATH, Constants.NO_REGEX);
        CommonMethods.clickAndVerifyTextButtonById(Constants.CS_BUTTON_DELIVERY_ID, Constants.NO_REGEX);

        // 14. Payment page
        CommonMethods.clickAndVerifyTextButtonByXpath(Constants.PAYMENT_BY_CARD_BUTTON_XPATH, Constants.NO_REGEX);

    }
}
