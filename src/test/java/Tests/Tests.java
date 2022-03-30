package Tests;

import Base.BaseSelenium;
import Pages.PoliciesPage;
import org.testng.annotations.Test;


public class Tests extends BaseSelenium {
    PoliciesPage policies;

    /**
     * Checking required Buttons and Fields isDisplayed or Not.
     */
    @Test(priority = 2)
    public void checkIsDisplayedButtonsAndFields() throws InterruptedException {
        policies = new PoliciesPage(driver);
        policies.goToPolicies();
        policies.goToPolicyList();
        policies.checkAddPolicyButtonIsDisplayed();
        policies.clickAddPolicyButton();
        policies.checkIsAddPolicyPopUpFormDisplayed();
        policies.checkIsNameOfPolicyDisplayed();
        policies.checkIsStateDisplayed();
        policies.checkIsSetPolicyDefaultDisplayed();
        policies.checkIsPriceFieldDisplayed();
        Thread.sleep(2000);
        policies.checkIsAddButtonDisplayed();
        policies.checkCloseAddPolicyButton();
    }

    /**
     * Creating policy with required fields only.
     */
    @Test(priority = 3)
    public void minimumValidInputs() {
        policies.inputNameOfPolicy("Test");
        policies.inputPetFee("100");
        policies.clickAddButton();
        policies.checkSuccessfullyAddedMessage();
        policies.checkIsAddedPolicy();
        policies.deletePolicy();
        policies.checkSuccessfullyDeletedMessage();
    }

    /**
     * Checking name field validation.
     */
    @Test(priority = 6)
    public void emptyRequiredFieldsTest() throws InterruptedException {
        policies.clickAddPolicyButton();
        policies.inputNameOfPolicy("");
        policies.inputPetFee("");
        policies.clickAddButton();
        policies.checkNameErrorMessage();
        Thread.sleep(5000);
        policies.checkPriceErrorMessage();

        policies.closePolicy();
    }

    /**
     * Checking pet fee with negative price. I found a BUG in this case.
     */
    @Test(priority = 7)
    public void invalidPetFeeTest() {
        policies.clickAddPolicyButton();
        policies.inputNameOfPolicy("Test");
        policies.inputPetFee("-10");
        policies.clickAddButton();
        policies.checkIsPolicyNotAdded();
    }

    /**
     * Checking is added default policy in 'Default State Policy' list.
     */
    @Test(priority = 5)
    public void defaultPolicyTest() throws InterruptedException {
        policies.clickAddPolicyButton();
        policies.inputNameOfPolicy("Test");
        policies.checkSetDefault();
        policies.inputPetFee("100");
        policies.clickAddButton();
        Thread.sleep(5000);
        policies.goToDefaultPolicies();
        policies.checkIsAddedDefaultPolicy();
        policies.goToPolicyList();
        policies.deletePolicy();
    }

    /**
     *
     */
    @Test(priority = 4)
    public void setStateTest() throws InterruptedException {
        policies.clickAddPolicyButton();
        policies.inputNameOfPolicy("Test");
        policies.setState();
        policies.inputPetFee("123");
        policies.clickAddButton();
        policies.checkIsAddedPolicy();
        policies.checkState();
        policies.deletePolicy();

    }
}


